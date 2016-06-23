package com.company.controller;

import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/6/23.
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    @Resource(name = "userServiceIml")
    UserService userService;

    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public void getUserById(@PathVariable String userId, HttpServletResponse response) {
        UserEntity userEntity = userService.getUserById(userId);
        if (userEntity != null) {
            System.out.println(Util.toJsonString(userEntity));
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody UserEntity userEntity) {
        System.out.println("username:"+userEntity.getUsername()+ "---password:"+ userEntity.getPassword());
        if (userEntity != null) {
            System.out.println(Util.toJsonString(userEntity));
        }
        userService.addUser(userEntity);
    }
}
