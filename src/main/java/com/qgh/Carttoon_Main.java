package com.qgh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 * @author: 秦光泓
 * @date: 2019-09-11
 * @time: 9:48
 */
@SpringBootApplication
@MapperScan("com.qgh.dao")
public class Carttoon_Main {
    public static void main(String[] args) {
        SpringApplication.run(Carttoon_Main.class,args);
    }
}
