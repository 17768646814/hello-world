package com.pch.sys.dao;

import com.pch.common.dao.impl.BaseDaoImpl;
import com.pch.sys.po.Log;
import org.springframework.stereotype.Repository;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
@Repository
public class LogDaoImpl extends BaseDaoImpl<Log, String> implements LogDaoCustom {
    @Override
    protected Class<Log> getEntityClass() {
        return Log.class;
    }
}
