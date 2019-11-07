package com.qgh.util;

import com.qgh.pojo.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 利用正则表达式进行网页爬虫 ------爬取漫画的分类
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 10:57
 */
public class GetCategoryUtil {
    private static List<String> categoryList=new ArrayList<>();
    private static List<String> htmlFiter(String html) {
        StringBuffer buffer = new StringBuffer();
        String str1 = "";
        String str2 = "";
        System.out.println("漫画分类: ");

        // 取出有用的范围 <li id="title_li_1347" data-title-no="1347">
        Pattern p = Pattern.compile("(<li id=\"title_li_([0-9]*)\" data-title-no=\"(.*?)\">)(.*?)(</li>)");
        Matcher m = p.matcher(html);
        while (m.find()){
            System.out.println("进来了吗");
            String  urlAll=m.group(4);
            Matcher m1;

            // 匹配漫画的类型，注：被包含在	<p class="genre g_love">恋爱</p>
            p = Pattern.compile("(<p class=\"genre g_(.*?)\">)(.*?)(</p>)");
            m1 = p.matcher(urlAll);

            if(m1.find()){
                categoryList.add(m1.group(3));
            }

        }

        return categoryList;
    }

    /**
     *  对以上两个方法进行封装。
     * @return
     */
    public static List<String> getTodayTemperatureInfo() {
        // 调用第一个方法，获取html字符串
        String html = ConnectionUtil.httpRequest("https://www.dongmanmanhua.cn/dailySchedule");
        // 调用第二个方法，过滤掉无用的信息
        List<String> result = htmlFiter(html);
        return result;
    }

}
