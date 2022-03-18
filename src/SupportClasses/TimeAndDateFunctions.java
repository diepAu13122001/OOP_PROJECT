package SupportClasses;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;

public class TimeAndDateFunctions {

	public TimeAndDateFunctions() {
	}

	// thoi gian hien tai (chi danh cho ngay, danh cho viec trich xuat)
	public String showCurrentDate(Date time) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
		return timeFormat.format(time);
	}

	// thoi gian hien tai (chi danh cho thoi gian, danh cho viec trich xuat)
	public String showCurrentTime(Date time) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(time.getTime());
	}

	// thoi gian hien tai (gom ca ngay va gio, danh cho in hoa don)
	public String showCurrentDateAndTime(Date time) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return timeFormat.format(time.getTime());
	}

// doi 1 chuoi sang ngay
	public String convertStringToDate(int day, int month, int year) throws Exception {
		String sDate = day + "/" + month + "/" + year;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return showCurrentDate(dateFormat.parse(sDate));
	}

	// doi 1 chuoi sang gio
	public String convertStringToTime(int hour, int minute, int second) throws Exception {
		String sTime = hour + ":" + minute + ":" + second;
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return showCurrentTime(timeFormat.parse(sTime));
	}

	// doi 1 chuoi sang ngay va gio
	// co 1 van de: neu vuot qua khoi so ngay hoac thang quy dinh no se tinh tiep
	// cho thang tiep theo chu khong bao loi
	public String convertStringToTimeAndDate(int day, int month, int year, int hour, int minute, int second)
			throws Exception {
		String sTimeAndDate = hour + ":" + minute + ":" + second + " " + day + "/" + month + "/" + year;
		SimpleDateFormat timeAndDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return showCurrentTime(timeAndDateFormat.parse(sTimeAndDate));
	}

	// calculate time for timeKeeping
	public ArrayList<Long> find(MyDate join_date, MyTime join_time, MyDate leave_date, MyTime leave_time) {
		Date date1 = new Date(join_date.getYear(), join_date.getMonth(), join_date.getDate(), join_time.getHour(),
				join_time.getMinute(), join_time.getSecond());
		Date date2 = new Date(leave_date.getYear(), leave_date.getMonth(), leave_date.getDate(), leave_time.getHour(),
				leave_time.getMinute(), leave_time.getSecond());

		// Calculate time difference in milliseconds
		long time_difference = date2.getTime() - date1.getTime();
		// Calculate time difference in days
		long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
		// Calculate time difference in months
		long months_difference = days_difference / 30;
		// Calculate time difference in years
		long years_difference = (time_difference / (1000l * 60 * 60 * 24 * 365));
		// Calculate time difference in seconds
		long seconds_difference = (time_difference / 1000) % 60;
		// Calculate time difference in minutes
		long minutes_difference = (time_difference / (1000 * 60)) % 60;
		// Calculate time difference in hours
		long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;

		ArrayList<Long> list_difference = new ArrayList<>();
		list_difference.add(years_difference);
		list_difference.add(months_difference);
		list_difference.add(days_difference);
		list_difference.add(hours_difference);
		list_difference.add(minutes_difference);
		list_difference.add(seconds_difference);
		return list_difference;
	}

	public static void main(String[] args) throws Exception {
		TimeAndDateFunctions t = new TimeAndDateFunctions();
		System.out.println(t.showCurrentDate(new Date()));
		System.out.println(t.showCurrentTime(new Date()));
		System.out.println(t.convertStringToDate(11, 9, 2003));
	
		System.out.println(t.find(new MyDate(12, 1, 2021), new MyTime(7, 49, 50), new MyDate(13, 1, 2021), new MyTime(5, 15, 00)).toString());

	}
}
