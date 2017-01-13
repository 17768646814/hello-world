package com.pch.common.util;

import com.pch.common.po.PageResult;
import com.pch.common.po.Result;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public class ResultUtil {

    public static<E> Result getResult(E e) {
        List<E> it = new ArrayList<>();
        return getResult(it);
    }

    public static<E> Result getResult(List<E> it) {
        Result<E> result = new Result<E>();
        result.setContent(it);
        result.setCode("200");
        result.setMsg("成功");
        result.setSuccess(true);
        return result;
    }

    public static<E> PageResult getPageResult(Page<E> page) {
        PageResult<E> result = new PageResult<E>(page);
        result.setCode("200");
        result.setMsg("成功");
        result.setSuccess(true);
        return result;
    }
}
