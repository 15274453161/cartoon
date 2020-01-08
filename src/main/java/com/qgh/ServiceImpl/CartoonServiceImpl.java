package com.qgh.ServiceImpl;

import com.qgh.dao.CartoonDao;
import com.qgh.pojo.Cartoon;
import com.qgh.pojo.Week;
import com.qgh.service.CartoonService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        cartoonDao.updatePcUrl(ctUrl, id);
    }

    @Override
    public Result indexEight(int weekId) {
        List<Cartoon> cartoons = cartoonDao.indexEight(weekId);

        return new Result("查询成功", cartoons);
    }

    @Override
    public Result selectById(int cartId) {
        return new Result("成功", cartoonDao.selectById(cartId));
    }

    @Override
    public Result searchCartoonByName(String cartoonName) {
        return Result.SUCCESS(cartoonDao.searchCartoonByName(cartoonName));
    }

    @Override
    public Result rankByCyId(int cyId) {
        return Result.SUCCESS(cartoonDao.rankByCyId(cyId));
    }

    /**
     * 根据漫画七个周末日期查询出其下面的所有漫画
     *
     * @return
     */
    @Override
    public Result searchByWeekId() {
        //一个List里面有7个子list
        List<Cartoon> allWeek = new ArrayList<>();
        for (int i = 1; i <= 7; ++i) {
            //找当当前星期下的所有漫画
            Cartoon cartoon = new Cartoon();
            List<Cartoon> cartoonList = cartoonDao.searchByWeekId(i);
            //设置周日名称
            cartoon.setWkName(cartoonList.get(0).getWkName());
            cartoon.setWeekCartoon(cartoonList);
            allWeek.add(cartoon);
        }
        return Result.SUCCESS(allWeek);
    }

    /**
     * 首页显示8条星期
     * @param weekId
     * @return
     */
    @Override
    public Result searchByWeekIdEight(int weekId) {
        return Result.SUCCESS(cartoonDao.searchByWeekIdEight(weekId));
    }


    /**
     * 查询所有完结漫画 状态为0
     * @param state
     * @return
     */
    public Result searchAllCom(int state){
    return Result.SUCCESS(cartoonDao.searchAllCom(state));
    }
}
