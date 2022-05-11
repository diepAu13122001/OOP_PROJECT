package Employee.Model;

import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

public class EmployeeHomeModel {
	private File URLList; // cach nhap duong link tu ??? (.txt or excel)

	public EmployeeHomeModel() {

	}

	// phuong thuc doc data tu bang du lieu
	public Object[][] dataTable(String URL) {
		Object[][] data = {};

		return data;
	}

	// phuong thuc doc tittle cua bang tu du lieu
	public Object[] columnNames(String URL) {
		Object[] names = {};

		return names;
	}

	// dung cho 4 bang thong ke tren dau (4 panel thong ke)
	public Object[] overviewData(HashMap<String, String> URLList, String nameOfPanel) {
		Object[] data = {};
		if (URLList.containsKey(nameOfPanel)) {
			data = transferToArr(URLList.get(nameOfPanel)).toArray();
		} else {
			data = null;
		}
		return data;
	}

	// phương thức chuyển từ file sang Obj[]
	private ArrayList<Object> transferToArr(String URL) {
		ArrayList<Object> transferDataList = null;
		// transfer (sử dụng phần excel hoặc file txt

		/*
		 * OVERVIEW DATA - File text 1. Summary: summaryTotalBillLabel: (để số vừa tìm
		 * được) summaryPercentageOfTotal: summaryTotalGain: summaryPercentGrowth:
		 * summaryLastDayTotalGain: 2. Offline: offlineTotalBillLabel: (để số vừa tìm
		 * được) offlinePercentageOfTotal: offlineTotalGain: offlinePercentGrowth:
		 * offlineLastDayTotalGain: 3. Web&Social media: webNSmTotalBillLabel: (để số
		 * vừa tìm được) webNSmPercentageOfTotal: webNSmTotalGain: webNSmPercentGrowth:
		 * webNSmLastDayTotalGain: 4. Online applications: onlAppTotalBillLabel: (để số
		 * vừa tìm được) onlAppPercentageOfTotal: onlAppTotalGain: onlAppPercentGrowth:
		 * onlAppLastDayTotalGain:
		 */
		return transferDataList;
	}
// cua cai 
	public String roundAndNumberFormat(Double a, int decimalPlaces, boolean hasCommas) {
		int n = (int) Math.pow(10, decimalPlaces);
		String numFormated = (double) Math.round(a * n) / n + "";
		int m = numFormated.indexOf(".");

		if (decimalPlaces == 0) {
			numFormated = Math.round(a * 1) / 1 + "";
		} else if (numFormated.substring(m).length() < decimalPlaces) {
			String extra0 = "";
			for (int i = 0; i < decimalPlaces - numFormated.substring(m).length(); i++) {
				extra0 += "0";
			}
			numFormated = (double) Math.round(a * n) / n + extra0;
		} else {
			numFormated = (double) Math.round(a * n) / n + "";
		}
		if (hasCommas) {
			DecimalFormat df = new DecimalFormat("###,###,###");
			String s = df.format(a);

			if (decimalPlaces > 0) {
				String newString = s.concat(numFormated.substring(m));
				return newString;
			} else
				return numFormated;
		}
		return numFormated;
	}
}
