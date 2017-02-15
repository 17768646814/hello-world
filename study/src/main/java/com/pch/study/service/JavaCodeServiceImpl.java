package com.pch.study.service;

import com.pch.common.po.Result;
import com.pch.common.util.ResultUtil;
import com.pch.common.util.StringUtil;
import com.pch.study.po.JavaCodeParam;
import com.pch.study.po.JavaCodeResult;
import freemarker.cache.MruCacheStorage;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/2/9
 */
@Service
public class JavaCodeServiceImpl implements JavaCodeService {

    private Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    @Autowired
    public void setConfiguration(Configuration configuration) {
        System.out.println("JavaCodeServiceImpl.setConfiguration");
        this.configuration = configuration;
        configuration.setCacheStorage(new MruCacheStorage(0, 0));
    }

    public Result<JavaCodeParam> genJavaCode(JavaCodeParam javaCodeParam, ModelMap modelMap) {
        JavaCodeResult javaCodeResult = new JavaCodeResult();
        Result result = ResultUtil.getResult(javaCodeResult);
        Class<StringUtil> stringUtilClass = StringUtil.class;
        modelMap.put(stringUtilClass.getSimpleName(), getTemplateModel(stringUtilClass));
        modelMap.put("javaCodeParam", javaCodeParam);
//        EntityUtil.modelToMapWhenMapNull(javaCodeParam, modelMap);
        javaCodeResult.setApi(genApiJavaCode(modelMap).getContent());
        javaCodeResult.setEntity(genEntityJavaCode(modelMap).getContent());
        javaCodeResult.setDao(genDaoJavaCode(modelMap).getContent());
        javaCodeResult.setImp(genImpJavaCode(modelMap).getContent());
        javaCodeResult.setService(genServiceJavaCode(modelMap).getContent());
        /*try {
            System.out.println(new ObjectMapper().writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        return result;
    }

    public Result<String> genApiJavaCode(Map map) {
        List<String> api = new ArrayList<String>();
        try {
            String res = FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "api"), map);
            api.add(res);
        } catch (Exception e) {
            System.out.println("no api");
            e.printStackTrace();
        }
        return ResultUtil.getResult(api);
    }

    public Result<String> genEntityJavaCode(Map map) {
        List<String> entity = new ArrayList<String>();
        try {
            JavaCodeParam javaCodeParam = (JavaCodeParam) map.get("javaCodeParam");
            if(isHsJavaCode(javaCodeParam)){
                Template template = getTemplate(map, "entity");
                for (String apiEntry : javaCodeParam.getApiEntries()) {
                    map.put("apiEntry", apiEntry);
                    String res = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
                    entity.add(res);
                }
            }else {
                entity.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "entity"), map));
            }
        } catch (Exception e) {
            System.out.println("no entity");
            e.printStackTrace();
        }
        return ResultUtil.getResult(entity);
    }

    private Result<String> genDaoJavaCode(Map map) {
        List<String> dao = new ArrayList<String>();
        try {
            dao.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "dao"), map));

            JavaCodeParam javaCodeParam = (JavaCodeParam) map.get("javaCodeParam");
            if(!isHsJavaCode(javaCodeParam)) {
                dao.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "daoCustom"), map));
                dao.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "daoImpl"), map));
            }
        } catch (Exception e) {
            System.out.println("no dao");
        }
        return ResultUtil.getResult(dao);
    }

    public Result<String> genImpJavaCode(Map map) {
        List<String> imp = new ArrayList<String>();
        try {
            imp.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "imp"), map));
        } catch (Exception e) {
            System.out.println("no imp");
            e.printStackTrace();
        }
        return ResultUtil.getResult(imp);
    }

    public Result<String> genServiceJavaCode(Map map) {
        List<String> service = new ArrayList<String>();
        try {
            service.add(FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(map, "service"), map));
        } catch (Exception e) {
            System.out.println("no service");
        }
        return ResultUtil.getResult(service);
    }

    private Object getTemplateModel(Class clazz) {
        TemplateHashModel staticModels = new BeansWrapperBuilder(Configuration.VERSION_2_3_25).build()
                .getStaticModels();
        TemplateModel templateModel = null;
        try {
            templateModel = staticModels.get(clazz.getName());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
        return templateModel;
    }

    private Template getTemplate(Map map, String type) {
        String templatePath = "java/%s.ftl";
        JavaCodeParam javaCodeParam = (JavaCodeParam) map.get("javaCodeParam");
        if (isHsJavaCode(javaCodeParam)) {
            templatePath = String.format(templatePath, javaCodeParam.getModule() + StringUtil.upperFirst(type));
        } else {
            templatePath = String.format(templatePath, type);
        }
        Template template = null;
        try {
            template = configuration.getTemplate(templatePath);
        } catch (IOException e) {
            System.out.println("no template");
        }
        return template;
    }

    private boolean isHsJavaCode(JavaCodeParam javaCodeParam) {
        List<String> apiEntries = javaCodeParam.getApiEntries();
        return apiEntries != null && !apiEntries.isEmpty();
    }
}
