package model.personel_employee;

import java.util.*;

public class Employee_Dao  {
	private List<Employee> list = new ArrayList<Employee>();

	public static List<Employee> listNv() {
		java.util.List<Employee> list = new ArrayList<Employee>();

		Employee nv1 = new Employee_Accountant("E01", "Tom", 200.0, "Accountant", null);
		Employee nv2 = new Employee_HRM("E02", "Jerry", 100.2, "HRM", null);
		Employee nv3 = new Employee_MenuManager("E03", "Donald", 200.2,"Menu_Manager", null);
		list.add(nv1);
		list.add(nv2);
		list.add(nv3);

		return list;
	}


	public static void main(String[] args) {
		System.out.println(listNv().get(2).updateSalary().toString());
		Employee e1 = new Employee_MenuManager("E04","Jerry",1000.2,"Menu_manager",null);
		listNv().add(e1);
		System.out.println(listNv().add(e1));
	}
}
