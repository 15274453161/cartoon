package com.qgh.service;

import com.qgh.pojo.Section;
import com.qgh.util.result.Result;

public interface SectionService {
    void addSection(Section section);
    Result searchByChartorId(int chaptorId);


}
