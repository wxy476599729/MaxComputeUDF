package com.uxin.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aliyun.odps.udf.UDF;

public class GetMonday extends UDF {

	public String evaluate(String date, String dateFormat) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat tmp = new SimpleDateFormat(dateFormat);
		cal.setTime(tmp.parse(date));
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		weekday = (weekday - 2 < 0) ? (weekday + 5) : (weekday - 2);
		cal.add(Calendar.DATE, - weekday);
		return tmp.format(cal.getTime());
	}
	
}
