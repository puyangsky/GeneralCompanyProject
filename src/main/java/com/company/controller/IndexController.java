package com.company.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.model.UserEntity;
import com.company.model.params.UserId;
import com.company.service.UserService;
import com.company.util.JsonUtil;
import com.company.util.StringCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

    @RequestMapping(value = "/getuserbyemail/{email}", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserByEmail(@PathVariable String email, HttpServletRequest request) {
        System.out.println("email>>>" + email);
        UserEntity userEntity = userService.getUserByEmail(email);
        String json = "";
        if (userEntity != null) {
            System.out.println(JsonUtil.toJsonString(userEntity));
            json = JsonUtil.toJsonString(userEntity);
        }
        String callback = request.getParameter("callback");
        // 这个拼接是为了让前端的JSONP可以知道callback，可以实现CORS
        String result = callback + "(" + json + ")";
        System.out.println(result);
        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(@RequestBody UserEntity entity, HttpServletRequest request) {
        System.out.println(entity.getEmail());
        if (StringCheck.isNullOrEmpty(entity.getEmail())) {
            JSONObject json = new JSONObject();
            json.put("result", "parameter invalid");
            return json.toString();
        }
        boolean pass = userService.login(entity);
        String res;
        if(pass) {
            request.getSession().setAttribute("user", entity.getEmail());
            res = "true";
        }
        else {
            res = "false";
        }
        JSONObject json = new JSONObject();
        json.put("result", res);
        return json.toString();
    }
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(MultipartHttpServletRequest request,
                         HttpServletResponse response) throws Exception {

        String imagePath = userService.saveImage(request);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgpath", imagePath);
        response.setContentType("text/html;charset=UTF-8");
        return jsonObject.toString();
    }

    @RequestMapping(value = "/image/{name}/{type}", method = RequestMethod.GET)
    public void getImage(@PathVariable String name,
                         @PathVariable String type,
                         HttpServletResponse response) throws IOException{
        userService.getImage(name, type, response);
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
        System.out.println(entity.getEmail());
        UserEntity user = userService.getUserByEmail(entity.getEmail());
        if (user != null) {
            json.put("result", "500");
            return json.toString();
        }
        int res = userService.addUser(entity);
        String result;
        if(res > 0) {
            request.getSession().setAttribute("user", entity.getEmail());
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
        JSONObject json = new JSONObject();
        if(StringCheck.isNullOrEmpty(userEntity.getEmail())) {
            json.put("result", "email is null");
            return json.toString();
        }
//        System.out.println(JsonUtil.toJsonString(userEntity));
        int result = userService.addUser(userEntity);

        json.put("result", result);
        return json.toString();
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestBody UserEntity userEntity, HttpServletRequest request) {
        System.out.println(JsonUtil.toJsonString(userEntity));

        String id = request.getHeader("UID");
        int uid;
        try {
            uid = Integer.valueOf(id);
        } catch (Exception e) {
            e.printStackTrace();
            uid = 0;
        }
        userEntity.setId(uid);
        boolean res = userService.updateUser(userEntity);
        JSONObject object = new JSONObject();
        if (res) {
            object.put("result", 1);
        } else {
            object.put("result", 0);
        }
        return object.toString();
    }

    @RequestMapping(value = "/v1/getusers/p/{page}", method = RequestMethod.GET)
    public String getUsersPage(@PathVariable int page, ModelMap model) {
        List<UserEntity> userEntityList = userService.getAllUser(page);
        for (UserEntity user:userEntityList) {
            System.out.println(JsonUtil.toJsonString(user));
        }
        model.addAttribute("userlist", userEntityList);
        return "userList";
    }

    @RequestMapping(value = "/getusers/p/{page}", method = RequestMethod.GET,
                    produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUsers(@PathVariable int page, HttpServletRequest request) {
        List<UserEntity> userEntityList = userService.getAllUser(page);
        String callback = request.getParameter("callback");
        JSONArray array = JsonUtil.listToJsonString(userEntityList);
        JSONObject object = new JSONObject();
        object.put("item", array);
        object.put("cnt", userService.getUserCount());
        String result = callback + "(" + object.toString() + ")";
        return result;
    }

    @RequestMapping(value = "/deleteusers", method = RequestMethod.POST,
                    produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteUsers(@RequestBody List<UserId> Ids) {
        ArrayList<Integer> id_list = new ArrayList<Integer>();
        for (UserId userId : Ids) {
            System.out.println("id>>>>>>>>>>>>>>" + userId.getId());
            try {
                int id = Integer.valueOf(userId.getId());
                id_list.add(id);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject json = new JSONObject();
        json.put("res", userService.delUsers(id_list));
        return json.toString();
    }
}
