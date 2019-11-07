package com.qgh.controller.chaptor;

import com.qgh.ServiceImpl.CartoonServiceImpl;
import com.qgh.ServiceImpl.CategoryServiceImpl;
import com.qgh.ServiceImpl.ChaptorsServiceImpl;

import com.qgh.pojo.Cartoon;
import com.qgh.pojo.Chaptors;
import com.qgh.util.result.Result;
import com.qgh.util.user.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @title:章节列表显示
 * @ClassName: ChaptorController
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/14
 * @time 12:59
 */
@Controller
public class ChaptorController {
    @Autowired
    private ChaptorsServiceImpl chaptorsService;
    @Autowired
    private CartoonServiceImpl cartoonService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private UserInfor userInfor;

    @RequestMapping("/chaptor")
    public String showChaptor(int cartoonId, Model model, int currentPage, HttpSession session){

      
        Result result= chaptorsService.searchPage(cartoonId,currentPage);
      
       //查询漫画信息
       Result cartoon= cartoonService.selectById(cartoonId);
      
       //设置漫画信息
        model.addAttribute("cartoon",cartoon.getMsg());

        //查询漫画分类
        Result category= categoryService.seletcById(((Cartoon)cartoon.getMsg()).getCtCyId());
       
        //设置漫画信息
        model.addAttribute("category",category.getMsg());

       //设置章节
       model.addAttribute("chaptors",result.getMsg());
       //设置当前页

        model.addAttribute("currentPage",result.getPageSize());
        //设置总页数

        model.addAttribute("Pages",result.getPages());
        //设置第一话的信息

        
         Integer firsId= chaptorsService.searchByCtId(cartoonId);
         if (firsId==null){
             firsId=1;//防止出错传到前端为空
         }
         model.addAttribute("firsId",firsId);
         userInfor.user(model,session);
         return "chaptor";
    }






}
