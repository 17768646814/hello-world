package com.pch.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public class HttpUtil {
    public static String getFormData(HttpServletRequest req) {
        String[] val;
        Map<String, String> map = new HashMap<>();
        Set<String> fieldSet = new HashSet<>();
        fieldSet.add("password");
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            val = entry.getValue();
            if (fieldSet.contains(entry.getKey())) {
                map.put(entry.getKey(), "******");
            } else {
                map.put(entry.getKey(), StringUtil.join(entry.getValue()));
            }
        }
        return map.toString();
    }

    public static Map<String, String> getParameterMap(HttpServletRequest req) {
        Map<String, String> map = new HashMap<>();
        Set<String> fieldSet = new HashSet<>();
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            map.put(entry.getKey(), StringUtil.join(entry.getValue()));
        }
        return map;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
