package Store;

import java.util.*;

import Customer.Model.TypeOfPayment;
import SupportClasses.LoadDataFromExcelFile;
import SupportClasses.MyDate;
import SupportClasses.MyTime;

public class DiscountCode {
	private String maKhuyenMai; // viet in hoa het
	private ArrayList<TypeOfPayment> ptttDuocApDungMa;
	private MyDate ngayBatDau;
	private MyDate ngayKetThuc;
	private MyTime gioVangBatDau; // ma chi ap dung cho khung gio do
	private MyTime gioVangKetThuc;
	private double giaTriPhanTram;
	private int giaTriThanhTien;
	private int hoaDonToiThieu;
	private int giamToiDa;

	public DiscountCode(String maKhuyenMai, ArrayList<String> idPTTT, MyDate ngayBatDau, MyDate ngayKetThuc,
			MyTime gioVangBatDau, MyTime gioVangKetThuc, double giaTriPhanTram, int giaTriThanhTien, int hoaDonToiThieu,
			int giamToiDa) {
		LoadDataFromExcelFile load = new LoadDataFromExcelFile();
		this.maKhuyenMai = maKhuyenMai;
		this.ptttDuocApDungMa = new ArrayList<>();
		setPtttDuocApDungMa(load.convertStringToIntList(idPTTT));
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.gioVangBatDau = gioVangBatDau;
		this.gioVangKetThuc = gioVangKetThuc;
		this.giaTriPhanTram = giaTriPhanTram;
		this.giaTriThanhTien = giaTriThanhTien;
		this.hoaDonToiThieu = hoaDonToiThieu;
		this.giamToiDa = giamToiDa;
	}

	public DiscountCode() {

	}

	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public ArrayList<TypeOfPayment> getPtttDuocApDungMa() {
		return ptttDuocApDungMa;
	}

	private void setPtttDuocApDungMa(ArrayList<Integer> idList) {
		for (Integer id : idList) {
			for (TypeOfPayment type : TypeOfPayment.getTypeList()) {
				if (type.getMaLoai() == id) {
					this.ptttDuocApDungMa.add(type.getInfo());
				}
			}
		}
	}

	public MyDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(MyDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public MyDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(MyDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public MyTime getGioVangBatDau() {
		return gioVangBatDau;
	}

	public void setGioVangBatDau(MyTime gioVangBatDau) {
		this.gioVangBatDau = gioVangBatDau;
	}

	public MyTime getGioVangKetThuc() {
		return gioVangKetThuc;
	}

	public void setGioVangKetThuc(MyTime gioVangKetThuc) {
		this.gioVangKetThuc = gioVangKetThuc;
	}

	public double getGiaTriPhanTram() {
		return giaTriPhanTram;
	}

	public void setGiaTriPhanTram(double giaTriPhanTram) {
		this.giaTriPhanTram = giaTriPhanTram;
	}

	public int getGiaTriThanhTien() {
		return giaTriThanhTien;
	}

	public void setGiaTriThanhTien(int giaTriThanhTien) {
		this.giaTriThanhTien = giaTriThanhTien;
	}

	public int getHoaDonToiThieu() {
		return hoaDonToiThieu;
	}

	public void setHoaDonToiThieu(int hoaDonToiThieu) {
		this.hoaDonToiThieu = hoaDonToiThieu;
	}

	public int getGiamToiDa() {
		return giamToiDa;
	}

	public void setGiamToiDa(int giamToiDa) {
		this.giamToiDa = giamToiDa;
	}

	@Override
	public String toString() {
		return "DiscountCode [maKhuyenMai=" + maKhuyenMai + ", \nptttDuocApDungMa=" + ptttDuocApDungMa
				+ ", \nngayBatDau=" + ngayBatDau + ", \nngayKetThuc=" + ngayKetThuc + ", \ngioVangBatDau="
				+ gioVangBatDau + ", \ngioVangKetThuc=" + gioVangKetThuc + ", \ngiaTriPhanTram=" + giaTriPhanTram
				+ ", \ngiaTriThanhTien=" + giaTriThanhTien + ", \nhoaDonToiThieu=" + hoaDonToiThieu + ", \ngiamToiDa="
				+ giamToiDa + "]";
	}

}
