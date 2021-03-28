package cn.com.pism.gfd.config;

import cn.com.pism.gfd.GoFastDfsUtil;
import cn.com.pism.gfd.properties.GoFastDfsProperties;
import cn.hutool.core.util.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author PerccyKing
 * @date 2021/3/26 19:10
 */
@Configuration
@ConditionalOnClass(GoFastDfsUtil.class)
@EnableConfigurationProperties(GoFastDfsProperties.class)
public class GoFastDsfConfiguration {

    @Autowired
    private GoFastDfsProperties properties;

    @Bean
    @ConditionalOnMissingBean(GoFastDfsProperties.class)
    public GoFastDfsUtil goFastDfsUtil(){
        return new GoFastDfsUtil(properties);
    }
}
