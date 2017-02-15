package com.pch.common.util;

import com.pch.common.po.BaseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public class EntityUtil {

    public static void saveBase(BaseEntity entity) {
        entity.setcDate(DateUtil.getDate8());
        entity.setcTime(DateUtil.getTime6());
    }

    public static <E> List<E> getSingleList(E e) {
        List<E> eList = new ArrayList<E>();
        eList.add(e);
        return eList;
    }

    public static <E> List<E> getSingleList(Class<E> clazz) {
        List<E> eList = new ArrayList<E>();
        try {
            E e = clazz.newInstance();
            eList.add(e);
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return eList;
    }

    public static Map<String, Object> modelToMapWhenMapNull(Object model, Map<String, Object> map) {
        Class<?> clazz = model.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            for (Method method : clazz.getDeclaredMethods()) {
                String mName = method.getName();
                if (mName.equals("is" + StringUtil.upperFirst(name)) || mName.equals("get" + StringUtil.upperFirst
                        (name))) {
                    try {
                        if(map.get(name) == null) {
                            map.put(name, method.invoke(model));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return map;
    }

    public static Map<String, Object> modelToMapWhenMapNull(Object model) {
        Map<String, Object> map = new HashMap<String, Object>();
        return modelToMapWhenMapNull(model, map);
    }
}
