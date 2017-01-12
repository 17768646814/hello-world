package com.pch.common.service.impl;

import com.pch.common.dao.BaseDao;
import com.pch.common.service.BaseService;

import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
public abstract class BaseServiceImpl<M extends Serializable, PK extends Serializable> implements BaseService<M, PK> {
    abstract protected BaseDao<M, PK> getBaseDao();

}
