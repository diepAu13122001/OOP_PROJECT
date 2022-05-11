package model.personel_employee;

import java.util.*;

public class Employee_Dao {
	private List<Employee> list = new ArrayList<Employee>();

	public static List<Employee> listNv() {
		java.util.List<Employee> list = new ArrayList<Employee>();

		Employee nv1 = new Employee("E01", "Tom", 200.0, 1, null);
		Employee nv2 = new Employee("E02", "Jerry", 100.2, 2, null);
		Employee nv3 = new Employee("E03", "Donald", 150.0, 2, null);
		list.add(nv1);
		list.add(nv2);
		list.add(nv3);

		return list;
	}

	public void addToList(String id, String name, double salary, int grade, double bonus) {
		Employee nv = new Employee(id, name, salary, grade, bonus);
		this.list.add(nv);
	}

	public List<Employee> getList() {
		return this.list;
	}
}
