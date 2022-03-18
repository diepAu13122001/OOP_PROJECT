package Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;

public class OrderView extends JFrame implements ActionListener {
	private OrderModel model;
	private OrderController controller;

	private JScrollPane billTableScrollPane;
	private JTable billTable;
	private JPanel buttonsGroupPanel;
	private JButton cancelButton;
	private JPanel coffeePanel;
	private JPanel coffeeParentPanel;
	private JScrollPane coffeeScrollPane;
	private JPanel coldDrinksParentPanel;
	private JPanel coldPanel;
	private JScrollPane coldScrollPane;
	private JPanel comboPanel;
	private JPanel comboParentPanel;
	private JScrollPane comboScrollPane;
	private JPanel dealPanel;
	private JScrollPane dealScrollPane;
	private JPanel dessertPanel;
	private JScrollPane dessertScrollPane;
	private JPanel dessertsParentPanel;
	private JPanel firedFoodsParentPanel;
	private JPanel firedPanel;
	private JScrollPane firedScrollPane;
	private JPanel hotDealParentPanel;
	private JPanel mainDishesParentPanel;
	private JPanel mainPanel;
	private JScrollPane mainScrollPane;
	private JTabbedPane menuTable;
	private JButton paymentButton;
	private JPanel teaPanel;
	private JPanel teaParentPanel;
	private JScrollPane teaScrollPane;
	private JPanel billParentPanel;

	public OrderView(OrderController controller, OrderModel model) {
		this.controller = controller;
		this.model = model;
	}

	public void createView() {
		// create frame
		ImageIcon appLogo = new ImageIcon("logoCircle100.png");
		setIconImage(appLogo.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Order view");
		setBounds(0, 0, 1380, 770);
		getContentPane().setLayout(null);

		// create hot deals panel
		hotDealParentPanel = new JPanel();
		hotDealParentPanel.setBackground(new Color(255, 255, 255));
		hotDealParentPanel.setName("Hot deal");

		dealPanel = new JPanel();
		dealPanel.setBackground(new Color(255, 255, 255));
		dealPanel.setLayout(new FlowLayout(0, 15, 15));
		dealPanel.setPreferredSize(new Dimension(850, 100000));

		dealScrollPane = new JScrollPane();
		dealScrollPane.setViewportView(dealPanel);

		createHotDealPanel();

		// create combo panel
		comboParentPanel = new JPanel();
		comboParentPanel.setBackground(new Color(255, 255, 255));
		comboParentPanel.setName("Combo");

		comboPanel = new JPanel();
		comboPanel.setBackground(new Color(255, 255, 255));
		comboPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		comboScrollPane = new JScrollPane();
		comboScrollPane.setViewportView(comboPanel);
		createComboPanel();

		// create main dishes panel
		mainDishesParentPanel = new JPanel();
		mainDishesParentPanel.setBackground(new Color(255, 255, 255));
		mainDishesParentPanel.setName("Main dishes");

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		mainScrollPane = new JScrollPane();
		mainScrollPane.setViewportView(mainPanel);
		createMainDishPanel();

		// create fired foods panel
		firedFoodsParentPanel = new JPanel();
		firedFoodsParentPanel.setBackground(new Color(255, 255, 255));
		firedFoodsParentPanel.setName("Fired foods");

		firedPanel = new JPanel();
		firedPanel.setBackground(new Color(255, 255, 255));
		firedPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		firedScrollPane = new JScrollPane();
		firedScrollPane.setViewportView(firedPanel);
		createFiredFoodPanel();

		// create desserts panel
		dessertsParentPanel = new JPanel();
		dessertsParentPanel.setBackground(new Color(255, 255, 255));
		dessertsParentPanel.setName("Desserts");

		dessertPanel = new JPanel();
		dessertPanel.setBackground(new Color(255, 255, 255));
		dessertPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		dessertScrollPane = new JScrollPane();
		dessertScrollPane.setViewportView(dessertPanel);
		createDessertPanel();

		// create cold drinks panel
		coldDrinksParentPanel = new JPanel();
		coldDrinksParentPanel.setBackground(new Color(255, 255, 255));
		coldDrinksParentPanel.setName("Cold drinks");

		coldScrollPane = new JScrollPane();

		coldPanel = new JPanel();
		coldPanel.setBackground(new Color(255, 255, 255));
		coldPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		coldScrollPane.setViewportView(coldPanel);
		createColdDrinkPanel();

		// create tea panel
		teaParentPanel = new JPanel();
		teaParentPanel.setBackground(new Color(255, 255, 255));
		teaParentPanel.setName("Tea");

		teaScrollPane = new JScrollPane();

		teaPanel = new JPanel();
		teaPanel.setBackground(new Color(255, 255, 255));
		teaPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		teaScrollPane.setViewportView(teaPanel);
		createTeaPanel();

		// create coffee panel
		coffeeParentPanel = new JPanel();
		coffeeParentPanel.setBackground(new Color(255, 255, 255));
		coffeeParentPanel.setName("Coffee");

		coffeeScrollPane = new JScrollPane();

		coffeePanel = new JPanel();
		coffeePanel.setBackground(new Color(255, 255, 255));
		coffeePanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		coffeeScrollPane.setViewportView(coffeePanel);
		createCoffeePanel();

		// create an menu table pane
		menuTable = new JTabbedPane();
		menuTable.setBackground(new Color(255, 204, 204));
		menuTable.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		menuTable.setFont(new Font("Segoe UI", 1, 24));
		menuTable.addTab("Hot deal", hotDealParentPanel);
		menuTable.addTab("Combo", comboParentPanel);
		menuTable.addTab("Main dishes", mainDishesParentPanel);
		menuTable.addTab("Fired foods", firedFoodsParentPanel);
		menuTable.addTab("Desserts", dessertsParentPanel);
		menuTable.addTab("Cold drinks", coldDrinksParentPanel);
		menuTable.addTab("Tea", teaParentPanel);
		menuTable.addTab("Coffee", coffeeParentPanel);

		menuTable.setBounds(0, 0, 900, 740);

		// create bill showing table
		billParentPanel = new JPanel();
		billParentPanel.setBackground(new Color(225, 225, 225));
		billParentPanel.setBounds(900, 0, 470, 590);
		billParentPanel.setLayout(new FlowLayout(1, 1, 1));

		billTable = new JTable();
		billTable.setFont(new Font("Segoe UI", 0, 24));
		setupBillTable();

		billTableScrollPane = new JScrollPane();
		billTableScrollPane.setViewportView(billTable);

		billParentPanel.add(billTableScrollPane);

		// create button payment
		paymentButton = new JButton();
		paymentButton.setBackground(new Color(255, 204, 204));
		paymentButton.setFont(new Font("Segoe UI", 1, 30));
		paymentButton.setForeground(new Color(51, 51, 255));
		paymentButton.setText("Payment");
		paymentButton.setFocusable(false);
		paymentButton.addActionListener(this);

		// create button cancel (delete bill)
		cancelButton = new JButton();
		cancelButton.setBackground(new Color(204, 204, 255));
		cancelButton.setFont(new Font("Segoe UI", 1, 30));
		cancelButton.setText("Cancel");
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(this);

		// create panel contains buttons
		buttonsGroupPanel = new JPanel();
		buttonsGroupPanel.setBackground(new Color(255, 255, 255));
		buttonsGroupPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		buttonsGroupPanel.setBounds(910, 600, 450, 130);
		setUpButtonGroupLayout();

		// add in frame
		getContentPane().add(menuTable);
		getContentPane().add(billParentPanel);
		getContentPane().add(buttonsGroupPanel);
		addItemInComboList();
		setVisible(true);
	}

	private void createHotDealPanel() {
		GroupLayout hotDealParentPanelLayout = new GroupLayout(hotDealParentPanel);
		hotDealParentPanel.setLayout(hotDealParentPanelLayout);
		hotDealParentPanelLayout
				.setHorizontalGroup(hotDealParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(dealScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		hotDealParentPanelLayout
				.setVerticalGroup(hotDealParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(dealScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createComboPanel() {
		GroupLayout comboParentPanelLayout = new GroupLayout(comboParentPanel);
		comboParentPanel.setLayout(comboParentPanelLayout);
		comboParentPanelLayout
				.setHorizontalGroup(comboParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(comboScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		comboParentPanelLayout
				.setVerticalGroup(comboParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(comboScrollPane, GroupLayout.PREFERRED_SIZE, 724, GroupLayout.PREFERRED_SIZE));

	}

	private void createMainDishPanel() {
		GroupLayout mainDishesParentPanelLayout = new GroupLayout(mainDishesParentPanel);
		mainDishesParentPanel.setLayout(mainDishesParentPanelLayout);
		mainDishesParentPanelLayout
				.setHorizontalGroup(mainDishesParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		mainDishesParentPanelLayout
				.setVerticalGroup(mainDishesParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createFiredFoodPanel() {
		GroupLayout firedFoodsParentPanelLayout = new GroupLayout(firedFoodsParentPanel);
		firedFoodsParentPanel.setLayout(firedFoodsParentPanelLayout);
		firedFoodsParentPanelLayout
				.setHorizontalGroup(firedFoodsParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(firedScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		firedFoodsParentPanelLayout
				.setVerticalGroup(firedFoodsParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(firedScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createDessertPanel() {
		GroupLayout dessertsParentPanelLayout = new GroupLayout(dessertsParentPanel);
		dessertsParentPanel.setLayout(dessertsParentPanelLayout);
		dessertsParentPanelLayout
				.setHorizontalGroup(dessertsParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(dessertScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		dessertsParentPanelLayout
				.setVerticalGroup(dessertsParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(dessertScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createColdDrinkPanel() {
		GroupLayout coldDrinksParentPanelLayout = new GroupLayout(coldDrinksParentPanel);
		coldDrinksParentPanel.setLayout(coldDrinksParentPanelLayout);
		coldDrinksParentPanelLayout
				.setHorizontalGroup(coldDrinksParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(coldScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		coldDrinksParentPanelLayout
				.setVerticalGroup(coldDrinksParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(coldScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createTeaPanel() {
		GroupLayout teaParentPanelLayout = new GroupLayout(teaParentPanel);
		teaParentPanel.setLayout(teaParentPanelLayout);
		teaParentPanelLayout.setHorizontalGroup(teaParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(teaScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		teaParentPanelLayout.setVerticalGroup(teaParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(teaScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void createCoffeePanel() {
		GroupLayout coffeeParentPanelLayout = new GroupLayout(coffeeParentPanel);
		coffeeParentPanel.setLayout(coffeeParentPanelLayout);
		coffeeParentPanelLayout
				.setHorizontalGroup(coffeeParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(coffeeScrollPane, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE));
		coffeeParentPanelLayout
				.setVerticalGroup(coffeeParentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(coffeeScrollPane, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE));

	}

	private void setUpButtonGroupLayout() {
		GroupLayout buttonsGroupPanelLayout = new GroupLayout(buttonsGroupPanel);
		buttonsGroupPanel.setLayout(buttonsGroupPanelLayout);
		buttonsGroupPanelLayout
				.setHorizontalGroup(buttonsGroupPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGroup(buttonsGroupPanelLayout.createSequentialGroup().addContainerGap(20, 20)
								.addComponent(paymentButton, 200, 200, 200).addGap(25, 25, 25)
								.addComponent(cancelButton, 200, 200, 200).addGap(25, 25, 25)));
		buttonsGroupPanelLayout.setVerticalGroup(buttonsGroupPanelLayout
				.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addGroup(buttonsGroupPanelLayout.createSequentialGroup().addContainerGap(30, 30)
						.addGroup(buttonsGroupPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(paymentButton, 100, 100, 100).addComponent(cancelButton, 100, 100, 100))
						.addGap(20, 20, 20)));
	}

	private void setupBillTable() {

		billTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Food name", "Qty", "Price" }) {
			Class[] types = new Class[] { String.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		billTable.setPreferredScrollableViewportSize(new Dimension(440, 560));
	}

	private JPanel createNewDish(String nameOfDish, String price, String imgURL) {
		JPanel dishPanel = new JPanel();
		JLabel imageOfDish1 = new JLabel();
		JLabel nameOfDish1 = new JLabel();
		JLabel priceOfDish1 = new JLabel();

		dishPanel.setBackground(new Color(255, 255, 255));
		dishPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		dishPanel.setPreferredSize(new Dimension(200, 200));

		imageOfDish1.setOpaque(true);
		

		nameOfDish1.setFont(new Font("Segoe UI", 1, 14));
		nameOfDish1.setHorizontalAlignment(SwingConstants.CENTER);
		nameOfDish1.setText(nameOfDish);

		priceOfDish1.setFont(new Font("Segoe UI", 1, 18));
		priceOfDish1.setHorizontalAlignment(SwingConstants.CENTER);
		priceOfDish1.setText(price);

		GroupLayout dishPanelLayout = new GroupLayout(dishPanel);
		dishPanel.setLayout(dishPanelLayout);
		dishPanelLayout.setHorizontalGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(nameOfDish1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(priceOfDish1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(imageOfDish1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		dishPanelLayout.setVerticalGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(dishPanelLayout.createSequentialGroup()
						.addComponent(imageOfDish1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nameOfDish1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(priceOfDish1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)));

		return dishPanel;
	}

	public void addADish(String typeOfFood, String nameOfDish, String price, String imgURL) {
		if (typeOfFood.equals(hotDealParentPanel.getName())) {
			dealPanel.add(createNewDish(nameOfDish, price, imgURL));
		}
		if (typeOfFood.equals(comboParentPanel.getName())) {
			comboPanel.add(createNewDish(nameOfDish, price, imgURL),"wrap");
		}
		if (typeOfFood.equals(mainDishesParentPanel.getName())) {
			mainPanel.add(createNewDish(nameOfDish, price, imgURL));
		}
		if (typeOfFood.equals(firedFoodsParentPanel.getName())) {
			firedPanel.add(createNewDish(nameOfDish, price, imgURL));
		}
		if (typeOfFood.equals(dessertsParentPanel.getName())) {
			dessertPanel.add(createNewDish(nameOfDish, price, imgURL));
		}
		if (typeOfFood.equals(coldDrinksParentPanel.getName())) {
			coldPanel.add(createNewDish(nameOfDish, price, imgURL));
		}
		if (typeOfFood.equals(teaParentPanel.getName())) {
			teaPanel.add(createNewDish(nameOfDish, price, imgURL),"wrap");
		}
		if (typeOfFood.equals(coffeeParentPanel.getName())) {
			coffeePanel.add(createNewDish(nameOfDish, price, imgURL));
		}
	}

	public void addDataForBillTable(String foodName, int qty, int price) {
		Object data[] = { foodName, qty, price };
		DefaultTableModel tbModel = (DefaultTableModel) this.billTable.getModel();
		tbModel.addRow(data);
	}

	public void addItemInComboList () {
		for (String[] data : this.model.getComboList()) {
			addADish(data[0], data[1], data[2], data[3]);
		}
	}
	public ArrayList<String[]> getComboList (){
		return this.model.getComboList();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == paymentButton) {
			dispose();
			PaymentModel paymentModel = new PaymentModel();
			PaymentController paymentController = new PaymentController(paymentModel);
//			controller.openPaymentView();
		}
		if (e.getSource() == cancelButton) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this order?", "Message!",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				controller.backHome();
			}
		}
	}
}
