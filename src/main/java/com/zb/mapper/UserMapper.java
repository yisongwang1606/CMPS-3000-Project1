package com.zb.mapper;

import com.zb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User login(@Param("username") String username,@Param("password") String password);

    Integer buyItems(@Param("username") String username, @Param("balance") Double balance);

    User findUser(@Param("username") String username);

}
