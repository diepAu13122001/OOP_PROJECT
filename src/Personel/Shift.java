package Personel;

import java.util.ArrayList;
import java.util.List;

public abstract class Shift {
	protected int id; // ma ca (ca so may?)
	protected String name; // ten ca
	protected double startedTime;// gio vo
	protected double outedTime; // gio ra

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStartedTime() {
		return startedTime;
	}

	public void setStartedTime(double startedTime) {
		this.startedTime = startedTime;
	}

	public double getOutedTime() {
		return outedTime;
	}

	public void setOutedTime(double outedTime) {
		this.outedTime = outedTime;
	}
	
	public abstract Shift getInfo ();
	
	public static List<Shift> getShiftList (){
		List<Shift> list = new ArrayList<>();
//		list.add(new Zalopay());
		return list;
	}

}
