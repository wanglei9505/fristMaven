package com.wl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by WL on 2017/12/11.
 */
public class DateUtils {
    /**
     *获取日期属于周几
     * @param time(格式：yyyy-MM-dd)
     * @return
     * @throws Exception
     */
    private static String getWeekOfDate(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String week="";
        try{
            Date date=sdf.parse(time);
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            week= weekDays[w];
        }catch(Exception e){
            e.printStackTrace();
        }
        return week;
    }
    private static int getWeekOfDate1(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int week = 0;
        try{
            Date date=sdf.parse(time);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            week = cal.get(Calendar.DAY_OF_WEEK)-1;
            if (week < 0)
                week = 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return week;
    }

    public static void main(String[] args) {
        System.out.println(getWeekOfDate("2017-12-09"));
        System.out.println(getWeekOfDate1("2017-12-10"));
    }
}
