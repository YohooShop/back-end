package com.yoooho.mall.common.utils;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    /**
     * 获取精确到秒的时间戳
     * @return
     **/
    public static int getSecondTimestampTwo(){
        String timestamp = String.valueOf(new Date().getTime()/1000);
        return Integer.valueOf(timestamp);
    }


    /**
     * 获取精确到秒的时间戳
     * @return
     **/
    public static int dateToTimestamp(Date date){
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 时间延期（小时）
     * @return
     **/
    public static Date dateAddHour(Date date , Integer hour){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.HOUR,hour); //把日期往后增加小时,整数  往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }



}
