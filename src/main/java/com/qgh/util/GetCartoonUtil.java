package com.qgh.util;

import com.qgh.pojo.Cartoon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 利用正则表达式进行网页爬虫 ------爬取漫画的信息
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 10:57
 */
public class GetCartoonUtil {
    private static List<Cartoon> cartoonList=new ArrayList<>();
    private static List<Cartoon> htmlFiter(String html) {
        StringBuffer buffer = new StringBuffer();
        String str1 = "";
        String str2 = "";
        System.out.println("漫画: ");

        // 取出有用的范围
        Pattern p = Pattern.compile("(<li id=\"title_li_([0-9]*)\" data-title-no=\"(.*?)\">)(.*?)(</li>)");
        Matcher m = p.matcher(html);
        while (m.find()){
            String  urlAll=m.group(4);
            Matcher m1;

            // 匹配漫画名称，注：漫画名称被包含在<p class="subj">特殊恋人攻略 LoveLock</p>中
            p = Pattern.compile("<p class=\"subj\">(.*?)</p>");
            m1 = p.matcher(urlAll);
            Cartoon cartoon=new Cartoon();
            if(m1.find()){
                cartoon.setCtName(m1.group(1));
            }
            //匹配作者 ，注：漫画作者	<p class="author">clevercool</p>
            p = Pattern.compile("<p class=\"author\">(.*?)</p>");
            m1 = p.matcher(urlAll);
            if(m1.find()){
                cartoon.setCtAuthor(m1.group(1));
            }
            // 匹配漫画点赞数，注：<em class="grade_num">5,375,106</em> 中
            p = Pattern.compile("(.*)<em class=\"grade_num\">(.*?)</em>(.*)");
            m1 = p.matcher(urlAll);
            if(m1.find()){
              //  cartoon.setCtTuNum(m1.group(2));
                System.out.println(m1.group(2));
            }

            // 匹配漫画的类型，注：被包含在	<p class="genre g_love">恋爱</p>
            p = Pattern.compile("(<p class=\"genre g_(.*?)\">)(.*?)(</p>)");
            m1 = p.matcher(urlAll);

            if(m1.find()){
              //  cartoon.setCtCyName(m1.group(3));
                System.out.println(m1.group(3));
            }
            cartoonList.add(cartoon);
        }

        return cartoonList;
    }

    /**
     *  对以上两个方法进行封装。
     * @return
     */
    public static List<Cartoon> getTodayTemperatureInfo() {
        // 调用第一个方法，获取html字符串  https://www.dongmanmanhua.cn/dailySchedule
        String html = ConnectionUtil.httpRequest("https://www.dongmanmanhua.cn");
        // 调用第二个方法，过滤掉无用的信息
        List<Cartoon> result = htmlFiter(html);https://
        return result;
    }

}
