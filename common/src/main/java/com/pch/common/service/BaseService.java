package com.pch.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
public interface BaseService<M extends Serializable, PK extends Serializable> {

    M findOne(PK pk);

    M save(M m);

    List<M> save(Iterable<M> it);

    List<M> findAll();
}
