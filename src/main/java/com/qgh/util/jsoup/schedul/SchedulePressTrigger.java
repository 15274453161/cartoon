package com.qgh.util.jsoup.schedul;

import com.qgh.util.jsoup.service.CrawlerJinSeLivePressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @title:通过定时任务开启爬虫
 * @ClassName: SchedulePressTrigger
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 14:13
 */
public class SchedulePressTrigger {
    @Autowired
    private CrawlerJinSeLivePressService crawlerJinSeLivePressService;
    /**
     * 定时抓取金色财经的新闻
     * 对于固定延迟和固定速率的任务，可以指定一个初始延迟表示该方法在第一被调用执行之前等待的毫秒数：
     */
    @Scheduled(initialDelay = 1000, fixedRate = 600 * 1000)
    public  void doCrawlJinSeLivePress(){
         //log.info("开始抓取金色财经新闻, time:" + new Date());
    }
}
