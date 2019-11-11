package com.qgh.util.jsoup.util;

import com.qgh.pojo.Chaptors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @ClassName: ChaptorUtil
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/14
 * @time 14:48
 */
public class ChaptorUtil {
    /**
     * 星期几更新
     * @return
     * @throws IOException
     */
    public static List getInfor(File in) throws IOException {
        //这个就是博客中的java反射的url
       // final String url=  "https://www.kuaikanmanhua.com/web/topic/321/";
        //先获得的是整个页面的html标签页面
      //  Document doc = Jsoup.connect(url).get();
        Document doc=   Jsoup.parse(in, "UTF-8", "");
      //  System.out.println(doc);
        //=====================多层次遍历===============
        Elements li= doc.select(".TopicItem");
        //  StringBuilder sb=new StringBuilder();
        List<Chaptors> list=new ArrayList();

        for (Element all:li){

           Chaptors chaptor=new Chaptors();


           Elements img= all.select("img[data-src]");

           chaptor.setChaptorUrl(img.attr("data-src"));
            //获得当前漫画章节名称
            Elements title= all.select(".title").select("span");

            chaptor.setChaptorName(title.text());

            //获得当前漫画创建时间
            Elements updateTime= all.select(".date").select("span");

            chaptor.setUpdateTime(updateTime.text());
            System.out.println(updateTime.text());

            //获得当前漫画的点赞数
           /* Elements zanNum= all.select(".laud").select("span");
            int s=  zanNum.text().lastIndexOf(".");
            String z=    zanNum.text().substring(s+2);
            System.out.println(z);*/
            list.add(chaptor);
        }


        return list;
    }
}
