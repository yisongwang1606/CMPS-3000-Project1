package com.zb.service.impl;

import com.zb.entity.User;
import com.zb.mapper.UserMapper;
import com.zb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username,password);
        if (user == null){
            return null;
        }
        String token = user.getUsername()+"_"+user.getRole();
        return token;
    }

    @Override
    public Integer buyItem(String username, Double totalPrice) {
        User user = userMapper.findUser(username);
        if (user.getBalance()<totalPrice){
            return 0;
        }
        Double newBalance = user.getBalance()-totalPrice;
        Integer num = userMapper.buyItems(username,newBalance);
        return num;
    }

}
