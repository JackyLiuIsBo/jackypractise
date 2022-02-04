//package utils.utils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import com.aliyuncs.utils.StringUtils;
//import org.springframework.util.CollectionUtils;
//
//import static java.util.stream.Collectors.toList;
//
///**
// * @说明：
// */
//public class DateUtil {
//
//    private static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd/";
//
//    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//    public final static String TIME_YYYY_MM_DD = "yyyy-MM-dd";
//    //public final static String TIME_YYYY_MM_DD_END = "yyyy-MM-dd 23:59:59";
//
//    public final static String TIME_YYYMMDD = "yyyyMMdd";
//
//    public final static String TIME_YYYMMDD_HHMMSS = "yyyyMMddHHmmss";
//
//    public final static Integer HOUR_PER_DAY = 24;
//    public final static String END_TIME_SUFFIX = " 23:59:59";
//
//    public static Date getDefaultEndTime() {
//        return parseDate("2099-12-31 23:59:59", TIME_FORMAT);
//    }
//
//    public static String toLocaleDate(Long currentTime, String dateFormat) {
//        if (currentTime == null) {
//            return null;
//        }
//        Date date = new Date(currentTime);
//        SimpleDateFormat sd = new SimpleDateFormat(dateFormat == null ? TIME_YYYY_MM_DD : dateFormat);
//        return sd.format(date);
//    }
//
//    /**
//     * 把日期型转换成字符串形式。
//     * s
//     *
//     * @param date       日期
//     * @param dateFormat 日期格式，例如"yyyy/MM/dd"、"yyyy年MM月dd"
//     * @return 日期字符串
//     */
//    public static String toLocaleString(Date date, String dateFormat) {
//        if (date == null) {
//            return "";
//        }
//
//        if (StringUtils.isEmpty(dateFormat)) {
//            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
//        }
//
//        return new SimpleDateFormat(dateFormat).format(date);
//    }
//
//    /**
//     * 把日期型转换成"yyyy/MM/dd/"字符串形式。
//     *
//     * @param date
//     * @return 日期字符串
//     */
//    public static String toLocaleString(Date date) {
//        return toLocaleString(date, null);
//    }
//
//    /**
//     * 获得sysdate+hours后的时间
//     *
//     * @param hours 提前或者推后的时间
//     * @return sysdate+hours后的时间
//     */
//    public static Date getSysDate(int hours) {
//        Calendar time = Calendar.getInstance();
//
//        time.add(Calendar.HOUR, hours);
//
//        return time.getTime();
//    }
//
//    @SuppressWarnings("static-access")
//    public static Date addDay(Date date, int iday) {
//
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        // 把日期往后增加一天.整数往后推,负数往前移动
//        calendar.add(Calendar.DATE, iday);
//        return date = calendar.getTime();
//    }
//
//    /**
//     * 方法说明:天数差
//     *
//     * @param firstDate
//     * @param lastDate
//     */
//    public static int getTimeIntervalDays(Date firstDate, Date lastDate) {
//        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);
//
//        if (intervals > 0) {
//            long daysd = intervals / (24 * 60 * 60 * 1000);
//
//            return new Long(daysd).intValue();
//        }
//
//        return 0;
//    }
//
//    /**
//     * 方法说明:小时差
//     *
//     * @param firstDate
//     * @param lastDate
//     */
//    public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
//        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);
//
//        if (intervals > 0) {
//            long longHours = (intervals / (60 * 60 * 1000)) % 24;
//
//            return new Long(longHours).intValue();
//        }
//
//        return 0;
//    }
//
//    /**
//     * 方法说明:分钟差
//     *
//     * @param firstDate
//     * @param lastDate
//     */
//    public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
//        long intervals = lastDate.getTime() - firstDate.getTime() + (60 * 1000);
//
//        if (intervals > 0) {
//            long longMins = (intervals / (60 * 1000)) % 60;
//
//            return new Long(longMins).intValue();
//        }
//
//        return 0;
//    }
//
//    /**
//     * 方法说明:parse date
//     *
//     * @param date
//     * @param dateformat
//     */
//    public static Date parseDate(String date, String dateformat) {
//        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
//
//        try {
//            return sdf.parse(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//    /**
//     * 解析天
//     *
//     * @param date
//     * @param dateformat
//     * @return
//     */
//    public static Date parseLocalDate(String date, String dateformat) {
//        try {
//            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(dateformat));
//            return from(localDate);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static Date from(LocalDate localDate) {
//        ZoneId defaultZoneId = ZoneId.systemDefault();
//        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
//    }
//
//    /**
//     * 比较日期是否大于当前日期
//     */
//    public static boolean afterNow(Date date) {
//        if (date == null) {
//            return false;
//        }
//
//        Calendar nowCar = Calendar.getInstance();
//        Calendar car = Calendar.getInstance();
//
//        car.setTime(date);
//
//        return car.after(nowCar);
//    }
//
//    /**
//     * 比较日期是否大于当前日期
//     */
//    public static boolean beforeNow(Date date) {
//        if (date == null) {
//            return false;
//        }
//
//        Calendar nowCar = Calendar.getInstance();
//        Calendar car = Calendar.getInstance();
//
//        car.setTime(date);
//
//        return car.before(nowCar);
//    }
//
//    /*
//     * 查看是否早几天
//     */
//    public static boolean afterDays(Date date, int day) {
//        if (date == null) {
//            return false;
//        }
//
//        Calendar levelDay = Calendar.getInstance();
//        Calendar createDay = Calendar.getInstance();
//
//        createDay.setTime(date);
//        createDay.add(Calendar.DATE, day);
//
//        if (createDay.after(levelDay)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /*
//     * 查看是否早几小时
//     */
//    public static boolean afterHours(Date date, int hours) {
//        if (date == null) {
//            return false;
//        }
//
//        Calendar levelDay = Calendar.getInstance();
//        Calendar createDay = Calendar.getInstance();
//
//        createDay.setTime(date);
//        createDay.add(Calendar.HOUR, hours);
//
//        if (createDay.after(levelDay)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * 取得系统当前日期
//     */
//    public static Date getCurrentTime() {
//        return new Date();
//    }
//
//    /**
//     * 返回多少时间的前的时间, seconds 可以是负的
//     *
//     * @param when
//     * @param seconds
//     */
//    public static Date addTime(Date when, int seconds) {
//        Calendar c = Calendar.getInstance();
//
//        c.setTime(when);
//        c.add(Calendar.SECOND, seconds);
//
//        return c.getTime();
//    }
//
//    /**
//     * 返回多少前后多少天的date,用正负表示前后
//     *
//     * @param day
//     * @param i
//     */
//    public static Date beforeOrAfterDay(Date day, int i) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(day);
//        c.add(Calendar.DAY_OF_MONTH, i);
//        return c.getTime();
//    }
//
//    /**
//     * 获取本月的第一天，时分秒均为0
//     *
//     * @param today
//     * @return
//     */
//    public static Date getFirstDayOfMonth(Date today) {
//        if (today == null) {
//            today = new Date();
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(today);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        return DateUtil.parseDate(toLocaleString(calendar.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    public static Date getYesterday() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        return DateUtil.parseDate(toLocaleString(calendar.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    /**
//     * 获取上月的第一天
//     *
//     * @return
//     */
//    public static Date getFirstDayOfLastMonth() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, -1);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        return DateUtil.parseDate(toLocaleString(calendar.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    public static Date addMonth(Date date, int day) {
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.setTime(date);
//
//        calendar.add(Calendar.MONTH, day);
//        return calendar.getTime();
//    }
//
//    /**
//     * 获取上月的最后一天
//     *
//     * @return
//     */
//    public static Date getLastDayOfLastMonth() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH, 0);
//        return DateUtil.parseDate(toLocaleString(calendar.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    /**
//     * 获取指定月的最后一天
//     *
//     * @return
//     */
//    public static Date getLastDayOfLastMonth(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.DAY_OF_MONTH, 0);
//        return DateUtil.parseDate(toLocaleString(calendar.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    /**
//     * 根据当前日期date，计算出下月一号，时分秒均为0 例如date = 2010-08-09，则返回2010-09-01
//     *
//     * @param date
//     */
//    public static Date getNextMonthFirst(Date date) {
//        if (date == null) {
//            date = new Date();
//        }
//        Calendar lastDate = Calendar.getInstance();
//        lastDate.setTime(date);
//        lastDate.add(Calendar.MONTH, 1);// 加一个月
//        lastDate.set(Calendar.DAY_OF_MONTH, 1);// 把日期设置为当月第一天
//        return DateUtil.parseDate(toLocaleString(lastDate.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    /**
//     * 根据当前日期date，计算出上月或者下月的今天日期，i表示-+
//     */
//    public static Date getNextOrBeforeMonthToday(Date date, int i) {
//        if (date == null) {
//            date = new Date();
//        }
//        Calendar lastDate = Calendar.getInstance();
//        lastDate.setTime(date);
//        lastDate.add(Calendar.MONTH, i);// 月份加减
//        return DateUtil.parseDate(toLocaleString(lastDate.getTime(), "yyyy-MM-dd"), "yyyy-MM-dd");
//    }
//
//    //	public static Boolean isYestoday(String strYestoday) {
//    //		if (strYestoday == null) {
//    //			return Boolean.FALSE;
//    //		}
//    //		// 将date转换为日期格式
//    //		  new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
//    //
//    //		Date theDate = DateTimeUtil.getFormatDate(strYestoday, "yyyy-MM-dd");
//    //		Calendar theCalendar = Calendar.getInstance();
//    //		theCalendar.setTime(theDate);
//    //		// 昨天日历
//    //		Calendar calendar = Calendar.getInstance();
//    //		calendar.add(Calendar.DAY_OF_MONTH, -1);
//    //		// 是否是昨天判断
//    //		if (theCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
//    //				&& theCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
//    //				&& theCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
//    //			return Boolean.TRUE;
//    //		} else {
//    //			return Boolean.FALSE;
//    //		}
//    //
//    //	}
//
//    public static Boolean isToday(Date dayTime) {
//        Calendar theStarCalendar = Calendar.getInstance();
//        theStarCalendar.setTime(new Date());
//        Calendar theEndCalendar = Calendar.getInstance();
//        theEndCalendar.setTime(dayTime);
//        // 是否同一天
//        if (theStarCalendar.get(Calendar.YEAR) == theEndCalendar.get(Calendar.YEAR)
//                && theStarCalendar.get(Calendar.MONTH) == theEndCalendar.get(Calendar.MONTH)
//                && theStarCalendar.get(Calendar.DAY_OF_MONTH) == theEndCalendar.get(Calendar.DAY_OF_MONTH)) {
//            return Boolean.TRUE;
//        } else {
//            return Boolean.FALSE;
//        }
//    }
//
//    public static Boolean isYestoday(Date yestoday) {
//        // 将date转换为日期格式
//        Calendar theCalendar = Calendar.getInstance();
//        theCalendar.setTime(yestoday);
//        // 昨天日历
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        // 是否是昨天判断
//        if (theCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
//                && theCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
//                && theCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
//            return Boolean.TRUE;
//        } else {
//            return Boolean.FALSE;
//        }
//
//    }
//
//    /**
//     * 计算2个日期(取整)相差的天数(返回值非负)
//     *
//     * @param startDate
//     * @param endDate
//     * @return
//     */
//    public static int getDateDistance(Date startDate, Date endDate) {
//        Date[] dates = {startDate, endDate};
//        Calendar[] calendars = new Calendar[2];
//        for (int i = 0; i < 2; i++) {
//            calendars[i] = Calendar.getInstance();
//            calendars[i].setTime(dates[i]);
//            calendars[i].set(Calendar.HOUR_OF_DAY, 0); // 小时取0
//            calendars[i].set(Calendar.MINUTE, 0); // 分取0
//            calendars[i].set(Calendar.SECOND, 0); // 秒取0
//            calendars[i].set(Calendar.MILLISECOND, 0); // 毫秒取0
//        }
//        return Math.abs(
//                (int) ((calendars[0].getTime().getTime() - calendars[1].getTime().getTime()) / 1000 / 60 / 60 / 24));
//    }
//
//    /**
//     * 增加月数
//     *
//     * @param day
//     */
//    public static Date nextMonthLastDay(Date day) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(day);
//        c.add(Calendar.MONTH, 2);
//        //
//        c.set(Calendar.DAY_OF_MONTH, 1);// 把日期设置为当月第一天
//        c.set(Calendar.HOUR_OF_DAY, 0); // 小时取0
//        c.set(Calendar.MINUTE, 0); // 分取0
//        c.set(Calendar.SECOND, 0); // 秒取0
//        c.set(Calendar.MILLISECOND, 0); // 毫秒取0
//        c.add(Calendar.SECOND, -1);
//        return c.getTime();
//    }
//
//    public static Date getNextYearOfDay() {
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.YEAR, 1);
//        return resetTime(c);
//    }
//
//    public static Date getToday() {
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.YEAR, 0);
//        return resetTime(c);
//    }
//
//    /**
//     * Remove time in date, reset to 00:00:00
//     *
//     * @param date datetime
//     * @return new date without time
//     */
//    public static Date removeTime(Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        return resetTime(c);
//    }
//
//    private static Date resetTime(Calendar c) {
//        c.set(Calendar.HOUR_OF_DAY, 0); // 小时取0
//        c.set(Calendar.MINUTE, 0); // 分取0
//        c.set(Calendar.SECOND, 0); // 秒取0
//        c.set(Calendar.MILLISECOND, 0); // 毫秒取0
//        c.add(Calendar.SECOND, 0);
//        return c.getTime();
//    }
//
//    public static Date resetTime(Date date, int hour, int minue) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.HOUR_OF_DAY, hour); // 小时取0
//        c.set(Calendar.MINUTE, minue); // 分取0
//        c.add(Calendar.SECOND, 0);
//        return c.getTime();
//
//    }
//
//    public static int getHour(Date date) {
//        Calendar calendar = GregorianCalendar.getInstance();
//        calendar.setTime(date);
//        return calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
//    }
//
//    public static Date getDateMax(Date date) {
//
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.HOUR_OF_DAY, 23);
//        c.set(Calendar.MINUTE, 59);
//        c.set(Calendar.SECOND, 59);
//        c.set(Calendar.MILLISECOND, 0);
//
//        return c.getTime();
//    }
//
//    public static Date getDateMin(Date date) {
//
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.HOUR_OF_DAY, 0);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//
//        return c.getTime();
//    }
//
//    /**
//     * 得到一个区间内的所有日期
//     *
//     * @param startDate 开始日期
//     * @param endDate   结束日期
//     * @return
//     */
//    public static List<String> getDates(Date startDate, Date endDate) {
//        List<String> dates = new ArrayList<String>();
//        dates.add(toLocaleString(startDate, "yyyy-MM-dd"));
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(startDate);
//
//        while (endDate.after(begin.getTime())) {
//            begin.add(Calendar.DAY_OF_MONTH, 1);
//            dates.add(toLocaleString(begin.getTime(), "yyyy-MM-dd"));
//        }
//        return dates;
//    }
//
//    /**
//     * 得到一个区间内的所有日期
//     *
//     * @param startDate 开始日期
//     * @param endDate   结束日期
//     * @return
//     */
//    public static List<Date> getDateDatas(Date startDate, Date endDate) {
//        List<Date> dates = new ArrayList<Date>();
//        dates.add(startDate);
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(startDate);
//
//        while (endDate.after(begin.getTime())) {
//            begin.add(Calendar.DAY_OF_MONTH, 1);
//            dates.add(begin.getTime());
//        }
//        return dates;
//    }
//
//    public static Date min(List<Date> dates) {
//        if (CollectionUtils.isEmpty(dates)) {
//            return null;
//        }
//        Date minDate = dates.get(0);
//        for (Date date : dates) {
//            if (date.before(minDate)) {
//                minDate = date;
//            }
//        }
//        return minDate;
//    }
//
//    public static Date max(List<Date> dates) {
//        if (CollectionUtils.isEmpty(dates)) {
//            return null;
//        }
//        Date maxDate = dates.get(0);
//        for (Date date : dates) {
//            if (date.after(maxDate)) {
//                maxDate = date;
//            }
//        }
//        return maxDate;
//    }
//
//    public static Date getMondayOfWeek(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
//        // 获得当前日期是一个星期的第几天  
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        // 获得当前日期是一个星期的第几天  
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        // 获取该周第一天
//        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//        return cal.getTime();
//    }
//
//    public static Date getDateOfWeek(Date date, int dayOfWeek, int hour) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek + 1);
//        cal.set(Calendar.HOUR, hour);
//        return cal.getTime();
//    }
//
//    public static String getMondayOfWeek(Date date, String format) {
//        Date startDate = getMondayOfWeek(date);
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        return sdf.format(startDate);
//    }
//
//    public static Date getSundayOfWeek(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
//        // 获得当前日期是一个星期的第几天  
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        // 获得当前日期是一个星期的第几天  
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        // 获取该周第一天
//        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//        // 获取该周最后一天
//        cal.add(Calendar.DATE, 6);
//        return cal.getTime();
//    }
//
//    public static Integer getDayOfWeek(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (dayWeek == 1) {
//            return 7;
//        } else {
//            return dayWeek - 1;
//        }
//    }
//
//    public static void main(String[] args) throws ParseException {
//        System.out.println(toLocaleString(new Date(), TIME_YYYMMDD_HHMMSS));
//    }
//
//    public static List<String> getDates(String startDateString, String endDateString) {
//        Date endDate = parseDate(endDateString, "yyyy-MM-dd");
//        Date startDate = parseDate(startDateString, "yyyy-MM-dd");
//
//        List<String> dates = new ArrayList<String>();
//        dates.add(startDateString);
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(startDate);
//
//        while (endDate.after(begin.getTime())) {
//            begin.add(Calendar.DAY_OF_MONTH, 1);
//            dates.add(toLocaleString(begin.getTime(), "yyyy-MM-dd"));
//        }
//        return dates;
//    }
//
//    public static List<String> getDates(String startDateString, String endDateString, String format) {
//        Date endDate = parseDate(endDateString, format);
//        Date startDate = parseDate(startDateString, format);
//
//        List<String> dates = new ArrayList<String>();
//        dates.add(startDateString);
//        Calendar begin = Calendar.getInstance();
//        begin.setTime(startDate);
//
//        while (endDate.after(begin.getTime())) {
//            begin.add(Calendar.DAY_OF_MONTH, 1);
//            dates.add(toLocaleString(begin.getTime(), format));
//        }
//        return dates;
//    }
//
//    /**
//     * 开始结束时间的严格检查
//     * 不允许任何一个为空
//     * 允许两个时间相同
//     *
//     * @param start
//     * @param end
//     * @param format
//     * @return
//     */
//    public static boolean isStrictlyValidStartEndDate(String start, String end, String format) {
//        if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
//            return false;
//        }
//        Date s = parseDate(start, format);
//        Date e = parseDate(end, format);
//        if (s.after(e)) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static boolean isStrictlyValidStartEndDate(String start, String end) {
//        return isStrictlyValidStartEndDate(start, end, TIME_YYYY_MM_DD);
//    }
//
//    /**
//     * Get dates between start and end, both inclusive
//     *
//     * @param startDate start date
//     * @param endDate   end date
//     * @return list of date
//     */
//    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
//        long numOfDaysBetween = getTimeIntervalDays(startDate, endDate);
//        return IntStream.iterate(0, i -> i + 1)
//                .limit(numOfDaysBetween + 1)
//                .mapToObj(i -> addDay(startDate, i))
//                .collect(toList());
//    }
//
//    public static boolean containToday(List<String> dateStr, String format) {
//        String todayStr = DateUtil.toLocaleString(getToday(), format);
//        return dateStr.contains(todayStr);
//    }
//
//    public static int diffDays(Date date1, Date date2) {
//        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
//        return days;
//    }
//
//    public static boolean needRealTime(Date start, Date end) {
//        Date today = getToday();
//        return !start.after(today) && !end.before(today);
//    }
//
//}
