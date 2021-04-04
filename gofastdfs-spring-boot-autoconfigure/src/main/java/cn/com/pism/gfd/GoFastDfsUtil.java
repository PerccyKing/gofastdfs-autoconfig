package cn.com.pism.gfd;

import cn.com.pism.gfd.enums.ActionEnum;
import cn.com.pism.gfd.enums.OutputEnum;
import cn.com.pism.gfd.exception.GoFastDfsException;
import cn.com.pism.gfd.model.config.GoFastDfsConfig;
import cn.com.pism.gfd.model.params.Reload;
import cn.com.pism.gfd.model.params.Upload;
import cn.com.pism.gfd.model.result.GoFastDfsResult;
import cn.com.pism.gfd.model.result.StatResult;
import cn.com.pism.gfd.model.result.UploadResult;
import cn.com.pism.gfd.properties.GoFastDfsProperties;
import cn.com.pism.gfd.util.ObjectToBeanUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.com.pism.gfd.constants.BaseGoFastDfsConstants.*;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/28 下午 06:07
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GoFastDfsUtil {

    private GoFastDfsProperties properties;

    /**
     * <p>
     * 获取基础的请求路径
     * </p>
     *
     * @return {@link String} 请求路径
     * @author PerccyKing
     * @date 2021/04/03 下午 03:11
     */
    public String getBaseUrl() {
        String group = properties.getGroup();
        if (StringUtils.isNotBlank(group)) {
            group = group + SLASH;
        }
        return HTTP + properties.getIp() + COLON + properties.getPort() + SLASH + group;
    }

    /**
     * <p>
     * 配置管理API
     * </p>
     *
     * @param action       : set(修改参数),get获取参数,reload重新加载参数
     * @param reloadAction : json参数　与 action=set配合完成参数设置
     * @return {@link GoFastDfsConfig} 获取到的参数
     * @author PerccyKing
     * @date 2021/04/03 下午 10:12
     */
    public GoFastDfsConfig reload(ActionEnum action, ReloadAction reloadAction) {
        Reload reload = new Reload();
        GoFastDfsConfig getConfig = null;
        if (action != ActionEnum.RELOAD) {
            getConfig = post(RELOAD_URL, reload.setAction(ActionEnum.GET), GoFastDfsConfig.class);
        }
        switch (action) {
            case GET:
                return getConfig;
            case SET:
                reloadAction.setConfig(getConfig);
                reload.setAction(ActionEnum.SET).setCfg(getConfig);
                post(RELOAD_URL, reload, GoFastDfsConfig.class);
                break;
            case RELOAD:
                reload.setAction(ActionEnum.RELOAD);
                post(RELOAD_URL, reload, GoFastDfsConfig.class);
                break;
            default:
                break;
        }
        //重新获取配置
        getConfig = post(RELOAD_URL, reload.setAction(ActionEnum.GET), GoFastDfsConfig.class);
        return getConfig;
    }

    /**
     * <p>
     * 文件统计信息
     * </p>
     *
     * @return {@link List< StatResult >} 统计信息列表
     * @author PerccyKing
     * @date 2021/04/04 下午 04:33
     */
    public List<StatResult> stat() {
        return postToArr(STAT_URL, null, StatResult.class);
    }

    /**
     * <p>
     * 
     * </p>
     * 
     * @param upload :
     * @return {@link UploadResult}        
     * @author PerccyKing
     * @date 2021/04/04 下午 10:43
     */
    public UploadResult upload(Upload upload) {
        upload.setOutput(OutputEnum.JSON2);
        return post(UPLOAD_URL, upload, UploadResult.class);
    }


    @FunctionalInterface
    public interface ReloadAction {
        /**
         * <p>
         * 基于原有的配置文件更新配置
         * </p>
         *
         * @param config : 系统内已经生效的配置文件
         * @author PerccyKing
         * @date 2021/04/04 下午 03:12
         */
        void setConfig(GoFastDfsConfig config);
    }

    /**
     * <p>
     * 发送post请求
     * </p>
     *
     * @param url    : 请求路径
     * @param params : 参数
     * @param clazz  : clazz
     * @return {@link T} 获取到的数据
     * @author PerccyKing
     * @date 2021/04/03 下午 10:05
     */
    public <T> T post(String url, Object params, Class<T> clazz) {
        String res = getPostResult(url, params);
        GoFastDfsResult<Object> result = JSON.parseObject(res, new TypeReference<GoFastDfsResult<Object>>() {
        });
        String status = result.getStatus();
        if (OK.equals(status)) {
            return ObjectToBeanUtil.parse(result.getData(), clazz);
        } else {
            log.error("error result:{}", result.getData());
            log.error("error message:{}", result.getMessage());
            throw new GoFastDfsException("request was aborted");
        }
    }


    /**
     * <p>
     * 发送post请求
     * </p>
     *
     * @param url    : 请求路径
     * @param params : 参数
     * @param clazz  : clazz
     * @return {@link List<T>} 获取到的数据
     * @author PerccyKing
     * @date 2021/04/03 下午 10:05
     */
    public <T> List<T> postToArr(String url, Object params, Class<T> clazz) {
        String res = getPostResult(url, params);
        GoFastDfsResult<Object> result = JSON.parseObject(res, new TypeReference<GoFastDfsResult<Object>>() {
        });
        String status = result.getStatus();
        if (OK.equals(status)) {
            return ObjectToBeanUtil.parseToList(result.getData(), clazz);
        } else {
            log.error("error result:{}", result.getData());
            log.error("error message:{}", result.getMessage());
            throw new GoFastDfsException("request was aborted");
        }
    }

    /**
     * <p>
     * 获取接口请求响应数据
     * </p>
     *
     * @param url    : 请求路径
     * @param params : 参数
     * @return {@link String}
     * @author PerccyKing
     * @date 2021/04/04 下午 04:31
     */
    private String getPostResult(String url, Object params) {
        JSONObject jsonObject = null;
        if (params != null) {
            jsonObject = ObjectToBeanUtil.parse(params, JSONObject.class);
        }
        String res = HttpUtil.post(getBaseUrl() + url, jsonObject);
        //判断返回格式是否为json
        if (!isJson(res)) {
            throw new GoFastDfsException(res);
        }
        return res;
    }


    public Boolean isJson(String s) {
        try {
            Object parse = JSON.parse(s);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }


}
