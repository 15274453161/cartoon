package com.qgh.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: 秦光泓
 * @date: 2019-09-09
 * @time: 19:26
 */
public class ReadFile {
    /**
     * 20      * 发起http get请求获取网页源代码
     * 21      * @param requestUrl     String    请求地址
     * 22      * @return                 String    该地址返回的html字符串
     * 23
     */
    public static String httpRequest(String path) {

        StringBuffer buffer = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;


        try {


            // 获取输入流
            inputStream = new FileInputStream(path);
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            // 从输入流读取结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }
}

