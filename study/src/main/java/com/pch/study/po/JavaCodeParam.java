package com.pch.study.po;

import java.util.List;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/2/9
 */
public class JavaCodeParam {

    private String explain;
    private String author;
    private String version;
    private String date;

    private String entityName;
    private List<String> fields;

    private String module;
    private String section;
    private List<String> imports;
    private List<String> apiEntries;

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public List<String> getApiEntries() {
        return apiEntries;
    }

    public void setApiEntries(List<String> apiEntries) {
        this.apiEntries = apiEntries;
    }
}
