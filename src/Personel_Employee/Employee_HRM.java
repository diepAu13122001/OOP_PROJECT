package Personel_Employee;

public class Employee_HRM implements DraftObserverInterface {
	@Override
	public void updateSalary(Employee emp) {
		emp.setSalary(emp.getSalary()+40000);
		
	}

}
