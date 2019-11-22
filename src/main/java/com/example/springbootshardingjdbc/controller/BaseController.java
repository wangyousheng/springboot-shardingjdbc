package com.example.springbootshardingjdbc.controller;

import com.example.springbootshardingjdbc.config.SdException;
import com.example.springbootshardingjdbc.model.vo.ResponseVo;
import com.example.springbootshardingjdbc.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *@author wb-wys567063
 *@version $ Id: BaseController.java, v 0.1 2019年11月21日 9:29 wb-wys567063 Exp $
 */
@Controller
public class BaseController {
    @ExceptionHandler(Exception.class)
    protected ResponseVo handEx(Exception e){
        e.printStackTrace();
        return ResponseUtil.fail(e.getMessage());
    }
    @ExceptionHandler(SdException.class)
    protected ResponseVo handEx(SdException e){
        e.printStackTrace();
        return ResponseUtil.fail(e.getMessage());
    }
}
