package Customer;

import java.io.IOException;
import java.util.ArrayList;

import Menu.*;
import Store.*;
import Test.*;

public class OrderController {
	private OrderView view;
	private OrderModel model;

	public OrderController(OrderModel model) {
		this.model = model;
		this.view = new OrderView(this, model);
		view.createView();
	}

	public void openPaymentView() {
		view.dispose();
		PaymentModel paymentModel = new PaymentModel();
		new PaymentController(paymentModel);
	}

	public void openDishDetailView() {
		DishDetailView dishDetailView = new DishDetailView();
		dishDetailView.createView();
	}

	public void backHome() {
		view.dispose();
		new MainHomeController();
	}

	public ArrayList<String[]> getComBoList() {
		return this.model.getComboList();
	}

	public static void main(String[] args) throws IOException {
		OrderModel model = new OrderModel();
		OrderController controller = new OrderController(model);
	}

}
