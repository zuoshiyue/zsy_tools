package com.jx3.api_sdk.util;



import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtil {

    /**
     * 定制格式化
     *
     * @param date   待格式化日期
     * @param format 格式
     */
    public static String format(Date date, String format) {
        if (null == date || StringUtils.isBlank(format)) {
            return null;
        }
        SimpleDateFormat sfd = new SimpleDateFormat(format);
        return sfd.format(date);
    }


    /**
     * 忽略时分秒
     * startDate 开始日期 小
     * endDate 结束日期 大
     */
    public static int daysBetween(Date startDate, Date endDate) {
        return daysBetween(toLocalDate(startDate), toLocalDate(endDate));
    }

    /**
     * 忽略时分秒
     * startDate 开始日期 小
     * endDate 结束日期 大
     */
    public static int daysBetween(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * date > LocalDate
     */
    public static LocalDate toLocalDate(Date dateTime) {
        if (null == dateTime) {
            return null;
        }
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
