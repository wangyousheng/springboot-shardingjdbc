package com.example.springbootshardingjdbc.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: ResponseVo.java, v 0.1 2019年11月20日 21:21 wb-wys567063 Exp $
 */
@Data
public class ResponseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String            msg;
    private String            code;
    private boolean           isSuccess;
    private Object            data;
    public ResponseVo(){
    }
    public ResponseVo(boolean isSuccess){
        this.isSuccess = isSuccess;
        this.code="200";
    }
    public ResponseVo(boolean isSuccess, Object data){
        this.isSuccess = isSuccess;
        this.data=data;
        this.code="200";
    }

    public ResponseVo(String msg, String code, boolean isSuccess, Object data) {
        this.msg = msg;
        this.code = code;
        this.isSuccess = isSuccess;
        this.data = data;
    }
}
