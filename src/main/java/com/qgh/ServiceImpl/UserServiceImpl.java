package com.qgh.ServiceImpl;

import com.qgh.dao.UserDao;
import com.qgh.pojo.User;
import com.qgh.service.UserService;
import com.qgh.util.encryption.EncryptionUtil;
import com.qgh.util.result.Result;

import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @ClassName: UserServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/3
 * @time 11:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User isexist(String email) {
    	//userDao.isexist(email);
        return userDao.isexist(email);
    }
    /**
     * 检查是否存在此用户
     * @param eamil
     * @return
     */
    public String register(User user) {
      User user1=	isexist(user.getUserName());
      if (user1!=null) {
		return "此用户已经存在";
	   }
      //开始进行密码加密
      String plusPassword;
      try {
    	  plusPassword=EncryptionUtil.dealPassword(user.getPassword());
    	  System.err.println("加密后的密码:"+plusPassword);
    	  user.setPassword(plusPassword);
    	  addUser(user);
    	  //开始插入数据到数据库
	} catch (UnsupportedEncodingException e) {

		e.printStackTrace();
	}
      return "注册成功";
    }
    
    
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	
	/**
	 * 登录时判断用户密码和用户名是否正确
	 */
	@Override
	public Result login(String userName, String password) {

		/**
		 * 解密的过程就是要将加密的密码查询出来获得盐值
		 */

		User user0=userDao.isexist(userName);

		if(user0==null) {
			System.out.println("不存在此用户，请先注册");
			return new Result("不存在此用户，请先注册",null);
		}

		String LessPassword;
		try {
			 LessPassword= EncryptionUtil.dealPasswordWithSalt(password,EncryptionUtil.getSalt(user0.getPassword()));
		    
			 if(!LessPassword.equals(user0.getPassword())) {
				 System.out.println("用户密码错误");
				 return new Result("用户密码错误",null);
				
			 }
		} catch (InvalidParameterException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
       //在用户不存在和密码错误之后进行
		if(user0.getStatus()==1){
			System.out.println("您已经登录");
			return new Result("您已经登录，请不要重复登录",user0);
		}
		 //登录成功将用户的状态为值位1
		 setStatus(user0.getId(),1);
	     return new Result("登录成功",user0);
	}
	/**
	 * 更新用户的用户的状态位
	 */
	@Override
	public void setStatus(int id,int status) {

		userDao.setStatus(id,status);
	}
	
}
