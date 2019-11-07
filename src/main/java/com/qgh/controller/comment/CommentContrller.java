package com.qgh.controller.comment;

import com.qgh.ServiceImpl.CommentServiceImpl;
import com.qgh.pojo.Comment;
import com.qgh.util.date.DateFormat;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @title:
 * @ClassName: CommentContrller
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/29
 * @time 9:46
 */
@Controller
public class CommentContrller {

    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private DateFormat dateFormat;
    @RequestMapping("/showAllComment")
    public String showAllComment(){

        return "section";
    }

    /**
     * 发布评论
     * @param content
     * @return
     */
    @RequestMapping("/publishComment")
    @ResponseBody
    public List<Comment> publishComment(String content, Integer chaptorId, Integer userId, Integer replay){
        Comment comment=new Comment();
        comment.setCommentTime(dateFormat.formatDate(new Date()));
        comment.setUserId(userId);
        comment.setChaptorId(chaptorId);
        comment.setReplay(replay);
        comment.setCommentContent(content);
        commentService.insertComment(comment);

        Result comL= commentService.showAll(chaptorId,1);
        return (List<Comment>)comL.getMsg();
    }

    @RequestMapping("/commentZan")
    @ResponseBody
    public String commentZan(Integer commentId,Integer zanNum){

        commentService.addZan(commentId,zanNum);
        return "";
    }

}
