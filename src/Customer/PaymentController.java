package Customer;

public class PaymentController {
	private PaymentView view;
	private PaymentModel model;

	public PaymentController(PaymentModel model) {
		this.model = model;
		this.view = new PaymentView(this, model);
		view.createView();
	}

	public static void main(String[] args) {
		PaymentModel model = new PaymentModel();
		PaymentController p = new PaymentController(model);
	}
}
