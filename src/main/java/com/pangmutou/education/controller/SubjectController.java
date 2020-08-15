package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Subject;
import com.pangmutou.education.service.SubjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程科目管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/subject")
public class SubjectController extends BaseController {
    @Autowired
    private SubjectService subjectService;

    @RequiresPermissions("education:subject:view")
    @RequestMapping()
    public String view() {
        return "education/subject.html";
    }

    /**
     * 分页查询课程科目
     */
    @RequiresPermissions("education:subject:list")
    @OperLog(value = "课程科目管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Subject> page(HttpServletRequest request) {
        PageParam<Subject> pageParam = new PageParam<>(request);
        return new PageResult<>(subjectService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return subjectService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程科目
     */
    @RequiresPermissions("education:subject:list")
    @OperLog(value = "课程科目管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Subject> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(subjectService.list(pageParam.getOrderWrapper()));
        //List<Subject> records = subjectService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程科目
     */
    @RequiresPermissions("education:subject:list")
    @OperLog(value = "课程科目管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(subjectService.getById(id));
		// 使用关联查询
        //PageParam<Subject> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Subject> records = subjectService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程科目
     */
    @RequiresPermissions("education:subject:save")
    @OperLog(value = "课程科目管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Subject subject) {
        if (subjectService.save(subject)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程科目
     */
    @RequiresPermissions("education:subject:update")
    @OperLog(value = "课程科目管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Subject subject) {
        if (subjectService.updateById(subject)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程科目
     */
    @RequiresPermissions("education:subject:remove")
    @OperLog(value = "课程科目管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (subjectService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程科目
     */
    @RequiresPermissions("education:subject:save")
    @OperLog(value = "课程科目管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Subject> list) {
        if (subjectService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程科目
     */
    @RequiresPermissions("education:subject:update")
    @OperLog(value = "课程科目管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Subject> batchParam) {
        if (batchParam.update(subjectService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程科目
     */
    @RequiresPermissions("education:subject:remove")
    @OperLog(value = "课程科目管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (subjectService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
