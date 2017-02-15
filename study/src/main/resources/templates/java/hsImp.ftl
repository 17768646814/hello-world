<#assign param=javaCodeParam/>
<#assign uModule=StringUtil.upperFirst(param.module)/>
<#assign uSection=StringUtil.upperFirst(param.section)/>
package com.cifm.one.${param.module}.imp;

import com.cifm.one.hs.api.*;
import com.cifm.one.hs.conf.*;
<#list param.imports as imp>
import com.hundsun.fund.fund.model.${imp}.*;
</#list>
import org.springframework.stereotype.Service;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
@Service
public class ${uModule}${uSection}Imp implements ${uModule}${uSection}Api {

<#list param.apiEntries as apiEntry>
    <#assign ae=StringUtil.pop(apiEntry, "API")/>
    <#assign uAe=StringUtil.upperFirst(ae)/>
    <#assign lAe=StringUtil.lowerFirst(ae)/>
    /**
    * 说明
    *
    * @param param
    * @return
    */
    public ${uAe}Result ${lAe}(${uAe}Param param) {
        ${uAe}Result result = new ${uAe}Result();
        result = ApiUtils.setResult(result, param, "${lAe}API");
        return result;
    }

</#list>
}