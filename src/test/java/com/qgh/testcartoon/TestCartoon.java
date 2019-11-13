package com.qgh.testcartoon;

import com.aliyun.oss.OSSClient;
import com.qgh.ServiceImpl.ChaptorsServiceImpl;
import com.qgh.ServiceImpl.CommentServiceImpl;
import com.qgh.ServiceImpl.SectionServiceImpl;
import com.qgh.ServiceImpl.ThumbUpServiceImp;

import com.qgh.pojo.Comment;
import com.qgh.pojo.Section;
import com.qgh.service.CartoonService;
import com.qgh.service.CategoryService;

import com.qgh.service.CommentService;
import com.qgh.util.DownloadPicFromURL;
import com.qgh.util.aliyun.OssUtil2;
import com.qgh.util.date.DateFormat;
import com.qgh.util.jsoup.service.impl.CrawlDZ;
import com.qgh.util.jsoup.service.impl.CrawlerJinSeLivePressServiceImpl;


import com.qgh.util.jsoup.util.CommentUtil;
import com.qgh.util.jsoup.util.SectionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 9:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class TestCartoon {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartoonService cartoonService;

    @Autowired
    CrawlerJinSeLivePressServiceImpl c;
    @Autowired
    CrawlDZ crawlDZ;
    @Autowired
    ThumbUpServiceImp thumbUpServiceImp;
    @Autowired
    private ChaptorsServiceImpl chaptorsService;


    @Autowired
    private SectionServiceImpl sectionService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private DateFormat dateFormat;

    /**
     * 插入漫画分类 成功
     *//*
    @Test
    public void testAddCartoon(){
    List<String> cateList = GetCategoryUtil.getTodayTemperatureInfo();
        System.out.println("漫画分类数量："+cateList.size());
    //循环的插入漫画分类
        for (int i=0;i<cateList.size();++i){
            categoryService.addCategory(cateList.get(i));
        }
    }*/

    /**
     * 插入漫画相关信息 通过
     */
   /* @Test
    public void testAddCartoon(){
        List<Cartoon> cartoonsList = GetCartoonUtil.getTodayTemperatureInfo();
        System.out.println("漫画数量："+cartoonsList.size());
        //插入之前要先遍历分类表 查询出分类的id
        for (int i=0;i<cartoonsList.size();++i){
        Category cyName=    categoryService.searchIdByName(cartoonsList.get(i).getCtCyName());
             cartoonsList.get(i).setCtCyId(cyName.getId());
            System.out.println("漫画分类id： "+cartoonsList.get(i).getCtCyId());
            cartoonService.addCartoon(cartoonsList.get(i));
        }
    }*/




    /*@Test
    public void getIn(){
        GetCartoonUtil1.getTodayTemperatureInfo();
    }*/

  /*@Test
    public void testInte() throws IOException {
      System.out.println(c.crawlPage(1));
  }*/

   /* @Test
    public void testCart() throws IOException {
        System.out.println(crawlDZ.crawlPage());
    }*/

   /*@Test
    public  void setCartoon() throws IOException {
       //得到 漫画的名称、作者、漫画No、漫画的分类名称、介绍
    //   List<Cartoon> listCart= Pachong.getInfor(1);
      //得到漫画No、点赞数
      List<Infor> li=  crawlDZ.crawlPage();
       //查出漫画分类
      //  List<Category> cy=    categoryService.selectAllCY();
      // System.out.println(listCart.size()+","+li.size());
      // System.out.println("分类表大小："+cy.size());
       *//*for (int i=0;i<listCart.size();++i){

           for (int j=0;j<cy.size();++j){
               System.out.println("漫画分类名："+listCart.get(i).getCyName()+","+"分类表分类名："+cy.get(j).getCyName());
               if (listCart.get(i).getCyName().equals(cy.get(j).getCyName())){
                   System.out.println("lllllllllll");
                   //将分类表中的id 设置到漫画表中的字段中
                   listCart.get(i).setCtCyId(cy.get(j).getId());
               }
           }

           cartoonService.addCartoon(listCart.get(i));
       }*//*
       //像数据库点赞表中添加数据

       List<Cartoon> listCart=cartoonService.selectAll();
    for (int i=0;i<listCart.size();++i){

          for (int j=0;j<li.size();++j){
             // System.out.println("漫画序号:"+listCart.get(i).getCtTitleNo()+"点赞表:"+li.get(j).getTitleNo());
              if (listCart.get(i).getCtTitleNo().equals(li.get(j).getTitleNo())){
                  //插入漫画id 、点赞数
                  ThumbUp tu=new ThumbUp();
                  tu.setCtId(listCart.get(i).getId());
                  System.out.println("漫画id "+listCart.get(i).getId());
                  tu.setTuNum(li.get(j).getCount());
                  System.out.println("成功");
                  thumbUpServiceImp.addThumbUp(tu);
                  break;
              }
          }

      }


   }*/
    //设置漫画封面图片
   /* @Test
    public void setImgUrl(){
      List<String > url=  GetPictureUrl.getTodayTemperatureInfo("F:\\咚漫\\封面2.txt");

      for (int i=49,j=0;j<23;++i,j++){
          cartoonService.updatePcUrl(url.get(j),i);
      }
    }*/

    //测试爬取漫画章节信息
    /*@Test
    public void getChaptor(){
        try {
            List<Chaptors>  chaptors=ChaptorUtil.getInfor(new File("F:\\咚漫\\jywx.html"));
            //将数据插入到数据库
         for (int i=0;i<chaptors.size();++i){
              chaptors.get(i).setCtId(7);
              chaptorsService.insertData(chaptors.get(i));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    //测试爬取漫画章节信息

   
    /*  @Test public void getChaptor()
      {
      //获取oss对象实例
      OSSClient  ossClient=  OssUtil2.getOSSClient();
     // for(int i=3;i<68;++i) {
      String folder=    OssUtil2.createFolder(ossClient,"qgh123456","教主，注意名声!/chaptor"+"/");
      System.out.println("文件夹 "+folder);
    //  }
     
      //String md5= OssUtil2.uploadObject2OSS(ossClient,new File("F:\\咚漫\\mhyc\\chaptor1\\1.png"),"qgh123456","名花有草/");
      // System.out.println("上传成功 "+md5);
      //  String url= OssUtil2.getUrl("1.png","名花有草/");
      // System.out.println("返回的图片的地址 "+url);
     }*/
    


    //测试开始往阿里云上传章节图片
 /*@Test
    public void upload() {
        //获得漫画章节图片
        List<Section> sections = null;
        OSSClient ossClient = OssUtil2.getOSSClient();
        try {
            sections = SectionUtil.getInfor(new
                    File("F:\\咚漫\\咚漫漫画\\H-Mate\\html\\hmate6.html"), 288);

            System.out.println(sections);
            //开始将漫画图片下载到本地
            for (int i = 0; i < sections.size(); ++i) {
                //下载到本地
                String pre = "F:\\咚漫\\咚漫漫画\\H-Mate\\外传第8\\";
                String fileName = (i + 1) + ".png";
                String path = pre + fileName;

               // String folder = "教主，注意名声!/chaptor/";
                DownloadPicFromURL.downloadPicture(sections.get(i).getSectionUrl(), path);
                //上传到阿里云对象存储
              //  String md5 = OssUtil2.uploadObject2OSS(ossClient, new File(path), "qgh123456", folder); //获得上传图片的地址
              //   String url= OssUtil2.getUrl(fileName, folder); //存储到数据库
               //  sections.get(i).setSectionUrl(url);
              //  sectionService.addSection(sections.get(i));

            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }*/

    /**
     * 新增评论
     */

    /*@Test
    public void  addComment() throws IOException {
    Comment comment=new Comment();
     comment.setCommentContent("男主太可爱了");
     comment.setCommentTime(dateFormat.formatDate(new Date()));
     comment.setChaptorId(287);
     comment.setUserId(2);
     comment.setReplay(0);
     commentService.insertComment(comment);

      List<Comment> commentList=  CommentUtil.getComment(new File("F:\\咚漫\\评论\\comment1.html"));

     commentService.batchInsert(commentList);
   }*/

/*@Test
    public void createDir(){
    for (int i=1;i<=8;++i){
        String path="F:\\咚漫\\咚漫漫画\\H-Mate\\外传第"+i+"\\";
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
    }
}*/





    //测试开始往阿里云上传章节图片
  /*@Test
    public void storeUrl() {
        //获得漫画章节图片
        List<Section> sections = null;

        try {
           int a=0;int b=0;
            for (int j=0;j<4;j++) {
                int id=7373+a;
                String url="http://waiwaiman.com/home/book/capter/id/"+id;
               // System.out.println(url);
                sections = SectionUtil.getUrl(url);

               // System.out.println(sections);
                //开始将漫画图片下载到本地
                *//*for (int i = 0; i < sections.size(); ++i) {
                    //下载到本地
                    int row=(29+b);
                    String pre = "F:\\咚漫\\咚漫漫画\\H-Mate\\chaptor"+row+"\\";
                    String fileName = (i + 1) + ".png";
                    String path = pre + fileName;
                    DownloadPicFromURL.downloadPicture(sections.get(i).getSectionUrl(), path);
                }*//*
                a=a+2;
               // b++;
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }*/

    /**
     * 测试创建OSS的bucket
     * 结果：成功
     */
    /*@Test
    public void createBucket(){
          OSSClient ossClient = OssUtil2.getOSSClient();
         OssUtil2.createBucketName(ossClient,"qghmusic");
    }*/

    /**
     * 上传音频到阿里云OSS对象存储
     * 结果：
     */
    /*@Test
    public void uploadAudio(){
        //1、创建连接对象
        OSSClient ossClient = OssUtil2.getOSSClient();
        String father="F:\\咚漫\\背景音乐\\";//上级目录
        String fileName="bg_music.m4a";//上传的当前文件名+后缀
        String path=father+fileName;//上传绝对路径
        String folder="background_music/";//上传到阿里云bucket的哪个目录
        String bucket="qgh123456";//阿里云的bucket名
        //2、上传文件
        //OssUtil2.uploadObject2OSS(ossClient,new File(path),bucket,folder);
        //3、获取返回地址
        String url= OssUtil2.getUrl(fileName, folder); //存储到数据库

        System.out.println("返回音频地址："+url);
        //4、将返回地址存入章节的数据库

        chaptorsService.updateBackgroundMusic(220,url);
    }*/

    //测试开始往阿里云上传章节图片
   /*@Test
    public void storeUrl() {
        //获得漫画章节图片
        List<Section> sections = null;

        try {
           int a=0;int b=1;
            for (int j=0;j<4;j++) {

                String url="http://127.0.0.1:8848/cpts_103_chg/test.html";

                sections = SectionUtil.getUrl(url);


                //开始将漫画图片下载到本地
               for (int i = 0; i < sections.size(); ++i) {
                    //下载到本地

                    String pre = "F:\\咚漫\\咚漫漫画\\人鱼哀曲\\chaptor1\\";
                    String fileName = (i + 1) + ".png";
                    String path = pre + fileName;
                    DownloadPicFromURL.downloadPicture(sections.get(i).getSectionUrl(), path);
                }


            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }*/
}
