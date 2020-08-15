package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Teacher;
import com.pangmutou.education.service.TeacherService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 讲师管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/teacher")
public class TeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;

    @RequiresPermissions("education:teacher:view")
    @RequestMapping()
    public String view() {
        return "education/teacher.html";
    }

    /**
     * 分页查询讲师
     */
    @RequiresPermissions("education:teacher:list")
    @OperLog(value = "讲师管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Teacher> page(HttpServletRequest request) {
        PageParam<Teacher> pageParam = new PageParam<>(request);
        return new PageResult<>(teacherService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return teacherService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部讲师
     */
    @RequiresPermissions("education:teacher:list")
    @OperLog(value = "讲师管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Teacher> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(teacherService.list(pageParam.getOrderWrapper()));
        //List<Teacher> records = teacherService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询讲师
     */
    @RequiresPermissions("education:teacher:list")
    @OperLog(value = "讲师管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(teacherService.getById(id));
		// 使用关联查询
        //PageParam<Teacher> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Teacher> records = teacherService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加讲师
     */
    @RequiresPermissions("education:teacher:save")
    @OperLog(value = "讲师管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Teacher teacher) {
        if (teacherService.save(teacher)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改讲师
     */
    @RequiresPermissions("education:teacher:update")
    @OperLog(value = "讲师管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Teacher teacher) {
        if (teacherService.updateById(teacher)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除讲师
     */
    @RequiresPermissions("education:teacher:remove")
    @OperLog(value = "讲师管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (teacherService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加讲师
     */
    @RequiresPermissions("education:teacher:save")
    @OperLog(value = "讲师管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Teacher> list) {
        if (teacherService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改讲师
     */
    @RequiresPermissions("education:teacher:update")
    @OperLog(value = "讲师管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Teacher> batchParam) {
        if (batchParam.update(teacherService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除讲师
     */
    @RequiresPermissions("education:teacher:remove")
    @OperLog(value = "讲师管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (teacherService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
