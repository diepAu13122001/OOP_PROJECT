package model.personel_employee;

import java.util.*;

public class Employee implements ObserverInterface{

	private String empNo;
	private String empName;
	private Double salary;
	private String position;
	private Double bonus;

	public Employee(String empNo, String empName, Double salary, String position, Double bonus) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
		this.position = position;
		this.bonus = bonus;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public Double setSalary(Double salary) {
		return this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "CSDL_NhanVien [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + ", position="
				+ position + ", bonus=" + bonus + "] \n";
	}


}

