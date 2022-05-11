package Personel_Employee;

public class Employee_Accountant implements ObserverInterface {
@Override
	public void updateSalary(Employee emp) {
		emp.setSalary((double) (emp.getSalary()+emp.getSalary()*0.1));
	}

}
