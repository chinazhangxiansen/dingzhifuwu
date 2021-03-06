package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.CourseDescription;

import java.util.List;
import java.util.Map;

/**
 * 课程简介服务类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CourseDescriptionService extends IService<CourseDescription> {

    /**
     * 分页查询
     */
    PageResult<CourseDescription> listPage(PageParam<CourseDescription> page);

    /**
     * 查询所有
     */
    List<CourseDescription> listAll(Map<String, Object> page);

}
