package Personel_Employee;

public class Employee_HRM implements ObserverInterface {
	@Override
	public void updateSalary(Employee emp) {
		emp.setSalary(emp.getSalary()+40000);
		
	}

}
