<#assign param=javaCodeParam/>
<#assign uEntityName=StringUtil.upperFirst(param.entityName)/>
package com.cifm.one.${param.module}.api;

import com.cifm.one.${param.module}.entity.*;
import com.cifm.one.common.dao.*;
import com.cifm.one.common.model.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ${param.explain!"这里是说明"}
 *
 * @author ${param.author!"潘朝辉"}
 * @version ${param.version!"1.0"}
 * @since ${param.date!"2017/02/09"}
 */
@Service
public interface ${uEntityName}Api extends BaseService<${uEntityName}, String> {

    ResultOb<${uEntityName}> getPageResultOb(String con, Map<Integer, Object> paras, Pageable pageable);

}