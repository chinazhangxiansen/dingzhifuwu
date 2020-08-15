package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.CourseCollect;

import java.util.List;
import java.util.Map;

/**
 * 课程收藏服务类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface CourseCollectService extends IService<CourseCollect> {

    /**
     * 分页查询
     */
    PageResult<CourseCollect> listPage(PageParam<CourseCollect> page);

    /**
     * 查询所有
     */
    List<CourseCollect> listAll(Map<String, Object> page);

}
