package com.example.springbootshardingjdbc.service.impl;

import com.example.springbootshardingjdbc.config.SdException;
import com.example.springbootshardingjdbc.mapper.UserMapper;
import com.example.springbootshardingjdbc.mapper.UserOrderMapper;
import com.example.springbootshardingjdbc.model.User;
import com.example.springbootshardingjdbc.model.UserOrder;
import com.example.springbootshardingjdbc.model.repquest.UserRequest;
import com.example.springbootshardingjdbc.model.vo.ResponseVo;
import com.example.springbootshardingjdbc.model.vo.UserOrderVo;
import com.example.springbootshardingjdbc.service.UserService;
import com.example.springbootshardingjdbc.util.ResponseUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: UserServiceImpl.java, v 0.1 2019年11月21日 9:51 wb-wys567063 Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper      userMapper;
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public ResponseVo addUser(User user) {
        User queryUser = userMapper.selectByPhone(user.getPhone());
        if(queryUser != null){
            return ResponseUtil.fail("用户已注册");
        }
        int insert = userMapper.insert(user);
        if (insert==1){
            return ResponseUtil.success(user);
        }
        return ResponseUtil.fail();
    }

    @Override
    public ResponseVo page(UserRequest userRequest) {
        Page<User> page = userMapper.page(userRequest);
        return ResponseUtil.success(new PageInfo<>(page));
    }

    @Override
    public ResponseVo listOrderByPhone(Long phone) {
        UserOrderVo userOrderVo = userMapper.listOrderByPhone(phone);
        return ResponseUtil.success(userOrderVo);
    }

    @Override
    public ResponseVo addOrder(UserOrder order) {
        User user = userMapper.selectByPhone(order.getUserPhone());
        if(user == null){
            return ResponseUtil.fail("用户不存在");
        }
        userOrderMapper.insert(order);
        return ResponseUtil.success();
    }

    /**
     * @see io.shardingsphere.shardingjdbc.jdbc.adapter.AbstractConnectionAdapter#commit()
     *
     * 单库时spring底层事物是通过threadlocal缓存了Connection,因此updateA和updateB共享一个链接，从而connection.commit整体提交或connection.rollback整体回滚
     * </br>
     * 而shardingjdbc分库之后，获取到的链接是不通的，通过查看代码AbstractConnectionAdapter#commit(),发现：</br>
     * shardingjdbc总链接处理了多条sql语句，最后一次性提交整个事务，每一条sql语句可能会分为多条子sql分库分表去执行，这意味着底层可能会关联多个真正的数据库连接
     * 引擎会遍历底层所有真正的数据库连接，一个个进行commit操作，如果任何一个出现了异常，直接捕获异常，但是也只是捕获而已，然后接着下一个连接的commit
     * 参考：https://blog.csdn.net/yanyan19880509/article/details/78335935
     * @return
     */
    @Override
    @Transactional
    public ResponseVo transicationTest() {
        //此用例，ds1 t1主键冲突，ds0、ds1 都会回滚


        //ds0 t0
        User user = new User();
        user.setPhone(110L);
        user.setAge(0);
        userMapper.insert(user);

        //ds1 t0
        User user1 = new User();
        user1.setPhone(111L);
        user1.setAge(0);
        userMapper.insert(user1);
        User user2 = new User();
        user2.setAge(0);
        user2.setPhone(111L);
        userMapper.insert(user2);
        return ResponseUtil.success();
    }

    @Override
    public List<User> listByPhones(List<Long> phones) {
        return userMapper.listByPhones(phones,1,2);//所有库表子sql，重写为limit 0,2，然后由shardingJdbc合并后再做limit 2
//        return userMapper.listByPhones(phones,2,2);//所有库表子sql，重写为limit 0,4，然后由shardingJdbc合并后再做limit 2
    }

    @Override
    public ResponseVo findByPhone(Long phone) {
        return ResponseUtil.success(userMapper.selectByPhone(phone));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseVo updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i!=1){
            throw new SdException("更新失败");
        }
        return ResponseUtil.success();
    }
}
