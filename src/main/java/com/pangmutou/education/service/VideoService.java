package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Video;

import java.util.List;
import java.util.Map;

/**
 * 课程视频服务类
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface VideoService extends IService<Video> {

    /**
     * 分页查询
     */
    PageResult<Video> listPage(PageParam<Video> page);

    /**
     * 查询所有
     */
    List<Video> listAll(Map<String, Object> page);

}
