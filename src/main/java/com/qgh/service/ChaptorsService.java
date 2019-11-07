package com.qgh.service;



import com.qgh.pojo.Chaptors;
import com.qgh.util.result.Result;
import org.apache.ibatis.annotations.Param;

public interface ChaptorsService {
    void insertData(Chaptors chaptors);
    Result searchPage(int ctId,int pageNo);
    Result searchByChaptorIdAndCartoonId(@Param("chaptorId") int chaptorId, @Param("cartoonId") int cartoonId);
    Result searchById(int id);
    Integer searchByCtId(int ctId);
}
