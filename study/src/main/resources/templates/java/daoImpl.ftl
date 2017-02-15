<#assign param=javaCodeParam/>
<#assign uEntityName=StringUtil.upperFirst(param.entityName)/>
<#assign lEntityName=StringUtil.lowerFirst(param.entityName)/>
package com.cifm.one.${param.module}.dao;

import com.cifm.one.act.entity.*;
import com.cifm.one.common.dao.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
public class ${uEntityName}DaoImpl extends BaseDaoImpl<${uEntityName}, String> implements ${uEntityName}DaoCustom {

    protected Class<${uEntityName}> getEntityClass() {
        return ${uEntityName}.class;
    }

    @Transactional
    public boolean del(String id) {
        ${uEntityName} data = super.baseFind(id);
        if (data != null) {
            data.setStat(0);
            return true;
        } else {
            return false;
        }
    }

}