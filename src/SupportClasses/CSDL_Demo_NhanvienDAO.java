package SupportClasses;

import java.util.*;

public class CSDL_Demo_NhanvienDAO {
	private List<CSDL_NhanVien> list = new ArrayList<CSDL_NhanVien>();

	public static List<CSDL_NhanVien> listNv() {
		java.util.List<CSDL_NhanVien> list = new ArrayList<CSDL_NhanVien>();

		CSDL_NhanVien nv1 = new CSDL_NhanVien("E01", "Tom", 200.0, 1, null);
		CSDL_NhanVien nv2 = new CSDL_NhanVien("E02", "Jerry", 100.2, 2, null);
		CSDL_NhanVien nv3 = new CSDL_NhanVien("E03", "Donald", 150.0, 2, null);
		list.add(nv1);
		list.add(nv2);
		list.add(nv3);

		return list;
	}

	public void addToList(String id, String name, double salary, int grade, double bonus) {
		CSDL_NhanVien nv = new CSDL_NhanVien(id, name, salary, grade, bonus);
		this.list.add(nv);
	}

	public List<CSDL_NhanVien> getList() {
		return this.list;
	}
}
