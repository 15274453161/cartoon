package com.qgh.controller;

import com.qgh.ServiceImpl.CartoonServiceImpl;
import com.qgh.ServiceImpl.WeekServiceImpl;
import com.qgh.util.result.Result;
import com.qgh.util.user.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @title:
 * @ClassName: TestController
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/1
 * @time 21:58
 */
@Controller
public class IndexController {
    @Autowired
    private CartoonServiceImpl cartoonService;
    @Autowired
    private WeekServiceImpl weekService;
    @Autowired
    private UserInfor userInfor;
    @RequestMapping("/index")
    public String index(Model model, HttpSession session){

        /**
         * 将漫画的信息传递到前端 只需要前八条
         */
        common(model,1);
        userInfor.user(model,session);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    /**
     * 选择周几的漫画
     * @return
     */
    @RequestMapping("/week")
    @ResponseBody
    public Object week(int weekId){

        //根据周末id查询漫画
        Result result=  cartoonService.searchByWeekIdEight(weekId);
         return result.getMsg();
    }

   /**
     * 通用的返回首页的代码
     * @param model
     */
    public void common(Model model,int weekId){
        Result result= cartoonService.indexEight(weekId);
        model.addAttribute("cartoon",result.getMsg());

        Result resultWk= weekService.searchAll();
        model.addAttribute("week",resultWk.getMsg());
        System.out.println(resultWk);
    }

    /**
     * 根据漫画名字进行搜索
     * @param cartoonName
     * @return
     */
    @RequestMapping("/search")
    public String search(String cartoonName,Model model,HttpSession session){

        Result cartoon=   cartoonService.searchCartoonByName(cartoonName);
        model.addAttribute("cartoon",cartoon.getMsg());
        model.addAttribute("cartoonName",cartoonName);
        userInfor.user(model,session);
        return "search";
    }

}
