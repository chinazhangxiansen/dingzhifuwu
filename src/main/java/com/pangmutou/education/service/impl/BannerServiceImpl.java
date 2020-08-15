package com.pangmutou.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Banner;
import com.pangmutou.education.mapper.BannerMapper;
import com.pangmutou.education.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 首页banner表服务实现类
 * Created by pangmutou on 2020-08-13 09:24:48
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public PageResult<Banner> listPage(PageParam<Banner> page) {
        List<Banner> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<Banner> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

}
