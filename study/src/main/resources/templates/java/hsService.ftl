<#assign param=javaCodeParam/>
<#assign uModule=StringUtil.upperFirst(param.module)/>
<#assign lModule=StringUtil.lowerFirst(param.module)/>
<#assign uSection=StringUtil.lowerFirst(param.section)/>
package com.cifm.one.${param.module}.service;

import com.cifm.one.common.model.*;
import com.cifm.one.common.utils.*;
import com.cifm.one.hs.api.*;
<#list param.imports as imp>
import com.hundsun.fund.fund.model.${imp}.*;
import com.cifm.one.hs.entity.${imp}.*;
</#list>
import com.cifm.one.hs.utils.*;
import com.hundsun.fund.fund.model.${param.module}.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
@Service
public interface ${uModule}${uSection}Service {

    @Autowired
    private ${uModule}${uSection}Api ${lModule}${uSection}Api;

<#list param.apiEntries as apiEntry>
    <#assign ae=StringUtil.pop(apiEntry, "API")/>
    <#assign uAe=StringUtil.upperFirst(ae)/>
    <#assign lAe=StringUtil.lowerFirst(ae)/>
    /**
    * 方法说明
    *
    * @param param1 参数1说明
    * @param param2 参数2说明
    * @return ResultOb
    */
    @Override
    public ResultOb<Hs${uAe}> ${lAe}(String param1, String param2) {
        ${uAe}Param param = new ${uAe}Param();
        ${uAe}Result result = ${lModule}${uSection}Api.${lAe}(param);
        Hs${uAe} ${lAe} = new Hs${uAe};
        Tools.copyProperties(${lAe}, result);
        ResultOb<Hs${uAe}> resultOb = new ResultOb<>();
        resultOb.setData(${lAe});
        HsApiTools.setCode(result, resultOb);
        return resultOb;
    }

</#list>
}