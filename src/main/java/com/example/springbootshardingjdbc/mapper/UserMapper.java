package com.example.springbootshardingjdbc.mapper;

import com.example.springbootshardingjdbc.model.User;
import com.example.springbootshardingjdbc.model.repquest.UserRequest;
import com.example.springbootshardingjdbc.model.vo.UserOrderVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMapper继承基类
 */
public interface UserMapper extends MyBatisBaseMapper<User, Long> {
    User selectByPhone(Long phone);
    Page<User> page(UserRequest userRequest);
    UserOrderVo listOrderByPhone(Long phone);
    List<User> listByPhones(@Param("list") List<Long> phone,@Param("pageIndex") Integer pageIndex,@Param("pageSize")Integer pageSize);
}