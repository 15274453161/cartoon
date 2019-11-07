package com.qgh.util.user;

import com.qgh.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @title:
 * @ClassName: UserInfor
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/30
 * @time 21:47
 */
@Service
public class UserInfor {
    public void user(Model model, HttpSession session){
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
