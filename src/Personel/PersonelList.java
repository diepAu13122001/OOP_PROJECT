package Personel;

import java.util.*;


public class PersonelList {
	private String nameOfList;
	private ArrayList<Personel> list;

	public PersonelList(ArrayList<Personel> list, String name) {
		this.nameOfList = name;
		this.list = list;
	}

	public String getNameOfList() {
		return nameOfList;
	}

	public void setNameOfList(String nameOfList) {
		this.nameOfList = nameOfList;
	}

	public ArrayList<Personel> getList() {
		return list;
	}

	public void setList(ArrayList<Personel> list) {
		this.list = list;
	}

	
}