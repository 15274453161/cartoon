package com.qgh.ServiceImpl;

import com.aliyun.oss.OSSClient;
import com.qgh.dao.SectionDao;
import com.qgh.pojo.Section;
import com.qgh.service.SectionService;
import com.qgh.util.aliyun.OssUtil2;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title:
 * @ClassName: SectionServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/15
 * @time 15:23
 */
@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionDao sectionDao;

    @Override
    public void addSection(Section section) {
        sectionDao.addSection(section);
    }

    @Override
    public Result searchByChartorId(int chaptorId) {
    // List<Section> sectionList=sectionDao.searchByChartorId(chaptorId);
       // OSSClient ossClient = OssUtil2.getOSSClient();

    // for (int i=0;i<sectionList.size();++i){
        // sectionList.get(i).setSectionUrl(OssUtil2.getUrl());
    // }
        return new Result("成功",sectionDao.searchByChartorId(chaptorId));
    }

    public int judge(int flag,int charptorId){
        if (flag==0){
            charptorId++;
        }else{
            charptorId--;
        }
        return charptorId;
    }


}
