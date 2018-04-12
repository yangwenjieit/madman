package com.madman.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @描述 UTC时间工具类
 * @author ywj
 * @版本：1.0
 * @创建时间：2018年4月12日 下午1:33:33
 */
public final class UTCTimeUtil {

    private static  final Logger log = LoggerFactory.getLogger(UTCTimeUtil.class);


    public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_STANDARD_SSS = "yyyy-MM-dd HH:mm:ss:SSS";

    public static Timestamp commonGetUTC(String formatStr){
        DateFormat format = new SimpleDateFormat(formatStr) ;
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second) ;
        if(PATTERN_STANDARD_SSS.equals(formatStr)){
            int milliSecond=cal.get(Calendar.MILLISECOND);
            UTCTimeBuffer.append(":").append(milliSecond);
        }
        try{
            Date date=format.parse(UTCTimeBuffer.toString());
            return new Timestamp(date.getTime());
        }catch(ParseException e)
        {
            log.error("",e);
        }
        return null ;
    }


    /**
     * @Title: commonGetUTC
     * @Description: 将本地指定时间 转为UTC时间
     * @param @param cal 本地传入时间
     * @param @param formatStr
     * @param @return
     * @return Timestamp
     */
    public static Timestamp commonGetUTC(Calendar cal,String formatStr){
        DateFormat format = new SimpleDateFormat(formatStr);
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：

        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second) ;
        if(PATTERN_STANDARD_SSS.equals(formatStr)){
            int milliSecond=cal.get(Calendar.MILLISECOND);
            UTCTimeBuffer.append(":").append(milliSecond);
        }
        try{
            Date date=format.parse(UTCTimeBuffer.toString());
            return new Timestamp(date.getTime());
        }catch(ParseException e)
        {
            log.error("",e);
        }
        return null ;
    }


    /**
     * 得到UTC时间戳，返回类型Timestamp，格式为"yyyy-MM-dd HH:mm:ss"
     * 如果获取失败，返回null
     * @return
     */
    public static Timestamp getUTCDateTimeStr() {
        return commonGetUTC(PATTERN_STANDARD);
    }

    /**
     * 得到UTC时间戳，精确到毫秒，返回类型Timestamp，格式为"yyyy-MM-dd HH:mm:ss:SSS"
     * 如果获取失败，返回null
     * @return
     */
    public static Timestamp getUTCDateTimeMSStr() {
        return commonGetUTC(PATTERN_STANDARD_SSS);
    }

    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd"
     * 如果获取失败，返回null
     * @return
     */
    public static Date getUTCDateStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        try{
            return format.parse(UTCTimeBuffer.toString()) ;
        }catch(ParseException e)
        {
            log.error("",e);
        }
        return null ;
    }

    /**
     * 将UTC时间转换为东八区时间,格式为"yyyy-MM-dd HH:mm:ss"
     * @param UTCTime
     * @return
     */
    public static Timestamp getLocalTimeFromUTC(String UTCTime){
        DateFormat format = new SimpleDateFormat(PATTERN_STANDARD) ;
        java.util.Date UTCDate = null ;
        String localTimeStr = null ;
        try {
            format.setTimeZone(TimeZone.getTimeZone("UTC")) ;
            UTCDate = format.parse(UTCTime);
            format.setTimeZone(TimeZone.getTimeZone("GMT-8")) ;
            localTimeStr = format.format(UTCDate) ;
            return new Timestamp(format.parse(localTimeStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null ;
    }

    /**
     * 将东八区的时间转换成utc时间
     * @param formatStr
     * @param gmt8Time
     * @return
     */
    public static Timestamp GMT8ToUTC(String formatStr,String gmt8Time){
        try{
            DateFormat format = new SimpleDateFormat(formatStr) ;
            StringBuffer UTCTimeBuffer = new StringBuffer();
            // 1、取得本地时间：
            Calendar cal = Calendar.getInstance() ;
            cal.setTime(format.parse(gmt8Time));
            // 2、取得时间偏移量：
            int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
            // 3、取得夏令时差：
            int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
            // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
            cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
            UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second) ;
            if(PATTERN_STANDARD_SSS.equals(formatStr)){
                int milliSecond=cal.get(Calendar.MILLISECOND);
                UTCTimeBuffer.append(":").append(milliSecond);
            }

            Date date=format.parse(UTCTimeBuffer.toString());
            return new Timestamp(date.getTime());
        }catch(ParseException e)
        {
            log.error("",e);
        }
        return null ;
    }

}


