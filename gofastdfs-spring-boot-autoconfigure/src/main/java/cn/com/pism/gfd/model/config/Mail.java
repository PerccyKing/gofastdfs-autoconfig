package cn.com.pism.gfd.model.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/30 下午 11:11
 * @since 0.0.1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Mail {
    /**
     * ex:abc@163.com
     */
    private String user;
    private String password;
    /**
     * ex:smtp.163.com:25
     */
    private String host;
}
