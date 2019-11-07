package com.qgh.util.aliyun;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @title:
 * @ClassName: OssUtil2
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/16
 * @time 20:02
 */
public class OssUtil2 {

    // 账号AK信息请填写(必选)
    //LTAIuMm7xUiKnS4b LTAI4Fv9XxMZEVf8piMD9cA4
    public static final String ACCESS_KEY_ID = "LTAI4Fv9XxMZEVf8piMD9cA4";
    // 账号AK信息请填写(必选) FArR8SNNUPJplnkA1edoZX9rt945V5 FArR8SNNUPJplnkA1edoZX9rt945V5
    public static final String ACCESS_KEY_SECRET = "ZsUJzGHcP3dSoNbdWVGn10W433F3Wv";
    // bucketName 2019814xyq qgh123456
    public static final String bucketName = "qgh123456";
    // objectName wordsOfSong/ 名花有草/
    public static final String objectName = "名花有草/";
    // Endpoint以杭州为例，其它Region请按实际情况填写。 http://oss-cn-beijing.aliyuncs.com
    public static final  String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";



    //创建阿里云的客户端对象
    public static OSSClient getOSSClient(){
        return new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }


    /**
     * 创建存储空间
     * @param ossClient OSS连接
     * @param bucketName 存储空间
     * @return
     */
    public static String createBucketName(OSSClient ossClient,String bucketName){
//存储空间
        final String bucketNames=bucketName;
        if(!ossClient.doesBucketExist(bucketName)){
//创建存储空间
            Bucket bucket=ossClient.createBucket(bucketName);
            System.out.println("创建存储空间成功");
            return bucket.getName();
        }
        return bucketNames;
    }

    /**
     * 删除存储空间buckName
     * @param ossClient oss对象
     * @param bucketName 存储空间
     */
    public static void deleteBucket(OSSClient ossClient, String bucketName){
        ossClient.deleteBucket(bucketName);
        System.out.println("删除" + bucketName + "Bucket成功");
    }


    /**
     * 创建模拟文件夹
     * @param ossClient oss连接
     * @param bucketName 存储空间
     * @param folder 模拟文件夹名如"qj_nanjing/"
     * @return 文件夹名
     */
    public static String createFolder(OSSClient ossClient,String bucketName,String folder){
//文件夹名
        final String keySuffixWithSlash =folder;
//判断文件夹是否存在，不存在则创建
        if(!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)){
//创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            System.out.println("创建文件夹成功");
//得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir=object.getKey();
            return fileDir;
        }
        return keySuffixWithSlash;
    }


    /**
     * 根据key删除OSS服务器上的文件
     * @param ossClient oss连接
     * @param bucketName 存储空间
     * @param folder 模拟文件夹名 如"qj_nanjing/"
     * @param key Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
     */
    public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key){
        ossClient.deleteObject(bucketName, folder + key);
        System.out.println("删除" + bucketName + "下的文件" + folder + key + "成功");
    }

    /**
     * 上传图片至OSS
     * @param ossClient oss连接
     * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName 存储空间
     * @param folder 模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     * */
    public static String uploadObject2OSS(OSSClient ossClient, File file, String bucketName, String folder) {
        String resultStr = null;
        try {
//以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
//文件名
            String fileName = file.getName();
//文件大小
            Long fileSize = file.length();
//创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
//上传的文件的长度
            metadata.setContentLength(is.available());
//指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
//指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
//指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
//文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
//如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
//指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
//上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is,metadata);
//解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传阿里云OSS服务器异常." + e.getMessage());
        }
        return resultStr;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName){
//文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
//默认返回类型
        return "image/jpeg";
    }


    //获取文件在oss里的链接(下载)
    public static String getUrl(String fileName,String folder) {


        String key=folder+fileName;
        OSSClient client = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 设置URL过期时间为10年
        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10*10);
        // 生成URL
        URL url = client.generatePresignedUrl(bucketName, key, expiration);
        System.out.println("URL:"+url.toString());
        return url.toString();
    }


}
