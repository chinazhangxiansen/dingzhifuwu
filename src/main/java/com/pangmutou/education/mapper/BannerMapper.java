package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 首页banner表Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:48
 */
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 分页查询
     */
    List<Banner> listPage(@Param("page") PageParam<Banner> page);

    /**
     * 查询全部
     */
    List<Banner> listAll(@Param("page") Map<String, Object> page);

}
