package Customer;

import java.util.*;

public abstract class TypeOfPayment {
	protected int maLoai;
	protected String tenLoai;
// subclass has way to pay (scan QR code, input code - voucher, input card info, or input amount need to pay by cash)
	protected boolean thanhCong;
	protected Bill xuatHoaDon; // create file txt -> bill

	public TypeOfPayment(int maLoai, String tenLoai, boolean thanhCong, Bill exportBill) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.thanhCong = thanhCong;
		this.xuatHoaDon = exportBill;
	}

	public TypeOfPayment() {

	}

	public int getMaLoai() {
		setMaLoai();
		return maLoai;
	}

	public abstract void setMaLoai();

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public boolean getTrangThai() {
		return thanhCong;
	}

	public void setDaThanhCong() {
		this.thanhCong = true;
	}

	public Bill getXuatHoaDon() {
		return xuatHoaDon;
	}

	public abstract void setXuatHoaDon(Bill xuatHoaDon);

	public abstract TypeOfPayment getInfo();
	
	public static List<TypeOfPayment> getTypeList (){
		List<TypeOfPayment> list = new ArrayList<>();
		list.add(new Zalopay());
		return list;
	}

	@Override
	public String toString() {
		return "TypeOfPayment [maLoai=" + maLoai + ", \ntenLoai=" + tenLoai + ", \nthanhCong=" + thanhCong
				+ ", \nxuatHoaDon=" + xuatHoaDon + "]";
	}

//	public static void main(String[] args) {
//		TypeOfPayment zalopay = new Zalopay("dfds");
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		System.out.println(zalopay.getList(list));
//	}
	
	
}
