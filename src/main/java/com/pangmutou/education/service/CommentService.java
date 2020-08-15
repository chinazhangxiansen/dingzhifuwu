package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * 评论服务类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CommentService extends IService<Comment> {

    /**
     * 分页查询
     */
    PageResult<Comment> listPage(PageParam<Comment> page);

    /**
     * 查询所有
     */
    List<Comment> listAll(Map<String, Object> page);

}
