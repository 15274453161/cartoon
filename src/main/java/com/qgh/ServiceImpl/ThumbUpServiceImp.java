package com.qgh.ServiceImpl;

import com.qgh.dao.ThumbUpDao;
import com.qgh.pojo.ThumbUp;
import com.qgh.service.ThumbUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @ClassName: ThumbUpServiceImp
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 17:36
 */
@Service
public class ThumbUpServiceImp implements ThumbUpService {
    @Autowired
    private ThumbUpDao thumbUpDao;
    @Override
    public void addThumbUp(ThumbUp tu) {
        thumbUpDao.addThumbUp(tu);
    }
}
