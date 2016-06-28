package com.company.controller;

import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    @Resource(name = "userServiceIml")
    UserService userService;

    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserById(@PathVariable String userId, HttpServletResponse response) {
        UserEntity userEntity = userService.getUserById(userId);
        if (userEntity != null) {
            System.out.println(Util.toJsonString(userEntity));
        }
        return Util.toJsonString(userEntity);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody UserEntity userEntity) {
        System.out.println("username:"+userEntity.getUsername()+ "---password:"+ userEntity.getPassword());
        System.out.println(Util.toJsonString(userEntity));

        userService.addUser(userEntity);
        return Util.toJsonString(userEntity);
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
