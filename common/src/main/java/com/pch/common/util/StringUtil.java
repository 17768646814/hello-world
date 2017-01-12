package com.pch.common.util;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/12
 */
public class StringUtil {

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

}
