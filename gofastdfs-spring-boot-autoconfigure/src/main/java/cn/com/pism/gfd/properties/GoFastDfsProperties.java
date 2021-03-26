package cn.com.pism.gfd.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangyihuai
 * @date 2021/3/26 20:05
 */
@Configuration
@ConfigurationProperties(prefix = "gofast")
public class GoFastDfsProperties {
}
