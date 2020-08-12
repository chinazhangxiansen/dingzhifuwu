package com.pangmutou.common.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangmutou.common.core.web.PageParam;
import com.pangmutou.common.core.web.PageResult;
import com.pangmutou.common.core.utils.UserAgentGetter;
import com.pangmutou.common.system.mapper.LoginRecordMapper;
import com.pangmutou.common.system.entity.LoginRecord;
import com.pangmutou.common.system.service.LoginRecordService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 登录日志服务实现类
 * Created by wangfan on 2018-12-24 16:10
 */
@Service
public class LoginRecordServiceImpl extends ServiceImpl<LoginRecordMapper, LoginRecord> implements LoginRecordService {

    @Override
    public PageResult<LoginRecord> listPage(PageParam<LoginRecord> page) {
        List<LoginRecord> records = baseMapper.listPage(page);
        return new PageResult<>(records, page.getTotal());
    }

    @Override
    public List<LoginRecord> listAll(Map<String, Object> page) {
        return baseMapper.listAll(page);
    }

    @Override
    public void saveAsync(String username, Integer type, String comments, HttpServletRequest request) {
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUsername(username);
        loginRecord.setOperType(type);
        loginRecord.setComments(comments);
        UserAgentGetter agentGetter = new UserAgentGetter(request);
        loginRecord.setOs(agentGetter.getOS());
        loginRecord.setDevice(agentGetter.getDevice());
        loginRecord.setBrowser(agentGetter.getBrowser());
        loginRecord.setIp(agentGetter.getIp());
        saveAsync(loginRecord);
    }

    @Override
    public void saveAsync(String username, HttpServletRequest request) {
        saveAsync(username, LoginRecord.TYPE_LOGIN, null, request);
    }

    @Async
    public void saveAsync(LoginRecord loginRecord) {
        baseMapper.insert(loginRecord);
    }

}
