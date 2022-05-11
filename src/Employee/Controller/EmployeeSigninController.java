package Employee.Controller;

import Employee.Model.EmployeeSigninModel;
import Employee.View.EmployeeSigninView;

public class EmployeeSigninController {
	private EmployeeSigninView view;
	private EmployeeSigninModel model;
	
	public EmployeeSigninController(EmployeeSigninModel model) {
		this.model = model;
		this.view = new EmployeeSigninView(this, model);
		view.createSignInView();
	}

}
