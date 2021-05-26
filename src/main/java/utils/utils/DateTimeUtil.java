/**
 * Project: alscadkbbp-service
 * 
 * File Created at Sep 2, 2020
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package utils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Title: DateTimeUtil.java
 * @Description: 通用容器操作类，借用
 * @author xiaochao.wuxc 借用
 * @date 2016年11月8日 上午11:31:16
 * @version V1.0
 **/
public class DateTimeUtil {
    /**
     * 定义时间日期显示格式
     */
    public final static String DATE_FORMAT           = "yyyy-MM-dd";
    public final static String DATE_FORMAT_CN        = "yyyy年MM月dd日";
    public final static String TIME_FORMAT           = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_FORMAT_CN        = "yyyy年MM月dd日 HH:mm:ss";
    public final static String MONTH_FORMAT          = "yyyy-MM";
    public final static String DAY_FORMAT            = "yyyyMMdd";

    public final static String END_TIME_SUFFIX       = " 23:59:59";

    public final static String TIME_FORMAT_MILLI     = "yyyy-MM-dd HH:mm:ss.SSS";

    public final static String TIME_FORMAT_MILLI_All = "yyyy-MM-dd HH:mm:ss.SSSSSS";

    /**
     * 取得当前系统时间，返回java.util.Date类型
     *
     * @see Date
     * @return java.util.Date 返回服务器当前系统时间
     */
    public static Date getCurrDate() {
        return new Date();
    }

    /**
     * 取得当前系统时间戳
     *
     * @see java.sql.Timestamp
     * @return java.sql.Timestamp 系统时间戳
     */
    public static java.sql.Timestamp getCurrTimestamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2016-11-04
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2016-11-04
     */
    public static String getFormatDate(Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2016-11-04
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(Date)
     * @return Date 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2016-11-04
     */
    public static Date getFormatDateToDate(Date currDate) {
        return getFormatDate(getFormatDate(currDate));
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2016年11月04日
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2016年11月04日
     */
    public static String getFormatDate_CN(Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2016年11月04日
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate_CN(String)
     * @return Date 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2016年11月04日
     */
    public static Date getFormatDateToDate_CN(Date currDate) {
        return getFormatDate_CN(getFormatDate_CN(currDate));
    }

    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2016-11-04
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(String, String)
     * @return Date 返回格式化后的日期，默认格式为yyyy-MM-dd，如2016-11-04
     */
    public static Date getFormatDate(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2016年11月04日
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(String, String)
     * @return 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2016年11月04日
     */
    public static Date getFormatDate_CN(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    /**
     * 根据格式得到格式化后的日期
     *
     * @param currDate 要格式化的日期
     * @param format 日期格式，如yyyy-MM-dd
     * @see SimpleDateFormat#format(Date)
     * @return String 返回格式化后的日期，格式由参数<code>format</code>
     *         定义，如yyyy-MM-dd，如2016-11-04
     */
    public static String getFormatDate(Date currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            return dtFormatdB.format(currDate);
        }
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     *
     * @param currDate 要格式化的时间
     * @see #getFormatDateTime(Date, String)
     * @return String 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     */
    public static String getFormatDateTime(Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     *
     * @param currDate 要格式环的时间
     * @see #getFormatDateTime(String)
     * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     */
    public static Date getFormatDateTimeToTime(Date currDate) {
        return getFormatDateTime(getFormatDateTime(currDate));
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     *
     * @param currDate 要格式化的时间
     * @see #getFormatDateTime(String, String)
     * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     */
    public static Date getFormatDateTime(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @see #getFormatDateTime(Date, String)
     * @return String 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     */
    public static String getFormatDateTime_CN(Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @see #getFormatDateTime_CN(String)
     * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     */
    public static Date getFormatDateTimeToTime_CN(Date currDate) {
        return getFormatDateTime_CN(getFormatDateTime_CN(currDate));
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @see #getFormatDateTime(String, String)
     * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     */
    public static Date getFormatDateTime_CN(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    /**
     * 根据格式得到格式化后的时间
     *
     * @param currDate 要格式化的时间
     * @param format 时间格式，如yyyy-MM-dd HH:mm:ss
     * @see SimpleDateFormat#format(Date)
     * @return String 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd HH:mm:ss
     */
    public static String getFormatDateTime(Date currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            return dtFormatdB.format(currDate);
        }
    }

    /**
     * 根据格式得到格式化后的日期
     *
     * @param currDate 要格式化的日期
     * @param format 日期格式，如yyyy-MM-dd
     * @see SimpleDateFormat#parse(String)
     * @return Date 返回格式化后的日期，格式由参数<code>format</code>定义，如yyyy-MM-dd，如2016-11-04
     */
    public static Date getFormatDate(String currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 根据格式得到格式化后的时间
     *
     * @param currDate 要格式化的时间
     * @param format 时间格式，如yyyy-MM-dd HH:mm:ss
     * @see SimpleDateFormat#parse(String)
     * @return Date 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd HH:mm:ss
     */
    public static Date getFormatDateTime(String currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 得到格式化后的当前系统日期，格式为yyyy-MM-dd，如2016-11-04
     *
     * @see #getFormatDate(Date)
     * @return String 返回格式化后的当前服务器系统日期，格式为yyyy-MM-dd，如2016-11-04
     */
    public static String getCurrDateStr() {
        return getFormatDate(getCurrDate());
    }

    /**
     * 得到格式化后的当前系统时间，格式为yyyy-MM-dd HH:mm:ss，如2016-11-04 15:23:45
     *
     * @see #getFormatDateTime(Date)
     * @return String 返回格式化后的当前服务器系统时间，格式为yyyy-MM-dd HH:mm:ss，如2016-11-04
     *         15:23:45
     */
    public static String getCurrDateTimeStr() {
        return getFormatDateTime(getCurrDate());
    }

    /**
     * 得到格式化后的当前系统日期，格式为yyyy年MM月dd日，如2016年11月04日
     *
     * @see #getFormatDate(Date, String)
     * @return String 返回当前服务器系统日期，格式为yyyy年MM月dd日，如2016年11月04日
     */
    public static String getCurrDateStr_CN() {
        return getFormatDate(getCurrDate(), DATE_FORMAT_CN);
    }

    /**
     * 得到格式化后的当前系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日 15:23:45
     *
     * @see #getFormatDateTime(Date, String)
     * @return String 返回格式化后的当前服务器系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2016年11月04日
     *         15:23:45
     */
    public static String getCurrDateTimeStr_CN() {
        return getFormatDateTime(getCurrDate(), TIME_FORMAT_CN);
    }

    /**
     * 得到系统当前日期的前或者后几天
     *
     * @param iDate 如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回系统当前日期的前或者后几天
     */
    public static Date getDateBeforeOrAfter(int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }

    /**
     * 得到日期的前或者后几天
     *
     * @param iDate 如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
     */
    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }

    /**
     * 得到格式化后的月份，格式为yyyy-MM，如2016-11
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的月份，格式为yyyy-MM，如2016-11
     */
    public static String getFormatMonth(Date currDate) {
        return getFormatDate(currDate, MONTH_FORMAT);
    }

    /**
     * 得到格式化后的日，格式为yyyyMMdd，如20060210
     *
     * @param currDate 要格式化的日期
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的日，格式为yyyyMMdd，如20060210
     */
    public static String getFormatDay(Date currDate) {
        return getFormatDate(currDate, DAY_FORMAT);
    }

    /**
     * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2016-11-01
     *
     * @param currDate 要格式化的日期
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2016-11-01
     */
    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2016-11-01
     *
     * @param currDate 要格式化的日期
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2016-11-01
     */
    public static String getFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到日期的前或者后几小时
     *
     * @param iHour 如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
     */
    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    /**
     * 得到日期的前或者后若干分钟
     *
     * @param iHour 如果要获得前若干分钟日期，该参数为负数； 如果要获得后若干分钟日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后若干分钟
     */
    public static Date getDateBeforeOrAfterMinutes(Date curDate, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * @Title: getTimeIntervalDays @Description: 两个时间的天数差 <ul> <li>@param
     * firstDate <li>@param lastDate <li>@return 参数描述</li> </ul> @param @param
     * firstDate @param @param lastDate @param @return 设定文件 @return int
     * 返回类型 @throws
     */
    public static int getTimeIntervalDays(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long daysd = intervals / (24 * 60 * 60 * 1000);

            return new Long(daysd).intValue();
        }

        return 0;
    }

    /**
     * @Title: getSysDate @Description: 获得sysdate+hours后的时间 <ul> <li>@param
     * hours <li>@return 参数描述</li> </ul> @param @param hours @param @return
     * 设定文件 @return Date 返回类型 @throws
     */
    public static Date getSysDate(int hours) {
        Calendar time = Calendar.getInstance();

        time.add(Calendar.HOUR, hours);

        return time.getTime();
    }

    /**
     * @Title: getTimeIntervalHours @Description: 两个时间的小时差 <ul> <li>@param
     * firstDate <li>@param lastDate <li>@return 参数描述</li> </ul> @param @param
     * firstDate @param @param lastDate @param @return 设定文件 @return int
     * 返回类型 @throws
     */
    public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long longHours = (intervals / (60 * 60 * 1000)) % 24;

            return new Long(longHours).intValue();
        }

        return 0;
    }

    /**
     * @Title: getTimeIntervalMins @Description: 两个时间的分钟差 <ul> <li>@param
     * firstDate <li>@param lastDate <li>@return 参数描述</li> </ul> @param @param
     * firstDate @param @param lastDate @param @return 设定文件 @return int
     * 返回类型 @throws
     */
    public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);

        if (intervals > 0) {
            long longMins = (intervals / (60 * 1000)) % 60;

            return new Long(longMins).intValue();
        }

        return 0;
    }

    /**
     * @Title: getSecondsBetweenDates @Description: 获取两个时间的相差秒 @param @param
     * d1 @param @param d2 @param @return 设定文件 <ul> <li>@param d1 <li>@param d2
     * <li>@return 参数描述</li> </ul> @return long 返回类型 @throws
     */
    public static long getSecondsBetweenDates(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("param should not be null");
        }
        long diff = d1.getTime() - d2.getTime();
        return Math.abs(TimeUnit.MILLISECONDS.toSeconds(diff));
    }

    /**
     * @Title: getYestodayStr @Description: 获取昨天的时间 <ul> <li>@return 参数描述</li>
     * </ul> @param @return 设定文件 @return String 返回类型 @throws
     */
    public static String getYestodayStr() {
        Date today = new Date();
        Calendar createDay = Calendar.getInstance();

        createDay.setTime(today);
        createDay.add(Calendar.DATE, -1);

        return getFormatDate(createDay.getTime(), DATE_FORMAT);
    }

    public static void main(String[] args) throws ParseException {
        String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(TIME_FORMAT);
        System.out.println(sf.parse("2017-09-27 00:00:00").getTime());
        System.out.println(sf.parse("2017-09-27 23:59:59").getTime());
    }
}
