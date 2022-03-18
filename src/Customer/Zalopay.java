package Customer;

public class Zalopay extends TypeOfPayment {

	private String QRCodePicURL;

	public Zalopay(String qRCodePicURL) {
		super(2, "ZaloPay", false, null);
		QRCodePicURL = qRCodePicURL;
		setXuatHoaDon(new Bill());
	}

	public Zalopay() {

	}

	public String getQRCodePicURL() {
		return QRCodePicURL;
	}

	public void setQRCodePicURL(String qRCodePicURL) {
		QRCodePicURL = qRCodePicURL;
	}

	@Override
	public void setXuatHoaDon(Bill xuatHoaDon) {
		this.xuatHoaDon = new Bill();
		// TODO
	}

	@Override
	public TypeOfPayment getInfo() {
		return new Zalopay(this.QRCodePicURL);
	}

	@Override
	public void setMaLoai() {
		this.maLoai = 2;
	}

}
