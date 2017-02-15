<#assign param=javaCodeParam/>
<#assign uEntityName=StringUtil.upperFirst(param.entityName)/>
<#assign lEntityName=StringUtil.lowerFirst(param.entityName)/>
package com.cifm.one.${param.module}.service;

import com.cifm.one.${param.module}.api.*;
import com.cifm.one.${param.module}.dao.*;
import com.cifm.one.${param.module}.entity.*;
import com.cifm.one.common.model.*;
import com.cifm.one.common.utils.*;
import com.cifm.one.common.web.QueryField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ${uEntityName}Service {

    @Autowired
    private ${uEntityName}Api ${lEntityName}Api;

    private ResultOb<${uEntityName}> getPageResultOb(String con, Map<Integer, Object> paras, Pageable pageable) {
        return ${lEntityName}Api.getPageResultOb(con, paras, pageable);
    }

    public ResultOb<${uEntityName}> save(${uEntityName} ${lEntityName}) {
        if (StringUtils.isBlank(${lEntityName}.getId())) {
            Tools.saveBase(${lEntityName});
        } else {
            ${uEntityName} db = ${lEntityName}Api.findOne(${lEntityName}.getId());
            EntityTools<${uEntityName}> entityTools = new EntityTools<>();
            entityTools.setDbVal(${lEntityName}, db);
        }
        ${lEntityName}.setBdate(Tools.getDate(${lEntityName}.getBdate()));
        ${lEntityName}.setEdate(Tools.getDate(${lEntityName}.getEdate()));
        ResultOb<${uEntityName}> resultOb = new ResultOb<>();
        resultOb.setData(${lEntityName}Api.save(${lEntityName}));
        Tools.setSuccessMessage(resultOb, "ok");
        return resultOb;
    }

    public boolean del(String id) {
        return ${lEntityName}Api.del(id);
    }

    public ResultOb<${uEntityName}> list(QueryModel queryModel, String name, String abdate, String aedate, String stat) {
        QueryField queryField = new QueryField();
        if (StringUtils.isNotBlank(stat)) {
            queryField.setFieldOb("stat", Integer.valueOf(stat));
        } else {
            queryField.setFieldOb("stat", 1);
        }
        if (StringUtils.isNotBlank(name)) {
            queryField.setLikeField("name", name);
        }
        queryField.setBEDate10("cdate", queryModel.getBdate(), queryModel.getEdate());
        queryField.setBEDate10("bdate", abdate, aedate);
        ResultOb<${uEntityName}> resultOb = this.getPageResultOb(queryField.sql, queryField.paras, QueryField.getPageable(queryModel));
        Tools.setSuccessMessage(resultOb, "ok");
        return resultOb;
    }

}