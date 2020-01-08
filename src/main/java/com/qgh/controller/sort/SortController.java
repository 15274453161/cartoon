package com.qgh.controller.sort;

import com.qgh.ServiceImpl.CategoryServiceImpl;
import com.qgh.pojo.Category;
import com.qgh.util.result.Result;
import com.qgh.util.user.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @title:分类
 * @ClassName: Sort
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/12/30
 * @time 16:51
 */
@Controller
public class SortController {
    @Autowired
    private UserInfor userInfor;
    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * 前端点击分类时
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/sort")
    public String sort(Model model , HttpSession session){
        userInfor.user(model,session);
        //从后台获取标签传递到前端
        List<Category> categories= categoryService.selectAllCY();
       //将分类目录传入到前端
        model.addAttribute("categories",categories);
        //根据漫画标签将漫画传递到前端

        Result sortResult= categoryService.selectBycy();
        model.addAttribute("sortCartoon",sortResult.getMsg());
       //设置一个标志
      //  model.addAttribute("cyflag",1);
        return "sort";
    }
}
