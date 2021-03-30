package cn.com.pism.gfd.model.config;

import lombok.Data;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/30 下午 11:11
 * @since 0.0.1
 */
@Data
public class Mail {
    private String user;
    private String password;
    private String host;
}
