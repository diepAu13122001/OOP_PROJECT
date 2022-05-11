package Menu.Model;

public class PriceByUnit {
	private String donViTinh;
	private String gia;
	private String[] giaTheoDVT;

	public PriceByUnit() {
		this.giaTheoDVT = new String[2];
	}

	public PriceByUnit(String donViTinh, String gia) {
		this.giaTheoDVT = new String[2];
		this.donViTinh = donViTinh;
		this.gia = gia;
		setGiaTheoDVT(donViTinh, gia);
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String[] getGiaTheoDVT() {
		return this.giaTheoDVT;
	}

	public void setGiaTheoDVT(String donViTinh, String gia) {
		setDonViTinh(donViTinh);
		setGia(gia);
		this.giaTheoDVT = new String[] { getDonViTinh(), getGia() };
	}
}
