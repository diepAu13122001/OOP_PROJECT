package SupportClasses;

public class MyTime {
	private int hour;
	private int minute;
	private int second;

	public MyTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public MyTime() {
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public String showTimeNoSecond() {
		return this.hour + ":" + this.minute;
	}

	public String showFullTime() {
		return this.hour + ":" + this.minute + ":" + this.second;
	}
	
	public MyTime convertStringHaveColon(String s){
		// String like: 10:01:01
		int hour = Integer.parseInt(s.split(":")[0]);
		int minute = Integer.parseInt(s.split(":")[1]);
		int second = Integer.parseInt(s.split(":")[2]);
		MyTime t = new MyTime(hour, minute, second);
		return t;
	}

}
