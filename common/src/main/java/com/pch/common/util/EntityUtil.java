package com.pch.common.util;

import com.pch.common.po.BaseEntity;

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
}
