package com.pangmutou.education.controller;

import com.alibaba.fastjson.JSON;
import com.pangmutou.common.base.BaseController;
import com.pangmutou.common.core.utils.GsonUtils;
import com.pangmutou.common.core.utils.JSONUtil;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.common.system.entity.Menu;
import com.pangmutou.education.entity.Course;
import com.pangmutou.education.entity.Reference;
import com.pangmutou.education.service.CourseService;
import com.pangmutou.education.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("web/h5/")
public class IndexH5Controller extends BaseController {

    @Autowired
    ReferenceService referenceService;
    @Autowired
    CourseService courseService;

    @RequestMapping("index")
    public String index(Model model,HttpServletRequest request){
        PageParam<Course> pageParam = new PageParam<Course>(request);
        pageParam.setSize(4L);
        System.out.println("返回值>>>>"+ JSON.toJSONString(courseService.listPage(pageParam).getData()));
        model.addAttribute("courseList", JSON.toJSONString(courseService.listPage(pageParam).getData()));

        return "front/h5/index.html";
    }

    @RequestMapping("star-teacher")
    public String teacher(Model model){
        return "front/h5/star-teacher.html";
    }

    @RequestMapping("reference-room")
    public String book(){
        return "front/h5/reference-room.html";
    }

    @ResponseBody
    @RequestMapping("reference-list")
    public String bookList(Model model, HttpServletRequest request){
        PageParam<Reference> pageParam = new PageParam<Reference>(request);
        pageParam.setDefaultOrder(new String[]{"id"}, null);
        PageResult<Reference> result =  referenceService.listPage(pageParam);
        return GsonUtils.toJsonString(result.getData());
    }

    @RequestMapping("school-page")
    public String schoolPage(){
        return "front/h5/school_list.html";
    }

    @RequestMapping(value = "user-login",method = RequestMethod.GET)
    public String toLogion(Model model){
        return "front/h5/user-login.html";
    }

    @RequestMapping(value = "user-login",method = RequestMethod.POST)
    public String doLogion(Model model){
        return REDIRECT+"/web/h5/user-login";
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
