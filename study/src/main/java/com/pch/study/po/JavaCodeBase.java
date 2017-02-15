package com.pch.study.po;

import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/2/13
 */
public abstract class JavaCodeBase implements JavaCode {
    
    private List<String> api;
    private List<String> entity;
    private List<String> dao;
    private List<String> imp;
    private List<String> service;

    @Override
    public List<String> getApi() {
        return api;
    }

    public void setApi(List<String> api) {
        this.api = api;
    }

    @Override
    public List<String> getEntity() {
        return entity;
    }

    public void setEntity(List<String> entity) {
        this.entity = entity;
    }

    @Override
    public List<String> getDao() {
        return dao;
    }

    public void setDao(List<String> dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getImp() {
        return imp;
    }

    public void setImp(List<String> imp) {
        this.imp = imp;
    }

    @Override
    public List<String> getService() {
        return service;
    }

    public void setService(List<String> service) {
        this.service = service;
    }
}
