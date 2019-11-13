package com.qgh.dao;

import com.qgh.pojo.Wallet;
import org.apache.ibatis.annotations.Param;

/**
 * @title:我的钱包
 * @ClassName: WalletDao
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/7
 * @time 15:31
 */
public interface WalletDao {
    void addWallet(Wallet  wallet);//第一次充值会员
    void updateWallet(Wallet  wallet);//不是第一次充值会员
    Wallet findUserId(int userId);
    void payChaptor(@Param("userId") int userId,@Param("chaptorId") String chaptorId);//用户购买指定章节


}
