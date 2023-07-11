package com.example.exception;

import cn.hutool.http.HttpStatus;

public class ServiceException extends RuntimeException{

    private int code;

    public int getCode() {
        return code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

}
