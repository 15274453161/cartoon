package com.qgh.pojo;

import lombok.Data;

import java.util.List;


/**
 * @title:评论表
 * @ClassName: Comment
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/29
 * @time 9:28
 */
@Data
public class Comment {
    private Integer id;
    private String commentTime;
    private  String commentContent;
    private Integer userId;
    private Integer chaptorId;
    private Integer replay;
    private Integer zan;

    private String  userName;
    private Integer childLength;
    //父评论下的子评论
    private List<Comment> commentList;
}
