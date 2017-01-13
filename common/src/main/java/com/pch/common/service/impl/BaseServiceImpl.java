package com.pch.common.service.impl;

import com.pch.common.dao.BaseDao;
import com.pch.common.po.PageResult;
import com.pch.common.po.Result;
import com.pch.common.service.BaseService;
import com.pch.common.util.ResultUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
public abstract class BaseServiceImpl<E extends Serializable, PK extends Serializable> implements BaseService<E, PK> {

    abstract protected BaseDao<E, PK> getBaseDao();

    @Override
    public Result<E> findOne(PK pk) {
        return ResultUtil.getResult(getJpaRepository().findOne(pk));
    }

    @Override
    public Result<E> save(E m) {
        return ResultUtil.getResult(getJpaRepository().save(m));
    }

    @Override
    public Result<E> save(Iterable<E> it) {
        return ResultUtil.getResult(getJpaRepository().save(it));
    }

    @Override
    public Result<E> findAll() {
        return ResultUtil.getResult(getJpaRepository().findAll());
    }

    @Override
    public PageResult<E> findAll(Pageable pageable) {
        return ResultUtil.getPageResult(getJpaRepository().findAll(pageable));
    }

    private JpaRepository<E, PK> getJpaRepository() {
        BaseDao<E, PK> baseDao = getBaseDao();
        JpaRepository<E, PK> repository = null;
        if (baseDao instanceof JpaRepository) {
            repository = (JpaRepository) baseDao;
        } else {
        }
        return repository;
    }

}
