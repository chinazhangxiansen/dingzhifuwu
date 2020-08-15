package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程视频Mapper接口
 * Created by pangmutou on 2020-08-13 09:24:49
 */
public interface VideoMapper extends BaseMapper<Video> {

    /**
     * 分页查询
     */
    List<Video> listPage(@Param("page") PageParam<Video> page);

    /**
     * 查询全部
     */
    List<Video> listAll(@Param("page") Map<String, Object> page);

}
