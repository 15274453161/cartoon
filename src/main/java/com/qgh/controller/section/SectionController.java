package com.qgh.controller.section;

import com.qgh.ServiceImpl.CartoonServiceImpl;
import com.qgh.ServiceImpl.ChaptorsServiceImpl;
import com.qgh.ServiceImpl.CommentServiceImpl;
import com.qgh.ServiceImpl.SectionServiceImpl;

import com.qgh.util.result.Result;

import afu.org.checkerframework.checker.units.qual.cd;

import com.qgh.util.user.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * @title:章节漫画内容
 * @ClassName: SectionController
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/15
 * @time 14:23
 */
@Controller
public class SectionController {
    @Autowired
    private SectionServiceImpl sectionService;
    @Autowired
    private ChaptorsServiceImpl chaptorsService;
    @Autowired
    private CartoonServiceImpl cartoonService;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private UserInfor userInfor;
   
    @RequestMapping("/section")
    public String show(int chaptorId, int cartoonId, Model model, HttpSession session) {

        //根据章节id查询出集合返回
        Result result = sectionService.searchByChartorId(chaptorId);
        //设置漫画章节信息
        model.addAttribute("section", result.getMsg());
        //设置漫画id
        model.addAttribute("cartoonId", cartoonId);
        //(Section)
        model.addAttribute("chaptorId", chaptorId);
        //设置漫画标题和本章标题
        Result chaptors = chaptorsService.searchById(chaptorId);
        model.addAttribute("chaptor", chaptors.getMsg());
        Result cartoon = cartoonService.selectById(cartoonId);

        model.addAttribute("cartoon", cartoon.getMsg());
        //传入一级父评论
        Result com=commentService.showAll(chaptorId,1);
        System.out.println(com);
        model.addAttribute("comment",com.getMsg());
        userInfor.user(model,session);
        return "section";
    }

    /**
     * 翻页上下节
     *
     * @param cartoonId 漫画id
     * @param chaptorId 漫画章节id
     * @param model
     * @return
     */
    @RequestMapping("/sectionPage")
    public String preAndNextSection(int chaptorId, int cartoonId, Integer flag, Model model,HttpSession session) {
        //根据cartoonId和chaptorId查询漫画
        Result result = chaptorsService.searchByChaptorIdAndCartoonId(chaptorId, cartoonId);
        if (result == null) {
            chaptorId = sectionService.judge(flag, chaptorId);

        }
        return show(chaptorId, cartoonId, model,session);

    }


     @RequestMapping("/sendComment")
     @ResponseBody
     public String sendComment(String content){
         System.out.println("发送后台成功"+content);

         return "hh";
     }

}
