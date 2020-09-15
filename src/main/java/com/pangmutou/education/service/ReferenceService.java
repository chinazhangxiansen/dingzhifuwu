package com.pangmutou.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.education.entity.Chapter;
import com.pangmutou.education.entity.Reference;

import java.util.List;
import java.util.Map;

public interface ReferenceService extends IService<Reference> {

    /**
     * 分页查询
     */
    PageResult<Reference> listPage(PageParam<Reference> page);

    /**
     * 查询所有
     */
    List<Reference> listAll(Map<String, Object> page);

}
