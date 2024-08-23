package com.example.util;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具集
 * 
 * @author weiwei
 * 
 */
public class TimeUtils {

	/**
	 * 时区毫秒偏移
	 */
	private static final long millisOffset = TimeZone.getDefault().getRawOffset();

	/**
	 * 取得指定时间在当天的秒索引
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 秒索引(0~86399)
	 */
	public static int getSecondOfDay(long timestamp) {
		return (int) (((timestamp + millisOffset) % 86400000L) / 1000L);
	}

	/**
	 * 取得指定时间在当天的分钟索引
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 分钟索引(0~1439)
	 */
	public static int getMinuteOfDay(long timestamp) {
		return (int) (((timestamp + millisOffset) % 86400000L) / 60000L);
	}

	/**
	 * 取得指定时间在当天的小时索引
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 时索引(0~23)
	 */
	public static int getHourOfDay(long timestamp) {
		return (int) (((timestamp + millisOffset) % 86400000L) / 3600000L);
	}
	
	/**
	 * 取得自1970-01-01以来的小时索引
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 小时索引（1970-01-01 00:59:00 为0）
	 */
	public static int getHourIndex(long timestamp) {
		return (int) ((timestamp + millisOffset) / 3600000L);
	}

	/**
	 * 取得自1970-01-01以来的日索引
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 日索引（1970-01-01为0）
	 */
	public static int getDayIndex(long timestamp) {
		return (int) ((timestamp + millisOffset) / 86400000L);
	}

	/**
	 * 取得指定时间是星期几
	 * 
	 * @param timestamp
	 *            时间戳,必须大于等于0
	 * @return 0表示星期一,6表示星期日，依次类推
	 */
	public static int getDayOfWeek(long timestamp) {
		return (int) (((timestamp + millisOffset + 259200000L) % 604800000L) / 86400000L);
	}

	/**
	 * 返回指定时间所在周周一的时间戳
	 * 
	 * @param timestamp
	 *            时间戳，必须大于等于0
	 * @return 周一的时间戳值
	 */
	public static long getMondayMillis(long timestamp) {
		return timestamp - (timestamp + millisOffset + 259200000L) % 604800000L;
	}

	/**
	 * 根据天索引和当天秒取得时间戳
	 * 
	 * @param dayIndex
	 *            天索引,必须大于等于0
	 * @param secondOfDay
	 *            当天秒,0~86399
	 * @return
	 */
	public static long getTimeMillis(int dayIndex, int secondOfDay) {
		return dayIndex * 86400000L - millisOffset + secondOfDay * 1000L;
	}
	
	/**
	 * 返回指定天(1970-01-01以来的日索引)和当天的秒索引数生成的时间戳，
	 * @param dayIndex 通过<code>getDayIndex(param)</code>方法生成的值
	 * @param secondOfDay 通过<code>getSecondOfDay(param)</code>方法生成的值
	 * @return 
	 */
	public static long getTimeStamp(int dayIndex,int secondOfDay){
		return (dayIndex * 86400000L - millisOffset) + (secondOfDay * TimeUnit.SECONDS.toMillis(1));
	}

	public static void main(String[] args) {
		int dayIndex = TimeUtils.getDayIndex(System.currentTimeMillis());
		System.out.println("日期索引：" + dayIndex);
	}
}
