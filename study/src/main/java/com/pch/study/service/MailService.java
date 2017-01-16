package com.pch.study.service;

import com.pch.common.po.Result;
import org.springframework.ui.ModelMap;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/16
 */
public interface MailService {
    Result<?> sendMail(ModelMap modelMap);
}
