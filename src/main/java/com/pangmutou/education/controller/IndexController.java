package com.pangmutou.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "front/index.html";
    }

}
