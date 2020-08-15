package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.CourseDescriptionMapper;
import com.pangmutou.education.entity.CourseDescription;
import com.pangmutou.education.service.CourseDescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程简介服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {

    @Override
    public PageResult<CourseDescription> listPage(PageParam<CourseDescription> page) {
        List<CourseDescription> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<CourseDescription> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
