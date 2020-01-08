package com.qgh.ServiceImpl;

import com.qgh.dao.CartoonDao;
import com.qgh.dao.CategoryDao;
import com.qgh.pojo.Cartoon;
import com.qgh.pojo.Category;
import com.qgh.service.CategoryService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private CartoonDao cartoonDao;


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

    /**
     * 根据漫画分类id查询所有分类下的漫画
     */
     public Result selectBycy(){
        List<Category> cyAll=  categoryDao.selectAllCY();
        //声明一个存储所有分类集合的集合
        List<Cartoon> cartoonList=new ArrayList<>();
        for (int i=0;i<cyAll.size();++i){
            Cartoon cartoon=new Cartoon();
            List<Cartoon> cylist=   cartoonDao.searchByCyId(cyAll.get(i).getId());
            cartoon.setCyCartoon(cylist);
            cartoon.setCtCyId(cyAll.get(i).getId());
            cartoon.setCyName(cyAll.get(i).getCyName());
            cartoonList.add(cartoon);
        }
        return new Result("成功",cartoonList);
    }
}
