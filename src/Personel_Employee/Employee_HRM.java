package Personel_Employee;

public class Employee_HRM extends Employee {

	public Employee_HRM(String empNo, String empName, Double salary, String position, Double bonus) {
		super(empNo, empName, salary, position, bonus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double updateSalary() {
		return this.setSalary(this.getSalary()+40000);
	}

