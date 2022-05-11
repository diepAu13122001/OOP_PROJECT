package Personel_Employee;

import java.io.IOException;
import java.util.*;

import org.apache.commons.collections4.map.HashedMap;

import SupportClasses.*;

public class EmployeeSigninModel {
	HashMap<String, String> loginInfo;
	String[] idList;
	String[] passList;
	String[] positionList;

	public EmployeeSigninModel(String employeeSigninURL, int sheetOfEmployeeLoginInfo, int columnIndexOfidList,
			int columnIndexOfpassList, int columnIndexOfpositionList) throws IOException {
		this.idList = new CSDL_ReadExcelFile(employeeSigninURL, sheetOfEmployeeLoginInfo).readOneColumn(columnIndexOfidList);
		this.passList = new CSDL_ReadExcelFile(employeeSigninURL, sheetOfEmployeeLoginInfo)
				.readOneColumn(columnIndexOfpassList);
		this.positionList = new CSDL_ReadExcelFile(employeeSigninURL, sheetOfEmployeeLoginInfo)
				.readOneColumn(columnIndexOfpositionList);
	}

	protected HashMap getLoginInfo() {
		int length = idList.length;
		this.loginInfo = new HashMap<String, String>();
		for (int i = 0; i < length; i++) {
			loginInfo.put(idList[i], passList[i]);
		}
		return loginInfo;
	}

	public String getPosition(String idKey) {
		HashMap<String, String> positionListList = new HashMap<>();
		int length = idList.length;
		for (int i = 0; i < length; i++) {
			positionListList.put(idList[i], positionList[i]);
		}
		return positionListList.get(idKey);
	}

	public static void main(String[] args) throws IOException {
		EmployeeSigninModel model = new EmployeeSigninModel("D:\\code\\subject\\Project_OOP\\FileExcel\\Cus+Staff.xlsx", 1, 1, 12,
				7);
		System.out.println(model.getLoginInfo());
		System.out.println(model.getPosition("1151010001"));
	}
}
