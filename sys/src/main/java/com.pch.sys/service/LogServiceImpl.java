package com.pch.sys.service;

import com.pch.common.dao.BaseDao;
import com.pch.common.service.impl.BaseServiceImpl;
import com.pch.sys.dao.LogDao;
import com.pch.sys.po.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log, String> implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    protected BaseDao<Log, String> getBaseDao() {
        return logDao;
    }

    @Override
    public Log findOne(String id) {
        return logDao.findOne(id);
    }

    @Override
    public Log save(Log log) {
        return logDao.save(log);
    }

    @Override
    public List<Log> save(Iterable<Log> it) {
        return logDao.save(it);
    }

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }

}
