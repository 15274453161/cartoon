package com.qgh.controller.week;

import com.qgh.ServiceImpl.CartoonServiceImpl;
import com.qgh.util.result.Result;
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
    @Autowired
    private CartoonServiceImpl cartoonService;
    @RequestMapping("weekSort")
    public  String show(Model model , HttpSession session){
        //希显示所有的漫画 根据星期类别查询
        Result result= cartoonService.searchByWeekId();
        userInfor.user(model,session);
        model.addAttribute("allCartoon",result.getMsg());
        //设置标志
        model.addAttribute("flag",1);
        //查询所有完结manhunt
        Result comCartoon=cartoonService.searchAllCom(0);
        System.out.println(comCartoon);
        model.addAttribute("comCartoon",comCartoon.getMsg());
        return "week";
    }
}
