package com.qgh.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @title:用户类
 * @ClassName: User
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/3
 * @time 11:05
 */
@Data
public class User {
    //用户 id,用户名、密码、状态、身份、出生年月月日、性别
    private int id;
    private String userName;
    private String password;
    private int status;
    private int identity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   
    private Date day;
    
    private String birthday;
    private String sex;
    private String vertifyCode;
}
