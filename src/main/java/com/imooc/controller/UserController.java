package com.imooc.controller;

import com.imooc.pojo.JSONResult;
import com.imooc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("小花");
        user.setPassword("xiaohua");
        user.setAge(20);
        user.setBirthday(new Date());
//        user.setDesc("kaiaaa ");

        return user;
    }

    @RequestMapping("/getUserJson")
    public JSONResult getUserJson(){
        User user = new User();
        user.setName("小花");
        user.setPassword("xiaohua");
        user.setAge(20);
        user.setBirthday(new Date());

        return JSONResult.ok(user);
    }

}
