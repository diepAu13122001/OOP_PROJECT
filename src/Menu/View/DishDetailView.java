package Menu.View;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Customer.Controller.OrderController;
import Customer.Model.OrderModel;
import Menu.Controller.DishDetailController;
import Menu.Model.DishDetailModel;

import java.util.*;

public class DishDetailView extends JFrame {
	private DishDetailModel model;
	private DishDetailController controller;

	private JScrollPane jScrollPane;
	private JPanel leftPanel;
	private JPanel rightPanel;

	public DishDetailView(DishDetailController controller, DishDetailModel model) {
		this.model = model;
		this.controller = controller;
	}

	public void createView() {
		// left panel
		setupLeftPanel();

		// right panel
		setupRightPanel();

		// set up frame
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
		getContentPane().add(jScrollPane);
		getContentPane().add(rightPanel);

		setVisible(true);
		pack();
	}

	private void setupLeftPanel() {
		jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setPreferredSize(new Dimension(650, 500));

		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		leftPanel.setPreferredSize(new Dimension(650, 500));
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		jScrollPane.setViewportView(leftPanel);

		// chuyen sang model va controller
//		HashMap<String, Integer> sizeOptionList = new HashMap<>();
//		sizeOptionList.put("380ml", 42000);
//		sizeOptionList.put("500ml", 50000);
//		addOptionSet("Size", sizeOptionList, true, false);
//
//		HashMap<String, Integer> toppingOptionlist = new HashMap<>();
//		toppingOptionlist.put("Tran chau trang", 15000);
//		toppingOptionlist.put("Tran chau den", 15000);
//		toppingOptionlist.put("Tran chau pho mai", 15000);
//		toppingOptionlist.put("Tran chau hoang kim", 15000);
//		toppingOptionlist.put("Tran chau socola", 15000);
//		toppingOptionlist.put("Tran chau trang", 17000);
//		addOptionSet("Topping", toppingOptionlist, true, true);
	}

	private void addAnOption(String optionName, boolean isCheckBox, ButtonGroup group) {
		AbstractButton option = null;
		if (isCheckBox) {
			option = new JCheckBox(optionName);
		} else {
			option = new JRadioButton(optionName);
			group.add(option);
		}
		option.setFocusable(false);
		option.setBackground(new Color(255, 255, 255));
		option.setFont(new Font("Segoe UI", 0, 14));
		option.setForeground(new Color(153, 153, 153));
		option.setPreferredSize(new Dimension(450, 30));
		leftPanel.setPreferredSize(reSizePanel(leftPanel.getPreferredSize().height, leftPanel.getPreferredSize().width,
				0, option.getPreferredSize().height));
		leftPanel.add(option);
	}

	private void addPriceOfAnOption(int price) {
		JLabel priceLabel = new JLabel("+" + price + " ");
		priceLabel.setFont(new Font("Segoe UI", 1, 14));
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setPreferredSize(new Dimension(120, 30));
		leftPanel.add(priceLabel);
	}

	private Dimension reSizePanel(int panelHeight, int panelWidth, int extraWidth, int extraHeight) {
		int width = panelWidth + extraWidth;
		int height = panelHeight + extraHeight;
		return new Dimension(width, height);
	}

	private void addOptionHeaderPanel(String optionName, boolean isObligator) {
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(590, 35));
		header.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel headerName = new JLabel(optionName);
		headerName.setFont(new Font("Segoe UI", 1, 18));
		headerName.setText("Size");
		header.add(headerName);

		if (isObligator) {
			JLabel obligatorLB = new JLabel("Obligator");
			obligatorLB.setFont(new Font("Segoe UI", 0, 12));
			obligatorLB.setForeground(Color.RED);
			header.add(obligatorLB);
		}
		leftPanel.setPreferredSize(reSizePanel(leftPanel.getPreferredSize().height, leftPanel.getPreferredSize().width,
				0, header.getPreferredSize().height));
		leftPanel.add(header);
	}

	public void addOptionSet(String name, Map<String, Integer> optionList, boolean isObligator, boolean isCheckBox) {
		ButtonGroup group = new ButtonGroup();
		addOptionHeaderPanel(name, isObligator);
		for (String nameOfOption : optionList.keySet()) {
			addAnOption(nameOfOption, isCheckBox, group);
			addPriceOfAnOption(optionList.get(nameOfOption));
		}
	}

	private void setupRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 255, 255));
		rightPanel.setPreferredSize(new Dimension(350, 500));
		FlowLayout rightLayout = new FlowLayout(FlowLayout.CENTER, 10, 7);
		rightLayout.setAlignOnBaseline(true);
		rightPanel.setLayout(rightLayout);

		JScrollPane nameOfFoodPane = new JScrollPane();
		nameOfFoodPane.setBackground(new Color(255, 255, 255));
		nameOfFoodPane.setBorder(null);
		nameOfFoodPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nameOfFoodPane.setFont(new Font("Segoe UI", 1, 24));
		nameOfFoodPane.setOpaque(false);
		nameOfFoodPane.setPreferredSize(new Dimension(220, 70));

		JTextArea nameTextArea = new JTextArea(5, 30);
		nameTextArea.setEditable(false);
		nameTextArea.setFont(new Font("Segoe UI", 1, 24));
		nameTextArea.setForeground(Color.red);
		nameTextArea.setLineWrap(true);
		nameTextArea.setText("Name of the food");
		nameTextArea.setWrapStyleWord(true);
		nameTextArea.setPreferredSize(new Dimension(220, 70));
		nameTextArea.setSize(220, 70);
		nameOfFoodPane.setViewportView(nameTextArea);

		rightPanel.add(nameOfFoodPane);

		JLabel prcie = new JLabel();
		prcie.setFont(new Font("Segoe UI", 0, 18));
		prcie.setHorizontalAlignment(SwingConstants.RIGHT);
		prcie.setText("00.000   ");
		prcie.setPreferredSize(new Dimension(100, 25));
		rightPanel.add(prcie);

		JScrollPane choiceListPane = new JScrollPane();
		choiceListPane.setFont(new Font("Segoe UI", 0, 18));
		choiceListPane.setInheritsPopupMenu(true);
		choiceListPane.setPreferredSize(new Dimension(330, 280));

		HashMap<String, Integer> toppinglist = new HashMap<>();
		toppinglist.put("Tran chau trang", 15000);
		toppinglist.put("Tran chau den", 15000);
		toppinglist.put("Tran chau pho mai", 15000);
		toppinglist.put("Tran chau hoang kim", 15000);
		toppinglist.put("Tran chau socola", 15000);
		toppinglist.put("Tran chau trang", 17000);
		choiceListPane.setViewportView(itemListInRP(toppinglist));

		rightPanel.add(choiceListPane);

		JSpinner qtyChoosing = new JSpinner();
		qtyChoosing.setFont(new Font("Segoe UI", 1, 18));
		qtyChoosing.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		qtyChoosing.setPreferredSize(new Dimension(105, 35));
		rightPanel.add(qtyChoosing);

		JLabel totalPriceLabel = new JLabel();
		totalPriceLabel.setFont(new Font("Segoe UI", 1, 18));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPriceLabel.setText("total price   ");
		totalPriceLabel.setPreferredSize(new Dimension(215, 35));
		rightPanel.add(totalPriceLabel);

		JButton cancelButton = new JButton();
		cancelButton.setText("Cancel");
		cancelButton.setFont(new Font("Segoe UI", 1, 20));
		cancelButton.setPreferredSize(new Dimension(125, 65));
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					cancelButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		rightPanel.add(cancelButton);

		JButton addButton = new JButton();
		addButton.setText("Add the dish");
		addButton.setFont(new Font("Segoe UI", 1, 20));
		addButton.setPreferredSize(new Dimension(195, 65));
		addButton.setBackground(new Color(255, 204, 204));
		addButton.setFocusable(false);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});
		rightPanel.add(addButton);
	}

	public JList<String> itemListInRP(HashMap<String, Integer> toppingList) {
		String[] item = new String[toppingList.size()];
		JList<String> itemList = new JList<>();
		int a = 0;
		for (String i : toppingList.keySet()) {
			item[a] = i + "   " + toppingList.get(i);
			a++;
		}
		itemList.setModel(new AbstractListModel<String>() {

			String[] strings = item;

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		itemList.setPreferredSize(new Dimension(330, 280));
		itemList.setFont(new Font("Segoe UI", 0, 16));

		return itemList;
	}

	public void cancelButtonActionPerformed(ActionEvent e) throws IOException {
		OrderModel orderModel = new OrderModel();
		new OrderController(orderModel);
		dispose();
	}

	public void addButtonActionPerformed(ActionEvent e) {

	}

}
