package com.pch.sys.service;

import com.pch.common.dao.BaseDao;
import com.pch.common.po.Result;
import com.pch.common.service.impl.BaseServiceImpl;
import com.pch.common.util.EntityUtil;
import com.pch.common.util.ResultUtil;
import com.pch.sys.dao.LogDao;
import com.pch.sys.po.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result<Log> save(Log log) {
        if (log.getData() == null || log.getData().isEmpty() || log.getcTime() == null || log.getcTime().isEmpty()) {
            EntityUtil.saveBase(log);
        }
        if (log.getName() == null) {
            log.setName("unknow");
        }
        return ResultUtil.getResult(logDao.save(log));
    }

}
