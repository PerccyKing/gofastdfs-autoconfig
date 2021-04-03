package cn.com.pism.gfd.model;

import lombok.Data;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/28 下午 05:34
 * @since 0.0.1
 */
@Data
public class GoFastDfsResult<T> {
    /**
     * 状态
     */
    private String status;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
}
