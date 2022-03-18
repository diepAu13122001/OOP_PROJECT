package Customer;

public class PaymentController {
	private PaymentView view;
	private PaymentModel model;

	public PaymentController(PaymentModel model) {
		this.model = model;
		this.view = new PaymentView(this, model);
		view.createView();
	}
}
