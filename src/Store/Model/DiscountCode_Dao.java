package Store.Model;

import SupportClasses.LoadDataFromExcelFile;
import SupportClasses.MyDate;
import SupportClasses.MyTime;

import java.io.IOException;
import java.util.ArrayList;

public class DiscountCode_Dao {
	private ArrayList<DiscountCode> discountList = new ArrayList<>();

	public void addItemInList(String maKhuyenMai, ArrayList<String> ptttDuocApDungMa, String gioVangBatDau,
			String ngayBatDau, String gioVangKetThuc, String ngayKetThuc, double giaTriPhanTram, int giaTriThanhTien,
			int hoaDonToiThieu, int giamToiDa) {

		DiscountCode item = new DiscountCode(maKhuyenMai, ptttDuocApDungMa,
				new MyDate().convertStringHaveSlash(ngayBatDau), new MyDate().convertStringHaveSlash(ngayKetThuc),
				new MyTime().convertStringHaveColon(gioVangBatDau), new MyTime().convertStringHaveColon(gioVangKetThuc),
				giaTriPhanTram, giaTriThanhTien, hoaDonToiThieu, giamToiDa);
		this.discountList.add(item);
	}

	public void removeItemInList(String maKhuyenMai) {
		for (DiscountCode discountCode : discountList) {
			if (discountCode.getMaKhuyenMai().equals(maKhuyenMai)) {
				discountList.remove(discountCode);
			}
		}
	}
	//update by something

	public ArrayList<DiscountCode> loadExcelDataList() throws IOException {
		LoadDataFromExcelFile load = new LoadDataFromExcelFile();
		this.discountList = load.loadDiscountData("D:\\code\\subject\\Project_OOP\\FileExcel\\HoaDon.xlsx", 31, 15, 1);
		return this.discountList;
	}

	public ArrayList<DiscountCode> getList() {
		return this.discountList;
	}
	
	public static void main(String[] args) throws IOException {
		DiscountCode_Dao dao = new DiscountCode_Dao();
		System.out.println(dao.loadExcelDataList());
	}
}
