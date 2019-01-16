package com.springboot.quartz.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.el.parser.ParseException;
import org.springframework.util.StringUtils;

import com.springboot.quartz.qenum.TriggerPeriod;



public class CronUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static final int SECOND = 0;
	protected static final int MINUTE = 1;
	protected static final int HOUR = 2;
	protected static final int DAY_OF_MONTH = 3;
	protected static final int MONTH = 4;
	protected static final int DAY_OF_WEEK = 5;
	protected static final int YEAR = 6;
	protected static final int ALL_SPEC_INT = 99; // *
	protected static final int NO_SPEC_INT = 98; // ?
	protected static final int ALL_SPEC = Integer.valueOf(ALL_SPEC_INT);
	protected static final int NO_SPEC = Integer.valueOf(NO_SPEC_INT);

	protected static Vector<Integer> seconds;
	protected static Vector<Integer> minutes;
	protected static Vector<Integer> hours;
	protected static Vector<Integer> dayOfMonth;
	protected static Vector<Integer> months;
	protected static Vector<Integer> dayOfWeek;
	protected static Vector<Integer> years;

	protected static final Map<Integer, String> monthMap = new HashMap<>(20);
	protected static final Map<Integer, String> dayMap = new HashMap<>(10);

	static {
		String[] monthArrayStr = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String[] dayArrayStr = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		for (int i = 0; i < monthArrayStr.length; i++) {
			monthMap.put(Integer.valueOf(i+1), monthArrayStr[i]);
		}
		for (int i = 0; i < dayArrayStr.length; i++) {
			dayMap.put(Integer.valueOf(i+1), dayArrayStr[i]);
		}
	}

	@SuppressWarnings("static-access")
	public static synchronized String toCronExpression(TriggerPeriod triggerPeriod, Date startTime) {
		initVector();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime);
		int lastDayOfMonth = getLastDayOfMonth(calendar.get(calendar.YEAR), calendar.get(Calendar.MONTH)+1);
		try {
			addToSet(calendar.get(Calendar.SECOND), 59, 0, SECOND);
			addToSet(calendar.get(Calendar.MINUTE), 59, 0, MINUTE);
			addToSet(calendar.get(Calendar.HOUR_OF_DAY), 23, 0, HOUR);
			if(TriggerPeriod.HOUR == triggerPeriod) {
				addToSet(ALL_SPEC_INT, 0, -1, HOUR);
				addToSet(ALL_SPEC_INT, 0, -1, DAY_OF_MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT, 0, -1, YEAR);
			}
			if(TriggerPeriod.DAY == triggerPeriod) {
				addToSet(ALL_SPEC_INT, 0, -1, DAY_OF_MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT, 0, -1, YEAR);
			}
			if(TriggerPeriod.WEEK ==triggerPeriod) {
				addToSet(NO_SPEC_INT, 0, -1, DAY_OF_MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, MONTH);
				addToSet(2, 0, 0, DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT, 0, -1, YEAR);
				
			}
			if(TriggerPeriod.MONTH==triggerPeriod) {
				addToSet(1, lastDayOfMonth, 0, DAY_OF_MONTH);
				addToSet(ALL_SPEC_INT, 0, -1, MONTH);
				addToSet(NO_SPEC_INT, 0, -1, DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT, 0, -1, YEAR);
			}
			if(TriggerPeriod.QUARTEROFYEAR == triggerPeriod) {
				addToSet(1,lastDayOfMonth,0,DAY_OF_MONTH);
				addToSet(1,0,-1,MONTH);
				addToSet(4,0,-1,MONTH);
				addToSet(7,0,-1,MONTH);
				addToSet(10,0,-1,MONTH);
				addToSet(NO_SPEC_INT,0,-1,DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT,0,-1,YEAR);
			}
			if(TriggerPeriod.HALFOFYEAR == triggerPeriod) {
				addToSet(1,lastDayOfMonth,0,DAY_OF_MONTH);
				addToSet(1,0,-1,MONTH);
				addToSet(7,0,-1,MONTH);
				addToSet(NO_SPEC_INT,0,-1,DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT,0,-1,YEAR);
			}
			if(TriggerPeriod.YEAR == triggerPeriod) {
				addToSet(1,lastDayOfMonth,0,DAY_OF_MONTH);
				addToSet(1,0,0,MONTH);
				addToSet(NO_SPEC_INT,0,-1,DAY_OF_WEEK);
				addToSet(ALL_SPEC_INT,0,-1,YEAR);
				
			}
		}catch(Exception E) {
			return null;
		}
		return buildCronExpression();
	}
	
	private static String buildCronExpression() {
		StringBuffer sf = new StringBuffer();
		sf.append(getCornExperssion(seconds, SECOND));
		sf.append(" ");
		sf.append(getCornExperssion(minutes, MINUTE));
		sf.append(" ");
		sf.append(getCornExperssion(hours, HOUR));
		sf.append(" ");
		sf.append(getCornExperssion(dayOfMonth, DAY_OF_MONTH));
		sf.append(" ");
		sf.append(getCornExperssion(months, MONTH));
		sf.append(" ");
		sf.append(getCornExperssion(dayOfWeek, DAY_OF_WEEK));
		sf.append(" ");
		sf.append(getCornExperssion(years, YEAR));
		sf.append(" ");
		
		seconds.clear();
		minutes.clear();
		hours.clear();
		hours.clear();
		dayOfMonth.clear();
		months.clear();
		dayOfWeek.clear();
		years.clear();
		
		return sf.toString();
	}
	
	private static String getCornExperssion(Vector<Integer> set, int type) {
		if(set.contains(ALL_SPEC)) {
			return "*";
		}
		if(set.contains(NO_SPEC)) {
			return "?";
		}
		StringBuffer buf = new StringBuffer();
		Iterator<Integer> it = set.iterator();
		boolean first = true;
		while(it.hasNext()) {
			Integer val = it.next();
			if(!first) {
				buf.append(",");
			}
			if(type == DAY_OF_WEEK)
				buf.append(getWeekStr(val));
			else if(type == MONTH)
				buf.append(getMonthStr(val));
			else
				buf.append(val.toString());
			first = false;	
		}
		return buf.toString();
	}
	
	private static String getWeekStr(Integer key) {
		String weekStr = String.valueOf(dayMap.get(key));
		if(StringUtils.isEmpty(weekStr)) {
			return "";
		}
		return weekStr;
	}
	
	private static String getMonthStr(Integer key) {
		String monthStr = String.valueOf(monthMap.get(key));
		if(StringUtils.isEmpty(monthStr)) {
			return "";
		}
		return monthStr;
	}
	
	private static void addToSet(int val,int end , int incr ,int type) throws ParseException {
		Vector<Integer> set = getSet(type);
		if(val != ALL_SPEC_INT) {
			if(type ==SECOND || type == MINUTE)
				if(val < 0 || val> 59 || end >59)
					throw new ParseException();
			if(type == HOUR)
				if(val < 0 || val>23 ||  end>23)
					throw new ParseException();
			if(type == DAY_OF_MONTH)
				if(val < 1 || val>31 || end>31)
					if(val != NO_SPEC_INT)
					   throw new ParseException();
			if(type == MONTH)
				if(val < 1 || val>12 || end>12)
					throw new ParseException();		
			if(type == DAY_OF_WEEK)
				if(val == 0|| val>7 || end>7)
					if(val != NO_SPEC_INT)
					    throw new ParseException();	
			
			if(incr == 0) set.add(Integer.valueOf(val));
			if(incr == -1) set.add(ALL_SPEC);
		}else {
			if(incr <= 0 )  set.add(ALL_SPEC);
		}
		
	}
	
	private static Vector<Integer> getSet(int type) {
		switch (type) {
		case SECOND:
			return seconds;
		case MINUTE:
			return minutes;
		case HOUR:
			return hours;
		case DAY_OF_MONTH:
			return dayOfMonth;
		case MONTH:
			return months;
		case DAY_OF_WEEK:
			return dayOfWeek;
		case YEAR:
			return years;
		default:
			break;
		}
		return null;
	}
	
	private static void initVector() {
		if (seconds == null)
			seconds = new Vector<>();
		if (minutes == null)
			minutes = new Vector<>();
		if (hours == null)
			hours = new Vector<>();
		if (dayOfMonth == null)
			dayOfMonth = new Vector<>();
		if (months == null)
			months = new Vector<>();
		if (dayOfWeek == null)
			dayOfWeek = new Vector<>();
		if (years == null)
			years = new Vector<>();
	}
	
	private static int getLastDayOfMonth(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
}
