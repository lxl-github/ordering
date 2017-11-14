package com.lxl.ordering.frame.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能概述：日期转换工具
 * <br/>
 * 创建时间：2015年10月26日下午3:09:21
 * <br/>
 * 修改记录：
 * @author lixiaoliang
 */
public class DateUtil {
	
	/** 存放不同的日期模板格式的sdf的Map */
	private static Map<String, ThreadLocal<SimpleDateFormat>> simpleDateFormatMap = new ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>>();

	private static Lock lock= new ReentrantLock();

	/**
	 * 返回一个ThreadLocal的SimpleDateFormat,每个线程只会new一次sdf
	 *
	 * @param pattern
	 * @return
	 */
	private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
		ThreadLocal<SimpleDateFormat> threadLocal = simpleDateFormatMap.get(pattern);

		// 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
		if (threadLocal == null) {
			try {
				lock.lock();
				// 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
				// 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
				threadLocal = new ThreadLocal<SimpleDateFormat>() {
					@Override
					protected SimpleDateFormat initialValue() {
						return new SimpleDateFormat(pattern);
					}
				};
				simpleDateFormatMap.put(pattern, threadLocal);
			} finally {
				lock.unlock();
			}
		}

		return threadLocal.get();
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * 日期转换字符串
	 * <br>
	 * 创建时间：2015年10月26日下午4:08:29
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return
	 *
	 */
	public static String getStringTime(Date date){
		return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	/**
	 * 日期转时间戳 
	 * <br> 
	 * 创建时间：2015年10月26日下午4:10:51
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return
	 *
	 */
	public static Integer getTimeSpanByDate(Date date){
		String date_string = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return getTimespan(date_string);
	}
	
	/**
	 * 日期转时间戳 
	 * <br> 
	 * 创建时间：2015年10月26日下午4:10:51
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @param date yyyy-MM-dd
	 * @return
	 *
	 */
	public static Integer getTimeSpanByDate2(Date date){
		String date_string = getSimpleDateFormat("yyyy-MM-dd").format(date);
		return getTimespan2(date_string);
	}
	
	/**
	 * 根据字符串时间获取对应的时间戳
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Integer getTimespan(String date){
		try {
			Long timespan = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime();
			return Integer.valueOf(String.valueOf(timespan).substring(0, 10));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 根据字符串时间获取对应的时间戳
	 * @param date yyyy-MM-dd
	 * @return
	 */
	public static Integer getTimespan2(String date){
		try {
			Long timespan = getSimpleDateFormat("yyyy-MM-dd").parse(date).getTime();
			return Integer.valueOf(String.valueOf(timespan).substring(0, 10));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 根据时间戳获取字符串时间
	 * @param timespan
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDatetime(Integer timespan){
		if(null==timespan||timespan==0){
			return  "";
		}
		Long time = Long.valueOf(String.valueOf(timespan));
		return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000L));
	}
	
	/**
	 * 根据时间戳获取日期
	 * @param timespan
	 * @return date
	 */
	public static Date getDate(Integer timespan){
		Long time = Long.valueOf(String.valueOf(timespan));
		return new Date(time * 1000L);
	}
	
	/**
	 * 根据时间戳获取日期
	 * @param timespan
	 * @return date
	 * @throws ParseException 
	 */
	public static Date getDateByString(String timespan) throws ParseException{
		return StringUtils.isEmpty(timespan) ? null : getSimpleDateFormat("yyyy-MM-dd").parse(timespan);
	}
	
	/**
	 * 根据时间戳获取字符串时间
	 * @param timespan 
	 * @return yyyy-MM-dd
	 */
	public static String getDatetime1(Integer timespan){
		Long time = Long.valueOf(String.valueOf(timespan));
		return getSimpleDateFormat("yyyy-MM-dd").format(new Date(time * 1000L));
	}
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static Integer getCurrentTimespan(){
		return Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10));
	}
	
	/**
	 * 获取当前1分钟后的时间戳
	 * @return
	 */
	public static Integer getCurrentAfterOneTimespan(){
		Calendar now=Calendar.getInstance();
		now.add(Calendar.SECOND, 3);
		return Integer.valueOf(String.valueOf(now.getTime().getTime()).substring(0, 10));
	}

	/**
	 * 获取当前年份
	 * <br>
	 * 创建时间：2015年6月3日下午2:19:52
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @return
	 *
	 */
	public static Integer getYear(){
		Calendar cal = Calendar.getInstance();
		Integer year = cal.get(Calendar.YEAR);
		return year;
	}
	
	public static Integer getHour(){
		Calendar cal = Calendar.getInstance();
		Integer hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	public static Integer getMinute(){
		Calendar cal = Calendar.getInstance();
		Integer minute = cal.get(Calendar.MINUTE);
		return minute;
	}
	
	/**
	 * 获取日期 yyyyMMdd
	 * <br>
	 * 创建时间：2015年6月8日下午2:42:47
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @return
	 *
	 */
	public static String getDate(){
		return getSimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取日期 yyyy-MM-dd
	 * <br>
	 * 创建时间：2015年6月8日下午2:42:47
	 * <br>
	 * @author lixiaoliang
	 * <br>
	 * @return
	 *
	 */
	public static String getDate2(){
		return getSimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
     * 获取当前时间一周后日期
     * @return
     */
    public static Map<String,String> dateToWeek() {
        Date fdate;
       Map<String,String> map = new LinkedHashMap<String, String>();
        for (int i = 1; i <= 7; i++) {
            fdate = getAfterDate(i);
            String weekDays = getWeekOfDate(fdate);
            map.put(getSimpleDateFormat("MM月dd日").format(fdate).concat("(").concat(weekDays).concat(")"), getSimpleDateFormat("yyyy-MM-dd").format(fdate));
        }
        
        return map;
    }
    
    
    
    /**
     * 获取当前日期n天后的日期
     * @param n:返回当天后的第N天
     * @return 返回的日期
     */
    public static Date getAfterDate(int n) {
        Calendar c = Calendar.getInstance();
        if(n == 1){
        	return c.getTime();
        }
        n = n - 1;
        c.add(Calendar.DAY_OF_MONTH, n);
        return c.getTime();
    }
    
    /**
     * 获取当前日期n月后的日期
     * @param n:返回当天后的第N月
     * @return 返回的日期
     */
    public static Date getMonthAfterDate(int n) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, n);
        c.add(Calendar.DAY_OF_MONTH, 1);
	    //将小时至0  
	    c.set(Calendar.HOUR_OF_DAY, 0);  
	    //将分钟至0  
	    c.set(Calendar.MINUTE, 0);  
	    //将秒至0  
	    c.set(Calendar.SECOND,0);  
	    //将毫秒至0  
	    c.set(Calendar.MILLISECOND, 0);
        //在n月基础上减去1毫秒  
        c.add(Calendar.MILLISECOND, -1); 
        return c.getTime();
    }
    
    /**
     * 获取几个月后的时间
     * <br>
     * 创建时间：2015年8月28日下午5:20:49
     * <br>
     * @author lixiaoliang
     * <br>
     * @param n
     * @return
     *
     */
    public static Integer getMonthAfterTime(int n){
    	Date date = getMonthAfterDate(n);
    	return Integer.valueOf(String.valueOf(date.getTime()).substring(0, 10));
    }
    
    /**
    * 获取当前日期是星期几<br>
    *
    * @param dt
    * @return 当前日期是星期几
    */
    public static String getWeekOfDate(Date dt) {
	    String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(dt);
	    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	    if (w < 0) w = 0;
	    return weekDays[w];
    }
    
    
    
	public static void main(String[] args){
		
		System.out.println(getCurrentAfterOneTimespan());
		
	}
	
}
