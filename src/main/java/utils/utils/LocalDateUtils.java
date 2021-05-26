package utils.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class LocalDateUtils {

    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_YYYY_MM_DD = "yyyy-MM-dd";
    //public final static String TIME_YYYY_MM_DD_END = "yyyy-MM-dd 23:59:59";

    public final static String TIME_YYYMMDD = "yyyyMMdd";

    public final static String TIME_YYYMMDD_HHMMSS = "yyyyMMddHHmmss";

    public static LocalDate string2LocalDate(String localDateStr, String format) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return LocalDate.from(fmt.parse(localDateStr));
    }

    public static String localDate2String(LocalDate localDate, String format) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return fmt.format(localDate);
    }

    public static String addDays2DateString(LocalDate localDate, int days, String format) {
        localDate = localDate.plusDays(days);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return fmt.format(localDate);
    }

    public static String minusDays2DateString(LocalDate localDate, int days, String format) {
        localDate = localDate.minusDays(days);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return fmt.format(localDate);
    }

    public static String localDateTime2String(LocalDateTime localDateTime, String format) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        return fmt.format(localDateTime);
    }

    public static Date localDate2Date(LocalDate localDate, String format) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime, String format) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
