package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.mapper.VideoMapper;
import com.pangmutou.education.entity.Video;
import com.pangmutou.education.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程视频服务实现类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Override
    public PageResult<Video> listPage(PageParam<Video> page) {
        List<Video> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Video> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
