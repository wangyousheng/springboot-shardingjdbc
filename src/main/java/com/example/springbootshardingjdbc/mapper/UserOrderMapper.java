package com.example.springbootshardingjdbc.mapper;

import com.example.springbootshardingjdbc.model.UserOrder;

import java.util.List;

/**
 * UserOrderMapper继承基类
 */
public interface UserOrderMapper extends MyBatisBaseMapper<UserOrder, Long> {
    List<UserOrder> listByUserPhone(Long phone);
}