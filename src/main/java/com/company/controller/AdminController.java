package com.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.model.AdminEntity;
import com.company.service.AdminService;
import com.company.util.StringCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by puyangsky on 2016/6/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
                    produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(@RequestBody AdminEntity entity, HttpServletRequest request) {
        System.out.println(entity.getUsername());
        if (StringCheck.isNullOrEmpty(entity.getUsername()) || StringCheck.isNullOrEmpty(entity.getPassword())) {
            JSONObject json = new JSONObject();
            json.put("result", "parameter invalid");
            return json.toString();
        }
        boolean pass = service.login(entity);
        if(pass) {
            request.getSession().setAttribute("user", entity.getUsername());
        }
        JSONObject json = new JSONObject();
        json.put("result", pass);
        return json.toString();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") != null) {
            System.out.println("登录成功！");
            return "admin";
        }
        return "login";
    }
}
