package com.example.springbootshardingjdbc.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: UserOrder.java, v 0.1 2019年11月20日 16:53 wb-wys567063 Exp $
 */
@Data
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;

    /**
     * 用户
     */
    private Long userPhone;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    private Date gmtModified;

    private Date gmtCreate;
}
