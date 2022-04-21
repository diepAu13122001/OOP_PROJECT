package Personel_Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import Store.*;

public class EmployeeSigninView extends JFrame implements ActionListener {

	private EmployeeSigninController controller;
	private EmployeeSigninModel model;

	private JLabel background;
	private JPanel panel;
	private JLabel header;
	private JLabel lbID;
	private JTextField idFiled;
	private JLabel lbPass;
	private JPasswordField passField;
	private JButton bnLogin;
	private JButton bnExit;
	private HashMap<String, String> loginInfo;

	public EmployeeSigninView(EmployeeSigninController controller, EmployeeSigninModel model) {
		this.controller = controller;
		this.model = model;
		this.loginInfo = model.getLoginInfo();

		// set frame
		ImageIcon appLogo = new ImageIcon("logoCircle100.png");
		setTitle("Bubble Tea App");
		setBounds(100, 100, 1000, 563);
		setUndecorated(true);
		setResizable(false);
		setIconImage(appLogo.getImage());

		// set background
		background = new JLabel();
		ImageIcon back = new ImageIcon("logo1000x563.jpg");
		background = new JLabel(back);
		background.setBounds(0, 0, 1000, 563);

		// set header
		header = new JLabel();
		header.setFont(new Font("Segoe UI", 1, 24));
		header.setForeground(new Color(255, 102, 102));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setText("Emloyee Login");

		// set ID label
		lbID = new JLabel();
		lbID.setFont(new Font("Segoe UI", 0, 14));
		lbID.setHorizontalAlignment(SwingConstants.LEFT);
		lbID.setLabelFor(idFiled);
		lbID.setText("Employee ID code");

		// set ID textField
		idFiled = new JTextField();
		idFiled.setFont(new Font("Tahoma", 0, 14));

		// set password label
		lbPass = new JLabel();
		lbPass.setFont(new Font("Segoe UI", 0, 14));
		lbPass.setHorizontalAlignment(SwingConstants.LEFT);
		lbPass.setLabelFor(passField);
		lbPass.setText("Password");

		// set password passwordField
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", 0, 14));

		// set login button
		bnLogin = new JButton();
		bnLogin.setBackground(new Color(255, 153, 153));
		bnLogin.setFont(new Font("Segoe UI", 1, 18));
		bnLogin.setText("Login");
		bnLogin.setFocusable(false);
		bnLogin.addActionListener(this);

		// set exit button
		bnExit = new JButton();
		bnExit.setFont(new Font("Segoe UI", 1, 18));
		bnExit.setText("Exit");
		bnExit.addActionListener(this);
		bnExit.setFocusable(false);

		// set panel
		panel = new JPanel();
		panel.setLayout(createpanelLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(300, 130, 400, 300);

		// add frame
		getContentPane().add(panel);
		getContentPane().add(background);
	}

	private GroupLayout createpanelLayout() {
		GroupLayout panelLayout = new GroupLayout(panel);

		// set chieu ngang
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				panelLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lbPass)
								.addComponent(passField, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addComponent(idFiled, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbID))
						.addGap(29, 29, 29))
				.addGroup(panelLayout.createSequentialGroup().addGroup(panelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup().addGap(116, 116, 116).addComponent(header,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelLayout.createSequentialGroup().addGap(30, 30, 30)
								.addComponent(bnExit, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addComponent(bnLogin, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(30, Short.MAX_VALUE)));

		// set chieu doc
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLayout
				.createSequentialGroup().addGap(25, 25, 25)
				.addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(25, 25, 25).addComponent(lbID).addGap(5, 5, 5)
				.addComponent(idFiled, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10, 10, 10)
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(panelLayout.createSequentialGroup().addComponent(lbPass).addGap(5, 5, 5)
								.addComponent(passField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(bnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(bnLogin, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 25, Short.MAX_VALUE)));
		return panelLayout;
	}

	public void createSignInView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bnLogin) {
			String idInput = idFiled.getText();
			String passInput = String.valueOf(passField.getPassword());

			if (loginInfo.containsKey(idInput)) {
				if (loginInfo.get(idInput).equals(passInput)) {
					if (model.getPosition(idInput).equals("KT")) {
						// open Employee_Marketing_Home_View
						dispose();
					}
					if (model.getPosition(idInput).equals("DV")) {
						// open Employee_HRM_Home_View
						dispose();
					}
					if (model.getPosition(idInput).equals("CK")) {
						// open Employee_MenuManager_Home_View
						dispose();
					}
					if (model.getPosition(idInput).equals("PV") || model.getPosition(idInput).equals("PC")
							|| model.getPosition(idInput).equals("BV") || model.getPosition(idInput).equals("VS")) {
						// open time keeping
						dispose();
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Your ID code or your password was wrong!", "Message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == bnExit) {
			new MainHomeView(new MainHomeController()).setVisible(true);
			dispose();
		}
	}
}
