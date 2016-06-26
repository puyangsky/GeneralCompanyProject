package com.company.controller;

import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
        System.out.println(Util.toJsonString(userEntity));
        try {
            String name = new String(userEntity.getUsername().getBytes("iso8859-1"),"utf-8");
            System.out.println(name);
            userEntity.setUsername(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userService.addUser(userEntity);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(ModelMap model) {
        List<UserEntity> userEntityList = userService.getAllUser();
        for (UserEntity user:userEntityList) {
            System.out.println(Util.toJsonString(user));
        }
        model.addAttribute("userlist", userEntityList);
        return "userList";
    }
}
