package com.qgh.util.jsoup.util;

import com.qgh.pojo.Comment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:评论爬虫
 * @ClassName: CommentUtil
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/10/29
 * @time 10:34
 */
public class CommentUtil {
     static final String url=  "https://www.dongmanmanhua.cn/LOVE/teshulianrengonglvelovelock/第2话/viewer?title_no=1385&episode_no=2";

    //先获得的是整个页面的html标签页面

    public static List<Comment> getComment(File in) throws IOException {

        Document doc=   Jsoup.parse(in, "UTF-8", "");

        Elements li= doc.select(".u_cbox_comment");

        List<com.qgh.pojo.Comment> commentList=new ArrayList<>();

        for (Element e:li){
            com.qgh.pojo.Comment comment=new com.qgh.pojo.Comment();

            Elements con=  e.select(".u_cbox_contents");
            Elements time=  e.select(".u_cbox_date");
            comment.setReplay(0);
            comment.setUserId(2);
            comment.setCommentContent(con.text());
            comment.setCommentTime(time.text());
            comment.setChaptorId(287);
            System.out.println(con.text());
            commentList.add(comment);
        }

        return commentList;
    }

}
