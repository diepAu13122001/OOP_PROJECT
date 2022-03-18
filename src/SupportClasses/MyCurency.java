package SupportClasses;

import java.text.NumberFormat;
import java.util.Locale;

// is for vnd
public class MyCurency {
	private String result;

	public MyCurency(int amount) {
		Locale vietNam = new Locale("vi", "VN");
		NumberFormat vneseFormat = NumberFormat.getCurrencyInstance(vietNam);
		this.result = vneseFormat.format(amount);
	}

	public String getResult() {
		return result;
	}

	public static void main(String[] args) {
		MyCurency c = new MyCurency(30000);

		System.out.println(c.getResult());
	}
}
