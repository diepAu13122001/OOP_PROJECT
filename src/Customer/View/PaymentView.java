package Customer.View;

import javax.swing.*;

import Customer.Controller.OrderController;
import Customer.Controller.PaymentController;
import Customer.Model.OrderModel;
import Customer.Model.PaymentModel;
import Store.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentView extends JFrame implements ActionListener {
	private PaymentController controller;
	private PaymentModel model;

	private JPanel HeaderPanel;
	private JLayeredPane PaymentLayeredPane;
	private JPanel PaymentMethodPanel1;
	private JPanel PaymentMethodPanel2;
	private JButton airpayButton;
	private JPanel billParentPanel;
	private JScrollPane billScrollPane;
	private JButton cashButton;
	private JLabel discountLabel;
	private JList<String> discountList;
	private JLabel discountTitle;
	private JPanel discountnMemberPart;
	private JButton exitButton;
	private JScrollPane discountScrollPane;
	private JTextField memberCodeField;
	private JLabel memberTitle;
	private JButton mocaButton;
	private JButton momoButton;
	private JButton nextButton;
	private JLabel numOfDiseshLabel;
	private JButton otherCardButton;
	private JTextField pointEnterField;
	private JLabel pointLabel;
	private JLabel pointTitle;
	private JButton previousButton;
	private JLabel subtotalLabel;
	private JLabel subtotalTitle;
	private JLabel timeNdateLabel;
	private JLabel totalLabel;
	private JLabel totalTitle;
	private JButton usePointButton;
	private JButton visaCardButton;
	private JButton voucherOffButton;
	private JButton voucherOnlButton;
	private JButton zalopayButton;

	public PaymentView(PaymentController controller, PaymentModel model) {
		this.model = model;
		this.controller = controller;
	}

	public void createView() {
		// header panel
		HeaderPanel = new JPanel();
		timeNdateLabel = new JLabel();
		exitButton = new JButton();
		HeaderPanel.setBackground(new Color(255, 204, 204));

		timeNdateLabel.setFont(new Font("Segoe UI", 1, 14));
		timeNdateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeNdateLabel.setText("hh:mm:ss  dd/mm/yyyy");

		exitButton.setBackground(new Color(255, 204, 204));
		exitButton.setIcon(new ImageIcon("src/icons8_cancel_24px.png"));
		exitButton.setBorderPainted(false);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);

		GroupLayout HeaderPanelLayout = new GroupLayout(HeaderPanel);
		HeaderPanel.setLayout(HeaderPanelLayout);
		HeaderPanelLayout.setHorizontalGroup(HeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(HeaderPanelLayout.createSequentialGroup().addContainerGap().addComponent(timeNdateLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)));
		HeaderPanelLayout.setVerticalGroup(HeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						HeaderPanelLayout.createSequentialGroup().addGap(7, 7, 7)
								.addComponent(timeNdateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap())
				.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		// bill showing panel
		billScrollPane = new JScrollPane();
		billParentPanel = new JPanel();
		billParentPanel.setBackground(new Color(255, 255, 255));
		billParentPanel.setPreferredSize(new Dimension(650, 100));
		billParentPanel.setLayout(new FlowLayout());
		billScrollPane.setViewportView(billParentPanel);

		// subtotal
		subtotalTitle = new JLabel();
		numOfDiseshLabel = new JLabel();
		subtotalLabel = new JLabel();
		subtotalTitle.setFont(new Font("Segoe UI", 1, 24));
		subtotalTitle.setForeground(new Color(255, 102, 102));
		subtotalTitle.setText("Subtotal:");

		numOfDiseshLabel.setFont(new Font("Segoe UI", 0, 18));
		numOfDiseshLabel.setForeground(new Color(153, 153, 153));
		numOfDiseshLabel.setText("xx dishes");

		subtotalLabel.setFont(new Font("Segoe UI", 1, 24));
		subtotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtotalLabel.setText("000.000   ");

		// member panel
		memberTitle = new JLabel();
		discountnMemberPart = new JPanel();
		memberCodeField = new JTextField();
		pointTitle = new JLabel();
		pointLabel = new JLabel();
		pointEnterField = new JTextField();
		usePointButton = new JButton();
		discountScrollPane = new JScrollPane();
		discountList = new JList<>();
		discountTitle = new JLabel();
		discountLabel = new JLabel();
		totalTitle = new JLabel();
		totalLabel = new JLabel();
		discountnMemberPart.setBackground(new Color(255, 255, 255));
		discountnMemberPart.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		memberTitle.setBackground(new Color(255, 255, 255));
		memberTitle.setFont(new Font("Segoe UI", 1, 18));
		memberTitle.setForeground(new Color(255, 51, 102));
		memberTitle.setText("Enter your member code here:");
		memberTitle.setPreferredSize(new Dimension(323, 25));
		discountnMemberPart.add(memberTitle);

		memberCodeField.setFont(new Font("Segoe UI", 1, 18));
		memberCodeField.setPreferredSize(new Dimension(323, 50));

		discountnMemberPart.add(memberCodeField);

		pointTitle.setFont(new Font("Segoe UI", 0, 18));
		pointTitle.setText("Your points:");
		pointTitle.setPreferredSize(new Dimension(158, 35));
		discountnMemberPart.add(pointTitle);

		pointLabel.setFont(new Font("Segoe UI", 1, 18));
		pointLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pointLabel.setText("000p   ");
		pointLabel.setPreferredSize(new Dimension(155, 35));
		discountnMemberPart.add(pointLabel);

		pointEnterField.setFont(new Font("Segoe UI", 0, 14));
		pointEnterField.setForeground(new Color(153, 153, 153));
		pointEnterField.setText("Enter amount of points to use");
		pointEnterField.setPreferredSize(new Dimension(195, 40));

		discountnMemberPart.add(pointEnterField);

		usePointButton.setBackground(new Color(255, 204, 204));
		usePointButton.setFont(new Font("Segoe UI", 1, 14));
		usePointButton.setText("Use points");
		usePointButton.setPreferredSize(new Dimension(122, 40));
		discountnMemberPart.add(usePointButton);

		discountList.setFont(new Font("Segoe UI", 0, 14));
		discountList.setModel(new AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		discountList.setPreferredSize(new Dimension(300, 212));
		discountScrollPane.setViewportView(discountList);

		discountnMemberPart.add(discountScrollPane);

		discountTitle.setFont(new Font("Segoe UI", 0, 14));
		discountTitle.setText("Discounts:");
		discountTitle.setPreferredSize(new Dimension(113, 35));
		discountnMemberPart.add(discountTitle);

		discountLabel.setFont(new Font("Segoe UI", 1, 14));
		discountLabel.setForeground(new Color(204, 0, 0));
		discountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		discountLabel.setText("- 00.000  ");
		discountLabel.setPreferredSize(new Dimension(200, 35));
		discountnMemberPart.add(discountLabel);

		totalTitle.setFont(new Font("Segoe UI", 1, 24));
		totalTitle.setForeground(new Color(255, 102, 102));
		totalTitle.setText("Total:");
		totalTitle.setPreferredSize(new Dimension(113, 35));
		discountnMemberPart.add(totalTitle);

		totalLabel.setFont(new Font("Segoe UI", 1, 24));
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setText("000.000  ");
		totalLabel.setPreferredSize(new Dimension(200, 35));
		discountnMemberPart.add(totalLabel);

		// payment method buttons
		previousButton = new JButton();
		previousButton.setEnabled(false);
		previousButton.setFocusable(false);
		previousButton.setBackground(new Color(255, 255, 255));
		previousButton.setFont(new Font("Segoe UI", 0, 18));
		previousButton.setIcon(new ImageIcon("icons8_back_26px.png"));
		previousButton.setText("Previous");
		previousButton.setHorizontalAlignment(SwingConstants.LEFT);
		previousButton.addActionListener(this);

		nextButton = new JButton();
		nextButton.setFocusable(false);
		nextButton.setBackground(new Color(204, 204, 255));
		nextButton.setFont(new Font("Segoe UI", 0, 18));
		nextButton.setIcon(new ImageIcon("icons8_more_than_30px.png"));
		nextButton.setText("Next");
		nextButton.setHorizontalAlignment(SwingConstants.RIGHT);
		nextButton.setHorizontalTextPosition(SwingConstants.LEADING);
		nextButton.addActionListener(this);

		PaymentLayeredPane = new JLayeredPane();
		PaymentLayeredPane.setLayout(new CardLayout());

		PaymentMethodPanel1 = new JPanel();
		PaymentMethodPanel1.setBackground(new Color(255, 255, 255));
		PaymentMethodPanel1.setPreferredSize(new Dimension(298, 450));
		PaymentMethodPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		cashButton = new JButton();
		cashButton.setFocusable(false);
		cashButton.setFont(new Font("Segoe UI", 0, 24));
		cashButton.setText("cash");
		cashButton.setPreferredSize(new Dimension(250, 60));
		cashButton.addActionListener(this);
		PaymentMethodPanel1.add(cashButton);

		momoButton = new JButton();
		momoButton.setFocusable(false);
		momoButton.setFont(new Font("Segoe UI", 0, 24));
		momoButton.setText("momo");
		momoButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel1.add(momoButton);

		zalopayButton = new JButton();
		zalopayButton.setFocusable(false);
		zalopayButton.setFont(new Font("Segoe UI", 0, 24));
		zalopayButton.setText("zalopay");
		zalopayButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel1.add(zalopayButton);

		airpayButton = new JButton();
		airpayButton.setFocusable(false);
		airpayButton.setFont(new Font("Segoe UI", 0, 24));
		airpayButton.setText("airpay");
		airpayButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel1.add(airpayButton);

		mocaButton = new JButton();
		mocaButton.setFocusable(false);
		mocaButton.setFont(new Font("Segoe UI", 0, 24));
		mocaButton.setText("moca");
		mocaButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel1.add(mocaButton);

		PaymentLayeredPane.add(PaymentMethodPanel1, "card3");

		PaymentMethodPanel2 = new JPanel();
		PaymentMethodPanel2.setBackground(new Color(255, 255, 255));
		PaymentMethodPanel2.setPreferredSize(new Dimension(298, 450));
		PaymentMethodPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		visaCardButton = new JButton();
		visaCardButton.setFocusable(false);
		visaCardButton.setFont(new Font("Segoe UI", 0, 24));
		visaCardButton.setText("visa card");
		visaCardButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel2.add(visaCardButton);

		otherCardButton = new JButton();
		otherCardButton.setFocusable(false);
		otherCardButton.setFont(new Font("Segoe UI", 0, 24));
		otherCardButton.setText("other card");
		otherCardButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel2.add(otherCardButton);

		voucherOnlButton = new JButton();
		voucherOnlButton.setFocusable(false);
		voucherOnlButton.setFont(new Font("Segoe UI", 0, 24));
		voucherOnlButton.setText("voucher online");
		voucherOnlButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel2.add(voucherOnlButton);

		voucherOffButton = new JButton();
		voucherOffButton.setFocusable(false);
		voucherOffButton.setFont(new Font("Segoe UI", 0, 24));
		voucherOffButton.setText("voucher offline");
		voucherOffButton.setPreferredSize(new Dimension(250, 60));
		PaymentMethodPanel2.add(voucherOffButton);

		PaymentLayeredPane.add(PaymentMethodPanel2, "card2");

		// set frame
		ImageIcon appLogo = new ImageIcon("src/logoCircle100.png");
		setIconImage(appLogo.getImage());
		setLocation(0, 100);
		setTitle("Payment View");
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 0));
		setFrameLayout();
		addADishPanel();
		pack();
		setVisible(true);
	}

	private void setFrameLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(billScrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(subtotalTitle, GroupLayout.PREFERRED_SIZE, 166,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(numOfDiseshLabel, GroupLayout.PREFERRED_SIZE, 308,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(subtotalLabel,
										GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(discountnMemberPart, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(previousButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addComponent(PaymentLayeredPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
				.addContainerGap())
				.addComponent(HeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout
				.createSequentialGroup()
				.addComponent(
						HeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(discountnMemberPart, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 48,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 48,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(
												PaymentLayeredPane, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(billScrollPane, GroupLayout.PREFERRED_SIZE, 470,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(numOfDiseshLabel, GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(subtotalTitle, GroupLayout.Alignment.LEADING))
												.addComponent(subtotalLabel))))
								.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
	}

	private JPanel newDish() {
		JPanel dishPanel = new JPanel();
		JSeparator separator = new JSeparator();
		JLabel nameLabel = new JLabel();
		JLabel priceLabel = new JLabel();
		JScrollPane toppingListSPane = new JScrollPane();
		JList<String> toppingList = new JList<>();
		JButton deleteButton = new JButton();

		dishPanel.setBackground(new Color(255, 255, 255));

		nameLabel.setFont(new Font("Segoe UI", 1, 18));
		nameLabel.setText("Name of food");
		nameLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showDishDetail(e, nameLabel.getText());
			}
		});

		priceLabel.setFont(new Font("Segoe UI", 1, 24));
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setText("00.000  ");

		toppingListSPane.setBackground(new Color(255, 255, 255));
		toppingListSPane.setBorder(null);
		toppingListSPane.setForeground(new Color(153, 153, 153));

		toppingList.setFont(new Font("Tahoma", 0, 13));
		toppingList.setModel(new AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		toppingListSPane.setViewportView(toppingList);

		deleteButton.setBackground(new Color(255, 255, 255));
		deleteButton.setIcon(new ImageIcon("icons8_delete_bin_32px.png"));
		deleteButton.setBorder(null);
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeADishPanel(e, dishPanel);
			}
		});

		GroupLayout dishPanelLayout = new GroupLayout(dishPanel);
		dishPanel.setLayout(dishPanelLayout);
		dishPanelLayout.setHorizontalGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(dishPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(toppingListSPane, GroupLayout.PREFERRED_SIZE, 405,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE))
				.addGroup(dishPanelLayout.createSequentialGroup().addComponent(separator).addContainerGap()));
		dishPanelLayout.setVerticalGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(dishPanelLayout.createSequentialGroup().addGroup(dishPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(dishPanelLayout.createSequentialGroup().addContainerGap()
								.addGroup(dishPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(priceLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(toppingListSPane,
										GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)));

		return dishPanel;
	}

	private Dimension reSizeBillPanel(int extraHeight) {
		int width = billParentPanel.getPreferredSize().width;
		int height = billParentPanel.getPreferredSize().height + extraHeight;
		return new Dimension(width, height);
	}

	public void addADishPanel() {
		billParentPanel.add(newDish());
		billParentPanel.setPreferredSize(reSizeBillPanel(123));
	}

	private void removeADishPanel(ActionEvent e, JPanel item) {
		billParentPanel.remove(item);
		billParentPanel.setPreferredSize(reSizeBillPanel(-123));
		billParentPanel.revalidate();
		billParentPanel.repaint();
	}

	private void showDishDetail(MouseEvent e, String nameOfDish) {
		// mo phan detail
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			Object[] options = { "Back to order page", "Cancel this bill", "Continue to pay" };
			int result = JOptionPane.showOptionDialog(this, "Choose 1 option in below:", "Message!",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if (result == JOptionPane.YES_OPTION) {
				dispose();
				OrderModel orderModel;
				try {
					orderModel = new OrderModel();
					new OrderController(orderModel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (result == JOptionPane.NO_OPTION) {
				dispose();
				MainHomeController homeController = new MainHomeController();
			}
		}
		if (e.getSource() == previousButton) {
			PaymentLayeredPane.removeAll();
			PaymentLayeredPane.add(PaymentMethodPanel1);
			PaymentLayeredPane.repaint();
			PaymentLayeredPane.revalidate();
			previousButton.setEnabled(false);
			nextButton.setEnabled(true);
			previousButton.setBackground(new Color(255, 255, 255));
			nextButton.setBackground(new Color(204, 204, 255));
		}
		if (e.getSource() == nextButton) {
			PaymentLayeredPane.removeAll();
			PaymentLayeredPane.add(PaymentMethodPanel2);
			PaymentLayeredPane.repaint();
			PaymentLayeredPane.revalidate();
			previousButton.setEnabled(true);
			nextButton.setEnabled(false);
			previousButton.setBackground(new Color(204, 204, 255));
			nextButton.setBackground(new Color(255, 255, 255));
		}
		if (e.getSource() == cashButton) {
			try {
				// TODO add your handling code here:
				dispose();
				// viet them phuong thuc tao 1 file txt lam hoa don
				File file = new File("C:\\Users\\DELL\\Desktop\\new.txt");

				if (!Desktop.isDesktopSupported()) {
					System.out.println("Desktop is not supported");
					return;
				}

				Desktop desktop = Desktop.getDesktop();
				if (file.exists())
					desktop.open(file);

			} catch (IOException ex) {
				Logger.getLogger(PaymentView.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}
}
