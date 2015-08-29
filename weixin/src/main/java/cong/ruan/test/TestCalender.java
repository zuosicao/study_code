package cong.ruan.test;

import java.util.Calendar;

public class TestCalender
{
	public static void main(String[] args)
	{
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		System.out.println(day + ":" + month);
	}
}
