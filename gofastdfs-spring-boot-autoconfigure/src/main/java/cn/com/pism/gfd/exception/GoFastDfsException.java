package cn.com.pism.gfd.exception;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 09:56
 * @since 0.0.1
 */
public class GoFastDfsException extends RuntimeException {

    Logger log = LoggerFactory.getLogger(GoFastDfsException.class);

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
