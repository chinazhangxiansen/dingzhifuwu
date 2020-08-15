package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.CourseDescription;
import com.pangmutou.education.service.CourseDescriptionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程简介管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/courseDescription")
public class CourseDescriptionController extends BaseController {
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @RequiresPermissions("education:courseDescription:view")
    @RequestMapping()
    public String view() {
        return "education/courseDescription.html";
    }

    /**
     * 分页查询课程简介
     */
    @RequiresPermissions("education:courseDescription:list")
    @OperLog(value = "课程简介管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<CourseDescription> page(HttpServletRequest request) {
        PageParam<CourseDescription> pageParam = new PageParam<>(request);
        return new PageResult<>(courseDescriptionService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return courseDescriptionService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程简介
     */
    @RequiresPermissions("education:courseDescription:list")
    @OperLog(value = "课程简介管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<CourseDescription> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(courseDescriptionService.list(pageParam.getOrderWrapper()));
        //List<CourseDescription> records = courseDescriptionService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程简介
     */
    @RequiresPermissions("education:courseDescription:list")
    @OperLog(value = "课程简介管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(courseDescriptionService.getById(id));
		// 使用关联查询
        //PageParam<CourseDescription> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<CourseDescription> records = courseDescriptionService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程简介
     */
    @RequiresPermissions("education:courseDescription:save")
    @OperLog(value = "课程简介管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(CourseDescription courseDescription) {
        if (courseDescriptionService.save(courseDescription)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程简介
     */
    @RequiresPermissions("education:courseDescription:update")
    @OperLog(value = "课程简介管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(CourseDescription courseDescription) {
        if (courseDescriptionService.updateById(courseDescription)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程简介
     */
    @RequiresPermissions("education:courseDescription:remove")
    @OperLog(value = "课程简介管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (courseDescriptionService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程简介
     */
    @RequiresPermissions("education:courseDescription:save")
    @OperLog(value = "课程简介管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<CourseDescription> list) {
        if (courseDescriptionService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程简介
     */
    @RequiresPermissions("education:courseDescription:update")
    @OperLog(value = "课程简介管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<CourseDescription> batchParam) {
        if (batchParam.update(courseDescriptionService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程简介
     */
    @RequiresPermissions("education:courseDescription:remove")
    @OperLog(value = "课程简介管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (courseDescriptionService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
