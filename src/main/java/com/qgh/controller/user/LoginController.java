package com.qgh.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgh.ServiceImpl.UserServiceImpl;
import com.qgh.pojo.User;
import com.qgh.util.result.Result;


@Controller
public class LoginController {
/**
 * 进入登录显示界面前：判断用户是否登录
 * @return
 */
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@RequestMapping("/account-login-show")
	public String login(Model model,HttpSession session) {
		//判断用户登录状态
		user(model,session);
		return "login";
	}
	
	/**
	 * 登录之前判断用户是否已经登录
	 * @return 返回到首页
	 */
	@RequestMapping("/account-login")

	public String lognIn(String userName,String password,HttpSession session,Model model) {
         //1、根据用户名和密码查询用户登录状况
	     Result result=	userServiceImpl.login(userName, password);
         //2、将登陆信息存入session
		 session.setAttribute("userInfor",result.getMsg());
		session.setMaxInactiveInterval(60*60);
		 //3、将用户登录状况信息返回前端 方便弹出提示信息
		 model.addAttribute("code",result.getCode());
		 //4、获取用户session中的值并存入model总 传递到html 方便动态修改头部
		 user(model,session);

		 return "login";
	}

	/**
	 * 判断用户是否登录 并返回用户id
	 * @return
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public int isLogin(HttpServletRequest request){

		HttpSession session=	request.getSession();

		int userId=0;
		//用户登录
		Object obj=session.getAttribute("userInfor");

		if (obj!=null){
			userId=(((User)obj).getId());
			System.out.println("用户id"+userId);
		}else{
			System.out.println("用户没有登录");
		}

		return userId;
	}

	/**
	 * 注销用户身份
	 * @param request
	 */
	@RequestMapping("/validateUser")
	@ResponseBody
	public String validateUser(HttpServletRequest request){
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("userInfor");
		if (obj!=null){
			//1、注销时将用户登录状态值为0
			userServiceImpl.setStatus(((User)obj).getId(),0);
		}
		//2、销毁session
		session.invalidate();

		return "0";
	}

	/**
	 * 获取session中的用户信息存储到model中
	 * @param model
	 * @param session
	 */
	public void user(Model model,HttpSession session){
		//4、获取用户session中的值并存入model总 传递到html 方便动态修改头部
		Object obj=session.getAttribute("userInfor");
		//5、判断session中的值 存入model中
		if (obj!=null){
			//已经登录
			model.addAttribute("userId",((User)obj).getId());
		}else{
			//没有登录
			model.addAttribute("userId",0);
		}
	}
}
