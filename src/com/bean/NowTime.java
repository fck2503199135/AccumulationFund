package com.bean;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NowTime {

	public static String getNowTiem()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String newDate = simpleDateFormat.format(date);
		return newDate;
	}
	
	public static double chargeTime(String date1, String date2)
	{
		try
		{
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1=sd.parse(date1);
			Date d2=sd.parse(date2);
			double charge=(d2.getTime()-d1.getTime())/1000/3600/24;
			return charge;
		} catch (Exception e) {// TODO: handle exception
		   }
		return 0;
	}
	
	
	
	public static void main(String[] args)
	{







	}
	
}
