package com.pch.study.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
    public String hello() {
        return "hello world";
    }
}