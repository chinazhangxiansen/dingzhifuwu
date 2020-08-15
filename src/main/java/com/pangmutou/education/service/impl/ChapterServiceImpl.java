package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.ChapterMapper;
import com.pangmutou.education.entity.Chapter;
import com.pangmutou.education.service.ChapterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Override
    public PageResult<Chapter> listPage(PageParam<Chapter> page) {
        List<Chapter> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Chapter> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
