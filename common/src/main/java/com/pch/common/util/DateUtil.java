package com.pch.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
public class DateUtil {
    public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat HHmmss = new SimpleDateFormat("HHmmss");

    public static String getDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    public static String getDate8() {
        Date date = new Date();
        return yyyyMMdd.format(date);
    }

    public static String getTime6() {
        Date date = new Date();
        return HHmmss.format(date);
    }


    void test() {
        Date d = new Date();
        String s;
        /** getDateInstance() */
        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance().format(d);
        System.out.println(s);

        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
        System.out.println(s);

        /** 输出格式: 2006年4月16日 星期六 */
        s = DateFormat.getDateInstance(DateFormat.FULL).format(d);
        System.out.println(s);

        /** 输出格式: 2006-4-16 */
        s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        System.out.println(s);

        /** 输出格式: 06-4-16 */
        s = DateFormat.getDateInstance(DateFormat.SHORT).format(d);
        System.out.println(s);

        /** 输出格式: 2006-01-01 00:00:00 */
        java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        s = format1.format(new Date());
        System.out.println(s);

        /** 输出格式: 2006-01-01 01:00:00 */
        System.out.println((new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));

        /** 输出格式: 2006-01-01 13:00:00 */
        System.out.println((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));

        /** 输出格式: 20060101000000***/
        java.text.DateFormat format2 = new java.text.SimpleDateFormat("yyyyMMddhhmmss");
        s = format2.format(new Date());
        System.out.println(s);
    }
}
