package com.qgh.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @title:
 * @ClassName: Chaptors
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/14
 * @time 14:46
 */
@Data
public class Chaptors {
    private int id;
    private String chaptorName;
    private int ctId;
    private String updateTime;
    private String chaptorUrl;
    private int zanNum;
    private Integer pay;//0为免费 1为付费
    private String payUserId;
    private String bgMusicUrl;//背景音乐
}
