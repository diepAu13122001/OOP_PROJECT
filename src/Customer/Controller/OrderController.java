package Customer.Controller;

import java.io.IOException;
import java.util.ArrayList;

import Customer.Model.OrderModel;
import Customer.View.OrderView;
import Customer.Model.PaymentModel;
import Menu.View.DishDetailView;
import Store.*;

public class OrderController {
	private OrderView view;
	private OrderModel model;

	public OrderController(OrderModel model) {
		this.model = model;
		this.view = new OrderView(this, model);
		view.createView();
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
