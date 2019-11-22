package com.example.springbootshardingjdbc.service;

import com.example.springbootshardingjdbc.model.User;
import com.example.springbootshardingjdbc.model.UserOrder;
import com.example.springbootshardingjdbc.model.repquest.UserRequest;
import com.example.springbootshardingjdbc.model.vo.ResponseVo;

import java.util.List;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: UserService.java, v 0.1 2019年11月21日 9:28 wb-wys567063 Exp $
 */
public interface UserService {
    ResponseVo addUser(User user);

    ResponseVo page(UserRequest user);

    ResponseVo listOrderByPhone(Long phone);

    ResponseVo addOrder(UserOrder order);

    /**
     * 垮库事物测试
     * @return
     */
    ResponseVo transicationTest();

    List<User> listByPhones(List<Long> phones);

    ResponseVo findByPhone(Long phone);

    ResponseVo updateUser(User user);

}
