package com.example.springbootshardingjdbc.util;

import com.example.springbootshardingjdbc.model.vo.ResponseVo;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: ResponseUtil.java, v 0.1 2019年11月20日 21:25 wb-wys567063 Exp $
 */
public class ResponseUtil {
    public static ResponseVo success(){
        ResponseVo responseVo = new ResponseVo(true);
        return responseVo;
    }
    public static ResponseVo success(Object data){
        ResponseVo responseVo = new ResponseVo(true,data);
        return responseVo;
    }
    public static ResponseVo fail(String msg, String code, boolean success, Object data){
        ResponseVo responseVo = new ResponseVo(msg, code, success, data);
        return responseVo;
    }
    public static ResponseVo fail(String msg){
        ResponseVo responseVo = new ResponseVo(msg, "1001", false, null);
        return responseVo;
    }
    public static ResponseVo fail(){
        ResponseVo responseVo = new ResponseVo("未知错误", "1001", false, null);
        return responseVo;
    }
}
