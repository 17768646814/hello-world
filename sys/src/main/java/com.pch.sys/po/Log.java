package com.pch.sys.po;

import com.pch.common.po.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
@Entity(name = "STUDY_LOG")
public class Log extends BaseEntity {

    private String ip;
    private String url;
    private String name;
    private String data;
    private String type;
    private String code;
    private String des;
    private String userAgent;

    @Column(length = 100, nullable = false)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(length = 200, nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(length = 200, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 4000)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(length = 100, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(length = 100, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(length = 200)
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Column(length = 400)
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
