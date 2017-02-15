package com.pch.study.web;

import com.pch.common.po.Result;
import com.pch.common.util.DateUtil;
import com.pch.study.po.JavaCodeParam;
import com.pch.study.service.JavaCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/2/9
 */
@RestController
@RequestMapping("/javaCode")
@Api(value = "javaCode", tags = "生成java代码")
public class JavaCodeController {

    @Autowired
    private JavaCodeService javaCodeService;

    @RequestMapping(value = "/genJavaCode", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "生成api层的java代码", notes = "javaCode.genJavaCode")
    public Result<JavaCodeParam> genJavaCode(JavaCodeParam javaCodeParam, ModelMap modelMap,
                                             HttpServletRequest
            request) {
        /*String[] apiEntries = {"BankChannelQueryAPI", "OpenFundAccoPreCheckAPI", "OpenFundAccountAPI",
                "OpenTradeAccountPreCheckAPI", "OpenTradeAccountAPI", "ChangeBankcardPreCheckAPI", "ChangeBankcardAPI",
                "CloseTradeAccountPreCheckAPI", "CloseTradeAccountAPI", "PaperInfoQueryAPI", "SubmitPaperInfoAPI",
                "ModifyTradePasswordAPI", "ResetTradePasswordAPI", "ModifyCustomerInfoAPI", "LoginCheckAPI",
                "MobileRegAPI", "CustInfoQueryAPI", "ResetRegUserPasswordAPI", "ModifyBankinfoAPI",
                "CustRiskInfoQueryAPI", "PwdEncrypAPI", "OpenTrustwayAPI", "OpenIdNoToUpperCaseAPI",
                "ModifyBankBranchNameAPI", "CGBBankcardUpdradeAPI", "ChangePwproAPI", "ValidatePwproAPI",
                "UpdateRegUserBindInfoAPI"};
        javaCodeParam.setSection("account");
        javaCodeParam.setModule("hs");
        javaCodeParam.setImports(Arrays.asList("account"));
        javaCodeParam.setApiEntries(Arrays.asList(apiEntries));*/

//        String[] fields = {"String name", "Boolean flag", "Integer age"};
//        javaCodeParam.setModule("act");
//        javaCodeParam.setEntityName("activity");
//        javaCodeParam.setFields(Arrays.asList(fields));

        if(javaCodeParam.getDate() == null) {
            javaCodeParam.setDate(DateUtil.getDate("yyyy/MM/dd"));
        }
        return javaCodeService.genJavaCode(javaCodeParam, modelMap);
    }
}
