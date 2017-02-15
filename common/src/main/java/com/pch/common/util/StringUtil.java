package com.pch.common.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public class StringUtil {

    public static String SEPARATOR = File.separator;
    public static String RN = "\r\n";
    public static String RN2 = RN + RN;

    public static String substring(final String str, int start) {
        if (str == null) {
            return null;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return "";
        }

        return str.substring(start);
    }

    public static String join(String[] array) {
        StringBuilder sb = new StringBuilder();
        if (array != null) {
            for (String s : array) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static String[] splitBlank(String name) {
        return split(name, "\\s+");
    }

    public static String[] split(String name, String regex) {
        return name.split(regex);
    }

    /**
     * 去掉尾巴
     *
     * @param src
     * @param tail
     * @return
     */
    public static String pop(String src, String tail) {
        Matcher ma = Pattern.compile("(.+)" + tail + "\\b").matcher(src);
        while (ma.find()) {
            return ma.group(1);
        }
        return src;
    }

    public static String upperFirst(String name) {
        return name.length() >= 1 ? name.substring(0, 1).toUpperCase() + name.substring(1) : name;
    }

    public static String upper(String name) {
        return name.toUpperCase();
    }

    public static String lowerFirst(String name) {
        return name.length() >= 1 ? name.substring(0, 1).toLowerCase() + name.substring(1) : name;
    }

    public static String lower(String name) {
        return name.toLowerCase();
    }

    public static String appendSeparatorFirst(String name) {
        return SEPARATOR + name;
    }

    public static String appendSeparatorEnd(String name) {
        return name + SEPARATOR;
    }

    public static String appendSeparatorAll(String name) {
        return SEPARATOR + name + SEPARATOR;
    }

    public static String appendEnterFirst(String name) {
        return RN + name;
    }

    public static String appendEnterEnd(String name) {
        return name + RN;
    }

    public static String appendEnterAll(String name) {
        return RN + name + RN;
    }

    public static String append2EnterFirst(String name) {
        return RN2 + name;
    }

    public static String append2EnterEnd(String name) {
        return name + RN2;
    }

    public static String append2EnterAll(String name) {
        return RN2 + name + RN2;
    }
}
