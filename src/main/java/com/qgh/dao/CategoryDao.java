package com.qgh.dao;

import com.qgh.pojo.Category;

import java.util.List;

/**
 * 分类表接口
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 10:27
 */
public interface CategoryDao {
    /**
     * 新增分类名称
     * @param cyName
     */
    void addCategory(String cyName);

    /**
     * 根据名称查询分类id
     * @param cyName
     * @return
     */
    Category searchIdByName(String cyName);

    List<Category> selectAllCY();

    Category seletcById(int id);


}
