package com.qgh.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Suyeq
 * @date: 2019-04-26
 * @time: 8:15
 */
public class UUIDUtil {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,12);
    }

}