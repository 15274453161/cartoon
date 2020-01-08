package com.qgh.service;

import com.qgh.pojo.Category;
import com.qgh.util.result.Result;

import java.util.List;

/**
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 10:52
 */
public interface CategoryService {
    void addCategory(String cyName);
    Category searchIdByName(String cyName);

    /**
     * 查询出所有的分类信息
     * @return
     */
    List<Category> selectAllCY();

    Result seletcById(int id);

    /**
     *
     */

}
