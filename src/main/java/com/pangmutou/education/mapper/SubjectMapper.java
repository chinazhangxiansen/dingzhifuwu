package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程科目Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 分页查询
     */
    List<Subject> listPage(@Param("page") PageParam<Subject> page);

    /**
     * 查询全部
     */
    List<Subject> listAll(@Param("page") Map<String, Object> page);

}
