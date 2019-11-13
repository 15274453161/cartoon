package com.qgh.util.jsoup.util;


import com.qgh.pojo.Section;
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
 * @ClassName: 章节里面的图片爬虫
 * @Description:1、传入爬虫的网页地址
 * 2、通过jousp获取并解析html页面 返回一个Dcument对象
 * 3、通过调用jsoup里面的选择器的方法获取我们需要的值
 * @Auther: 秦光泓
 * @date 2019/10/14
 * @time 14:48
 */
public class SectionUtil {
    /**
     * 星期几更新
     * @return
     * @throws IOException
     */
    public static List getInfor(File in,int chaptorId) throws IOException {
        //这个就是博客中的java反射的url
        //final String url=  "https://www.kuaikanmanhua.com/web/topic/321/";

        //先获得的是整个页面的html标签页面
      // Document doc = Jsoup.connect(url).get();
       Document doc=   Jsoup.parse(in, "UTF-8", "");

        //=====================多层次遍历===============
        //获得当前图片 循环的是他 他一定要有多个
       // Elements li= doc.select("img[data-src]");
        Elements li= doc.select("img[src]");

        List<Section> list=new ArrayList();

        for (Element all:li){

            Section section=new Section();

            //获得当前图片

           //String urlImg=all.attr("data-src");
            String urlImg=all.attr("src");

            //String newC=urlImg.replace("amp;","");
            System.out.println("新的字符："+urlImg);

            section.setSectionUrl(urlImg);
            section.setChaptorId(chaptorId);
            list.add(section);
        }


        return list;
    }

    public static List getUrl(String url) throws IOException {
        //这个就是博客中的java反射的url
        //final String url=  "https://www.kuaikanmanhua.com/web/topic/321/";
        //先获得的是整个页面的html标签页面
        Document doc = Jsoup.connect(url).header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(600000)
                .get();


        System.out.println(doc);

       // Document doc=   Jsoup.parse(in, "UTF-8", "");

        //=====================多层次遍历===============
        //获得当前图片 循环的是他 他一定要有多个
        // Elements li= doc.select("img[data-src]");
        Elements li= doc.select("img[src]");
       // System.out.println(li);

        List<Section> list=new ArrayList();

        for (Element all:li){

            Section section=new Section();

            //获得当前图片

            //String urlImg=all.attr("data-src");
            String urlImg=all.attr("src");

            //String newC=urlImg.replace("amp;","");
            System.out.println("新的字符："+urlImg);

            section.setSectionUrl(urlImg);
            // section.setChaptorId(chaptorId);
            list.add(section);
        }


        return list;
    }
}
