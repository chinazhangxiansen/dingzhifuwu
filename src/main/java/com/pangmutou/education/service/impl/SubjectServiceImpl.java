package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.SubjectMapper;
import com.pangmutou.education.entity.Subject;
import com.pangmutou.education.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程科目服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public PageResult<Subject> listPage(PageParam<Subject> page) {
        List<Subject> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Subject> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
