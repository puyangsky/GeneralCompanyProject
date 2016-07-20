package com.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.model.UserEntity;
import com.company.service.UserService;
import com.company.util.Constant;
import com.company.util.JsonUtil;
import com.company.util.StringCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
    @ResponseBody
    public String upload(MultipartHttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());

        String name = Calendar.getInstance().getTimeInMillis() + "";
        String type = "jpg";
        String originName = mpf.getOriginalFilename();
        if (originName.contains(".")) {
            String[] names = originName.split("\\.");
            type = names[1];
        }
        ufile = new UploadedFile(mpf.getBytes(), name + "." + type, mpf.getContentType(),
                mpf.getBytes().length);

        String imagePath = "http://" + request.getServerName() + ":" + request.getServerPort() + "/user/image/" +
                name + "/" + type;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgpath", imagePath);
        response.setContentType("text/html;charset=UTF-8");
        return jsonObject.toString();
    }

    @RequestMapping(value = "/image/{name}/{type}", method = RequestMethod.GET)
    public void getImage(@PathVariable String name,
                         @PathVariable String type,
                         HttpServletResponse response) throws IOException{

        OutputStream out = null;
        BufferedImage image = null;
        try {
            File file = new File(Constant.IMGDIR + name + "." + type);
            image = ImageIO.read(file);
            out = response.getOutputStream();
            ImageIO.write(image, type, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestBody UserEntity userEntity, HttpServletRequest request) {
        System.out.println(JsonUtil.toJsonString(userEntity));
//        Cookie[] cookies = request.getCookies();
//        int len = cookies.length;
//        for (int i=0;i<len;i++) {
//            if (cookies[i].getName().equals("id")) {
//                id = cookies[i].getValue();
//            }
//        }
        String id = "0";
        int uid;
        id = request.getHeader("UID");
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
            File file = new File(Constant.IMGDIR + name);
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
