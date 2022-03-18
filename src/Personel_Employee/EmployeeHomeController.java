package Personel_Employee;

import java.util.HashMap;

public class EmployeeHomeController {
	private EmployeeHomeModel model;
	private EmployeeHomeView view;

	public EmployeeHomeController(EmployeeHomeModel model) {
		this.model = model;
		this.view = new EmployeeHomeView(this, model);
		view.createView();
	}

	public static void main(String[] args) {
		EmployeeHomeModel model = new EmployeeHomeModel();
		new EmployeeHomeController(model);
	}

	public String[] overviewDataTransfer(String nameOfPanel) {
		String inscreaseImage = "icons8_up_16px.png";
		String decreaseImage = "icons8_down_16px.png";
		
		model.overviewData(URLOverviewDataList(), nameOfPanel);
		
			return null;
	}

// chỉ dành cho data của phần overview, đường link tự nhập lun
	private HashMap<String, String> URLOverviewDataList() {
		HashMap<String, String> URLOverviewDataList = new HashMap<>();
		URLOverviewDataList.put("Summary", "");
		URLOverviewDataList.put("Offline", "");
		URLOverviewDataList.put("Web&Social media", "");
		URLOverviewDataList.put("Online applications", "");
		return URLOverviewDataList;
	}
}
