package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Course;
import com.pangmutou.education.service.CourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    @RequiresPermissions("education:course:view")
    @RequestMapping()
    public String view() {
        return "education/course.html";
    }

    /**
     * 分页查询课程
     */
    @RequiresPermissions("education:course:list")
    @OperLog(value = "课程管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Course> page(HttpServletRequest request) {
        PageParam<Course> pageParam = new PageParam<>(request);
        return new PageResult<>(courseService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return courseService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程
     */
    @RequiresPermissions("education:course:list")
    @OperLog(value = "课程管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Course> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(courseService.list(pageParam.getOrderWrapper()));
        //List<Course> records = courseService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程
     */
    @RequiresPermissions("education:course:list")
    @OperLog(value = "课程管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(courseService.getById(id));
		// 使用关联查询
        //PageParam<Course> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Course> records = courseService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程
     */
    @RequiresPermissions("education:course:save")
    @OperLog(value = "课程管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Course course) {
        if (courseService.save(course)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程
     */
    @RequiresPermissions("education:course:update")
    @OperLog(value = "课程管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Course course) {
        if (courseService.updateById(course)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("education:course:remove")
    @OperLog(value = "课程管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (courseService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程
     */
    @RequiresPermissions("education:course:save")
    @OperLog(value = "课程管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Course> list) {
        if (courseService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程
     */
    @RequiresPermissions("education:course:update")
    @OperLog(value = "课程管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Course> batchParam) {
        if (batchParam.update(courseService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程
     */
    @RequiresPermissions("education:course:remove")
    @OperLog(value = "课程管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (courseService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
