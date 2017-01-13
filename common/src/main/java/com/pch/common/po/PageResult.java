package com.pch.common.po;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public class PageResult<E> extends BaseResult implements Page<E> {

    private Page<E> page;

    public PageResult(Page<E> page) {
        this.page = page;
    }

    @Override
    public int getTotalPages() {
        return page.getTotalPages();
    }

    @Override
    public long getTotalElements() {
        return page.getTotalElements();
    }

    @Override
    public int getNumber() {
        return page.getNumber();
    }

    @Override
    public int getSize() {
        return page.getSize();
    }

    @Override
    public int getNumberOfElements() {
        return page.getNumberOfElements();
    }

    @Override
    public List<E> getContent() {
        return page.getContent();
    }

    @Override
    public boolean hasContent() {
        return page.hasContent();
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }

    @Override
    public boolean isFirst() {
        return page.isFirst();
    }

    @Override
    public boolean isLast() {
        return page.isLast();
    }

    @Override
    public boolean hasNext() {
        return page.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return page.hasPrevious();
    }

    @Override
    public Pageable nextPageable() {
        return page.nextPageable();
    }

    @Override
    public Pageable previousPageable() {
        return page.previousPageable();
    }

    @Override
    public <S> Page<S> map(Converter<? super E, ? extends S> converter) {
        return page.map(converter);
    }

    @Override
    public Iterator<E> iterator() {
        return page.iterator();
    }
}
