package com.pch.sys.dao;

import com.pch.common.dao.BaseDao;
import com.pch.sys.po.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public interface LogDao extends BaseDao<Log, String>, JpaRepository<Log, String> {
}
