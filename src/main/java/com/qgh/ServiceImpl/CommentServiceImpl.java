package com.qgh.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qgh.dao.CommentDao;
import com.qgh.pojo.Comment;
import com.qgh.service.CommentService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title:
 * @ClassName: CommentServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/29
 * @time 9:33
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;


    @Override
    public Result showAll(int chaptorId,int pageNo) {
         PageHelper.startPage(pageNo, 10);
         //查询出10条父评论
         Page<Comment> commentPage=  commentDao.showAll(chaptorId);
        //查询出5条子评论 一条父评论下可能有很多条子评论

        for (int i=0;i<commentPage.size();++i){
            Page<Comment> replay= commentDao.showChild(commentPage.get(i).getId());
            commentPage.get(i).setCommentList(replay.getResult());
            commentPage.get(i).setChildLength(replay.size());
        }

         return Result.SUCCESS(commentPage.getResult(),commentPage.getPageNum(),commentPage.getPages());
    }

    @Override
    public Result insertComment(Comment comment) {
        commentDao.insertComment(comment);
        return Result.SUCCESS("成功");
    }

    @Override
    public void batchInsert(List<Comment> commentList) {
        commentDao.batchInsert(commentList);
    }

    @Override
    public Result showReplay(int pageNo, int CommendId) {
        return null;
    }

    @Override
    public void addZan(int commentId, int zan) {
        commentDao.addZan(commentId,zan);
    }
}
