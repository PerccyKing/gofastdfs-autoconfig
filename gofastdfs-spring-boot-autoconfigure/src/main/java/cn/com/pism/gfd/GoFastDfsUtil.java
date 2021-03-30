package cn.com.pism.gfd;

import cn.com.pism.gfd.properties.GoFastDfsProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/28 下午 06:07
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
public class GoFastDfsUtil {
    private GoFastDfsProperties properties;

    public String getBaseUrl() {
        return properties.getIp() + properties.getPort();
    }


}
