package com.qgh.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qgh.dao.ChaptorDao;
import com.qgh.pojo.Chaptors;
import com.qgh.service.ChaptorsService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @ClassName: ChaptorsServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/14
 * @time 16:47
 */
@Service
public class ChaptorsServiceImpl implements ChaptorsService {
   @Autowired
   private ChaptorDao chaptorDao;
    @Override
    public void insertData(Chaptors chaptors) {
        chaptorDao.insertData(chaptors);
        System.out.println("插入章节");
    }

    /**
     * 根据漫画id分页显示漫画章节
     * @param ctId
     * @param pageNo
     * @return
     */
    @Override
    public Result searchPage(int ctId,int pageNo) {
        if(pageNo<=0){
            pageNo=1;
        }
        PageHelper.startPage(pageNo, 10);
        Page<Chaptors> chaptorList =chaptorDao.searchPage(ctId);

        return Result.SUCCESS(chaptorList.getResult(), chaptorList.getPageNum(),chaptorList.getPages());
    }

    /**
     * 漫画中的上下页的查询判断
     * @param chaptorId
     * @param cartoonId
     * @return
     */
    @Override
    public Result searchByChaptorIdAndCartoonId(int chaptorId, int cartoonId) {
        return Result.SUCCESS(chaptorDao.searchByChaptorIdAndCartoonId(chaptorId,cartoonId));
    }

    /**
     * 根据章节id查询漫画章节信息
     * @param id
     * @return
     */
    @Override
    public Result searchById(int id) {
        return Result.SUCCESS(chaptorDao.searchById(id));
    }

    @Override
    public Integer searchByCtId(int ctId) {
        return chaptorDao.searchByCtId(ctId);
    }

    /**
     * 更新背景音乐
     * @param chaptorId
     * @param bgMusicUrl
     */
    @Override
    public void updateBackgroundMusic(int chaptorId, String bgMusicUrl) {
    chaptorDao.updateBackgroundMusic(chaptorId,bgMusicUrl);
    }


}
