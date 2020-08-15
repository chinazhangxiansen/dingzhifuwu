package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Video;
import com.pangmutou.education.service.VideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程视频管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/video")
public class VideoController extends BaseController {
    @Autowired
    private VideoService videoService;

    @RequiresPermissions("education:video:view")
    @RequestMapping()
    public String view() {
        return "education/video.html";
    }

    /**
     * 分页查询课程视频
     */
    @RequiresPermissions("education:video:list")
    @OperLog(value = "课程视频管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Video> page(HttpServletRequest request) {
        PageParam<Video> pageParam = new PageParam<>(request);
        return new PageResult<>(videoService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return videoService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部课程视频
     */
    @RequiresPermissions("education:video:list")
    @OperLog(value = "课程视频管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Video> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(videoService.list(pageParam.getOrderWrapper()));
        //List<Video> records = videoService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询课程视频
     */
    @RequiresPermissions("education:video:list")
    @OperLog(value = "课程视频管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(videoService.getById(id));
		// 使用关联查询
        //PageParam<Video> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Video> records = videoService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加课程视频
     */
    @RequiresPermissions("education:video:save")
    @OperLog(value = "课程视频管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Video video) {
        if (videoService.save(video)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改课程视频
     */
    @RequiresPermissions("education:video:update")
    @OperLog(value = "课程视频管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Video video) {
        if (videoService.updateById(video)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除课程视频
     */
    @RequiresPermissions("education:video:remove")
    @OperLog(value = "课程视频管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (videoService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加课程视频
     */
    @RequiresPermissions("education:video:save")
    @OperLog(value = "课程视频管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Video> list) {
        if (videoService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改课程视频
     */
    @RequiresPermissions("education:video:update")
    @OperLog(value = "课程视频管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Video> batchParam) {
        if (batchParam.update(videoService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除课程视频
     */
    @RequiresPermissions("education:video:remove")
    @OperLog(value = "课程视频管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (videoService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
