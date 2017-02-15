<#assign param=javaCodeParam/>
<#assign ae=StringUtil.upperFirst(StringUtil.pop(apiEntry, "API"))/>
package com.cifm.one.hs.entity.account;

<#list param.imports as imp>
import com.hundsun.fund.fund.model.${imp}.*;
</#list>

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
public class Hs${ae} extends ${ae}Result {

}