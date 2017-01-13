package com.pch.common.service;

import com.pch.common.po.PageResult;
import com.pch.common.po.Result;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
public interface BaseService<E extends Serializable, PK extends Serializable> {

    Result<E> findOne(PK pk);

    Result<E> save(E m);

    Result<E> save(Iterable<E> it);

    Result<E> findAll();

    PageResult<E> findAll(Pageable pageable);
}
