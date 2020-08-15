package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.CourseCollect;
import com.pangmutou.education.service.CourseCollectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程收藏管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/courseCollect")
public class CourseCollectController extends BaseController {
    @Autowired
    private CourseCollectService courseCollectService;

    @RequiresPermissions("education:courseCollect:view")
    @RequestMapping()
    public String view() {
        return "education/courseCollect.html";
    }

    /**
     * 分页查询课程收藏
     */
    @RequiresPermissions("education:courseCollect:list")
    @OperLog(value = "课程收藏管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<CourseCollect> page(HttpServletRequest request) {
        PageParam<CourseCollect> pageParam = new PageParam<>(request);
        return new PageResult<>(courseCollectService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return courseCollectService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程收藏
     */
    @RequiresPermissions("education:courseCollect:list")
    @OperLog(value = "课程收藏管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<CourseCollect> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(courseCollectService.list(pageParam.getOrderWrapper()));
        //List<CourseCollect> records = courseCollectService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程收藏
     */
    @RequiresPermissions("education:courseCollect:list")
    @OperLog(value = "课程收藏管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(courseCollectService.getById(id));
		// 使用关联查询
        //PageParam<CourseCollect> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<CourseCollect> records = courseCollectService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程收藏
     */
    @RequiresPermissions("education:courseCollect:save")
    @OperLog(value = "课程收藏管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(CourseCollect courseCollect) {
        if (courseCollectService.save(courseCollect)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程收藏
     */
    @RequiresPermissions("education:courseCollect:update")
    @OperLog(value = "课程收藏管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(CourseCollect courseCollect) {
        if (courseCollectService.updateById(courseCollect)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程收藏
     */
    @RequiresPermissions("education:courseCollect:remove")
    @OperLog(value = "课程收藏管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (courseCollectService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程收藏
     */
    @RequiresPermissions("education:courseCollect:save")
    @OperLog(value = "课程收藏管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<CourseCollect> list) {
        if (courseCollectService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程收藏
     */
    @RequiresPermissions("education:courseCollect:update")
    @OperLog(value = "课程收藏管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<CourseCollect> batchParam) {
        if (batchParam.update(courseCollectService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程收藏
     */
    @RequiresPermissions("education:courseCollect:remove")
    @OperLog(value = "课程收藏管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (courseCollectService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
