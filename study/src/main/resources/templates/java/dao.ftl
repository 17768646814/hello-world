<#assign param=javaCodeParam/>
<#assign uEntityName=StringUtil.upperFirst(param.entityName)/>
<#assign lEntityName=StringUtil.lowerFirst(param.entityName)/>

package com.cifm.one.${param.module}.dao;

import com.cifm.one.act.entity.*;
import org.springframework.data.jpa.repository.*;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
public interface ${uEntityName}Dao extends ${uEntityName}DaoCustom, JpaRepository<${uEntityName}, String> {

}