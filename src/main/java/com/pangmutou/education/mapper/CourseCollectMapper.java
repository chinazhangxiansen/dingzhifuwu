package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.CourseCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程收藏Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CourseCollectMapper extends BaseMapper<CourseCollect> {

    /**
     * 分页查询
     */
    List<CourseCollect> listPage(@Param("page") PageParam<CourseCollect> page);

    /**
     * 查询全部
     */
    List<CourseCollect> listAll(@Param("page") Map<String, Object> page);

}
