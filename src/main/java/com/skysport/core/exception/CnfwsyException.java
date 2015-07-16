package com.skysport.core.exception;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public class CnfwsyException extends RuntimeException {
    private String code;
    private String message;

    public CnfwsyException() {
    }

    public CnfwsyException(String code) {
        this.code = code;
    }

    public CnfwsyException(String message, String code) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
