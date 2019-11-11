package com.qgh.pojo;

import lombok.Data;

/**
 * @title:充值记录表
 * @ClassName: PayRecord
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/7
 * @time 15:00
 */
@Data
public class PayRecord {
    private int id;
    private String oderNumber;
    private int userId;
    private String payTime;
    private double payMoney;
    private int dongNum;

    private String userName;


}
