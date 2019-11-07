package com.qgh.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgh.ServiceImpl.UserServiceImpl;
import com.qgh.pojo.User;
import com.qgh.service.UserService;
import com.qgh.util.date.DateFormat;
import com.qgh.util.email.EmailUtil;

@Controller
public class RegisterController {
	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private DateFormat formatDate;

	@RequestMapping("/account-register-show")
	public String login() {
		System.out.println("注册");
		return "register";
	}

	/**
	 * 获取邮箱的验证码
	 * 
	 * @return
	 */
	@RequestMapping("/getVerification")
	@ResponseBody
	public String getVerification(String email) {
		emailUtil.sendVerificationCode(email);
		System.out.println("获取邮箱验证码");
		return "register";
	}

	/**
	 * 开始校验注册
	 * 
	 * @return
	 */
	@RequestMapping("/startRegister")
    @ResponseBody
	public String register(@RequestBody User user) {

		String codeString = emailUtil.getVertifyCode();
		System.out.println("缓存中的验证码：" + codeString);
		System.out.println("前端的验证码 " + user.getVertifyCode());
		System.out.println("前端的面密码" + user.getPassword());
		System.out.println("前端的日期" + user.getBirthday());

		if (!user.getVertifyCode().equals(codeString)) {
            //验证码正确开始检验是否已经注册
			 return "验证码错误";
		} 
		
		return userService.register(user);
	}
}
