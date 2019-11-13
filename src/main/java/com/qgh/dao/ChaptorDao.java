package com.qgh.dao;

import com.github.pagehelper.Page;
import com.qgh.pojo.Chaptors;
import com.qgh.pojo.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ChaptorDao {
    void insertData(Chaptors chaptors);

    /**
     * 分页显示漫画章节
     * @param ctId
     * @return
     */
    Page<Chaptors> searchPage(int ctId);

    /**
     * 根据章节id和漫画id查询章节
     * @param chaptorId
     * @param cartoonId
     * @return
     */
    Chaptors searchByChaptorIdAndCartoonId(@Param("chaptorId") int chaptorId, @Param("cartoonId") int cartoonId);

    /**
     * 根据漫画id查询漫画章节信息
     * @param id
     * @return
     */
    Chaptors searchById(int id);

    Integer searchByCtId(int ctId);

    /**
     * 添加购买用户的id到章节行中
     * @param chaptorId
     * @param userId
     */
    void addPayId(@Param("chaptorId") int chaptorId,@Param("userId")String userId);

    void updateBackgroundMusic(@Param("chaptorId") int chaptorId,@Param("bgMusicUrl")String bgMusicUrl);
}
