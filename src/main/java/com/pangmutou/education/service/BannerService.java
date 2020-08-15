package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Banner;

import java.util.List;
import java.util.Map;

/**
 * 首页banner表服务类
 * Created by pangmutou on 2020-08-13 09:24:48
 */
public interface BannerService extends IService<Banner> {

    /**
     * 分页查询
     */
    PageResult<Banner> listPage(PageParam<Banner> page);

    /**
     * 查询所有
     */
    List<Banner> listAll(Map<String, Object> page);

}
