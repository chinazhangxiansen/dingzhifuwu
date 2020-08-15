package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.CourseCollectMapper;
import com.pangmutou.education.entity.CourseCollect;
import com.pangmutou.education.service.CourseCollectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程收藏服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class CourseCollectServiceImpl extends ServiceImpl<CourseCollectMapper, CourseCollect> implements CourseCollectService {

    @Override
    public PageResult<CourseCollect> listPage(PageParam<CourseCollect> page) {
        List<CourseCollect> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<CourseCollect> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
