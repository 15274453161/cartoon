package com.qgh.controller.rank;

import com.qgh.ServiceImpl.AgeServiceImpl;
import com.qgh.ServiceImpl.CartoonServiceImpl;
import com.qgh.ServiceImpl.CategoryServiceImpl;
import com.qgh.dao.CartoonDao;
import com.qgh.pojo.Age;
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
 * @title:排行榜的
 * @ClassName: RankController
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/17
 * @time 21:56
 */
@Controller
public class RankController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private AgeServiceImpl ageService;
    @Autowired
    private CartoonServiceImpl cartoonService;
    @Autowired
    private UserInfor userInfor;
    /**
     *
     * @param model
     * @param categoryId 选择的分类标签Id
     * @param ageId 传递进来选择的年龄的ID
     * @return
     */
    @RequestMapping("/rank")
    public String rank(Model model, Integer categoryId, Integer ageId, HttpSession session){

        //查询出所有分类标签
        List<Category> categoryList= categoryService.selectAllCY();
        model.addAttribute("category",categoryList);
        System.out.println(categoryList);
        //查询出所有的年龄
        Result result =  ageService.searchAllAge();
        model.addAttribute("age",result.getMsg());

        //开始根据分类id进行分类
        Result cartoonList=cartoonService.rankByCyId(categoryId);
        model.addAttribute("cartoon",cartoonList.getMsg());
        userInfor.user(model,session);
        return "rank";
    }
}
