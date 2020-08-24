package com.pangmutou.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/h5/")
public class IndexH5Controller {

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

}
