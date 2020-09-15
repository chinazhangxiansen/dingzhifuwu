package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Course;
import com.pangmutou.education.entity.Reference;
import com.pangmutou.education.mapper.ReferenceMapper;
import com.pangmutou.education.service.ReferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReferenceServiceImpl extends ServiceImpl<ReferenceMapper, Reference> implements ReferenceService {

    @Override
    public PageResult<Reference> listPage(PageParam<Reference> page) {
        List<Reference> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Reference> listAll(Map<String, Object> page) {
        return null;
    }
}
