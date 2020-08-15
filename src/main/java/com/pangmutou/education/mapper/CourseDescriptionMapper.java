package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.CourseDescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程简介Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {

    /**
     * 分页查询
     */
    List<CourseDescription> listPage(@Param("page") PageParam<CourseDescription> page);

    /**
     * 查询全部
     */
    List<CourseDescription> listAll(@Param("page") Map<String, Object> page);

}
