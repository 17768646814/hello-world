package com.pch.study.web;

import com.pch.common.po.Result;
import com.pch.common.util.DateUtil;
import com.pch.common.util.HttpUtil;
import com.pch.study.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/16
 */
@RestController
@RequestMapping("/mail")
@Api(value = "mail", tags = "邮件")
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "发送邮件", notes = "mail.sendMail")
    public Result<?> sendMail(ModelMap modelMap, HttpServletRequest request) {
        modelMap.putAll(HttpUtil.getParameterMap(request));
        return mailService.sendMail(modelMap);
    }

    @RequestMapping(value = "/sendMailTest", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "发送邮件测试", notes = "mail.sendMailTest")
    public Result<?> sendMailTest(ModelMap modelMap, HttpServletRequest request) {
        modelMap.put("userName", "张三");
        modelMap.put("channel", "渠道");
        modelMap.put("accoName", "基金账号");
        modelMap.put("date", DateUtil.getDate8());
        modelMap.put("tradeType", "交易类型");
        modelMap.put("num", "888");
        modelMap.put("fund", "基金");
        return sendMail(modelMap, request);
    }
}
