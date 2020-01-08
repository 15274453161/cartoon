package com.qgh.ServiceImpl;

import com.qgh.dao.WeekDao;
import com.qgh.service.WeekService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @ClassName: WeekServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/4
 * @time 21:08
 */
@Service
public class WeekServiceImpl implements WeekService {
    @Autowired
    private WeekDao weekDao;

    @Override
    public Result searchAll() {

        return new Result("周末信息查询成功",weekDao.searchAll());
    }
}
