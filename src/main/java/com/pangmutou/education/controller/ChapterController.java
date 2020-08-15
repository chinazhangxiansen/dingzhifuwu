package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Chapter;
import com.pangmutou.education.service.ChapterService;
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
@RequestMapping("/education/chapter")
public class ChapterController extends BaseController {
    @Autowired
    private ChapterService chapterService;

    @RequiresPermissions("education:chapter:view")
    @RequestMapping()
    public String view() {
        return "education/chapter.html";
    }

    /**
     * 分页查询课程
     */
    @RequiresPermissions("education:chapter:list")
    @OperLog(value = "课程管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Chapter> page(HttpServletRequest request) {
        PageParam<Chapter> pageParam = new PageParam<>(request);
        return new PageResult<>(chapterService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return chapterService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程
     */
    @RequiresPermissions("education:chapter:list")
    @OperLog(value = "课程管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Chapter> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(chapterService.list(pageParam.getOrderWrapper()));
        //List<Chapter> records = chapterService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程
     */
    @RequiresPermissions("education:chapter:list")
    @OperLog(value = "课程管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(chapterService.getById(id));
		// 使用关联查询
        //PageParam<Chapter> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Chapter> records = chapterService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程
     */
    @RequiresPermissions("education:chapter:save")
    @OperLog(value = "课程管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Chapter chapter) {
        if (chapterService.save(chapter)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程
     */
    @RequiresPermissions("education:chapter:update")
    @OperLog(value = "课程管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Chapter chapter) {
        if (chapterService.updateById(chapter)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("education:chapter:remove")
    @OperLog(value = "课程管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (chapterService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程
     */
    @RequiresPermissions("education:chapter:save")
    @OperLog(value = "课程管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Chapter> list) {
        if (chapterService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程
     */
    @RequiresPermissions("education:chapter:update")
    @OperLog(value = "课程管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Chapter> batchParam) {
        if (batchParam.update(chapterService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程
     */
    @RequiresPermissions("education:chapter:remove")
    @OperLog(value = "课程管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (chapterService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
