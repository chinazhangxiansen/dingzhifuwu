package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 讲师Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 分页查询
     */
    List<Teacher> listPage(@Param("page") PageParam<Teacher> page);

    /**
     * 查询全部
     */
    List<Teacher> listAll(@Param("page") Map<String, Object> page);

}
