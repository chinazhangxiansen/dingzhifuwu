package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Banner;
import com.pangmutou.education.service.BannerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页banner表管理
 * Created by pangmutou on 2020-08-13 09:24:48
 */
@Controller
@RequestMapping("/education/banner")
public class BannerController extends BaseController {
    @Autowired
    private BannerService bannerService;

    @RequiresPermissions("education:banner:view")
    @RequestMapping()
    public String view() {
        return "education/banner.html";
    }

    /**
     * 分页查询首页banner表
     */
    @RequiresPermissions("education:banner:list")
    @OperLog(value = "首页banner表管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Banner> page(HttpServletRequest request) {
        PageParam<Banner> pageParam = new PageParam<>(request);
        return new PageResult<>(bannerService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return bannerService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部首页banner表
     */
    @RequiresPermissions("education:banner:list")
    @OperLog(value = "首页banner表管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Banner> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(bannerService.list(pageParam.getOrderWrapper()));
        //List<Banner> records = bannerService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询首页banner表
     */
    @RequiresPermissions("education:banner:list")
    @OperLog(value = "首页banner表管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(bannerService.getById(id));
		// 使用关联查询
        //PageParam<Banner> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Banner> records = bannerService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加首页banner表
     */
    @RequiresPermissions("education:banner:save")
    @OperLog(value = "首页banner表管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Banner banner) {
        if (bannerService.save(banner)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改首页banner表
     */
    @RequiresPermissions("education:banner:update")
    @OperLog(value = "首页banner表管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Banner banner) {
        if (bannerService.updateById(banner)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除首页banner表
     */
    @RequiresPermissions("education:banner:remove")
    @OperLog(value = "首页banner表管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (bannerService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加首页banner表
     */
    @RequiresPermissions("education:banner:save")
    @OperLog(value = "首页banner表管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Banner> list) {
        if (bannerService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改首页banner表
     */
    @RequiresPermissions("education:banner:update")
    @OperLog(value = "首页banner表管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Banner> batchParam) {
        if (batchParam.update(bannerService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除首页banner表
     */
    @RequiresPermissions("education:banner:remove")
    @OperLog(value = "首页banner表管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (bannerService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
