package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.CourseMapper;
import com.pangmutou.education.entity.Course;
import com.pangmutou.education.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public PageResult<Course> listPage(PageParam<Course> page) {
        List<Course> records = baseMapper.listPage(page);
        System.out.println(">>>>>"+records.toString());
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Course> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
