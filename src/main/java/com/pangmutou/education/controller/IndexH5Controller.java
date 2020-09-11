package com.pangmutou.education.controller;

import com.pangmutou.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("web/h5/")
public class IndexH5Controller extends BaseController {

    @RequestMapping("index")
    public String index(Model model){
        return "front/h5/index.html";
    }

    @RequestMapping("star-teacher")
    public String teacher(Model model){
        return "front/h5/star-teacher.html";
    }

    @RequestMapping("reference-room")
    public String book(Model model){
        return "front/h5/reference-room.html";
    }

    @RequestMapping(value = "user-login",method = RequestMethod.GET)
    public String toLogion(Model model){
        return "front/h5/user-login.html";
    }

    @RequestMapping(value = "user-login",method = RequestMethod.POST)
    public String doLogion(Model model){
        return REDIRECT+"/web/h5/index";
    }

    @RequestMapping(value = "user-register",method = RequestMethod.GET)
    public String toRegister(Model model){
        return "front/h5/user-login.html";
    }

    @RequestMapping(value = "user-register",method = RequestMethod.POST)
    public String doRegister(Model model){
        return REDIRECT+"/web/h5/user-login";
    }

}
