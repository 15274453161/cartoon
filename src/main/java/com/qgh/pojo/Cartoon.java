package com.qgh.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 映射漫画表
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 9:53
 */
@Data
@Accessors(chain = true)
public class Cartoon {
    //漫画: id,漫画名,作者,分类id,更新周日id,介绍,状态id,评分,年龄范围id,
    private Integer id;
    private String ctName;
    private String ctAuthor;
    private Integer ctCyId;
    private Integer ctWkId;
    private String ctIntroduce;
    private Integer ctStateId;
    private double ctScore;
    private Integer  ctAgeRangeId;
    private String ctUrl;
    //替换 中间值   分类名  漫画序号
    private String cyName;
    private String ctTitleNo;

}
