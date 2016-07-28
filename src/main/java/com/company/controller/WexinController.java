package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/7/6.
 */
@Controller
@RequestMapping("/wx")
public class WexinController {
    @RequestMapping("/reg")
    public String register() {
        return "wxreg";
    }

    @RequestMapping("index")
    public String index() {
        return "wxindex";
    }

    @RequestMapping("login")
    public String login(){
        return "wxlogin";
    }

    @RequestMapping("detail")
    public String detail() {
        return "wxdetail";
    }

}
