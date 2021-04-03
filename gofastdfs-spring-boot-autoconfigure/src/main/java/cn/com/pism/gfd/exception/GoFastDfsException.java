package cn.com.pism.gfd.exception;

import lombok.extern.slf4j.Slf4j;


/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 09:56
 * @since 0.0.1
 */
@Slf4j
public class GoFastDfsException extends RuntimeException {

    public GoFastDfsException() {
        log.error("An error occurred");
    }

    public GoFastDfsException(String message) {
        super(message);
    }

    public GoFastDfsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoFastDfsException(Throwable cause) {
        super(cause);
    }

    public GoFastDfsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
