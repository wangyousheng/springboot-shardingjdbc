package com.example.springbootshardingjdbc.config;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: SdException.java, v 0.1 2019年11月22日 15:27 wb-wys567063 Exp $
 */
public class SdException extends RuntimeException {
    public SdException() {
    }

    public SdException(String message) {
        super(message);
    }

    public SdException(String message, Throwable cause) {
        super(message, cause);
    }

    public SdException(Throwable cause) {
        super(cause);
    }

    public SdException(String message, Throwable cause, boolean enableSuppression,
                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
