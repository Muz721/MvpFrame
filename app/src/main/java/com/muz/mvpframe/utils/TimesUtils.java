package com.muz.mvpframe.utils;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by hankehui on 2017/12/25.
 * 获取指定日期
 */

public class TimesUtils {
    /**
     * 默认格式
     */
    public static final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd hh:mm:ss";
    /**
     * 年月日    默认格式
     */
    public static final String TIME_DEFAULT_YTD_FORMAT = "yyyy-MM-dd";
    /**
     * 年月日    没有横线格式
     */
    public static final String TIME_NO_LINE_YTD_FORMAT = "yyyyMMdd";
    /**
     * 年月日    中文年月日格式
     */
    public static final String TIME_CHINESE_YTD_FORMAT = "yyyy年MM月dd日";
    /**
     * 年月日    斜杠格式
     */
    public static final String TIME_SLASH_YTD_FORMAT = "yyyy/MM/dd";
    /**
     * 年月日    冒号格式
     */
    public static final String TIME_COLON_YTD_FORMAT = "yyyy:MM:dd";
    /**
     * 年月    默认格式
     */
    public static final String TIME_DEFAULT_YM_FORMAT = "yyyy-MM";
    /**
     * 月日    中文年月日格式
     */
    public static final String TIME_CHINESE_MD_FORMAT = "MM月dd日";
    /**
     * 月日     横线月日格式
     */
    public static final String TIME_LINE_MD_FORMAT = "MM-dd";
    /**
     * 时分     横线时分格式
     */
    public static final String TIME_COLON_HS_FORMAT = "hh:mm";
    /**
     * 月     横线时分格式
     */
    public static final String TIME_ONLY_CHINESE_M_FORMAT = "MM月";

    /**
     * 获取最近日期       默认
     *
     * @param i 偏离当前日期天数      -1:昨天   0:今天      1:明天
     * @return 返回日期
     */
    public static String getRecentTime(int i) {
        return getRecentTime(i, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 获取最近日期
     *
     * @param i 偏离当前日期天数      -1:昨天   0:今天      1:明天
     * @return 返回日期
     */
    public static String getRecentTime(int i, String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String dateString = "";
        try {
            calendar.add(calendar.DATE, i);//把日期往后增加一天.整数往后推,负数往前移动
            date = calendar.getTime(); //这个时间就是日期往后推一天的结果
            dateString = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }

    /************************本年第一天*********************************************************************************
     /**
     * 本年第一天  默认
     * @return 返回时间
     */
    public static String getYearFirstDay() {
        return getYearFirstDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * * 本年第一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getYearFirstDay(String format) {
//        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.DAY_OF_YEAR, 1);
        return getDate(format, Calendar.DAY_OF_YEAR, 1);
    }

    /**
     * 本年第一天     默认
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getYearFirstDay(TextView view) {
        getYearFirstDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本年第一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getYearFirstDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_YEAR, 1));
    }

    /************************本年最后一天*********************************************************************************
     /**
     * 本年最后一天
     * @return 返回时间
     */
    public static String getYearLastDay() {
        return getYearLastDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本年最后一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getYearLastDay(String format) {
        return getDate(format, Calendar.DAY_OF_YEAR, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR));
    }

    /**
     * 本年最后一天
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getYearLastDay(TextView view) {
        getYearLastDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本年最后一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getYearLastDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_YEAR, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR)));
    }

    /************************本月第一天*********************************************************************************
     /**
     * 本月第一天  默认
     * @return 返回时间
     */
    public static String getMonthFirstDay() {
        return getMonthFirstDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * * 本月第一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getMonthFirstDay(String format) {
        return getDate(format, Calendar.DAY_OF_MONTH, 1);
    }

    /**
     * 本月第一天     默认
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getMonthFirstDay(TextView view) {
        getMonthFirstDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本月第一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getMonthFirstDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_MONTH, 1));
    }

    /************************本月最后一天*********************************************************************************
     /**
     * 获取本月
     *
     * @return 本月时间
     */
    public static String getMonth() {
        return getToday(TIME_DEFAULT_YM_FORMAT);
    }
     /**
     * 本月最后一天
     * @return 返回时间
     */
    public static String getMonthLastDay() {
        return getMonthLastDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本月最后一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getMonthLastDay(String format) {
        return getDate(format, Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    /**
     * 本月最后一天
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getMonthLastDay(TextView view) {
        getMonthLastDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本月最后一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getMonthLastDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)));
    }

    /************************本周第一天*********************************************************************************
     /**
     * 本周第一天  默认
     * @return 返回时间
     */
    public static String getWeekFirstDay() {
        return getMonthFirstDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * * 本周第一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getWeekFirstDay(String format) {
        return getDate(format, Calendar.DAY_OF_WEEK, 1);
    }

    /**
     * 本周第一天     默认
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getWeekFirstDay(TextView view) {
        getMonthFirstDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本周第一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getWeekFirstDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_WEEK, 1));
    }

    /************************本周最后一天*********************************************************************************
     /**
     * 本周最后一天
     * @return 返回时间
     */
    public static String getWeekLastDay() {
        return getMonthLastDay(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本周最后一天
     *
     * @param format 格式
     * @return 返回时间
     */
    public static String getWeekLastDay(String format) {
        return getDate(format, Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK));
    }

    /**
     * 本周最后一天
     *
     * @param view 需要显示的控件（Button,TextView）
     */
    public static void getWeekLastDay(TextView view) {
        getMonthLastDay(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 本周最后一天
     *
     * @param view   需要显示的控件（Button,TextView）
     * @param format 格式
     */
    public static void getWeekLastDay(TextView view, String format) {
        view.setText(getDate(format, Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK)));
    }

    /************************当天*********************************************************************************
     * 获取当天        默认
     * @return 当天时间
     */
    public static String getToday() {
        return getToday(TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 获取当前时间
     *
     * @param format 格式
     * @return 当天时间
     */
    public static String getToday(String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        return dateFormater.format(cal.getTime());
    }

    /**
     * 获取当天
     *
     * @return 当天时间
     */
    public static void getToday(TextView view) {
        getToday(view, TIME_DEFAULT_YTD_FORMAT);
    }

    /**
     * 获取当前时间
     *
     * @param view   控件
     * @param format 格式
     */
    public static void getToday(TextView view, String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        view.setText(dateFormater.format(cal.getTime()));
    }

    /**
     * 获取指定日期
     *
     * @param format   格式
     * @param calendar 日历
     * @param day      第几天
     * @return 返回日期
     */
    public static String getDate(String format, int calendar, int day) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.set(calendar, day);
        return dateFormater.format(cal.getTime());
    }

    /**
     * 获取指定日期
     *
     * @param view     控件
     * @param format   格式
     * @param calendar 日历
     * @param day      第几天
     * @return 返回日期
     */
    public static void getDate(TextView view, String format, int calendar, int day) {
        view.setText(getDate(format, calendar, day));
    }
/***********************************时间格式转换*********************************************************************/
    /**
     * 时间转换  输入date 输出String
     *
     * @param date 日期
     * @return 返回日期
     */
    public static String timeFormatAlter(Date date, String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
        return dateFormater.format(date);
        // SimpleDateFormat formatter = new SimpleDateFormat(TimesUtils.TIME_DEFAULT_YTD_FORMAT);
        // time= formatter.format(data.getYearmonthday());
    }

    /**
     * 时间转换  输入date 输出String
     *
     * @param time 日期
     * @return 返回日期
     */
    public static String timeFormatAlter(String time, String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        Date date = new Date(time);
        cal.setTime(date);
        return dateFormater.format(date);
    }
    /**
     * 时间转换  输入String 输出Calendar
     *
     * @param time 日期
     * @return 返回日期
     */
    public static Calendar timeFormatAlter(String time) {
//    SimpleDateFormat dateFormater = new SimpleDateFormat(TIME_DEFAULT_YTD_FORMAT);
        SimpleDateFormat fmt = new SimpleDateFormat(TIME_DEFAULT_YTD_FORMAT);
        Calendar cal = Calendar.getInstance();

        try {
            Date date = fmt.parse(time);

            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cal;
    }
    public static Calendar timeFormatAlters(String time,String dateType) {
//    SimpleDateFormat dateFormater = new SimpleDateFormat(TIME_DEFAULT_YTD_FORMAT);
        SimpleDateFormat fmt = new SimpleDateFormat(dateType);
        Calendar cal = Calendar.getInstance();

        try {
            Date date = fmt.parse(time);

            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cal;
    }
/**********************************时间戳**************************************************************/
    /**
     * 调用此方法输入所要转换的时间戳输入
     *
     * @param time 时间戳
     * @return
     */
    public static String timestampShiftTime(long time, String format) {
        SimpleDateFormat sdr = new SimpleDateFormat(format);
//        @SuppressWarnings("unused")
//        long lcc = Long.valueOf(time);
//        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(time * 1000L));
        return times;

    }


    /**
     * 显示当前时间
     *
     * @param textView 要显示时间的控件
     */
    public static void setTime(Context context, final TextView textView) {


        final Calendar mCalendar = Calendar.getInstance();
        int mHour = mCalendar.get(Calendar.HOUR);
        int mMinuts = mCalendar.get(Calendar.MINUTE);

        String tvTime = (String) textView.getText();
        int hour;
        int minuts;
        if (TextUtils.isEmpty(tvTime)) {
            hour = mCalendar.get(Calendar.HOUR);
            minuts = mCalendar.get(Calendar.MINUTE);
        } else {
            String[] split = tvTime.split(":");
            hour = Integer.parseInt(split[0]);
            minuts = Integer.parseInt(split[split.length - 1]);
        }

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendar.set(hourOfDay, minute);//获取时间
                textView.setText(DateFormat.format("hh:ss", mCalendar));//显示时间
            }
        }, hour, minuts, true);
        timePickerDialog.show();

    }

    public static String getTime(Date date,String formats) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat(formats);
        return format.format(date);
    }

    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat(TIME_DEFAULT_YTD_FORMAT);
        return format.format(date);
    }
}
