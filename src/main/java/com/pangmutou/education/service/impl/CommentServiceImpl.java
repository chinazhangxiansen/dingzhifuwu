package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.CommentMapper;
import com.pangmutou.education.entity.Comment;
import com.pangmutou.education.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 评论服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public PageResult<Comment> listPage(PageParam<Comment> page) {
        List<Comment> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Comment> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
