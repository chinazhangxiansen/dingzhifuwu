package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.TeacherMapper;
import com.pangmutou.education.entity.Teacher;
import com.pangmutou.education.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 讲师服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public PageResult<Teacher> listPage(PageParam<Teacher> page) {
        List<Teacher> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Teacher> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
