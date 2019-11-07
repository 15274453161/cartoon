package com.qgh.util.jsoup;

import com.qgh.pojo.Cartoon;
import com.qgh.pojo.Category;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:爬虫
 * @ClassName: Pachong
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 10:45
 */
/*
 * 这个案例你只需要看结果，具体的jsoup介绍下一篇博客会详细介绍
 */
public class Pachong {
    /**
     * 星期几更新
     * @param weekId
     * @return
     * @throws IOException
     */
    public static List getInfor(int weekId) throws IOException {
        //这个就是博客中的java反射的url
        final String url=  "https://www.dongmanmanhua.cn";
        //先获得的是整个页面的html标签页面
        Document doc = Jsoup.connect(url).get();

      // Elements xy= doc.select(".subj");


       //.select(".genre g_").select(".author").select(".summary");
        //获取正文标题，因为整片文章只有标题是用h1标签
       /* Elements btEl = doc.select(".card_front").select(".subj");
        StringBuilder  sub=new  StringBuilder();
        for (Element subt:btEl){
            sub.append(subt.text());
            sub.append("\n");
        }
        String  ss=sub.toString();
        System.out.println("========漫画标题======：");
        System.out.println(ss);

        //获取二级标题
        Elements ejbtEls = doc.select(".genre");
        //因为整片文章有多个二级标题所以进行拼接
        StringBuilder  ejbts=new  StringBuilder();
        for(Element el :ejbtEls) {
            ejbts.append(el.text());
            ejbts.append("\n");
        }
        String ejbt=ejbts.toString();
        System.out.println("=======漫画分类=========：");
        System.out.println(ejbt);


        //==================================

        //================================


       //获取作者
        Elements timeEl = doc.select(".author");
        StringBuilder sb3=new StringBuilder();
        for (Element au:timeEl){
            sb3.append(au.text());
            sb3.append("\n");
        }
        String  time=sb3.toString();
        System.out.println("========作者=========：");
        System.out.println("作者：" + time);

        //获取漫画介绍
        Elements esum = doc.select(".summary");
        StringBuilder sb4=new StringBuilder();
        for (Element sum:esum){
            sb4.append(sum.text());
            sb4.append("\n");
        }
        String  read=sb4.toString();
        System.out.println("========漫画介绍=========：");
        System.out.println("漫画介绍：" + read);*/


        //=====================多层次遍历===============
        Elements li= doc.select("li[data-title-no]");
      //  StringBuilder sb=new StringBuilder();
        List<Cartoon> list=new ArrayList();
      for (Element all:li){
          Cartoon cartoon=new Cartoon();
          Category cy=new Category();
          Elements subj= all.select(".card_front").select(".subj");
          cartoon.setCtName(subj.text());
         // sb.append("漫画标题："+subj.text()+"\n");
          Elements author= all.select(".author");
         // sb.append("漫画作者："+author.text()+"\n");
          cartoon.setCtAuthor(author.text());
          Elements genre= all.select(".genre");
          cartoon.setCyName(genre.text().substring(0,2));
        //  sb.append("漫画分类："+genre.text()+"\n");
          Elements summary= all.select(".summary");
         // sb.append("漫画介绍："+summary.text()+"\n");
          cartoon.setCtIntroduce(summary.text());
          String no=  all.attr("data-title-no");
          cartoon.setCtTitleNo(no);
          //设置周日
          cartoon.setCtWkId(weekId);

        //  sb.append("属性值: "+no);
         // sb.append("\n=================================\n");
          list.add(cartoon);
      }

       // String str=sb.toString();
       // System.out.println(str);
        return list;
    }
}
