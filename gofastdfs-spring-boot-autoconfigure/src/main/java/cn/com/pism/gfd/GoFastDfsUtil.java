package cn.com.pism.gfd;

import cn.com.pism.gfd.enums.ActionEnum;
import cn.com.pism.gfd.exception.GoFastDfsException;
import cn.com.pism.gfd.model.GoFastDfsResult;
import cn.com.pism.gfd.model.config.GoFastDfsConfig;
import cn.com.pism.gfd.model.params.Reload;
import cn.com.pism.gfd.properties.GoFastDfsProperties;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import static cn.com.pism.gfd.constants.BaseGoFastDfsConstants.*;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/28 下午 06:07
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
public class GoFastDfsUtil {

    Logger log = LoggerFactory.getLogger(GoFastDfsUtil.class);

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
        switch (action) {
            case GET:
                reload.setAction(ActionEnum.GET);
                break;
            case SET:
                reload.setAction(ActionEnum.SET).setCfg(config);
                break;
            case RELOAD:
                reload.setAction(ActionEnum.RELOAD);
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
        String res = HttpUtil.post(getBaseUrl() + url, JSON.toJSONString(params));
        GoFastDfsResult<T> result = JSON.parseObject(res, new TypeReference<GoFastDfsResult<T>>() {
        });
        String status = result.getStatus();
        if (OK.equals(status)) {
            return result.getData();
        } else {
            log.error("error result:{}", result.getData());
            log.error("error message:{}", result.getMessage());
            throw new GoFastDfsException("request was aborted");
        }
    }


}
