package com.example.springbootshardingjdbc.model;

import lombok.Data;

import java.util.Date;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: User.java, v 0.1 2019年11月20日 16:49 wb-wys567063 Exp $
 */
@Data
public class User {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 手机号
     */
    private Long phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;
    private Date gmtModified;

    private Date gmtCreate;
}
