package com.qgh.service;

import com.qgh.pojo.Wallet;
import com.qgh.util.result.Result;

public interface WalletService {
  Result addWallet(int userId,int dongNum);
    void updateWallet(Wallet  wallet);//不是第一次充值会员
    Wallet findUserId(int userId);
}
