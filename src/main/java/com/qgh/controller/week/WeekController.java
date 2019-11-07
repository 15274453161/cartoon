package com.qgh.controller.week;

import com.qgh.util.user.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @title:星期类别显示所有漫画
 * @ClassName: WeekController
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/18
 * @time 11:42
 */
@Controller
public class WeekController {
    @Autowired
    private UserInfor userInfor;
    @RequestMapping("weekSort")
    public  String show(Model model , HttpSession session){
        userInfor.user(model,session);
        return "week";
    }
}
