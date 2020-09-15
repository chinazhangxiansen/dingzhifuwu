package com.pangmutou.education.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.education.entity.Reference;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReferenceMapper extends BaseMapper<Reference> {

    /**
     * 分页查询
     */
    List<Reference> listPage(@Param("page") PageParam<Reference> page);

    /**
     * 查询全部
     */
    List<Reference> listAll(@Param("page") Map<String, Object> page);
}
