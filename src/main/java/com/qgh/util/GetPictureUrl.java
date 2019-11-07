package com.qgh.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取漫画封面图片地址url
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 15:55
 */
public class GetPictureUrl {
    private static List<String> picUrl=new ArrayList<>();

    private static List<String> htmlFiter(String html) {
        /**
         * <img vw="144" class="imgs"
         * data-src="http://f2.kkmh.com/image/180831/l2WcBVX3F.webp-fe.w180.webp.m.i1" src="http://f2.kkmh.com/image/180831/l2WcBVX3F.webp-fe.w180.webp.m.i1" lazy="loaded">
         */
        /**
         * data-src="http://f2.kkmh.com/image/190331/JhZIY8PGd.webp-fe.w360.webp.m.i1"
         * data-src="http://f2.kkmh.com/image/171107/pbvrrgbws.webp-fe.w360.webp.m.i1"
         */
        Pattern pattern=Pattern.compile("data-src=\"http://f2.kkmh.com/image/(.*?)/(.*?).webp-fe.w360.webp.m.i1\"");
        Matcher m=pattern.matcher(html);
        System.out.println(m.matches());
        while (m.find()){
            String url1=m.group(1);
            String url2=m.group(2);
            String url="http://f2.kkmh.com/image/"+url1+"/"+url2+".webp-fe.w360.webp.m.i1";
            System.out.println("漫画图片地址: "+url);
            picUrl.add(url);
            //System.out.println("漫画地址");
        }
        System.out.println(picUrl.size());

        return picUrl;
    }
    public static List<String> getTodayTemperatureInfo(String path) {
        // 调用第一个方法，获取html字符串
        String html = ReadFile.httpRequest(path);
        System.out.println(html);
        // 调用第二个方法，过滤掉无用的信息
        List<String> result = htmlFiter(html);
        return result;
    }
}
