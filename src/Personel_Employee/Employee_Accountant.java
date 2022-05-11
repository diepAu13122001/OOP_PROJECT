package Personel_Employee;

public class Employee_Accountant  extends Employee  {
	
	public Employee_Accountant(String empNo, String empName, Double salary, String position, Double bonus) {
		super(empNo, empName, salary, position, bonus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double updateSalary() {
		return this.setSalary((double) (this.getSalary()+this.getSalary()*0.5));
	}
}

