package cn.com.pism.gfd.config;

import cn.com.pism.gfd.properties.GoFastDfsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author PerccyKing
 * @date 2021/3/26 19:10
 */
@Configuration
@EnableConfigurationProperties(GoFastDfsProperties.class)
public class GoFastDsfConfiguration {
}
