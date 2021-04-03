package cn.com.pism.gfd.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangyihuai
 * @date 2021/3/26 20:05
 */
@ConfigurationProperties(prefix = "gofast")
@Data
public class GoFastDfsProperties {
    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private String port;

    /**
     * 分组，当填写分组时，表示支持集群管理
     */
    private String group;
}
