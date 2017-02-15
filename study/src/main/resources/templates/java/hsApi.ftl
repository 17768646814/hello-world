<#assign param=javaCodeParam/>
package com.cifm.one.${param.module}.api;

<#list param.imports as imp>
import com.hundsun.fund.fund.model.${imp}.*;
</#list>
import org.springframework.stereotype.Service;

/**
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
@Service
public interface ${StringUtil.upperFirst(param.module)}${StringUtil.upperFirst(param.section)}Api {

<#list param.apiEntries as apiEntry>
    <#assign ae=StringUtil.pop(apiEntry, "API")/>
    ${StringUtil.upperFirst(ae)}Result ${StringUtil.lowerFirst(ae)}(${StringUtil.upperFirst(ae)}Param param);

</#list>
}