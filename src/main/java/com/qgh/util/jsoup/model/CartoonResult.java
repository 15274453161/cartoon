package com.qgh.util.jsoup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @title:接口中的json格式的数据
 * @ClassName: CartoonResult
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 15:19
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CartoonResult {
    //list的名字也要和json数据的list名字一致，否则无用
    private List<Info> data;
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Info {

        @JsonProperty("titleNo")
        private String titleNo;
        @JsonProperty("count")
        private int count;

    }
}
