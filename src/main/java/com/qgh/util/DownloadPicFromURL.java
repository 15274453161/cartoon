package com.qgh.util;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadImageRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadImageResponse;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * @title:将图片根据url下载到本地
 * @ClassName: DownloadPicFromURL
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/15
 * @time 16:37
 */
public class DownloadPicFromURL {
 
    //链接url下载图片到服务器的upload文件夹下面  urlList:网址 path:下载到本地的绝对地址
   public static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
