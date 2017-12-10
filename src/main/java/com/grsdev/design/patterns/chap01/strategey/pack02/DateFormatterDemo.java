package com.grsdev.design.patterns.chap01.strategey.pack02;

import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.System.*;

public class DateFormatterDemo {

	public static void main(String[] args) {
		
		Date date=new Date();
		
		DateFormatter formatter=new DateFormatterYYYYMMDD();
		
		out.println("date : "+formatter.format(date));
		
		formatter=new DateFormatYYYY_MMM_DD();
		
		out.println(formatter.format(date));
		
	}

}


interface DateFormatter{
	
	String format(Date date);
}

class DateFormatterYYYYMMDD implements DateFormatter{
	
	@Override
	public String format(Date date) {
		
		String pattern="yyyyMMdd";
		
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		
		return format.format(date);
	}
	
}

class DateFormatYYYY_MMM_DD implements DateFormatter{
	
	@Override
	public String format(Date date) {
		
		String pattern="yyyy_MMM_dd";
		
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		
		return format.format(date);
	}
}

