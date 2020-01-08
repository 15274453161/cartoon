package com.qgh.dao;


import com.qgh.pojo.Week;

import java.util.List;

public interface WeekDao {
    List<Week> searchAll();

    List<Week> searchAllById(int id);


}
