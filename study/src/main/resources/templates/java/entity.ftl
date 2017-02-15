<#assign param=javaCodeParam/>
<#assign u_module=StringUtil.upper(param.module)/>
<#assign uEntityName=StringUtil.upperFirst(param.entityName)/>
<#assign u_entityName=StringUtil.upper(param.entityName)/>
package com.cifm.one.${param.module}.entity;

import com.cifm.one.common.anno.*;
import com.cifm.one.common.dao.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
@Entity(name = "${u_module}_${u_entityName}")
//@Cache
public class ${uEntityName} extends BaseEntity {

<#if param.fields??>
<#list param.fields as fields>
    <#assign aFileds=StringUtil.splitBlank(fields)/>
    <#assign uType=StringUtil.upperFirst(aFileds[0])/>
    <#assign lField=StringUtil.lowerFirst(aFileds[1])/>
    private ${uType} ${lField};
</#list>
</#if>

<#if param.fields??>
<#list param.fields as fields>
    <#assign aFileds=StringUtil.splitBlank(fields)/>
    <#assign uType=StringUtil.upperFirst(aFileds[0])/>
    <#assign lField=StringUtil.lowerFirst(aFileds[1])/>
    <#assign uField=StringUtil.upperFirst(aFileds[1])/>
    @Column(length = 100, nullable = true)
    public ${uType} ${(uType == 'Boolean') ? string('is', 'get')}${uField}() {
        return ${lField};
    }

    public void set${uField}(${uType} ${lField}) {
        this.${lField} = ${lField};
    }

</#list>
</#if>
}
