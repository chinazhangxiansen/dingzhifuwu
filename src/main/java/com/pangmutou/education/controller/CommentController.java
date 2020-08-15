package com.pangmutou.education.controller;

import com.pangmutou.common.core.web.*;
import com.pangmutou.common.core.annotation.OperLog;
import com.pangmutou.education.entity.Comment;
import com.pangmutou.education.service.CommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 评论管理
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Controller
@RequestMapping("/education/comment")
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    @RequiresPermissions("education:comment:view")
    @RequestMapping()
    public String view() {
        return "education/comment.html";
    }

    /**
     * 分页查询评论
     */
    @RequiresPermissions("education:comment:list")
    @OperLog(value = "评论管理", desc = "分页查询")
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Comment> page(HttpServletRequest request) {
        PageParam<Comment> pageParam = new PageParam<>(request);
        return new PageResult<>(commentService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return commentService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部评论
     */
    @RequiresPermissions("education:comment:list")
    @OperLog(value = "评论管理", desc = "查询全部")
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Comment> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(commentService.list(pageParam.getOrderWrapper()));
        //List<Comment> records = commentService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询评论
     */
    @RequiresPermissions("education:comment:list")
    @OperLog(value = "评论管理", desc = "根据id查询")
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(commentService.getById(id));
		// 使用关联查询
        //PageParam<Comment> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Comment> records = commentService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加评论
     */
    @RequiresPermissions("education:comment:save")
    @OperLog(value = "评论管理", desc = "添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Comment comment) {
        if (commentService.save(comment)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改评论
     */
    @RequiresPermissions("education:comment:update")
    @OperLog(value = "评论管理", desc = "修改", param = false, result = true)
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Comment comment) {
        if (commentService.updateById(comment)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("education:comment:remove")
    @OperLog(value = "评论管理", desc = "删除", result = true)
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (commentService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加评论
     */
    @RequiresPermissions("education:comment:save")
    @OperLog(value = "评论管理", desc = "批量添加", param = false, result = true)
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Comment> list) {
        if (commentService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改评论
     */
    @RequiresPermissions("education:comment:update")
    @OperLog(value = "评论管理", desc = "批量修改", result = true)
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Comment> batchParam) {
        if (batchParam.update(commentService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除评论
     */
    @RequiresPermissions("education:comment:remove")
    @OperLog(value = "评论管理", desc = "批量删除", result = true)
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (commentService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
