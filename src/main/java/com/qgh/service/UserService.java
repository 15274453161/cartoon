package com.qgh.service;

import com.qgh.pojo.User;
import com.qgh.util.result.Result;

/**
 * @title:用户逻辑操作
 * @ClassName: UserService
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/3
 * @time 11:10
 */
public interface UserService {
    /**
     * 判断注册时是否存在此用户
     * @param email
     * @return
     */
   public User isexist(String email);
   void addUser(User user);
   Result login(String userName,String password);
   void setStatus(int id,int status);
}
