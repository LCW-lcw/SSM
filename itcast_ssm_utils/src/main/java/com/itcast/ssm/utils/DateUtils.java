package com.itcast.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//日期转换
public class DateUtils {
//    日期转换成字符串
    public static String data2String(Date date, String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format=sdf.format(date);
        return format;
    }
//    字符串转换日期
    public static Date string2Date(String str,String patt) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date date=sdf.parse(str);
        return date;

    }

}
