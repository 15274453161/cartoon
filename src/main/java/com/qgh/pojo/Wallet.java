package com.qgh.pojo;

import lombok.Data;

/**
 * @title:我的钱包
 * @ClassName: Wallet
 * @Description:用户充值后的钱包
 * @Auther: 秦光泓
 * @date 2019/11/7
 * @time 14:59
 */
@Data
public class Wallet {
    private int id;
    private int userId;
    private int dongNum;
}
