package com.example.springbootshardingjdbc.controller;

import com.example.springbootshardingjdbc.model.User;
import com.example.springbootshardingjdbc.model.UserOrder;
import com.example.springbootshardingjdbc.model.repquest.UserRequest;
import com.example.springbootshardingjdbc.model.vo.ResponseVo;
import com.example.springbootshardingjdbc.service.UserService;
import com.example.springbootshardingjdbc.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: UserController.java, v 0.1 2019年11月20日 21:15 wb-wys567063 Exp $
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add")
    public ResponseVo addUser(User user){
        if(user.getPhone() == null){
            return ResponseUtil.fail("手机号不能为空");
        }
        return userService.addUser(user);
    }

    /**
     *   gmt_create   timestamp default CURRENT_TIMESTAMP not null<br>
     *   gmt_modified timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP<br>
     *   gmt_create当insert的时候生成，不会再变化<br>
     *   gmt_modified当insert的时候生成，每次modify会再变化
     */
    @RequestMapping(value = "update")
    public ResponseVo updateUser(User user){
        if(user.getId() == null){
            return ResponseUtil.fail("用户ID不能为空");
        }

        //更新手机号和年龄后，通过手机号查用户，可能查不到（sharding）
        if(user.getPhone() != null){
            return ResponseUtil.fail("不能更新手机号");
        }
        if(user.getAge() != null){
            return ResponseUtil.fail("不能更新年龄");
        }
        return userService.updateUser(user);
    }
    @RequestMapping(value = "findByPhone")
    public ResponseVo findByPhone(Long phone){
        if(phone== null){
            return ResponseUtil.fail("手机号不能为空");
        }
        return userService.findByPhone(phone);
    }

    @RequestMapping(value = "addOrder")
    public ResponseVo addOrder(UserOrder order){
        if(order.getUserPhone() == null){
            return ResponseUtil.fail("手机号不能为空");
        }
        return userService.addOrder(order);
    }

    @RequestMapping("page")
    public ResponseVo page(UserRequest userRequest) {
        return userService.page(userRequest);
    }

    @RequestMapping("listOrder")
    public ResponseVo listOrder(Long phone){
        return userService.listOrderByPhone(phone);
    }

    @RequestMapping("transicationTest")
    public ResponseVo transicationTest(){
        return userService.transicationTest();
    }

    /**
     * 测试垮库in查询
     * @param phones
     * @return
     */
    @RequestMapping("listByPhones")
    public ResponseVo listByPhones(@RequestParam("phones") List<Long> phones){
        if(CollectionUtils.isEmpty(phones)){
            return ResponseUtil.fail("手机号不能为空");
        }
        return ResponseUtil.success(userService.listByPhones(phones));
    }
}
