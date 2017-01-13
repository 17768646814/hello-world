package com.pch.common.dao.impl;

import com.pch.common.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
public abstract class BaseDaoImpl<E extends Serializable, PK extends Serializable> implements BaseDao<E, PK> {
    private static Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    abstract protected Class<E> getEntityClass();
}
