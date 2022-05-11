package Personel_Employee;

public class Employee_MenuManager extends Employee {

	public Employee_MenuManager(String empNo, String empName, Double salary, String position, Double bonus) {
		super(empNo, empName, salary, position, bonus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double updateSalary() {
		return this.setSalary(111.1);
	}
}

