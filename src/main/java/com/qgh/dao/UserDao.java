package com.qgh.dao;

import org.apache.ibatis.annotations.Param;

import com.qgh.pojo.User;

public interface UserDao {
     User isexist(String email);
     void addUser(User user);
     
     User login(@Param("userName") String userName,@Param("password") String password);
     
     void setStatus(@Param("id")int id,@Param("status") int status);
}
