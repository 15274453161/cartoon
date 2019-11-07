package com.qgh.ServiceImpl;

import com.qgh.dao.CategoryDao;
import com.qgh.pojo.Category;
import com.qgh.service.CategoryService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 10:53
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private  CategoryDao categoryDao;

    @Override
    public void addCategory(String cyName) {
        categoryDao.addCategory(cyName);
    }

    @Override
    public Category searchIdByName(String cyName) {
        return categoryDao.searchIdByName(cyName);
    }

    @Override
    public List<Category> selectAllCY() {
        return categoryDao.selectAllCY();
    }

    @Override
    public Result seletcById(int id) {
        return new Result("成功",categoryDao.seletcById(id));
    }


}
