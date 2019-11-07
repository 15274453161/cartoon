package com.qgh.util.jsoup.util;

/**
 * @title:
 * @ClassName: CoinPressConsts
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 14:30
 */
public class CoinPressConsts {
    // 30 分钟
    public static final long MINTUES30 = 30 * 60 * 1000;

    // 抓取最大时间区间
    public static final long MAX_CRAWLER_TIME = 30 * 7 * 24 * 60 * 60 * 1000;

    // ================================资讯常量=======================================

    // ==============金色财经==================
    /**
     * 金色财经新闻地址
     */
  //  public static final String CHAIN_FOR_LIVE_URL = "https://www.jinse.com/xinwen";
    public static final String CHAIN_FOR_LIVE_URL="https://www.dongmanmanhua.cn";

    /**
     * 金色财经新闻接口地址
     */
   // public static final String CHAIN_FOR_LIVE_PRESS_DATA_URL_FORMAT = "https://api.jinse.com/v6/information/list?catelogue_key=news&limit=%d&information_id=%d&flag=down&version=9.9.9";
    public static final String CHAIN_FOR_LIVE_PRESS_DATA_URL_FORMAT ="https://www.dongmanmanhua.cn/v1/title/like/count?titleNos=1432,1412,1313,1385,1277,1389,241," +
        "298,1426,1347,381,1335,1339,1430,1218,465,1115,1334,1328,1203,262,1332,1293,1405,1240,1273,1442,1268,296,1331,1336,1369,249,1350," +
        "1397,629,423,1374,1241,1365,1416,1324,1380,1437,465,1388,1378,1323,1358,1229,1063,1366,1353,1408,1337,1440,1411,1409,1433,1342,1402,1246," +
        "552,1442,1441,1427,1443,1429," +
        "1439,1444,1440,1442,1441,1427," +
        "1443,1429,1439,1444,1440,1253,1342,1436,803,1154,884,962,716";
    // ==============链得得==================
   /* *//**
     * 金色财经新闻地址
     *//*
    public static final String LDD_LIVE_URL = "http://www.chaindd.com";

    *//**
     * 金色财经新闻接口地址
     *//*
    public static final String LDD_PRESS_DATA_URL_FORMAT = "https://api.jinse.com/v6/information/list?catelogue_key=news&limit=%d&information_id=%d&flag=down&version=9.9.9";*/

}


