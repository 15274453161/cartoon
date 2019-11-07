package com.qgh.util.jsoup.util;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @title:
 * @ClassName: OkHttp
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/9/23
 * @time 14:44
 */
public class OkHttp {
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();

    public static OkHttpClient singleton() {
        return OK_HTTP_CLIENT;
    }
}
