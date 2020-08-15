package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 评论Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 分页查询
     */
    List<Comment> listPage(@Param("page") PageParam<Comment> page);

    /**
     * 查询全部
     */
    List<Comment> listAll(@Param("page") Map<String, Object> page);

}
