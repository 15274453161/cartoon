package com.qgh.ServiceImpl;

import com.qgh.dao.WalletDao;
import com.qgh.pojo.Wallet;
import com.qgh.service.WalletService;
import com.qgh.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @title:用户账户咚币
 * @ClassName: WalletServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/11
 * @time 13:43
 */
@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletDao walletDao;
    /**
     * 插入之前判断该表是否已经充值过了 是不是第一次充值
     * @param userId
     * @param dongNum
     * @return
     */
    @Override
    public Result addWallet(int userId,int dongNum) {

        Wallet wallet=new Wallet();
        wallet.setUserId(userId);
        wallet.setDongNum(dongNum);

        if (findUserId(userId)==null){

            walletDao.addWallet(wallet);
        }else{
            updateWallet(wallet);
        }
        return Result.SUCCESS("成功");
    }

    /**
     * 更新用户充值表
     * @param wallet
     */
    @Override
    public void updateWallet(Wallet  wallet) {
        walletDao.updateWallet(wallet);
    }

    /**
     * 根据用户id查询此表是否存在此用户
     * @param userId
     * @return
     */
    @Override
    public Wallet findUserId(int userId) {
      return walletDao.findUserId(userId);
    }

    /**
     * 根据用户id查询出当前用户的咚币数量
     * @param userId
     * @return
     */
    public int getDongNum(int userId){
     Wallet wallet=   findUserId(userId);
     if (wallet==null){
         return 0;
     }
     return wallet.getDongNum();
    }

}
