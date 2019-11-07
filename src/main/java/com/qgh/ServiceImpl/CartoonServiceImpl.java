package com.qgh.ServiceImpl;

import com.qgh.dao.CartoonDao;
import com.qgh.pojo.Cartoon;
import com.qgh.service.CartoonService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 11:42
 */
@Service
public class CartoonServiceImpl implements CartoonService {
    @Autowired
    private CartoonDao cartoonDao;
    @Override
    public void addCartoon(Cartoon cartoon) {
        cartoonDao.addCartoon(cartoon);
    }

    @Override
    public List<Cartoon> selectAll() {
        return cartoonDao.selectAll();
    }

    @Override
    public void updatePcUrl(String ctUrl, Integer id) {
        cartoonDao.updatePcUrl(ctUrl,id);
    }

    @Override
    public Result indexEight(int weekId) {
    List<Cartoon> cartoons=    cartoonDao.indexEight(weekId);

        return new Result("查询成功",cartoons);
    }
    @Override
     public   Result selectById(int cartId){
     return   new Result("成功",cartoonDao.selectById(cartId)) ;
    }

    @Override
    public Result searchCartoonByName(String cartoonName) {
        return Result.SUCCESS(cartoonDao.searchCartoonByName(cartoonName));
    }

    @Override
    public Result rankByCyId(int cyId) {
        return Result.SUCCESS(cartoonDao.rankByCyId(cyId));
    }
}
