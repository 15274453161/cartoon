package com.qgh.dao;

import com.qgh.pojo.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionDao {
    /**
     * 新增章节漫画
     * @param section
     */
    void addSection(Section section);
    List<Section> searchByChartorId(int chaptorId);
    List<Section> preAndNextSection(@Param("chaptorId") int chaptorId,@Param("cartoonId") int cartoonId);
}
