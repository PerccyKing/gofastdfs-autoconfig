package cn.com.pism.gfd;

import cn.com.pism.gfd.enums.ActionEnum;
import cn.com.pism.gfd.exception.GoFastDfsException;
import cn.com.pism.gfd.model.GoFastDfsResult;
import cn.com.pism.gfd.model.config.GoFastDfsConfig;
import cn.com.pism.gfd.model.params.Reload;
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
     * @param action : set(修改参数),get获取参数,reload重新加载参数
     * @param config : json参数　与 action=set配合完成参数设置
     * @return {@link GoFastDfsConfig} 获取到的参数
     * @author PerccyKing
     * @date 2021/04/03 下午 10:12
     */
    public GoFastDfsConfig reload(ActionEnum action, GoFastDfsConfig config) {
        Reload reload = new Reload();
        GoFastDfsConfig getConfig = reload(ActionEnum.GET, null);
        switch (action) {
            case GET:
                reload.setAction(ActionEnum.GET);
                return post(RELOAD_URL, reload, GoFastDfsConfig.class);
            case SET:
                //获取到config。基于config设置参数
                reload.setAction(ActionEnum.SET).setCfg(config);
                post(RELOAD_URL, reload, GoFastDfsConfig.class);
                return getConfig;
            case RELOAD:
                reload.setAction(ActionEnum.RELOAD);
                post(RELOAD_URL, reload, GoFastDfsConfig.class);
                return getConfig;
            default:
                break;
        }
        return post(RELOAD_URL, reload, GoFastDfsConfig.class);
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
        Map<String, Object> map = new HashMap<>(0);
        JSONObject jsonObject = ObjectToBeanUtil.parse(params, JSONObject.class);
        jsonObject.forEach(map::put);
        String res = HttpUtil.post(getBaseUrl() + url, map);
        //判断返回格式是否为json
        if (!isJson(res)) {
            throw new GoFastDfsException(res);
        }
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
