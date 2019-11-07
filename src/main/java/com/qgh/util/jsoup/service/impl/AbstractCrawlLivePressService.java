package com.qgh.util.jsoup.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @title:
 * @ClassName: AbstractCrawlLivePressService
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 14:17
 */
public abstract class AbstractCrawlLivePressService {
    String url;
    public void doTask(String url) throws IOException {
        this.url = url;
        int pageNum = 1;

        //通过 while (true)会一直循环调取接口，直到数据为空或者时间过老跳出循环
        while (true) {
            List<PageListPress> newsList = crawlPage(pageNum++);
            // 抓取不到新的内容本次抓取结束
            if (CollectionUtils.isEmpty(newsList)) {
                break;
            }
            //这里并没有把数据放到数据库，而是直接从控制台输出
            for (int i = newsList.size() - 1; i >= 0; i--) {
                PageListPress pageListNews = newsList.get(i);
                System.out.println(pageListNews.toString());

            }
        }
    }
    //这个由具体实现类实现
    protected abstract List<PageListPress> crawlPage(int pageNum) throws IOException;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PageListPress {

        //新闻详情页面url
        private String href;
        //新闻标题
        private String title;
        //新闻阅读数量
        private int readCounts;
        //新闻发布时间
        private Date createTime;
        //新闻摘要
        private String summary;

    }


}
