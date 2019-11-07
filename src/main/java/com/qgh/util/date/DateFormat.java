package com.qgh.util.date;




import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class DateFormat {

	
	public  String formatDate(Date date)  {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s1 = sdf.format(date); //2015-02-09 format()才是格式化
		System.err.println(s1);
		return s1;
	}
}
