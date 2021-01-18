package com.pangmutou.education.controller;

import com.alibaba.fastjson.JSON;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.system.entity.LoginRecord;
import com.pangmutou.education.entity.Course;
import com.pangmutou.education.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("web")
public class IndexController {

    @Autowired
    CourseService courseService;

    @RequestMapping("index")
    public String index(Model model, HttpServletRequest request){
        PageParam<Course> pageParam = new PageParam<Course>(request);
        pageParam.setSize(4L);
        System.out.println("返回值>>>>"+ JSON.toJSONString(courseService.listPage(pageParam).getData()));
        model.addAttribute("courseList", JSON.toJSONString(courseService.listPage(pageParam).getData()));
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
