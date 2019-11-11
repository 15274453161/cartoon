package com.qgh.service;


import com.qgh.util.result.Result;



public interface PayRecordService {

    Result addPayRecord(String oderNumber, double money, int userId);
    Result searchAllByUserId(int userId,int pageNo);
}
