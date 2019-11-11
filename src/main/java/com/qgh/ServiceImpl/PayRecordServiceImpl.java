package com.qgh.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qgh.dao.PayRecordDao;
import com.qgh.pojo.PayRecord;
import com.qgh.pojo.User;
import com.qgh.service.PayRecordService;
import com.qgh.util.date.DateFormat;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @title:
 * @ClassName: PayRecordServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/11
 * @time 11:34
 */
@Service
public class PayRecordServiceImpl implements PayRecordService {
    @Autowired
    private PayRecordDao payRecordDao;
    @Autowired DateFormat dateFormat;

    /**
     * 支付订单的插入
     * @param oderNumber
     * @param money
     * @return
     */
    @Override
    public Result addPayRecord(String oderNumber, double money,int userId) {
    PayRecord payRecord=new PayRecord();
    payRecord.setOderNumber(oderNumber);
    payRecord.setPayMoney(money);
    payRecord.setPayTime(dateFormat.formatDate(new Date()));
    payRecord.setDongNum(getDongNum(money));
    payRecord.setUserId(userId);

    payRecordDao.addPayRecord(payRecord);

    return Result.SUCCESS(userId);
    }

    /**
     * 根据用户id查询所有充值订单
     * @param userId
     * @return
     */
    @Override
    public Result searchAllByUserId(int userId,int pageNo) {
        PageHelper.startPage(pageNo,10);
        Page<PayRecord> recordList= payRecordDao.searchAllByUserId(userId);
        //  pageNums 多少页  pages:第几页
        return Result.SUCCESS(recordList.getResult(), recordList.getPageNum(),recordList.getPages());
    }

    /**
     * 所得咚币
     * @param money
     * @return
     */
    public int getDongNum(double money){

        switch ((int)money){
            case 15:
                return 1500;
            case 50:
                return 5500;
            case 75:
                return 8000;
            case 128:
                return 20000;
                default: return 0;

        }
    }

    /**
     *
     * @param session
     * @return
     */
    public  int getUserId(HttpSession session){
        Object obj=session.getAttribute("userInfor");
        String msg;
        if (obj!=null){
           return ((User)obj).getId();
        }else{
            return 0;
        }
    }
}
