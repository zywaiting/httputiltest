package com.github.zywaiting.httputiltest;

/**
 * Created by 杨文军 on 2017-07-18.
 *
 * @author 杨文军
 * @version 0.1-SNAPSHOT
 */
public class HttpException extends RuntimeException {

    public static final HttpException INSTANCE = new HttpException("系统内部错误");

    public HttpException() {
        super();
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }

    protected HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
