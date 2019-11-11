package com.qgh.dao;

import com.github.pagehelper.Page;
import com.qgh.pojo.PayRecord;

public interface PayRecordDao {

   void addPayRecord(PayRecord payRecord);
   Page<PayRecord> searchAllByUserId(int userId);
}
