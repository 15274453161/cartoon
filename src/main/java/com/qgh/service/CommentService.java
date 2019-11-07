package com.qgh.service;

import com.qgh.pojo.Comment;
import com.qgh.util.result.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    /**
     * 根据章节id和页号显示评论
     * @param chaptorId
     * @param pageNo
     * @return
     */
    Result showAll(int chaptorId,int pageNo);

    /**
     * 新增评论
     * @param comment
     * @return
     */
     Result insertComment(Comment comment);

    /**
     * 批量插入评论
     * @param commentList
     */
     void  batchInsert(List<Comment> commentList);

    /**
     * 显示父评论下的孩子回复
     * @param pageNo
     * @param CommendId
     * @return
     */
     Result showReplay(int pageNo,int CommendId);

    /**
     * 更新评论点赞表根据用户id
     * @param commentId
     * @param zan
     */
    void addZan( int commentId,  int zan);
}
