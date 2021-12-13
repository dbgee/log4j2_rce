package com.kk.log4j2_rce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2RceApplication {

    public static void main(String[] args) {
        //高版本的jdk默认trustURLCodebase为false不能成功利用JNDI注入,需要设置为true才能复现
        //如果复现失败，大概率是java 版本或log4j 版本问题，可以取消下面的两条注释，再进行尝试
//        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
//        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        SpringApplication.run(Log4j2RceApplication.class, args);
    }

}
