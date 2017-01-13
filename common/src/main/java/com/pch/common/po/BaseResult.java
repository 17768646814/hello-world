package com.pch.common.po;

import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public abstract class BaseResult implements Serializable {

    private static final long serialVersionUID = -2487537330424420406L;

    private String code;

    private String msg;

    private boolean isSuccess;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResult that = (BaseResult) o;

        if (!code.equals(that.code)) return false;
        return msg.equals(that.msg);

    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + msg.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
