package com.pch.common.po;

import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public class Result<E> extends BaseResult {
    private List<E> content;

    public List<E> getContent() {
        return content;
    }

    public void setContent(List<E> content) {
        this.content = content;
    }
}
