package com.pch.study.service;

import com.pch.common.po.Result;
import com.pch.study.po.JavaCodeParam;
import org.springframework.ui.ModelMap;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/2/9
 */
public interface JavaCodeService {

    Result<JavaCodeParam> genJavaCode(JavaCodeParam javaCodeParam, ModelMap modelMap);
}
