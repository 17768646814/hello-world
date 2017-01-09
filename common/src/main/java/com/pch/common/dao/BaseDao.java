package com.pch.common.dao;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
@NoRepositoryBean
public interface BaseDao<M extends Serializable, PK extends Serializable> {
    EntityManager getEntityManager();
}
