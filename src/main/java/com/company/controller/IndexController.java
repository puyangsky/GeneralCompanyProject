package com.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.model.AdminEntity;
import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.JsonUtil;
import com.company.util.StringCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    @Resource(name = "userServiceIml")
    UserService userService;

    @RequestMapping(value = "/getuser/{userId}", method = RequestMethod.GET,
                    produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserById(@PathVariable String userId, HttpServletRequest request) {
        UserEntity userEntity = userService.getUserById(userId);
        if (userEntity != null) {
            System.out.println(JsonUtil.toJsonString(userEntity));
        }
        String callback = request.getParameter("callback");
        // 这个拼接是为了让前端的JSONP可以知道callback，可以实现CORS
        String result = callback + "(" + JsonUtil.toJsonString(userEntity) + ")";
        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(@RequestBody UserEntity entity, HttpServletRequest request) {
        System.out.println(entity.getUsername());
        if (StringCheck.isNullOrEmpty(entity.getUsername()) || StringCheck.isNullOrEmpty(entity.getPassword())) {
            JSONObject json = new JSONObject();
            json.put("result", "parameter invalid");
            return json.toString();
        }
        boolean pass = userService.login(entity);
        String res;
        if(pass) {
            request.getSession().setAttribute("user", entity.getUsername());
            res = "true";
        }
        else {
            res = "false";
        }
        JSONObject json = new JSONObject();
        json.put("result", res);
        return json.toString();
    }


    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    @ResponseBody
    public String getLoginUser(HttpServletRequest request) {
        JSONObject json = new JSONObject();
        if (request.getSession().getAttribute("user") == null) {
            json.put("user", "null");
            return json.toString();
        }
        else {
            json.put("user", request.getSession().getAttribute("user").toString());
            return json.toString();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            request.getSession().removeAttribute("user");
        }
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String register(@RequestBody UserEntity entity, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        System.out.println(entity.getUsername());
        UserEntity user = userService.getUserByUsername(entity.getUsername());
        if (user != null) {
            json.put("result", "500");
            return json.toString();
        }
        int res = userService.addUser(entity);
        String result;
        if(res > 0) {
            request.getSession().setAttribute("user", entity.getUsername());
            result = "200";
        } else {
            result = "400";
        }
        json.put("result", result);
        return json.toString();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody UserEntity userEntity) {
//        System.out.println("username:"+userEntity.getUsername()+ "---password:"+ userEntity.getPassword());
        System.out.println(JsonUtil.toJsonString(userEntity));

        int result = userService.addUser(userEntity);
        JSONObject json = new JSONObject();
        if (result > 0) {
            json.put("result", "1");
            return json.toString();
        }else {
            json.put("result", "0");
            return json.toString();
        }
    }

    @RequestMapping(value = "/v1/getusers", method = RequestMethod.GET)
    public String getUsersPage(ModelMap model) {
        List<UserEntity> userEntityList = userService.getAllUser();
        for (UserEntity user:userEntityList) {
            System.out.println(JsonUtil.toJsonString(user));
        }
        model.addAttribute("userlist", userEntityList);
        return "userList";
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET,
                    produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUsers(HttpServletRequest request) {
        List<UserEntity> userEntityList = userService.getAllUser();
        String callback = request.getParameter("callback");
        String result = callback + "(" + JsonUtil.listToJsonString(userEntityList) + ")";
        return result;
    }
}
