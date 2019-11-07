package com.qgh.dao;

import com.github.pagehelper.Page;
import com.qgh.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    /**
     * 分页显示当前章节下的评论
     * @return
     */
    Page<Comment> showAll(int chaptorId);

    /**
     * 插入评论
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * 批量插入评论
     * @param commentList
     */
    void batchInsert(List<Comment> commentList);

    /**
     * 根据评论id 查询出当前父评论下的所有孩子评论
     * @param commentId
     * @return
     */
    Page<Comment> showChild(int commentId);

    /**
     * 更新点赞数：++
     * @param commentId 让参数的用户的赞数++或--
     * @param zan
     */
    void addZan(@Param("commentId") int commentId,@Param("zan") int zan);
}
