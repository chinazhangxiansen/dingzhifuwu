package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface ChapterMapper extends BaseMapper<Chapter> {

    /**
     * 分页查询
     */
    List<Chapter> listPage(@Param("page") PageParam<Chapter> page);

    /**
     * 查询全部
     */
    List<Chapter> listAll(@Param("page") Map<String, Object> page);

}
