package com.hao.lr.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName TimeUtils
 * @Description  时间管理转换类
 * @Author Administrator
 * @Date 2020/6/2 16:13
 * @Version 1.0
 **/
public class TimeUtils {
//        public static void main(String[] args) throws ParseException {
//        String time = "2020-05-13T16:00:00.000Z";
//        System.out.println(StringToDate(time));
//
//    }
    public static Date StringToDate(String time) throws ParseException {
        System.out.println(time);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        date = format1.parse(time);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);
        Date d = new java.sql.Date(calendar.getTime().getTime());
        System.out.println(d);
        return d;
    }
}
