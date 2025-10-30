package com.zb.service;

import com.zb.entity.User;

public interface UserService {

    String login(String username,String password);

    Integer buyItem(String username, Double totalPrice);

}
