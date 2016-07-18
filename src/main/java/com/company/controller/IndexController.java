package com.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.JsonUtil;
import com.company.util.StringCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    UploadedFile ufile;

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
    public@ResponseBody String upload(MultipartHttpServletRequest request) throws Exception {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());

        ufile = new UploadedFile(mpf.getBytes(), mpf.getOriginalFilename(), mpf.getContentType(),
                mpf.getBytes().length);
        String name = "default";
        String type = "jpg";
        if (ufile.name.contains(".")) {
            String[] names = ufile.name.split("\\.");
            name = names[0];
            type = names[1];
        }
        String imagePath = "http://" + request.getServerName() + ":" + request.getServerPort() + "/user/image/" +
                name + "/" + type;
        return imagePath;
    }

    @RequestMapping(value = "/image/{name}/{type}", method = RequestMethod.GET)
    public void getImage(@PathVariable String name,
                         @PathVariable String type,
                         HttpServletResponse response) throws IOException{

        InputStream inputStream = null;
        OutputStream out = null;
        try {
            File file = new File("D:\\image\\" + name + "." + type);
            inputStream = new FileInputStream(file);
            out = response.getOutputStream();
            // pic size = 1M
            byte[] bytes = new byte[5 * 1024 * 1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                inputStream.close();
            if (out != null)
                out.close();
        }
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

        System.out.println(JsonUtil.toJsonString(userEntity));

        int result = userService.addUser(userEntity);
        JSONObject json = new JSONObject();
        json.put("result", result);
        return json.toString();
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

    private class UploadedFile {
        byte[] bytes;
        int length;
        String type;
        String name;

        public UploadedFile() {
        }

        public UploadedFile(byte[] bytes, String name, String type, int length) {
            this.bytes = bytes;
            this.name = name;
            this.type = type;
            this.length = length;
            File file = new File("D:\\image\\" + name);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(this.bytes, 0, this.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
