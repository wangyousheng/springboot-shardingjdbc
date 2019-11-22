package com.example.springbootshardingjdbc.model.vo;

import com.example.springbootshardingjdbc.model.User;
import com.example.springbootshardingjdbc.model.UserOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: UserOrderVo.java, v 0.1 2019年11月22日 9:39 wb-wys567063 Exp $
 */
@Data
public class UserOrderVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private User            user;
    private List<UserOrder> userOrderList;
}
