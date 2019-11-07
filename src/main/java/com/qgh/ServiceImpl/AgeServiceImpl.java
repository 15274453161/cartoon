package com.qgh.ServiceImpl;

import com.qgh.dao.AgeDao;
import com.qgh.pojo.Age;
import com.qgh.service.AgeServicce;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title:
 * @ClassName: AgeServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/17
 * @time 22:31
 */
@Service
public class AgeServiceImpl implements AgeServicce {
    @Autowired
    private AgeDao ageDao;
    @Override
    public Result searchAllAge() {
        return Result.SUCCESS(ageDao.searchAllAge());
    }
}
