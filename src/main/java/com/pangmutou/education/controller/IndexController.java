package com.pangmutou.education.controller;

import com.pangmutou.education.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class IndexController {

//    @Autowired
//    CourseService courseService;

    @RequestMapping("index")
    public String index(){
        return "front/index.html";
    }


    @RequestMapping("star-teacher")
    public String starTeacher(){
        return "front/star-teacher.html";
    }


    @RequestMapping("reference-room")
    public String referenceRoom(){
        return "front/reference-room.html";
    }

    @RequestMapping("excellent-course")
    public String excellentCourse(){
        return "front/excellent-course.html";
    }

}
