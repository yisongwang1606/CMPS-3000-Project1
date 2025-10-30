package com.zb.controller;

import com.zb.service.UserService;
import com.zb.util.LoginData;
import com.zb.util.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value="userController",tags={"LoginApi"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("login")
    public ResponseResult login(@RequestBody LoginData loginData){
        return ResponseResult.success(userService.login(loginData.getUsername(),loginData.getPassword()));
    }

    @GetMapping("buy")
    public ResponseResult changeBalance(@RequestParam("username") String username, @RequestParam("totalPrice") Double totalPrice){
        return ResponseResult.success(userService.buyItem(username,totalPrice));
    }


}
