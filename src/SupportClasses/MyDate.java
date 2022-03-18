package SupportClasses;

import java.util.*;

public class MyDate {
	private int date;
	private int month;
	private int year;
	private String day; // thu hai, ba, tu ...

	public MyDate(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public MyDate() {
		
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLongDay() {
		setDay();
		return this.day;
	}

	public String getShortDay() {
		String d = getLongDay();
		switch (d) {
		case "Monday": {
			return "Mon";
		}
		case "Tuesday": {
			return "Tue";
		}
		case "Wednesday": {
			return "Mon";
		}
		case "Thursday": {
			return "Thu";
		}
		case "Friday": {
			return "Fri";
		}
		case "Saturday": {
			return "Sat";
		}

		case "Sunday": {
			return "Sun";
		}
		}
		return "";
	}

	private void setDay() {
		Date d = new Date(getYear(), getMonth(), getDate());
		int tmp = d.getDay();
		switch (tmp) {
		case 1: {
			this.day = "Monday";
		}
		case 2: {
			this.day = "Tuesday";
		}
		case 3: {
			this.day = "Wednesday";
		}
		case 4: {
			this.day = "Thursday";
		}
		case 5: {
			this.day = "Friday";
		}
		case 6: {
			this.day = "Saturday";
		}
		case 0: {
			this.day = "Sunday";
		}
		}
	}
	public MyDate convertStringHaveSlash(String s){
		// String like: 10/01/2001
		int date = Integer.parseInt(s.split("/")[0]);
		int month = Integer.parseInt(s.split("/")[1]);
		int year = Integer.parseInt(s.split("/")[2]);
		MyDate d = new MyDate(date, month, year);
		return d;
	}

}
