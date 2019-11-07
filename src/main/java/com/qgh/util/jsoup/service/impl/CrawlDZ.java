package com.qgh.util.jsoup.service.impl;

import com.qgh.util.jsoup.model.CartoonResult;
import com.qgh.util.jsoup.model.Infor;


import com.qgh.util.jsoup.service.CrawlerJinSeLivePressService;
import com.qgh.util.jsoup.service.LivePressService;
import com.qgh.util.jsoup.util.CoinPressConsts;
import com.qgh.util.jsoup.util.JsonUtils;
import com.qgh.util.jsoup.util.OkHttp;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

/**
 * @title:
 * @ClassName: CrawlerJinSeLivePressServiceImpl
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 14:21
 */
@Slf4j
@Service
public class CrawlDZ  implements CrawlerJinSeLivePressService {
    //这个参数代表每一次请求获得多少个数据
    private static final int PAGE_SIZE = 15;

    //这个是真正翻页参数，每一次找id比它小的15个数据（有写接口是通过page=1，2来进行翻页所以比较好理解一点，其实它们性质一样）
    private long bottomId;


    //这个这里没有用到，但是如果有数据层，就需要用到，这里我只是把它答应到控制台
    @Autowired
    private LivePressService livePressService;






    public List<Infor> crawlPage() throws IOException {

        // 格式化翻页参数（第一次bottomId为0，第二次就是这次爬到的最小bottomId值）
        String requestUrl = String.format(CoinPressConsts.CHAIN_FOR_LIVE_PRESS_DATA_URL_FORMAT, PAGE_SIZE, bottomId);

        Response response = OkHttp.singleton().newCall(
                new Request.Builder().url(requestUrl).addHeader("referer", CoinPressConsts.CHAIN_FOR_LIVE_URL).get().build())
                .execute();
        if (response.isRedirect()) {
            // 如果请求发生了跳转，说明请求不是原来的地址了，返回空数据。
            return Collections.emptyList();
        }

        //先获得json数据格式
        String responseText = response.body().string();

        //在通过工具类进行数据赋值
        CartoonResult cartResult = JsonUtils.objectFromJson(responseText, CartoonResult.class);
        if (null == cartResult) {
            // 反序列化失败
            System.out.println("抓取金色财经新闻列表反序列化异常");
            return Collections.emptyList();
        }
        List<Infor> ss=new ArrayList<>();

        for (CartoonResult.Info info:cartResult.getData()){
            Infor infor=new Infor();
            infor.setTitleNo(info.getTitleNo());
            infor.setCount(info.getCount());
            ss.add(infor);
        }
        return ss;
    }

    @Override
    public void start() {

    }
}
