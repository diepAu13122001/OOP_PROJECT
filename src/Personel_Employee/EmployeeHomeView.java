package Personel_Employee;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.util.SystemOutLogger;

import com.toedter.calendar.*;

import SupportClasses.TimeAndDateFunctions;

public class EmployeeHomeView extends JFrame implements ActionListener {
	private EmployeeHomeModel model;
	private EmployeeHomeController controller;

	private JPanel menuBarPanel;
	private TimeAndDateFunctions timeAndDate;

	private JPanel contentPanel;
	private JPanel breakPanel;
	private JTabbedPane settingParentPane;
	private JScrollPane overviewScrollPane;
	private JPanel billingPanel;
	private JTabbedPane menuParentPane;
	private JTabbedPane partnerParentPane;
	private JPanel discountPanel;
	private JPanel staffPanel;
	private JPanel accountManagementPanel;

	private Color whiteColor = Color.WHITE;
	private Color pinkColor = new Color(255, 204, 204);
	private Color greyColor = new Color(153, 153, 153);

	public EmployeeHomeView(EmployeeHomeController controller, EmployeeHomeModel model) {
		this.model = model;
		this.controller = controller;
	}

	public void createView() {

		ImageIcon appLogo = new ImageIcon("logoCircle100.png");
		setTitle("Employee management");
		setBounds(0, 0, 1400, 780);
		setIconImage(appLogo.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 102, 0));
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));

		createMenuBar();

		getContentPane().add(menuBarPanel);
		getContentPane().add(contentPanel(null));

		setVisible(true);
	}

	private void createMenuBar() {
		menuBarPanel = new JPanel();
		menuBarPanel.setBackground(new Color(255, 255, 255));
		menuBarPanel.setFont(new Font("Segoe UI", 0, 11));
		menuBarPanel.setMinimumSize(new Dimension(215, 770));
		menuBarPanel.setPreferredSize(new Dimension(215, 730));
		menuBarPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 15));

		JLabel timeNDateLabel = new JLabel();
		timeNDateLabel.setFont(new Font("Segoe UI", 0, 14));
		timeNDateLabel.setForeground(new Color(153, 153, 153));
		timeNDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clock(timeNDateLabel);
		timeNDateLabel.setPreferredSize(new Dimension(195, 25));
		menuBarPanel.add(timeNDateLabel);

		JLabel positionLabel = new JLabel();
		positionLabel.setText("Position of this employee");
		positionLabel.setPreferredSize(new Dimension(195, 25));
		menuBarPanel.add(positionLabel);

		JLabel nameTitleLabel = new JLabel();
		nameTitleLabel.setFont(new Font("Segoe UI", 0, 11));
		nameTitleLabel.setText("Name:");
		nameTitleLabel.setPreferredSize(new Dimension(55, 25));
		menuBarPanel.add(nameTitleLabel);

		JLabel nameLabel = new JLabel();
		nameLabel.setFont(new Font("Segoe UI", 1, 12));
		nameLabel.setForeground(new Color(255, 51, 51));
		nameLabel.setText("the Employee's name");
		nameLabel.setPreferredSize(new Dimension(135, 25));
		menuBarPanel.add(nameLabel);

		JLabel idTitleLabel = new JLabel();
		idTitleLabel.setFont(new Font("Segoe UI", 0, 11));
		idTitleLabel.setText("ID code:");
		idTitleLabel.setPreferredSize(new Dimension(55, 25));
		menuBarPanel.add(idTitleLabel);

		JLabel idLabel = new JLabel();
		idLabel.setFont(new Font("Segoe UI", 1, 12));
		idLabel.setText("00000000");
		idLabel.setPreferredSize(new Dimension(135, 25));
		menuBarPanel.add(idLabel);

		JButton accountMangementButton = createNewButton(195, 35, whiteColor, null, "Account management", 14);
		accountMangementButton.setForeground(new Color(51, 51, 255));

		JButton signoutButton = createNewButton(95, 35, whiteColor, null, "Sign out", 14);
		signoutButton.setForeground(new Color(255, 51, 51));

		JButton breakButton = createNewButton(90, 35, whiteColor, null, "Break", 14);
		breakButton.setForeground(new Color(51, 51, 255));

		JButton overviewButton = createNewButton(195, 45, pinkColor, null, "Overview", 16);

		JButton revenueButton = createNewButton(195, 45, whiteColor, null, "Revenue", 16);

		JButton menuManagementButton = createNewButton(195, 45, whiteColor, null, "Menu management", 16);

		JButton partnerButton = createNewButton(195, 45, whiteColor, null, "Partner", 16);

		JButton discountManagementButton = createNewButton(195, 45, whiteColor, null, "Discount management", 16);

		JButton staffManagementButton = createNewButton(195, 45, whiteColor, null, "Staff management", 16);

		JButton settingButton = createNewButton(195, 45, whiteColor, null, "Setting", 16);

		ArrayList<JButton> buttonList = new ArrayList<>(); // dung cho phuong thuc changeColor
		buttonList.add(accountMangementButton);
		buttonList.add(signoutButton);
		buttonList.add(breakButton);
		buttonList.add(overviewButton);
		buttonList.add(revenueButton);
		buttonList.add(menuManagementButton);
		buttonList.add(partnerButton);
		buttonList.add(discountManagementButton);
		buttonList.add(staffManagementButton);
		buttonList.add(settingButton);

		accountMangementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, accountManagementPanel);
			}
		});
		menuBarPanel.add(accountMangementButton);

		signoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				signOutButtonActionPerformed(evt);
			}
		});
		menuBarPanel.add(signoutButton);

		breakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, breakPanel);
			}
		});
		menuBarPanel.add(breakButton);

		JSeparator menuBarSeparator = new JSeparator();
		menuBarSeparator.setPreferredSize(new Dimension(195, 5));
		menuBarPanel.add(menuBarSeparator);

		overviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, overviewScrollPane);
				changeColorOfbutton(evt, buttonList, overviewButton);
				menuBarPanel.repaint();
			}
		});
		menuBarPanel.add(overviewButton);

		revenueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, billingPanel);
				changeColorOfbutton(evt, buttonList, revenueButton);
				menuBarPanel.repaint();
			}
		});
		menuBarPanel.add(revenueButton);

		menuManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, menuParentPane);
				changeColorOfbutton(evt, buttonList, menuManagementButton);
				menuBarPanel.repaint();
			}
		});
		menuBarPanel.add(menuManagementButton);

		partnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, partnerParentPane);
				changeColorOfbutton(evt, buttonList, partnerButton);
				menuBarPanel.repaint();
			}
		});
		menuBarPanel.add(partnerButton);

		discountManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, discountPanel);
				changeColorOfbutton(evt, buttonList, discountManagementButton);
			}
		});
		menuBarPanel.add(discountManagementButton);

		staffManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, staffPanel);
				changeColorOfbutton(evt, buttonList, staffManagementButton);
			}
		});
		menuBarPanel.add(staffManagementButton);

		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changeCardLayoutByClickBtn(evt, settingParentPane);
				changeColorOfbutton(evt, buttonList, settingButton);
			}
		});
		menuBarPanel.add(settingButton);
	}

	private JPanel contentPanel(ArrayList<ArrayList<String>> unitItemLists) {
		contentPanel = new JPanel();
		contentPanel.setMinimumSize(new Dimension(1100, 700));
		contentPanel.setPreferredSize(new Dimension(1100, 730));
		contentPanel.setLayout(new CardLayout());

		contentPanel.add(overviewScrollPane(), "card1");
		contentPanel.add(revenuePanel(""), "card2");
		contentPanel.add(menuParentPane(), "card3");
		contentPanel.add(partnerParentPane(), "card4");
		contentPanel.add(discountPanel(), "card5");
		contentPanel.add(staffPanel(), "card6");
		contentPanel.add(settingParentPane(unitItemLists), "card7");
		contentPanel.add(accountManagementPanel(), "card8");
		contentPanel.add(breakPanel(), "card10");
		return contentPanel;

	}

	private JScrollPane overviewScrollPane() {
		JPanel overviewParentPanel = new JPanel();
		JPanel panel = new JPanel();
		JLabel headerLabel = new JLabel();
		JLabel numOfBill = new JLabel();
		JLabel totalGain = new JLabel();
		JLabel sumaryDevPercentLabel = new JLabel();
		JLabel sumaryyesGainLabel = new JLabel();
		JPanel mainPanel = new JPanel();
		JLabel headerName = new JLabel();
		JLabel totalBillLabel = new JLabel();
		JLabel percentageOfTotal = new JLabel();
		// JLabel totalGain = new JLabel();
		JLabel percentGrowth = new JLabel();
		JLabel lastDayTotalGain = new JLabel();
		JPanel onlinePanel = new JPanel();
		JLabel onlHeaderLabel = new JLabel();
		JLabel onlBillLabel = new JLabel();
		JLabel onlPercentLabel = new JLabel();
		JLabel onlTotalGainLabel = new JLabel();
		JLabel onlDevPercentLabel = new JLabel();
		JLabel onlYesGainLabel = new JLabel();
		JPanel appPanel = new JPanel();
		JLabel appHeaderLabel = new JLabel();
		JLabel appBillLabel = new JLabel();
		JLabel appPercentLabel = new JLabel();
		JLabel appTotalGainLabel = new JLabel();
		JLabel appDevPercentLabel = new JLabel();
		JLabel appYesGainLabel = new JLabel();
		JPanel revenueOverviewPanel = new JPanel();
		JLabel revenueHeaderLabel = new JLabel();
		JComboBox revPeriodChoiceComboBox = new JComboBox<>();
		JComboBox revTypeChoiceComboBox = new JComboBox<>();
		JLabel revenueGainLabel = new JLabel();
		JPanel revChartPanel = new JPanel();
		JPanel memberStatisticPanel = new JPanel();
		JLabel memberStatisticHeaderLabel = new JLabel();
		JComboBox memPeriodChoiceComboBox = new JComboBox<>();
		JLabel memGainLabel = new JLabel();
		JPanel memChartPanel = new JPanel();
		JPanel bestSellerStatisticPanel = new JPanel();
		JLabel sellerHeaderLabel = new JLabel();
		JComboBox sellerPeriodChoiceComboBox = new JComboBox<>();
		JComboBox sellerTypeChoiceComboBox = new JComboBox<>();
		JPanel sellerChartPanel = new JPanel();

		overviewScrollPane = new JScrollPane();
		overviewScrollPane.setBackground(new Color(255, 255, 255));
		overviewScrollPane.setMinimumSize(new Dimension(1000, 600));
		overviewScrollPane.setPreferredSize(new Dimension(1000, 500));

		overviewParentPanel.setMinimumSize(new Dimension(1000, 107));
		overviewParentPanel.setPreferredSize(new Dimension(900, 1800));
		overviewParentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(240, 135));
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		headerLabel.setFont(new Font("Segoe UI", 1, 20));
		headerLabel.setText("Summary");
		headerLabel.setPreferredSize(new Dimension(215, 30));
		panel.add(headerLabel);

		numOfBill.setFont(new Font("Segoe UI", 0, 12));
		numOfBill.setText("xx bills");
		numOfBill.setPreferredSize(new Dimension(215, 20));
		panel.add(numOfBill);

		totalGain.setFont(new Font("Segoe UI", 1, 15));
		totalGain.setForeground(new Color(255, 51, 0));
		totalGain.setText("000.000   ");
		totalGain.setPreferredSize(new Dimension(115, 30));
		panel.add(totalGain);

		sumaryDevPercentLabel.setFont(new Font("Segoe UI", 0, 12));
		sumaryDevPercentLabel.setForeground(new Color(153, 153, 153));
		sumaryDevPercentLabel.setIcon(new ImageIcon("icons8_up_16px.png"));
		sumaryDevPercentLabel.setText("00.00%");
		sumaryDevPercentLabel.setPreferredSize(new Dimension(70, 30));
		panel.add(sumaryDevPercentLabel);

		sumaryyesGainLabel.setFont(new Font("Segoe UI", 0, 12));
		sumaryyesGainLabel.setForeground(new Color(153, 153, 153));
		sumaryyesGainLabel.setText("Yesterday 000.000  ");
		sumaryyesGainLabel.setPreferredSize(new Dimension(215, 20));
		panel.add(sumaryyesGainLabel);

		overviewParentPanel.add(panel);

		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		mainPanel.setPreferredSize(new Dimension(240, 135));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		headerName.setFont(new Font("Segoe UI", 1, 20));
		headerName.setText("Offline");
		headerName.setPreferredSize(new Dimension(215, 30));
		mainPanel.add(headerName);

		totalBillLabel.setFont(new Font("Segoe UI", 0, 12));
		totalBillLabel.setText("xx bills");
		totalBillLabel.setPreferredSize(new Dimension(70, 20));
		mainPanel.add(totalBillLabel);

		percentageOfTotal.setFont(new Font("Segoe UI", 0, 13));
		percentageOfTotal.setForeground(new Color(153, 153, 153));
		percentageOfTotal.setText("xx.x% of the total");
		percentageOfTotal.setPreferredSize(new Dimension(115, 20));
		mainPanel.add(percentageOfTotal);

		totalGain.setFont(new Font("Segoe UI", 1, 15));
		totalGain.setForeground(new Color(255, 51, 0));
		totalGain.setText("000.000   ");
		totalGain.setPreferredSize(new Dimension(115, 30));
		mainPanel.add(totalGain);

		percentGrowth.setForeground(new Color(153, 153, 153));
		percentGrowth.setIcon(new ImageIcon("icons8_down_16px.png"));
		percentGrowth.setText("00.00%");
		percentGrowth.setPreferredSize(new Dimension(70, 30));
		mainPanel.add(percentGrowth);

		lastDayTotalGain.setFont(new Font("Segoe UI", 0, 12));
		lastDayTotalGain.setForeground(new Color(153, 153, 153));
		lastDayTotalGain.setText("Yesterday 000.000  ");
		lastDayTotalGain.setPreferredSize(new Dimension(215, 20));
		mainPanel.add(lastDayTotalGain);

		overviewParentPanel.add(mainPanel);

		onlinePanel.setBackground(new Color(255, 255, 255));
		onlinePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		onlinePanel.setPreferredSize(new Dimension(240, 135));
		onlinePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		onlHeaderLabel.setFont(new Font("Segoe UI", 1, 20));
		onlHeaderLabel.setText("Web & Social media");
		onlHeaderLabel.setPreferredSize(new Dimension(215, 30));
		onlinePanel.add(onlHeaderLabel);

		onlBillLabel.setFont(new Font("Segoe UI", 0, 12));
		onlBillLabel.setText("xx bills");
		onlBillLabel.setPreferredSize(new Dimension(70, 20));
		onlinePanel.add(onlBillLabel);

		onlPercentLabel.setFont(new Font("Segoe UI", 0, 13));
		onlPercentLabel.setForeground(new Color(153, 153, 153));
		onlPercentLabel.setText("xx.x% of the total");
		onlPercentLabel.setPreferredSize(new Dimension(115, 20));
		onlinePanel.add(onlPercentLabel);

		onlTotalGainLabel.setFont(new Font("Segoe UI", 1, 15));
		onlTotalGainLabel.setForeground(new Color(255, 51, 0));
		onlTotalGainLabel.setText("000.000   ");
		onlTotalGainLabel.setPreferredSize(new Dimension(115, 30));
		onlinePanel.add(onlTotalGainLabel);

		onlDevPercentLabel.setFont(new Font("Segoe UI", 0, 12));
		onlDevPercentLabel.setForeground(new Color(153, 153, 153));
		onlDevPercentLabel.setIcon(new ImageIcon("icons8_up_16px.png"));
		onlDevPercentLabel.setText("00.00%");
		onlDevPercentLabel.setPreferredSize(new Dimension(70, 30));
		onlinePanel.add(onlDevPercentLabel);

		onlYesGainLabel.setFont(new Font("Segoe UI", 0, 12));
		onlYesGainLabel.setForeground(new Color(153, 153, 153));
		onlYesGainLabel.setText("Yesterday 000.000  ");
		onlYesGainLabel.setPreferredSize(new Dimension(215, 20));
		onlinePanel.add(onlYesGainLabel);

		overviewParentPanel.add(onlinePanel);

		appPanel.setBackground(new Color(255, 255, 255));
		appPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		appPanel.setPreferredSize(new Dimension(240, 135));
		appPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		appHeaderLabel.setFont(new Font("Segoe UI", 1, 20));
		appHeaderLabel.setText("Online applications");
		appHeaderLabel.setPreferredSize(new Dimension(215, 30));
		appPanel.add(appHeaderLabel);

		appBillLabel.setFont(new Font("Segoe UI", 0, 12));
		appBillLabel.setText("xx bills");
		appBillLabel.setPreferredSize(new Dimension(70, 20));
		appPanel.add(appBillLabel);

		appPercentLabel.setFont(new Font("Segoe UI", 0, 13));
		appPercentLabel.setForeground(new Color(153, 153, 153));
		appPercentLabel.setText("xx.x% of the total");
		appPercentLabel.setPreferredSize(new Dimension(115, 20));
		appPanel.add(appPercentLabel);

		appTotalGainLabel.setFont(new Font("Segoe UI", 1, 15));
		appTotalGainLabel.setForeground(new Color(255, 51, 0));
		appTotalGainLabel.setText("000.000   ");
		appTotalGainLabel.setPreferredSize(new Dimension(115, 30));
		appPanel.add(appTotalGainLabel);

		appDevPercentLabel.setFont(new Font("Segoe UI", 0, 12));
		appDevPercentLabel.setForeground(new Color(153, 153, 153));
		appDevPercentLabel.setIcon(new ImageIcon("icons8_up_16px.png"));
		appDevPercentLabel.setText("00.00%");
		appDevPercentLabel.setPreferredSize(new Dimension(70, 30));
		appPanel.add(appDevPercentLabel);

		appYesGainLabel.setFont(new Font("Segoe UI", 0, 12));
		appYesGainLabel.setForeground(new Color(153, 153, 153));
		appYesGainLabel.setText("Yesterday 000.000  ");
		appYesGainLabel.setPreferredSize(new Dimension(215, 20));
		appPanel.add(appYesGainLabel);

		overviewParentPanel.add(appPanel);

		revenueOverviewPanel.setBackground(new Color(255, 255, 255));
		revenueOverviewPanel.setPreferredSize(new Dimension(1000, 500));
		revenueOverviewPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		revenueHeaderLabel.setFont(new Font("Segoe UI", 1, 20));
		revenueHeaderLabel.setText("Revenue in");
		revenueOverviewPanel.add(revenueHeaderLabel);

		revPeriodChoiceComboBox.setFont(new Font("Segoe UI", 1, 14));
		revPeriodChoiceComboBox.setForeground(new Color(0, 0, 204));
		revPeriodChoiceComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "Today", "Yesterday", "7 last days", "this month", "last month" }));
		revPeriodChoiceComboBox.setBorder(null);
		revPeriodChoiceComboBox.setFocusable(false);
		revPeriodChoiceComboBox.setOpaque(false);
		revenueOverviewPanel.add(revPeriodChoiceComboBox);

		revTypeChoiceComboBox.setFont(new Font("Segoe UI", 1, 14));
		revTypeChoiceComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "by day of the month", "by hour (24h)", "by day of the week" }));
		revTypeChoiceComboBox.setBorder(null);
		revTypeChoiceComboBox.setFocusable(false);
		revTypeChoiceComboBox.setOpaque(false);
		revenueOverviewPanel.add(revTypeChoiceComboBox);

		revenueGainLabel.setFont(new Font("Segoe UI", 1, 16));
		revenueGainLabel.setForeground(new Color(255, 51, 51));
		revenueGainLabel.setText("0.000.000");
		revenueOverviewPanel.add(revenueGainLabel);

		revChartPanel.setPreferredSize(new Dimension(975, 435));

		GroupLayout revChartPanelLayout = new GroupLayout(revChartPanel);
		revChartPanel.setLayout(revChartPanelLayout);
		revChartPanelLayout.setHorizontalGroup(
				revChartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 975, Short.MAX_VALUE));
		revChartPanelLayout.setVerticalGroup(
				revChartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 435, Short.MAX_VALUE));

		revenueOverviewPanel.add(revChartPanel);

		overviewParentPanel.add(revenueOverviewPanel);

		memberStatisticPanel.setBackground(new Color(255, 255, 255));
		memberStatisticPanel.setPreferredSize(new Dimension(1000, 500));
		memberStatisticPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		memberStatisticHeaderLabel.setFont(new Font("Segoe UI", 1, 20));
		memberStatisticHeaderLabel.setText("The number of members in");
		memberStatisticPanel.add(memberStatisticHeaderLabel);

		memPeriodChoiceComboBox.setFont(new Font("Segoe UI", 1, 14));
		memPeriodChoiceComboBox.setForeground(new Color(0, 0, 204));
		memPeriodChoiceComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "Today", "Yesterday", "7 last days", "this month", "last month" }));
		memPeriodChoiceComboBox.setBorder(null);
		memPeriodChoiceComboBox.setFocusable(false);
		memPeriodChoiceComboBox.setOpaque(false);
		memberStatisticPanel.add(memPeriodChoiceComboBox);

		memGainLabel.setFont(new Font("Segoe UI", 1, 16));
		memGainLabel.setForeground(new Color(255, 51, 51));
		memGainLabel.setText("00");
		memberStatisticPanel.add(memGainLabel);

		memChartPanel.setPreferredSize(new Dimension(975, 435));

		GroupLayout memChartPanelLayout = new GroupLayout(memChartPanel);
		memChartPanel.setLayout(memChartPanelLayout);
		memChartPanelLayout.setHorizontalGroup(
				memChartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 975, Short.MAX_VALUE));
		memChartPanelLayout.setVerticalGroup(
				memChartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 435, Short.MAX_VALUE));

		memberStatisticPanel.add(memChartPanel);

		overviewParentPanel.add(memberStatisticPanel);

		bestSellerStatisticPanel.setBackground(new Color(255, 255, 255));
		bestSellerStatisticPanel.setPreferredSize(new Dimension(1000, 500));
		bestSellerStatisticPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		sellerHeaderLabel.setFont(new Font("Segoe UI", 1, 20));
		sellerHeaderLabel.setText("Top 10 Bestsellers in");
		bestSellerStatisticPanel.add(sellerHeaderLabel);

		sellerPeriodChoiceComboBox.setFont(new Font("Segoe UI", 1, 14));
		sellerPeriodChoiceComboBox.setForeground(new Color(0, 0, 204));
		sellerPeriodChoiceComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "Today", "Yesterday", "7 last days", "this month", "last month" }));
		sellerPeriodChoiceComboBox.setBorder(null);
		sellerPeriodChoiceComboBox.setFocusable(false);
		sellerPeriodChoiceComboBox.setOpaque(false);
		bestSellerStatisticPanel.add(sellerPeriodChoiceComboBox);

		sellerTypeChoiceComboBox.setFont(new Font("Segoe UI", 1, 14));
		sellerTypeChoiceComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "by revenue", "by quantity" }));
		sellerTypeChoiceComboBox.setBorder(null);
		sellerTypeChoiceComboBox.setFocusable(false);
		sellerTypeChoiceComboBox.setOpaque(false);
		bestSellerStatisticPanel.add(sellerTypeChoiceComboBox);

		sellerChartPanel.setPreferredSize(new Dimension(975, 435));

		GroupLayout sellerChartPanelLayout = new GroupLayout(sellerChartPanel);
		sellerChartPanel.setLayout(sellerChartPanelLayout);
		sellerChartPanelLayout.setHorizontalGroup(sellerChartPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 975, Short.MAX_VALUE));
		sellerChartPanelLayout.setVerticalGroup(sellerChartPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 435, Short.MAX_VALUE));

		bestSellerStatisticPanel.add(sellerChartPanel);

		overviewParentPanel.add(bestSellerStatisticPanel);

		overviewScrollPane.setViewportView(overviewParentPanel);

		return overviewScrollPane;
	}

	// of overviewScrollPane()
	private JPanel salesStatisticsPanel(String name, boolean isSummary, HashMap<String, Double> data) {
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setPreferredSize(new Dimension(240, 135));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		// cả header cũng dùng biến lấy từ bảng bên model lun
		// bên controller tạo 1 phương thức hashmap để nạp dữ liệu cho view, và được lấy
		// từ model
		JLabel headerName = new JLabel(name);
		headerName.setFont(new Font("Segoe UI", 1, 20));
		headerName.setPreferredSize(new Dimension(215, 30));
		mainPanel.add(headerName);

		JLabel totalBillLabel = new JLabel();
		totalBillLabel.setFont(new Font("Segoe UI", 0, 12));
		if (data.containsKey("totalBill")) {
			totalBillLabel.setText(model.roundAndNumberFormat(data.get("totalBill"), 0, true) + " bills");
		}
		totalBillLabel.setPreferredSize(new Dimension(70, 20));
		mainPanel.add(totalBillLabel);

		if (!isSummary) {// bỏ biến này, dù có hay không vẫn tạo

			JLabel percentageOfTotal = new JLabel(); // summary k co
			percentageOfTotal.setFont(new Font("Segoe UI", 0, 13));
			percentageOfTotal.setForeground(new Color(153, 153, 153));
			if (data.containsKey("percentageOfTotal")) {
				percentageOfTotal
						.setText(model.roundAndNumberFormat(data.get("percentageOfTotal"), 2, true) + "% of the total");
			}
			percentageOfTotal.setPreferredSize(new Dimension(115, 20));
			mainPanel.add(percentageOfTotal);
		}

		JLabel totalGain = new JLabel();
		totalGain.setFont(new Font("Segoe UI", 1, 15));
		totalGain.setForeground(new Color(255, 51, 0));
		if (data.containsKey("totalGain")) {
			totalGain.setText(model.roundAndNumberFormat(data.get("totalGain"), 0, true) + "   ");
		}
		totalGain.setPreferredSize(new Dimension(115, 30));
		mainPanel.add(totalGain);

		JLabel percentGrowth = new JLabel();
		percentGrowth.setForeground(new Color(153, 153, 153));

		// percentGrowth.setIcon(new ImageIcon(controller.percentGrowthImage()));
		if (data.containsKey("percentGrowth")) {
			percentGrowth.setText(model.roundAndNumberFormat(data.get("percentGrowth"), 2, true) + "%");
		}
		percentGrowth.setPreferredSize(new Dimension(70, 30));
		mainPanel.add(percentGrowth);

		JLabel lastDayTotalGain = new JLabel();
		lastDayTotalGain.setFont(new Font("Segoe UI", 0, 12));
		lastDayTotalGain.setForeground(new Color(153, 153, 153));
		if (data.containsKey("lastDayTotalGain")) {
			lastDayTotalGain
					.setText("Yesterday " + model.roundAndNumberFormat(data.get("lastDayTotalGain"), 2, true) + "  ");
		}
		lastDayTotalGain.setPreferredSize(new Dimension(215, 20));
		mainPanel.add(lastDayTotalGain);

		return mainPanel;
	}

	private JPanel revenuePanel(String URL) {
		billingPanel = new JPanel();
		billingPanel.setBackground(new Color(255, 255, 255));
		billingPanel.setMinimumSize(new Dimension(1000, 700));
		billingPanel.setPreferredSize(new Dimension(1100, 700));
		billingPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		billingPanel.add(blankLabel(490, 40));

		JButton addBillButton = createNewButton(150, 40, pinkColor, null, "Add new bill", 14);
		billingPanel.add(addBillButton);

		JButton importBillsButton = createNewButton(150, 40, pinkColor, null, "Import excel file", 14);
		billingPanel.add(importBillsButton);

		JButton exportBillsButton = createNewButton(150, 40, pinkColor, null, "Export excel file", 14);
		billingPanel.add(exportBillsButton);

		JTextField billSearchField = new JTextField();
		billSearchField.setFont(new Font("Segoe UI", 0, 12));
		billSearchField.setForeground(new Color(204, 204, 204));
		billSearchField.setText("Search by key ...");
		billSearchField.setPreferredSize(new Dimension(250, 30));
		billingPanel.add(billSearchField);

		String[] billTypeItems = { "All types", "sale bill", "bought receipt" };
		JComboBox<Object> billTypeComboBox = comboBox(billTypeItems, 115, 30, whiteColor, null, 13);
		billingPanel.add(billTypeComboBox);

		String[] partnerTypeItems = { "All partners", "suppliers", "customers" };
		JComboBox<Object> billPartnerComboBox = comboBox(partnerTypeItems, 95, 30, whiteColor, null, 13);
		billingPanel.add(billPartnerComboBox);

		String[] rangeItems = { "Price range", "under 100.000", "under 500.000", "under 1.000.000", "under 1.500.000",
				"under 2.000.000", "over" };
		JComboBox<Object> billRangeComboBox = comboBox(rangeItems, 125, 30, whiteColor, null, 13);
		billRangeComboBox.setFont(new Font("Segoe UI", 0, 13));
		billingPanel.add(billRangeComboBox);

		JCheckBox billDelivCheckBox = checkBox("Delivery cost", false, null, null, 13, 100, 30);
		billingPanel.add(billDelivCheckBox);

		JCheckBox billDiscountCheckBox = checkBox("Discount", false, null, null, 13, 100, 30);
		billingPanel.add(billDiscountCheckBox);

		JButton billSearchButton = new JButton("Search", new ImageIcon("icons8_search_24px_1.png"));
		billSearchButton.setBackground(new Color(204, 204, 204));
		billSearchButton.setFont(new Font("Segoe UI", 0, 14));
		billSearchButton.setBorderPainted(false);
		billSearchButton.setFocusable(false);
		billSearchButton.setPreferredSize(new Dimension(125, 30));
		billingPanel.add(billSearchButton);

		JScrollPane billScrollPane = tableScrollPane(1000, 500, URL, 13, whiteColor, null);
		billingPanel.add(billScrollPane);

		return billingPanel;
	}

	private JTabbedPane menuParentPane() {
		JPanel menuManagementPanel = new JPanel();
		JLabel blank = new JLabel();
		JButton addDishButton = new JButton();
		JButton importMenuButton = new JButton();
		JButton exportMenuButton = new JButton();
		JTextField menuSearchField = new JTextField();
		JComboBox menuGroupComboBox = new JComboBox<>();
		JComboBox menuTypeComboBox = new JComboBox<>();
		JComboBox menuUnitCombobox = new JComboBox<>();
		JComboBox menuSizeComboBox = new JComboBox<>();
		JCheckBox menuOnSaleCheckBox = new JCheckBox();
		JButton menuSearchButton = new JButton();
		JScrollPane menuTablePane = new JScrollPane();
		JTable menuTable = new JTable();
		JPanel materialsManagementPanel = new JPanel();
		JLabel materialsTotalHeaderLabel = new JLabel();
		JLabel materialsTotalAmountLabel = new JLabel();
		JButton addMaterialButton = new JButton();
		JButton importMaterialsButton = new JButton();
		JButton exportMaterialsButton = new JButton();
		JTextField materialsSearchField = new JTextField();
		JComboBox materialsUnitComboBox = new JComboBox<>();
		JButton materialsSearchButton = new JButton();
		JLabel meterialsBlank = new JLabel();
		JScrollPane materialsTablePane = new JScrollPane();
		JTable materialsTable = new JTable();

		// create menu panel
		menuParentPane = new JTabbedPane();
		menuParentPane.setBackground(new Color(255, 255, 255));
		menuParentPane.setFont(new Font("Segoe UI", 1, 18));
		menuParentPane.setPreferredSize(new Dimension(1165, 739));

		menuManagementPanel.setBackground(new Color(255, 255, 255));
		menuManagementPanel.setPreferredSize(new Dimension(900, 715));
		menuManagementPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		blank.setPreferredSize(new Dimension(450, 40));
		menuManagementPanel.add(blank);

		addDishButton.setBackground(new Color(255, 204, 204));
		addDishButton.setFont(new Font("Segoe UI", 0, 14));
		addDishButton.setText("Add new dish");
		addDishButton.setBorder(null);
		addDishButton.setBorderPainted(false);
		addDishButton.setPreferredSize(new Dimension(150, 40));

		menuManagementPanel.add(addDishButton);

		importMenuButton.setBackground(new Color(255, 204, 204));
		importMenuButton.setFont(new Font("Segoe UI", 0, 14));
		importMenuButton.setText("Import excel file");
		importMenuButton.setBorder(null);
		importMenuButton.setBorderPainted(false);
		importMenuButton.setPreferredSize(new Dimension(150, 40));
		menuManagementPanel.add(importMenuButton);

		exportMenuButton.setBackground(new Color(255, 204, 204));
		exportMenuButton.setFont(new Font("Segoe UI", 0, 14));
		exportMenuButton.setText("Export excel file");
		exportMenuButton.setBorder(null);
		exportMenuButton.setBorderPainted(false);
		exportMenuButton.setPreferredSize(new Dimension(150, 40));
		menuManagementPanel.add(exportMenuButton);

		menuSearchField.setFont(new Font("Segoe UI", 0, 12));
		menuSearchField.setForeground(new Color(204, 204, 204));
		menuSearchField.setText("Search by key ...");
		menuSearchField.setPreferredSize(new Dimension(250, 30));

		menuManagementPanel.add(menuSearchField);

		menuGroupComboBox.setFont(new Font("Segoe UI", 0, 13));
		menuGroupComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "All groups", "food group", "drink group", "combo group", "topping group" }));
		menuGroupComboBox.setBorder(null);
		menuGroupComboBox.setOpaque(false);
		menuGroupComboBox.setPreferredSize(new Dimension(125, 30));
		menuManagementPanel.add(menuGroupComboBox);

		menuTypeComboBox.setFont(new Font("Segoe UI", 0, 13));
		menuTypeComboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "All types", "Main dishes", "Junk food", "Desserts", "Colld drinks", "Tea", "Coffee" }));
		menuTypeComboBox.setBorder(null);
		menuTypeComboBox.setOpaque(false);
		menuTypeComboBox.setPreferredSize(new Dimension(110, 30));
		menuManagementPanel.add(menuTypeComboBox);

		menuUnitCombobox.setFont(new Font("Segoe UI", 0, 13));
		menuUnitCombobox.setModel(
				new DefaultComboBoxModel<>(new String[] { "All units", "cup", "bottle", "ml", "a meal", "a piece" }));
		menuUnitCombobox.setBorder(null);
		menuUnitCombobox.setOpaque(false);
		menuUnitCombobox.setPreferredSize(new Dimension(85, 30));
		menuManagementPanel.add(menuUnitCombobox);

		menuSizeComboBox.setFont(new Font("Segoe UI", 0, 13));
		menuSizeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All sizes", "350ml", "500ml", "50ml",
				"100ml", "single", "double", "1/4", "1/6", "1/2" }));
		menuSizeComboBox.setBorder(null);
		menuSizeComboBox.setOpaque(false);
		menuSizeComboBox.setPreferredSize(new Dimension(85, 30));
		menuManagementPanel.add(menuSizeComboBox);

		menuOnSaleCheckBox.setBackground(new Color(255, 255, 255));
		menuOnSaleCheckBox.setFont(new Font("Segoe UI", 0, 13));
		menuOnSaleCheckBox.setText("On sale");
		menuOnSaleCheckBox.setBorder(null);
		menuOnSaleCheckBox.setOpaque(false);
		menuOnSaleCheckBox.setPreferredSize(new Dimension(100, 30));
		menuManagementPanel.add(menuOnSaleCheckBox);

		menuSearchButton.setBackground(new Color(204, 204, 204));
		menuSearchButton.setFont(new Font("Segoe UI", 0, 14));
		menuSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		menuSearchButton.setText("Search");
		menuSearchButton.setBorder(null);
		menuSearchButton.setBorderPainted(false);
		menuSearchButton.setPreferredSize(new Dimension(100, 30));
		menuManagementPanel.add(menuSearchButton);

		menuTablePane.setPreferredSize(new Dimension(950, 500));

		menuTable.setFont(new Font("Segoe UI", 0, 12));
		menuTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null } },
				new String[] { "0", "Dish ID", "Dish name", "Group", "Type", "Unit", "Size", "Price", "On sale" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		menuTablePane.setViewportView(menuTable);

		menuManagementPanel.add(menuTablePane);

		menuParentPane.addTab("Menu", menuManagementPanel);

		materialsManagementPanel.setBackground(new Color(255, 255, 255));
		materialsManagementPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		materialsTotalHeaderLabel.setFont(new Font("Segoe UI", 0, 16));
		materialsTotalHeaderLabel.setText("Bought:");
		materialsTotalHeaderLabel.setPreferredSize(new Dimension(80, 40));
		materialsManagementPanel.add(materialsTotalHeaderLabel);

		materialsTotalAmountLabel.setFont(new Font("Segoe UI", 0, 16));
		materialsTotalAmountLabel.setText("00.000.000");
		materialsTotalAmountLabel.setPreferredSize(new Dimension(350, 40));
		materialsManagementPanel.add(materialsTotalAmountLabel);

		addMaterialButton.setBackground(new Color(255, 204, 204));
		addMaterialButton.setFont(new Font("Segoe UI", 0, 14));
		addMaterialButton.setText("Add new material");
		addMaterialButton.setBorder(null);
		addMaterialButton.setBorderPainted(false);
		addMaterialButton.setPreferredSize(new Dimension(150, 40));

		materialsManagementPanel.add(addMaterialButton);

		importMaterialsButton.setBackground(new Color(255, 204, 204));
		importMaterialsButton.setFont(new Font("Segoe UI", 0, 14));
		importMaterialsButton.setText("Import excel file");
		importMaterialsButton.setBorder(null);
		importMaterialsButton.setBorderPainted(false);
		importMaterialsButton.setPreferredSize(new Dimension(150, 40));
		materialsManagementPanel.add(importMaterialsButton);

		exportMaterialsButton.setBackground(new Color(255, 204, 204));
		exportMaterialsButton.setFont(new Font("Segoe UI", 0, 14));
		exportMaterialsButton.setText("Export excel file");
		exportMaterialsButton.setBorder(null);
		exportMaterialsButton.setBorderPainted(false);
		exportMaterialsButton.setPreferredSize(new Dimension(150, 40));
		materialsManagementPanel.add(exportMaterialsButton);

		materialsSearchField.setFont(new Font("Segoe UI", 0, 12));
		materialsSearchField.setForeground(new Color(204, 204, 204));
		materialsSearchField.setText("Search by key ...");
		materialsSearchField.setPreferredSize(new Dimension(300, 30));

		materialsManagementPanel.add(materialsSearchField);

		materialsUnitComboBox.setFont(new Font("Segoe UI", 0, 13));
		materialsUnitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All units", "box (24)", "box (20)",
				"box (10)", "box (12)", "bottle", "kg", "l", "g", "ml", "loaf" }));
		materialsUnitComboBox.setBorder(null);
		materialsUnitComboBox.setOpaque(false);
		materialsUnitComboBox.setPreferredSize(new Dimension(100, 30));
		materialsManagementPanel.add(materialsUnitComboBox);

		materialsSearchButton.setBackground(new Color(204, 204, 204));
		materialsSearchButton.setFont(new Font("Segoe UI", 0, 14));
		materialsSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		materialsSearchButton.setText("Search");
		materialsSearchButton.setBorder(null);
		materialsSearchButton.setBorderPainted(false);
		materialsSearchButton.setPreferredSize(new Dimension(100, 30));
		materialsManagementPanel.add(materialsSearchButton);

		meterialsBlank.setPreferredSize(new Dimension(400, 30));
		materialsManagementPanel.add(meterialsBlank);

		materialsTablePane.setPreferredSize(new Dimension(950, 500));

		materialsTable.setFont(new Font("Segoe UI", 0, 12));
		materialsTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "0", "Stuff name", "Unit", "Supplier ID", "Dish IDs used", "Unit", "Price", "Bought" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		materialsTablePane.setViewportView(materialsTable);

		materialsManagementPanel.add(materialsTablePane);

		menuParentPane.addTab("Materials", materialsManagementPanel);

		contentPanel.add(menuParentPane, "card11");
		// create mmeterials panel

		return menuParentPane;
	}

	private JTabbedPane partnerParentPane() {
		JPanel suppliersPanel = new JPanel();
		JTextField supplierSearchField = new JTextField();
		JButton supplierSearchButton = new JButton();
		JButton addSupplierButton = new JButton();
		JButton importSupplierButton = new JButton();
		JButton exportSuppliersButton = new JButton();
		JLabel supplierQtyTitleLabel = new JLabel();
		JLabel supplierQtyAmountLabel = new JLabel();
		JLabel supplierBlank = new JLabel();
		JLabel supplierTotalPaidTitle = new JLabel();
		JLabel supplierTotalPaidAmount = new JLabel();
		JLabel supplierTotalDebtTitle = new JLabel();
		JLabel supplierTotalDebtAmount = new JLabel();
		JScrollPane suppliersTablePane = new JScrollPane();
		JTable jTable5 = new JTable();
		JPanel customersPanel = new JPanel();
		JTextField cusSearchField = new JTextField();
		JButton cusSearchButton = new JButton();
		JButton addCusButton = new JButton();
		JButton importCusButton = new JButton();
		JButton exportCusButton = new JButton();
		JLabel cusQtyTitle = new JLabel();
		JLabel cusQtyAmount = new JLabel();
		JLabel cusBlank = new JLabel();
		JLabel cusTotalPaidTitle = new JLabel();
		JLabel cusTotalPaidAmount = new JLabel();
		JLabel cusDiscountedTitle = new JLabel();
		JLabel cusDiscountedAmount = new JLabel();
		JScrollPane cusTablePane = new JScrollPane();
		JTable cusTable = new JTable();

		// create suppliers panel
		partnerParentPane = new JTabbedPane();
		partnerParentPane.setFont(new Font("Segoe UI", 1, 18));
		partnerParentPane.setPreferredSize(new Dimension(1000, 739));

		suppliersPanel.setBackground(new Color(255, 255, 255));
		suppliersPanel.setPreferredSize(new Dimension(900, 673));
		suppliersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		supplierSearchField.setForeground(new Color(204, 204, 204));
		supplierSearchField.setText("Search ...");
		supplierSearchField.setPreferredSize(new Dimension(380, 40));

		suppliersPanel.add(supplierSearchField);

		supplierSearchButton.setBackground(new Color(255, 255, 255));
		supplierSearchButton.setFont(new Font("Segoe UI", 0, 14));
		supplierSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		supplierSearchButton.setBorder(null);
		supplierSearchButton.setBorderPainted(false);
		supplierSearchButton.setPreferredSize(new Dimension(50, 40));
		suppliersPanel.add(supplierSearchButton);

		addSupplierButton.setBackground(new Color(255, 204, 204));
		addSupplierButton.setFont(new Font("Segoe UI", 0, 14));
		addSupplierButton.setText("Add new supplier");
		addSupplierButton.setBorder(null);
		addSupplierButton.setBorderPainted(false);
		addSupplierButton.setPreferredSize(new Dimension(150, 40));

		suppliersPanel.add(addSupplierButton);

		importSupplierButton.setBackground(new Color(255, 204, 204));
		importSupplierButton.setFont(new Font("Segoe UI", 0, 14));
		importSupplierButton.setText("Import excel file");
		importSupplierButton.setBorder(null);
		importSupplierButton.setBorderPainted(false);
		importSupplierButton.setPreferredSize(new Dimension(150, 40));
		suppliersPanel.add(importSupplierButton);

		exportSuppliersButton.setBackground(new Color(255, 204, 204));
		exportSuppliersButton.setFont(new Font("Segoe UI", 0, 14));
		exportSuppliersButton.setText("Export excel file");
		exportSuppliersButton.setBorder(null);
		exportSuppliersButton.setBorderPainted(false);
		exportSuppliersButton.setPreferredSize(new Dimension(150, 40));
		suppliersPanel.add(exportSuppliersButton);

		supplierQtyTitleLabel.setFont(new Font("Segoe UI", 0, 14));
		supplierQtyTitleLabel.setText("Total supplier:");
		supplierQtyTitleLabel.setPreferredSize(new Dimension(150, 30));
		suppliersPanel.add(supplierQtyTitleLabel);

		supplierQtyAmountLabel.setFont(new Font("Segoe UI", 0, 14));
		supplierQtyAmountLabel.setText("000");
		supplierQtyAmountLabel.setPreferredSize(new Dimension(50, 30));
		suppliersPanel.add(supplierQtyAmountLabel);

		supplierBlank.setPreferredSize(new Dimension(250, 30));
		suppliersPanel.add(supplierBlank);

		supplierTotalPaidTitle.setFont(new Font("Segoe UI", 0, 14));
		supplierTotalPaidTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		supplierTotalPaidTitle.setText("Total paid:");
		supplierTotalPaidTitle.setPreferredSize(new Dimension(100, 30));
		suppliersPanel.add(supplierTotalPaidTitle);

		supplierTotalPaidAmount.setFont(new Font("Segoe UI", 0, 14));
		supplierTotalPaidAmount.setText("0.000.000");
		supplierTotalPaidAmount.setPreferredSize(new Dimension(100, 30));
		suppliersPanel.add(supplierTotalPaidAmount);

		supplierTotalDebtTitle.setFont(new Font("Segoe UI", 0, 14));
		supplierTotalDebtTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		supplierTotalDebtTitle.setText("Total debt:");
		supplierTotalDebtTitle.setPreferredSize(new Dimension(100, 30));
		suppliersPanel.add(supplierTotalDebtTitle);

		supplierTotalDebtAmount.setFont(new Font("Segoe UI", 0, 14));
		supplierTotalDebtAmount.setText("0.000.000");
		supplierTotalDebtAmount.setPreferredSize(new Dimension(100, 30));
		suppliersPanel.add(supplierTotalDebtAmount);

		suppliersTablePane.setPreferredSize(new Dimension(950, 500));

		jTable5.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "0", "Supplier ID", "Supplier name", "Phone num", "Total paid", "Dept",
						"Delivery cost" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		suppliersTablePane.setViewportView(jTable5);

		suppliersPanel.add(suppliersTablePane);

		partnerParentPane.addTab("Suppliers", suppliersPanel);

		customersPanel.setBackground(new Color(255, 255, 255));
		customersPanel.setPreferredSize(new Dimension(1000, 673));
		customersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		cusSearchField.setForeground(new Color(204, 204, 204));
		cusSearchField.setText("Search ...");
		cusSearchField.setPreferredSize(new Dimension(380, 40));

		customersPanel.add(cusSearchField);

		cusSearchButton.setBackground(new Color(255, 255, 255));
		cusSearchButton.setFont(new Font("Segoe UI", 0, 14));
		cusSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		cusSearchButton.setBorder(null);
		cusSearchButton.setBorderPainted(false);
		cusSearchButton.setPreferredSize(new Dimension(50, 40));
		customersPanel.add(cusSearchButton);

		addCusButton.setBackground(new Color(255, 204, 204));
		addCusButton.setFont(new Font("Segoe UI", 0, 14));
		addCusButton.setText("Add new Customer");
		addCusButton.setBorder(null);
		addCusButton.setBorderPainted(false);
		addCusButton.setPreferredSize(new Dimension(150, 40));

		customersPanel.add(addCusButton);

		importCusButton.setBackground(new Color(255, 204, 204));
		importCusButton.setFont(new Font("Segoe UI", 0, 14));
		importCusButton.setText("Import excel file");
		importCusButton.setBorder(null);
		importCusButton.setBorderPainted(false);
		importCusButton.setPreferredSize(new Dimension(150, 40));

		customersPanel.add(importCusButton);

		exportCusButton.setBackground(new Color(255, 204, 204));
		exportCusButton.setFont(new Font("Segoe UI", 0, 14));
		exportCusButton.setText("Export excel file");
		exportCusButton.setBorder(null);
		exportCusButton.setBorderPainted(false);
		exportCusButton.setPreferredSize(new Dimension(150, 40));

		customersPanel.add(exportCusButton);

		cusQtyTitle.setFont(new Font("Segoe UI", 0, 14));
		cusQtyTitle.setText("Total customer:");
		cusQtyTitle.setPreferredSize(new Dimension(150, 30));
		customersPanel.add(cusQtyTitle);

		cusQtyAmount.setFont(new Font("Segoe UI", 0, 14));
		cusQtyAmount.setText("000");
		cusQtyAmount.setPreferredSize(new Dimension(50, 30));
		customersPanel.add(cusQtyAmount);

		cusBlank.setPreferredSize(new Dimension(250, 30));
		customersPanel.add(cusBlank);

		cusTotalPaidTitle.setFont(new Font("Segoe UI", 0, 14));
		cusTotalPaidTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		cusTotalPaidTitle.setText("Total:");
		cusTotalPaidTitle.setPreferredSize(new Dimension(100, 30));
		customersPanel.add(cusTotalPaidTitle);

		cusTotalPaidAmount.setFont(new Font("Segoe UI", 0, 14));
		cusTotalPaidAmount.setText("0.000.000");
		cusTotalPaidAmount.setPreferredSize(new Dimension(100, 30));
		customersPanel.add(cusTotalPaidAmount);

		cusDiscountedTitle.setFont(new Font("Segoe UI", 0, 14));
		cusDiscountedTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		cusDiscountedTitle.setText("Discounted:");
		cusDiscountedTitle.setPreferredSize(new Dimension(100, 30));
		customersPanel.add(cusDiscountedTitle);

		cusDiscountedAmount.setFont(new Font("Segoe UI", 0, 14));
		cusDiscountedAmount.setText("- 0.000.000");
		cusDiscountedAmount.setPreferredSize(new Dimension(100, 30));
		customersPanel.add(cusDiscountedAmount);

		cusTablePane.setPreferredSize(new Dimension(950, 500));

		cusTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Customer ID", "Customer name", "Phone num", "Bought", "Discount" }));
		cusTablePane.setViewportView(cusTable);

		customersPanel.add(cusTablePane);

		partnerParentPane.addTab("Customers", customersPanel);

		contentPanel.add(partnerParentPane, "card8");

		// create customers panel

		return partnerParentPane;
	}

	private JPanel discountPanel() {
		JLabel discountTotalTitle = new JLabel();
		JLabel discountTotalAmount = new JLabel();
		JButton addDiscountButton = new JButton();
		JButton importDiscountButton = new JButton();
		JButton exportDiscountButton = new JButton();
		JTextField discountSearchField = new JTextField();
		JComboBox discountTypeComboBox = new JComboBox<>();
		JLabel discountFromLabel = new JLabel();
		JDateChooser discountStartedDate = new JDateChooser();
		JLabel discountToLabel = new JLabel();
		JDateChooser discountEndedDate = new JDateChooser();
		JButton discountSearchButton = new JButton();
		JScrollPane discountTablePane = new JScrollPane();
		JTable discountTable = new JTable();

		discountPanel = new JPanel();
		discountPanel.setBackground(new Color(255, 255, 255));
		discountPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		discountTotalTitle.setFont(new Font("Segoe UI", 0, 14));
		discountTotalTitle.setText("Discounted:");
		discountTotalTitle.setPreferredSize(new Dimension(100, 40));
		discountPanel.add(discountTotalTitle);

		discountTotalAmount.setFont(new Font("Segoe UI", 0, 14));
		discountTotalAmount.setText("- 0.000.000");
		discountTotalAmount.setPreferredSize(new Dimension(330, 40));
		discountPanel.add(discountTotalAmount);

		addDiscountButton.setBackground(new Color(255, 204, 204));
		addDiscountButton.setFont(new Font("Segoe UI", 0, 14));
		addDiscountButton.setText("Add new discount");
		addDiscountButton.setBorder(null);
		addDiscountButton.setBorderPainted(false);
		addDiscountButton.setPreferredSize(new Dimension(150, 40));

		discountPanel.add(addDiscountButton);

		importDiscountButton.setBackground(new Color(255, 204, 204));
		importDiscountButton.setFont(new Font("Segoe UI", 0, 14));
		importDiscountButton.setText("Import excel file");
		importDiscountButton.setBorder(null);
		importDiscountButton.setBorderPainted(false);
		importDiscountButton.setPreferredSize(new Dimension(150, 40));
		discountPanel.add(importDiscountButton);

		exportDiscountButton.setBackground(new Color(255, 204, 204));
		exportDiscountButton.setFont(new Font("Segoe UI", 0, 14));
		exportDiscountButton.setText("Export excel file");
		exportDiscountButton.setBorder(null);
		exportDiscountButton.setBorderPainted(false);
		exportDiscountButton.setPreferredSize(new Dimension(150, 40));
		discountPanel.add(exportDiscountButton);

		discountSearchField.setForeground(new Color(204, 204, 204));
		discountSearchField.setText("Search ...");
		discountSearchField.setPreferredSize(new Dimension(300, 30));

		discountPanel.add(discountSearchField);

		discountTypeComboBox.setFont(new Font("Segoe UI", 0, 13));
		discountTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All type", "by percent", "by vnd" }));
		discountTypeComboBox.setBorder(null);
		discountTypeComboBox.setOpaque(false);
		discountTypeComboBox.setPreferredSize(new Dimension(100, 30));
		discountPanel.add(discountTypeComboBox);

		discountFromLabel.setFont(new Font("Segoe UI", 0, 14));
		discountFromLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		discountFromLabel.setText("From");
		discountFromLabel.setPreferredSize(new Dimension(40, 30));
		discountPanel.add(discountFromLabel);

		discountStartedDate.setMinimumSize(new Dimension(150, 30));
		discountStartedDate.setPreferredSize(new Dimension(150, 30));
		discountPanel.add(discountStartedDate);

		discountToLabel.setFont(new Font("Segoe UI", 0, 14));
		discountToLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		discountToLabel.setText("to");
		discountToLabel.setPreferredSize(new Dimension(20, 30));
		discountPanel.add(discountToLabel);

		discountEndedDate.setPreferredSize(new Dimension(150, 30));
		discountPanel.add(discountEndedDate);

		discountSearchButton.setBackground(new Color(255, 255, 255));
		discountSearchButton.setFont(new Font("Segoe UI", 1, 14));
		discountSearchButton.setForeground(Color.blue);
		discountSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		discountSearchButton.setText("Search");
		discountSearchButton.setBorder(null);
		discountSearchButton.setBorderPainted(false);
		discountSearchButton.setPreferredSize(new Dimension(100, 30));

		discountPanel.add(discountSearchButton);

		discountTablePane.setPreferredSize(new Dimension(950, 500));

		discountTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "", "Discount code", "Cost", "Num of users", "Discounted", "Started date",
						"Ended date" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		discountTablePane.setViewportView(discountTable);

		discountPanel.add(discountTablePane);

		contentPanel.add(discountPanel, "card5");
		return discountPanel;
	}

	private JPanel staffPanel() {
		JTextField staffSearchField = new JTextField();
		JButton staffSearchButton = new JButton();
		JButton addStaffButton = new JButton();
		JButton importStaffButton = new JButton();
		JButton exportStaffButton = new JButton();
		JLabel staffQtyTitle = new JLabel();
		JLabel staffTotalSalaryTitle = new JLabel();
		JLabel staffTotalSalaryAmount = new JLabel();
		JScrollPane staffTablePane = new JScrollPane();
		JTable staffTable = new JTable();
		JLabel header = new JLabel();
		JButton edit = new JButton();
		JPanel identityPanel = new JPanel();
		JLabel identity = new JLabel();
		JLabel employeeName = new JLabel();
		JTextField nameField = new JTextField();
		JLabel gender = new JLabel();
		JCheckBox male = new JCheckBox();
		JCheckBox female = new JCheckBox();
		JLabel idCardNum = new JLabel();
		JTextField idCardNumField = new JTextField();
		JLabel employeeID = new JLabel();
		JTextField employeeIDField = new JTextField();
		JLabel Password = new JLabel();
		JButton changePass = new JButton();
		JLabel lastChangedPass = new JLabel();
		JPanel photoPanel = new JPanel();
		JLabel portraitPhoto = new JLabel();
		JButton uploadPhoto = new JButton();
		JPanel connectionPanel = new JPanel();
		JLabel connection = new JLabel();
		JLabel phoneNum = new JLabel();
		JTextField phoneNumField = new JTextField();
		JLabel email = new JLabel();
		JTextField emailField = new JTextField();
		JLabel address = new JLabel();
		JTextField addressField = new JTextField();
		JPanel workPanel = new JPanel();
		JLabel work = new JLabel();
		JLabel position = new JLabel();
		JTextField positionField = new JTextField();
		JLabel salary = new JLabel();
		JTextField salaryField = new JTextField();
		JLabel enterDate = new JLabel();
		JDateChooser endDateField = new JDateChooser();
		JLabel endDate = new JLabel();
		JDateChooser enterDateField = new JDateChooser();

		staffPanel = new JPanel();
		staffPanel.setBackground(new Color(255, 255, 255));
		staffPanel.setPreferredSize(new Dimension(900, 739));
		staffPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));

		staffSearchField.setForeground(new Color(204, 204, 204));
		staffSearchField.setText("Search ...");
		staffSearchField.setPreferredSize(new Dimension(380, 40));

		staffPanel.add(staffSearchField);

		staffSearchButton.setBackground(new Color(255, 255, 255));
		staffSearchButton.setFont(new Font("Segoe UI", 0, 14));
		staffSearchButton.setIcon(new ImageIcon("icons8_search_24px_1.png"));
		staffSearchButton.setBorder(null);
		staffSearchButton.setBorderPainted(false);
		staffSearchButton.setPreferredSize(new Dimension(50, 40));
		staffPanel.add(staffSearchButton);

		addStaffButton.setBackground(new Color(255, 204, 204));
		addStaffButton.setFont(new Font("Segoe UI", 0, 14));
		addStaffButton.setText("Add new staff");
		addStaffButton.setBorder(null);
		addStaffButton.setBorderPainted(false);
		addStaffButton.setPreferredSize(new Dimension(150, 40));

		staffPanel.add(addStaffButton);

		importStaffButton.setBackground(new Color(255, 204, 204));
		importStaffButton.setFont(new Font("Segoe UI", 0, 14));
		importStaffButton.setText("Import excel file");
		importStaffButton.setBorder(null);
		importStaffButton.setBorderPainted(false);
		importStaffButton.setPreferredSize(new Dimension(150, 40));
		staffPanel.add(importStaffButton);

		exportStaffButton.setBackground(new Color(255, 204, 204));
		exportStaffButton.setFont(new Font("Segoe UI", 0, 14));
		exportStaffButton.setText("Export excel file");
		exportStaffButton.setBorder(null);
		exportStaffButton.setBorderPainted(false);
		exportStaffButton.setPreferredSize(new Dimension(150, 40));
		staffPanel.add(exportStaffButton);

		staffQtyTitle.setFont(new Font("Segoe UI", 0, 14));
		staffQtyTitle.setText("Total staff:   000   ");
		staffQtyTitle.setPreferredSize(new Dimension(500, 30));
		staffPanel.add(staffQtyTitle);

		staffTotalSalaryTitle.setFont(new Font("Segoe UI", 0, 14));
		staffTotalSalaryTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		staffTotalSalaryTitle.setText("Total salary paid:");
		staffTotalSalaryTitle.setPreferredSize(new Dimension(300, 30));
		staffPanel.add(staffTotalSalaryTitle);

		staffTotalSalaryAmount.setFont(new Font("Segoe UI", 0, 14));
		staffTotalSalaryAmount.setHorizontalAlignment(SwingConstants.CENTER);
		staffTotalSalaryAmount.setText("0.000.000");
		staffTotalSalaryAmount.setPreferredSize(new Dimension(100, 30));
		staffPanel.add(staffTotalSalaryAmount);

		staffTablePane.setPreferredSize(new Dimension(950, 500));

		staffTable.setFont(new Font("Segoe UI", 0, 14));
		staffTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "0", "Staff ID", "Staff name", "Phone num", "Position", "Salary debt" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		staffTable.setVerifyInputWhenFocusTarget(false);
		staffTablePane.setViewportView(staffTable);

		staffPanel.add(staffTablePane);

		contentPanel.add(staffPanel, "card5");
		return staffPanel;
	}

	private JTabbedPane settingParentPane(ArrayList<ArrayList<String>> unitItemLists) {
		settingParentPane = new JTabbedPane();
		settingParentPane.setBackground(new Color(255, 255, 255));
		settingParentPane.setFont(new Font("Segoe UI", 1, 14));
		settingParentPane.setPreferredSize(new Dimension(1000, 739));

		settingParentPane.addTab("Menu setup", menuSetupScrollPane(unitItemLists));
		settingParentPane.addTab("Work setup", scheduleSetupPanel());
		settingParentPane.addTab("Timekeeping setup", createTimeKeepingSetupPanel());
		settingParentPane.addTab("Salary setup", createSalarySetupPanel());

		return settingParentPane;
	}

// of Setting card panel
	private JScrollPane menuSetupScrollPane(ArrayList<ArrayList<String>> itemLists) {
		JScrollPane menuSetupScrollPane = new JScrollPane();
		JPanel menuSetupPanel = new JPanel();
		menuSetupPanel.setBackground(whiteColor);
		menuSetupPanel.setPreferredSize(new Dimension(900, 1500));
		menuSetupPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
		// lam de nhan nhieu list ma van biet duoc list thuoc phan nao???
		// -> tam thoi mac dinh vi tri
		// nho xoa cai item nay
		itemLists = new ArrayList<>();

		ArrayList<String> drinkItemList = new ArrayList<>();
		drinkItemList.add("drink");

		ArrayList<String> foodItemList = new ArrayList<>();
		foodItemList.add("food");

		ArrayList<String> toppingItemList = new ArrayList<>();
		toppingItemList.add("topping");

		ArrayList<String> comboItemList = new ArrayList<>();
		comboItemList.add("combo");

		ArrayList<String> meterialsItemList = new ArrayList<>();
		meterialsItemList.add("meterials");

		itemLists.add(drinkItemList);
		itemLists.add(foodItemList);
		itemLists.add(toppingItemList);
		itemLists.add(comboItemList);
		itemLists.add(meterialsItemList);
		itemLists.add(drinkItemList);
		itemLists.add(foodItemList);
		itemLists.add(toppingItemList);
		itemLists.add(comboItemList);
		itemLists.add(meterialsItemList);

		menuSetupPanel.add(unitPanel("Drink", itemLists.get(0), itemLists.get(1)));
		menuSetupPanel.add(unitPanel("Food", itemLists.get(2), itemLists.get(3)));
		menuSetupPanel.add(unitPanel("Topping", itemLists.get(4), itemLists.get(5)));
		menuSetupPanel.add(unitPanel("Combo", itemLists.get(6), itemLists.get(7)));
		menuSetupPanel.add(unitPanel("Meterials", itemLists.get(8), itemLists.get(9)));

		return menuSetupScrollPane;
	}

	// of Setting card panel
	private JPanel scheduleSetupPanel() {
		JButton holidaySetupButton = new JButton();
		JButton shiftSetupButton = new JButton();
		JButton schedulingButton = new JButton();
		JPanel workSetupCards = new JPanel();
		JPanel holidayPanel = new JPanel();
		JLabel holidayBlank = new JLabel();
		JButton createHolidayButton = new JButton();
		JButton removeHolidayButton = new JButton();
		JButton importHolidayButton = new JButton();
		JButton exportHolidayButton = new JButton();
		JScrollPane holidayTablePane = new JScrollPane();
		JTable holidayTable = new JTable();
		JPanel shiftPanel = new JPanel();
		JLabel holidayBlank1 = new JLabel();
		JButton createShiftButton = new JButton();
		JButton removeShiftButton = new JButton();
		JButton importShiftButton = new JButton();
		JButton exportShiftButton = new JButton();
		JScrollPane shiftTablePane = new JScrollPane();
		JTable shiftTable = new JTable();
		JPanel schedulingPanel = new JPanel();
		JCalendar schedulingCalendar = new JCalendar();
		JPanel createTimetablePanel = new JPanel();
		JLabel createScheduleTitle = new JLabel();
		JComboBox shiftChoosingComboBox = new JComboBox<>();
		JScrollPane staffIDTextArea = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JButton staffChoosingComboBox = new JButton();
		JLabel dayStartTitle = new JLabel();
		JDateChooser scheduleStartedDate = new JDateChooser();
		JCheckBox scheduleRepeatCheckBox = new JCheckBox();
		JSpinner dayRepeatSchedule = new JSpinner();
		JComboBox repeatScheduleTypeComboBox = new JComboBox<>();
		JLabel dayEndTile = new JLabel();
		JDateChooser scheduleEndedDate = new JDateChooser();
		JButton createScheduleButton = new JButton();
		JScrollPane scheduleTablePane = new JScrollPane();
		JTable scheduleTable = new JTable();

		JPanel workShedulePanel = new JPanel();
		workShedulePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 30));

		holidaySetupButton.setBackground(new Color(255, 255, 255));
		holidaySetupButton.setFont(new Font("Segoe UI", 1, 15));
		holidaySetupButton.setText("Holidays set up");
		holidaySetupButton.setPreferredSize(new Dimension(150, 45));

		workShedulePanel.add(holidaySetupButton);

		shiftSetupButton.setBackground(new Color(255, 255, 255));
		shiftSetupButton.setFont(new Font("Segoe UI", 1, 15));
		shiftSetupButton.setText("Shift set up");
		shiftSetupButton.setPreferredSize(new Dimension(150, 45));
		workShedulePanel.add(shiftSetupButton);

		schedulingButton.setBackground(new Color(255, 255, 255));
		schedulingButton.setFont(new Font("Segoe UI", 1, 15));
		schedulingButton.setText("Scheduling");
		schedulingButton.setPreferredSize(new Dimension(150, 45));
		workShedulePanel.add(schedulingButton);

		workSetupCards.setBackground(new Color(255, 255, 255));
		workSetupCards.setPreferredSize(new Dimension(1000, 590));
		workSetupCards.setLayout(new CardLayout());

		holidayPanel.setBackground(new Color(255, 255, 255));
		holidayPanel.setMinimumSize(new Dimension(1388, 550));
		holidayPanel.setPreferredSize(new Dimension(1050, 600));
		holidayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

		holidayBlank.setPreferredSize(new Dimension(300, 45));
		holidayPanel.add(holidayBlank);

		createHolidayButton.setBackground(new Color(255, 204, 204));
		createHolidayButton.setText("Create a holiday");
		createHolidayButton.setPreferredSize(new Dimension(130, 45));
		holidayPanel.add(createHolidayButton);

		removeHolidayButton.setBackground(new Color(255, 204, 204));
		removeHolidayButton.setText("Remove choosed  holidays");
		removeHolidayButton.setPreferredSize(new Dimension(190, 45));
		holidayPanel.add(removeHolidayButton);

		importHolidayButton.setBackground(new Color(255, 204, 204));
		importHolidayButton.setText("Import excel file");
		importHolidayButton.setPreferredSize(new Dimension(130, 45));
		holidayPanel.add(importHolidayButton);

		exportHolidayButton.setBackground(new Color(255, 204, 204));
		exportHolidayButton.setText("Export excel file");
		exportHolidayButton.setPreferredSize(new Dimension(130, 45));
		holidayPanel.add(exportHolidayButton);

		holidayTablePane.setMinimumSize(new Dimension(950, 450));
		holidayTablePane.setPreferredSize(new Dimension(950, 450));

		holidayTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "0", "Holiday name", "From", "To", "Total days" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		holidayTablePane.setViewportView(holidayTable);

		holidayPanel.add(holidayTablePane);

		workSetupCards.add(holidayPanel, "card4");

		shiftPanel.setBackground(new Color(255, 255, 255));
		shiftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

		holidayBlank1.setPreferredSize(new Dimension(350, 45));
		shiftPanel.add(holidayBlank1);

		createShiftButton.setBackground(new Color(255, 204, 204));
		createShiftButton.setText("Create a shift");
		createShiftButton.setPreferredSize(new Dimension(110, 45));
		shiftPanel.add(createShiftButton);

		removeShiftButton.setBackground(new Color(255, 204, 204));
		removeShiftButton.setText("Remove choosed  shift");
		removeShiftButton.setPreferredSize(new Dimension(160, 45));
		shiftPanel.add(removeShiftButton);

		importShiftButton.setBackground(new Color(255, 204, 204));
		importShiftButton.setText("Import excel file");
		importShiftButton.setPreferredSize(new Dimension(130, 45));
		shiftPanel.add(importShiftButton);

		exportShiftButton.setBackground(new Color(255, 204, 204));
		exportShiftButton.setText("Export excel file");
		exportShiftButton.setPreferredSize(new Dimension(130, 45));
		shiftPanel.add(exportShiftButton);

		shiftTablePane.setPreferredSize(new Dimension(950, 450));

		shiftTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "0", "Shift name", "From", "To", "Num of staffs", "Staff group" }) {
			Class[] types = new Class[] { java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class, java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		shiftTablePane.setViewportView(shiftTable);

		shiftPanel.add(shiftTablePane);

		workSetupCards.add(shiftPanel, "card4");

		schedulingPanel.setBackground(new Color(255, 255, 255));
		schedulingPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		schedulingCalendar.setPreferredSize(new Dimension(450, 530));
		schedulingPanel.add(schedulingCalendar);

		createTimetablePanel.setOpaque(false);
		createTimetablePanel.setPreferredSize(new Dimension(500, 530));
		createTimetablePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

		createScheduleTitle.setFont(new Font("Segoe UI", 1, 16));
		createScheduleTitle.setForeground(new Color(255, 0, 51));
		createScheduleTitle.setText("Create new schedulde");
		createScheduleTitle.setPreferredSize(new Dimension(475, 40));
		createTimetablePanel.add(createScheduleTitle);

		shiftChoosingComboBox.setFont(new Font("Segoe UI", 0, 14));
		shiftChoosingComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose a shift", "shift a", "..." }));
		shiftChoosingComboBox.setBorder(null);
		shiftChoosingComboBox.setPreferredSize(new Dimension(475, 30));
		createTimetablePanel.add(shiftChoosingComboBox);

		staffIDTextArea.setPreferredSize(new Dimension(340, 55));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setPreferredSize(new Dimension(164, 55));
		staffIDTextArea.setViewportView(jTextArea1);

		createTimetablePanel.add(staffIDTextArea);

		staffChoosingComboBox.setFont(new Font("Segoe UI", 0, 12));
		staffChoosingComboBox.setText("Choose staffs");
		staffChoosingComboBox.setPreferredSize(new Dimension(125, 55));
		createTimetablePanel.add(staffChoosingComboBox);

		dayStartTitle.setFont(new Font("Segoe UI", 0, 13));
		dayStartTitle.setText("Day start");
		dayStartTitle.setPreferredSize(new Dimension(55, 30));
		createTimetablePanel.add(dayStartTitle);

		scheduleStartedDate.setPreferredSize(new Dimension(120, 30));
		createTimetablePanel.add(scheduleStartedDate);

		scheduleRepeatCheckBox.setFont(new Font("Segoe UI", 0, 14));
		scheduleRepeatCheckBox.setText("Repeat");
		createTimetablePanel.add(scheduleRepeatCheckBox);

		dayRepeatSchedule.setModel(new SpinnerNumberModel(0, 0, null, 1));
		dayRepeatSchedule.setPreferredSize(new Dimension(90, 30));
		createTimetablePanel.add(dayRepeatSchedule);

		repeatScheduleTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Day", "Week" }));
		repeatScheduleTypeComboBox.setPreferredSize(new Dimension(101, 30));
		createTimetablePanel.add(repeatScheduleTypeComboBox);

		dayEndTile.setFont(new Font("Segoe UI", 0, 13));
		dayEndTile.setText("to");
		dayEndTile.setPreferredSize(new Dimension(55, 30));
		createTimetablePanel.add(dayEndTile);

		scheduleEndedDate.setPreferredSize(new Dimension(120, 30));
		createTimetablePanel.add(scheduleEndedDate);

		createScheduleButton.setBackground(new Color(255, 204, 204));
		createScheduleButton.setFont(new Font("Segoe UI", 1, 14));
		createScheduleButton.setText("Create");
		createScheduleButton.setPreferredSize(new Dimension(280, 30));
		createTimetablePanel.add(createScheduleButton);

		scheduleTablePane.setPreferredSize(new Dimension(475, 280));

		scheduleTable
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Shift name", "From", "To", "Staff IDs" }));
		scheduleTablePane.setViewportView(scheduleTable);

		createTimetablePanel.add(scheduleTablePane);

		schedulingPanel.add(createTimetablePanel);

		workSetupCards.add(schedulingPanel, "card2");

		workShedulePanel.add(workSetupCards);

		settingParentPane.addTab("Work shedule", workShedulePanel);

		return workShedulePanel;
	}

	// of Setting card panel
	private JPanel createTimeKeepingSetupPanel() {
		JPanel timekeepingPanel = new JPanel();
		JButton timekeepingStatisticsButton = new JButton();
		JButton timekeepingAutoCalculButton = new JButton();
		JPanel timekeepingCards = new JPanel();
		JPanel timekeepingStatisticsPanel = new JPanel();
		JLabel satisticsBlank = new JLabel();
		JButton timekeepingManualButton = new JButton();
		JButton importTimekeepingButton = new JButton();
		JButton exportTimekeepingButton = new JButton();
		JScrollPane timekeepingTablePane = new JScrollPane();
		JTable timekeepingTable = new JTable();
		JPanel timekeepingSetupPanel = new JPanel();
		JPanel lateCalculationPanel = new JPanel();
		JLabel lateHeader = new JLabel();
		JLabel lateTitle = new JLabel();
		JTextField lateMinuteField = new JTextField();
		JLabel lateMinuteLabel = new JLabel();
		JLabel earlyTitle = new JLabel();
		JTextField earlyMinuteField = new JTextField();
		JLabel earlyMinLabel = new JLabel();
		JSeparator autoCalTimekeepingSeparator = new JSeparator();
		JPanel overtimeCalculationPanel = new JPanel();
		JLabel ovHeader = new JLabel();
		JLabel ovBeforeShiftTitle = new JLabel();
		JTextField ovBeforeShiftMinField = new JTextField();
		JLabel ovBeforeShiftMinLabel = new JLabel();
		JLabel ovAfterShiftMinTitle = new JLabel();
		JTextField ovAfterShiftMinField = new JTextField();
		JLabel ovAfterShiftMinLabel = new JLabel();
		JLabel timekeepingBlank = new JLabel();
		JButton turnOffAutoCalButton = new JButton();
		JButton saveAutoCalButton = new JButton();
		timekeepingPanel.setPreferredSize(new Dimension(1000, 750));
		timekeepingPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 30));

		timekeepingStatisticsButton.setBackground(new Color(255, 255, 255));
		timekeepingStatisticsButton.setFont(new Font("Segoe UI", 1, 15));
		timekeepingStatisticsButton.setText("Statistics");
		timekeepingStatisticsButton.setPreferredSize(new Dimension(100, 45));
		timekeepingPanel.add(timekeepingStatisticsButton);

		timekeepingAutoCalculButton.setBackground(new Color(255, 255, 255));
		timekeepingAutoCalculButton.setFont(new Font("Segoe UI", 1, 15));
		timekeepingAutoCalculButton.setText("Automatic calulation");
		timekeepingAutoCalculButton.setPreferredSize(new Dimension(180, 45));
		timekeepingPanel.add(timekeepingAutoCalculButton);

		timekeepingCards.setBackground(new Color(255, 255, 255));
		timekeepingCards.setPreferredSize(new Dimension(1000, 590));
		timekeepingCards.setLayout(new CardLayout());

		timekeepingStatisticsPanel.setBackground(new Color(255, 255, 255));
		timekeepingStatisticsPanel.setPreferredSize(new Dimension(1000, 590));
		timekeepingStatisticsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

		satisticsBlank.setPreferredSize(new Dimension(490, 45));
		timekeepingStatisticsPanel.add(satisticsBlank);

		timekeepingManualButton.setBackground(new Color(255, 204, 204));
		timekeepingManualButton.setText("manual timekeeping");
		timekeepingManualButton.setPreferredSize(new Dimension(150, 45));
		timekeepingStatisticsPanel.add(timekeepingManualButton);

		importTimekeepingButton.setBackground(new Color(255, 204, 204));
		importTimekeepingButton.setText("Import excel file");
		importTimekeepingButton.setPreferredSize(new Dimension(130, 45));
		timekeepingStatisticsPanel.add(importTimekeepingButton);

		exportTimekeepingButton.setBackground(new Color(255, 204, 204));
		exportTimekeepingButton.setText("Export excel file");
		exportTimekeepingButton.setPreferredSize(new Dimension(130, 45));
		timekeepingStatisticsPanel.add(exportTimekeepingButton);

		timekeepingTablePane.setPreferredSize(new Dimension(950, 450));

		timekeepingTable
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Date", "Shift name", "Staff ID", "Status" }));
		timekeepingTablePane.setViewportView(timekeepingTable);

		timekeepingStatisticsPanel.add(timekeepingTablePane);

		timekeepingCards.add(timekeepingStatisticsPanel, "card6");

		timekeepingSetupPanel.setBackground(Color.white);
		timekeepingSetupPanel.setPreferredSize(new Dimension(1000, 300));
		timekeepingSetupPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 15));

		lateCalculationPanel.setBackground(new Color(255, 255, 255));
		lateCalculationPanel.setPreferredSize(new Dimension(450, 185));
		lateCalculationPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));

		lateHeader.setFont(new Font("Segoe UI", 1, 15));
		lateHeader.setForeground(new Color(255, 51, 0));
		lateHeader.setText("Automatically calculate going late, leaving early");
		lateHeader.setPreferredSize(new Dimension(400, 35));
		lateCalculationPanel.add(lateHeader);

		lateTitle.setFont(new Font("Segoe UI", 0, 14));
		lateTitle.setText("Being late after");
		lateTitle.setPreferredSize(new Dimension(200, 30));
		lateCalculationPanel.add(lateTitle);

		lateMinuteField.setFont(new Font("Segoe UI", 0, 14));
		lateMinuteField.setHorizontalAlignment(JTextField.RIGHT);
		lateMinuteField.setText("5");
		lateMinuteField.setPreferredSize(new Dimension(100, 30));
		lateCalculationPanel.add(lateMinuteField);

		lateMinuteLabel.setFont(new Font("Segoe UI", 0, 14));
		lateMinuteLabel.setText("minutes");
		lateMinuteLabel.setPreferredSize(new Dimension(100, 30));
		lateCalculationPanel.add(lateMinuteLabel);

		earlyTitle.setFont(new Font("Segoe UI", 0, 14));
		earlyTitle.setText("Leaving early before");
		earlyTitle.setPreferredSize(new Dimension(200, 30));
		lateCalculationPanel.add(earlyTitle);

		earlyMinuteField.setFont(new Font("Segoe UI", 0, 14));
		earlyMinuteField.setHorizontalAlignment(JTextField.RIGHT);
		earlyMinuteField.setText("15");
		earlyMinuteField.setPreferredSize(new Dimension(100, 30));
		lateCalculationPanel.add(earlyMinuteField);

		earlyMinLabel.setFont(new Font("Segoe UI", 0, 14));
		earlyMinLabel.setText("minutes");
		earlyMinLabel.setPreferredSize(new Dimension(100, 30));
		lateCalculationPanel.add(earlyMinLabel);

		timekeepingSetupPanel.add(lateCalculationPanel);

		autoCalTimekeepingSeparator.setOrientation(SwingConstants.VERTICAL);
		autoCalTimekeepingSeparator.setPreferredSize(new Dimension(10, 185));
		timekeepingSetupPanel.add(autoCalTimekeepingSeparator);

		overtimeCalculationPanel.setBackground(new Color(255, 255, 255));
		overtimeCalculationPanel.setPreferredSize(new Dimension(450, 185));
		overtimeCalculationPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));

		ovHeader.setFont(new Font("Segoe UI", 1, 15));
		ovHeader.setForeground(new Color(255, 51, 0));
		ovHeader.setText("Automatically calculate overtime");
		ovHeader.setPreferredSize(new Dimension(400, 35));
		overtimeCalculationPanel.add(ovHeader);

		ovBeforeShiftTitle.setFont(new Font("Segoe UI", 0, 14));
		ovBeforeShiftTitle.setText("Overtime calculation before shift");
		ovBeforeShiftTitle.setPreferredSize(new Dimension(200, 30));
		overtimeCalculationPanel.add(ovBeforeShiftTitle);

		ovBeforeShiftMinField.setFont(new Font("Segoe UI", 0, 14));
		ovBeforeShiftMinField.setHorizontalAlignment(JTextField.RIGHT);
		ovBeforeShiftMinField.setText("5");
		ovBeforeShiftMinField.setPreferredSize(new Dimension(100, 30));
		overtimeCalculationPanel.add(ovBeforeShiftMinField);

		ovBeforeShiftMinLabel.setFont(new Font("Segoe UI", 0, 14));
		ovBeforeShiftMinLabel.setText("minutes");
		ovBeforeShiftMinLabel.setPreferredSize(new Dimension(100, 30));
		overtimeCalculationPanel.add(ovBeforeShiftMinLabel);

		ovAfterShiftMinTitle.setFont(new Font("Segoe UI", 0, 14));
		ovAfterShiftMinTitle.setText("Overtime calculation after shift");
		ovAfterShiftMinTitle.setPreferredSize(new Dimension(200, 30));
		overtimeCalculationPanel.add(ovAfterShiftMinTitle);

		ovAfterShiftMinField.setFont(new Font("Segoe UI", 0, 14));
		ovAfterShiftMinField.setHorizontalAlignment(JTextField.RIGHT);
		ovAfterShiftMinField.setText("15");
		ovAfterShiftMinField.setPreferredSize(new Dimension(100, 30));
		overtimeCalculationPanel.add(ovAfterShiftMinField);

		ovAfterShiftMinLabel.setFont(new Font("Segoe UI", 0, 14));
		ovAfterShiftMinLabel.setText("minutes");
		ovAfterShiftMinLabel.setPreferredSize(new Dimension(100, 30));
		overtimeCalculationPanel.add(ovAfterShiftMinLabel);

		timekeepingSetupPanel.add(overtimeCalculationPanel);

		timekeepingBlank.setPreferredSize(new Dimension(650, 40));
		timekeepingSetupPanel.add(timekeepingBlank);

		turnOffAutoCalButton.setFont(new Font("Segoe UI", 1, 14));
		turnOffAutoCalButton.setText("Turn off");
		turnOffAutoCalButton.setPreferredSize(new Dimension(120, 40));
		timekeepingSetupPanel.add(turnOffAutoCalButton);

		saveAutoCalButton.setBackground(new Color(255, 204, 204));
		saveAutoCalButton.setFont(new Font("Segoe UI", 1, 14));
		saveAutoCalButton.setText("Save");
		saveAutoCalButton.setPreferredSize(new Dimension(150, 40));
		timekeepingSetupPanel.add(saveAutoCalButton);

		timekeepingCards.add(timekeepingSetupPanel, "card3");

		timekeepingPanel.add(timekeepingCards);

		settingParentPane.addTab("Timekeeping", timekeepingPanel);
		return timekeepingSetupPanel;
	}

	// of Setting card panel
	private JPanel createSalarySetupPanel() {
		ButtonGroup buttonGroup1 = new ButtonGroup();
		ButtonGroup buttonGroup2 = new ButtonGroup();
		ButtonGroup buttonGroup3 = new ButtonGroup();
		ButtonGroup buttonGroup4 = new ButtonGroup();
		ButtonGroup buttonGroup5 = new ButtonGroup();
		ButtonGroup buttonGroup6 = new ButtonGroup();

		JPanel salarySetupPanel = new JPanel();
		JButton salaryStatisticsButton = new JButton();
		JButton calSalaryButton = new JButton();
		JPanel salaryParentPanel = new JPanel();
		JPanel timekeepingSetupPanel1 = new JPanel();
		JPanel basicSalarySetupPanel = new JPanel();
		JLabel salaryStartDay = new JLabel();
		JLabel everyMonth = new JLabel();
		JLabel dateLabel1 = new JLabel();
		JComboBox dayChoosing1 = new JComboBox<>();
		JLabel salaryBlank1 = new JLabel();
		JLabel twiceAMonth = new JLabel();
		JLabel dateLabel2 = new JLabel();
		JComboBox dayChoosing2 = new JComboBox<>();
		JLabel dateLabel3 = new JLabel();
		JComboBox dayChoosing3 = new JComboBox<>();
		JLabel everyWeek = new JLabel();
		JComboBox dateOfWeekChoosing1 = new JComboBox<>();
		JLabel salaryBlank2 = new JLabel();
		JLabel twiceAWeek = new JLabel();
		JComboBox dateOfWeekChoosing2 = new JComboBox<>();
		JLabel circleTittle = new JLabel();
		JLabel numOfDayForACircleLabel = new JLabel();
		JSpinner numOfDayForACircle = new JSpinner();
		JLabel salaryBlank3 = new JLabel();
		JLabel sumSalaryDayLabel = new JLabel();
		JComboBox sumDayChoosing = new JComboBox<>();
		JLabel paySalaryDayLabel = new JLabel();
		JComboBox paySalaryDayChoosing = new JComboBox<>();
		JLabel setupSalaryTittle = new JLabel();
		JLabel typeOfStaffLabel = new JLabel();
		JComboBox typeOfStaffChoosing = new JComboBox<>();
		JLabel salaryBlank5 = new JLabel();
		JLabel payPeriodLabel = new JLabel();
		JComboBox payPeriodChoosing = new JComboBox<>();
		JLabel salaryBlank6 = new JLabel();
		JLabel mainSalaryLabel = new JLabel();
		JComboBox mainSalaryChoosing = new JComboBox<>();
		JLabel salaryBlank7 = new JLabel();
		JLabel wageLabel = new JLabel();
		JLabel casualDayWageLabel = new JLabel();
		JTextField casualDayWageField = new JTextField();
		JLabel periodUnit1 = new JLabel();
		JLabel salaryBlank8 = new JLabel();
		JLabel dayOffWageLabel = new JLabel();
		JTextField dayOffWageField = new JTextField();
		JRadioButton vndUnitOption1 = new JRadioButton();
		JRadioButton percentUnitOption1 = new JRadioButton();
		JLabel salaryBlank9 = new JLabel();
		JLabel holidayWageLabel = new JLabel();
		JTextField holidayWageField = new JTextField();
		JRadioButton vndUnitOption2 = new JRadioButton();
		JRadioButton percentUnitOption2 = new JRadioButton();
		JScrollPane advancedSalarySetupSP = new JScrollPane();
		JPanel advancedSalarySetupPanel = new JPanel();
		JLabel otherOptionsHeader = new JLabel();
		JCheckBox extraHoursCheckbox = new JCheckBox();
		JLabel casualDayExtraWageLabel = new JLabel();
		JTextField casualDayExtraWageField = new JTextField();
		JLabel percentUnit1 = new JLabel();
		JLabel otherOptionBlank1 = new JLabel();
		JLabel offDayExtraWageLabel = new JLabel();
		JTextField offDayExtraWageField = new JTextField();
		JLabel percentUnit2 = new JLabel();
		JLabel otherOptionBlank2 = new JLabel();
		JLabel jLabel25 = new JLabel();
		JTextField jTextField16 = new JTextField();
		JLabel percentUnit3 = new JLabel();
		JCheckBox bonusByRevenueCheckbox = new JCheckBox();
		JLabel lowestRevenueRangeLabel = new JLabel();
		JTextField lowestRevenueRangeField = new JTextField();
		JRadioButton vndUnitOption3 = new JRadioButton();
		JRadioButton percentUnitOption3 = new JRadioButton();
		JLabel overRevenueRangeLabel = new JLabel();
		JTextField overRevenueRangeField = new JTextField();
		JLabel otherOptionBlank3 = new JLabel();
		JLabel bonusLabel = new JLabel();
		JTextField bonusField = new JTextField();
		JRadioButton vndUnitOption4 = new JRadioButton();
		JRadioButton percentUnitOption4 = new JRadioButton();
		JToggleButton addExtraBonusConditionBtn = new JToggleButton();
		JToggleButton removeExtraBonusConditionBtn = new JToggleButton();
		JScrollPane extraBonusConditionSP = new JScrollPane();
		JList extraBonusConditionList = new JList<>();
		JCheckBox bonusCheckbox = new JCheckBox();
		JLabel typeOfBonusLabel = new JLabel();
		JTextField tpeOfBonusField = new JTextField();
		JLabel rangeOfBonusLabel = new JLabel();
		JTextField rangeOfBonusField = new JTextField();
		JRadioButton vndUnitOption5 = new JRadioButton();
		JRadioButton percentUnitOption5 = new JRadioButton();
		JToggleButton addBonusConditionBtn = new JToggleButton();
		JToggleButton removeBonusConditionBtn = new JToggleButton();
		JScrollPane bonusConditionSP = new JScrollPane();
		JList bonusConditionList = new JList<>();
		JCheckBox deductionCheckbox = new JCheckBox();
		JLabel typeOfDeductionLabel = new JLabel();
		JTextField typeOfDeductionField = new JTextField();
		JLabel rangeOfDeductionLabel = new JLabel();
		JTextField rangeOfDeductionField = new JTextField();
		JRadioButton vndUnitOption6 = new JRadioButton();
		JRadioButton pecentUnitOption6 = new JRadioButton();
		JToggleButton addDeductionConditionBtn = new JToggleButton();
		JToggleButton removeDeductionConditionBtn = new JToggleButton();
		JScrollPane deductionConditionSP = new JScrollPane();
		JList deductionConditionList = new JList<>();
		JButton saveButton = new JButton();
		JPanel calSalaryPanel = new JPanel();
		JLabel calBlank = new JLabel();
		JButton timekeepingManualButton3 = new JButton();
		JButton importTimekeepingButton3 = new JButton();
		JButton exportTimekeepingButton3 = new JButton();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTable jTable1 = new JTable();
		JPanel functionSetupPanel = new JPanel();
		JPanel appSetupPanel = new JPanel();

		salarySetupPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 30));

		salaryStatisticsButton.setBackground(new Color(255, 255, 255));
		salaryStatisticsButton.setFont(new Font("Segoe UI", 1, 15));
		salaryStatisticsButton.setText("Statistics");
		salaryStatisticsButton.setPreferredSize(new Dimension(100, 45));
		salarySetupPanel.add(salaryStatisticsButton);

		calSalaryButton.setBackground(new Color(255, 255, 255));
		calSalaryButton.setFont(new Font("Segoe UI", 1, 15));
		calSalaryButton.setText("Calculating salary");
		calSalaryButton.setPreferredSize(new Dimension(160, 45));
		salarySetupPanel.add(calSalaryButton);

		salaryParentPanel.setBackground(new Color(255, 255, 255));
		salaryParentPanel.setPreferredSize(new Dimension(1000, 590));
		salaryParentPanel.setLayout(new CardLayout());

		timekeepingSetupPanel1.setBackground(new Color(255, 255, 255));
		timekeepingSetupPanel1.setPreferredSize(new Dimension(1000, 590));
		timekeepingSetupPanel1.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 15));

		basicSalarySetupPanel.setOpaque(false);
		basicSalarySetupPanel.setPreferredSize(new Dimension(450, 500));
		basicSalarySetupPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 7));

		salaryStartDay.setFont(new Font("Segoe UI", 1, 16));
		salaryStartDay.setForeground(new Color(255, 0, 51));
		salaryStartDay.setText("Ngay bat dau tinh luong:");
		salaryStartDay.setPreferredSize(new Dimension(350, 30));
		basicSalarySetupPanel.add(salaryStartDay);

		everyMonth.setFont(new Font("Segoe UI", 0, 14));
		everyMonth.setText("Hang thang:");
		everyMonth.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(everyMonth);

		dateLabel1.setFont(new Font("Segoe UI", 0, 14));
		dateLabel1.setForeground(new Color(153, 153, 153));
		dateLabel1.setText("Ngay");
		dateLabel1.setPreferredSize(new Dimension(35, 25));
		basicSalarySetupPanel.add(dateLabel1);

		dayChoosing1.setFont(new Font("Segoe UI", 0, 14));
		dayChoosing1.setModel(new DefaultComboBoxModel<>(new String[] { "Day 01", "Day 02", "Day 03", "Day 04",
				"Day 05", "Day 06", "Day 07", "Day 08", "Day 09", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14",
				"Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
				"Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31" }));
		dayChoosing1.setBorder(null);
		dayChoosing1.setOpaque(false);
		dayChoosing1.setPreferredSize(new Dimension(85, 25));

		basicSalarySetupPanel.add(dayChoosing1);

		salaryBlank1.setPreferredSize(new Dimension(130, 25));
		basicSalarySetupPanel.add(salaryBlank1);

		twiceAMonth.setFont(new Font("Segoe UI", 0, 14));
		twiceAMonth.setText("2 lan 1 thang:");
		twiceAMonth.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(twiceAMonth);

		dateLabel2.setFont(new Font("Segoe UI", 0, 14));
		dateLabel2.setForeground(new Color(153, 153, 153));
		dateLabel2.setText("Ngay");
		dateLabel2.setPreferredSize(new Dimension(35, 25));
		basicSalarySetupPanel.add(dateLabel2);

		dayChoosing2.setFont(new Font("Segoe UI", 0, 14));
		dayChoosing2.setModel(new DefaultComboBoxModel<>(new String[] { "Day 01", "Day 02", "Day 03", "Day 04",
				"Day 05", "Day 06", "Day 07", "Day 08", "Day 09", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14",
				"Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
				"Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31" }));
		dayChoosing2.setBorder(null);
		dayChoosing2.setOpaque(false);
		dayChoosing2.setPreferredSize(new Dimension(85, 25));
		basicSalarySetupPanel.add(dayChoosing2);

		dateLabel3.setFont(new Font("Segoe UI", 0, 14));
		dateLabel3.setForeground(new Color(153, 153, 153));
		dateLabel3.setText("va Ngay");
		dateLabel3.setPreferredSize(new Dimension(50, 25));
		basicSalarySetupPanel.add(dateLabel3);

		dayChoosing3.setFont(new Font("Segoe UI", 0, 14));
		dayChoosing3.setModel(new DefaultComboBoxModel<>(new String[] { "Day 01", "Day 02", "Day 03", "Day 04",
				"Day 05", "Day 06", "Day 07", "Day 08", "Day 09", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14",
				"Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
				"Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31" }));
		dayChoosing3.setBorder(null);
		dayChoosing3.setOpaque(false);
		dayChoosing3.setPreferredSize(new Dimension(85, 25));
		basicSalarySetupPanel.add(dayChoosing3);

		everyWeek.setFont(new Font("Segoe UI", 0, 14));
		everyWeek.setText("Hang tuan:");
		everyWeek.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(everyWeek);

		dateOfWeekChoosing1.setFont(new Font("Segoe UI", 0, 14));
		dateOfWeekChoosing1.setModel(new DefaultComboBoxModel<>(
				new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", " " }));
		dateOfWeekChoosing1.setBorder(null);
		dateOfWeekChoosing1.setOpaque(false);
		dateOfWeekChoosing1.setPreferredSize(new Dimension(125, 25));
		basicSalarySetupPanel.add(dateOfWeekChoosing1);

		salaryBlank2.setPreferredSize(new Dimension(130, 25));
		basicSalarySetupPanel.add(salaryBlank2);

		twiceAWeek.setFont(new Font("Segoe UI", 0, 14));
		twiceAWeek.setText("2 tuan 1 lan:");
		twiceAWeek.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(twiceAWeek);

		dateOfWeekChoosing2.setFont(new Font("Segoe UI", 0, 14));
		dateOfWeekChoosing2.setModel(new DefaultComboBoxModel<>(
				new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", " " }));
		dateOfWeekChoosing2.setBorder(null);
		dateOfWeekChoosing2.setOpaque(false);
		dateOfWeekChoosing2.setPreferredSize(new Dimension(125, 25));
		basicSalarySetupPanel.add(dateOfWeekChoosing2);

		circleTittle.setFont(new Font("Segoe UI", 1, 16));
		circleTittle.setForeground(new Color(255, 0, 51));
		circleTittle.setText("Chu ky luong:");
		circleTittle.setPreferredSize(new Dimension(350, 30));
		basicSalarySetupPanel.add(circleTittle);

		numOfDayForACircleLabel.setFont(new Font("Segoe UI", 0, 14));
		numOfDayForACircleLabel.setText("So ngay 1 chu ky:");
		numOfDayForACircleLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(numOfDayForACircleLabel);

		numOfDayForACircle.setModel(new SpinnerNumberModel(0, null, 31, 1));
		numOfDayForACircle.setPreferredSize(new Dimension(75, 25));
		basicSalarySetupPanel.add(numOfDayForACircle);

		salaryBlank3.setPreferredSize(new Dimension(130, 25));
		basicSalarySetupPanel.add(salaryBlank3);

		sumSalaryDayLabel.setFont(new Font("Segoe UI", 0, 14));
		sumSalaryDayLabel.setText("Ngay chot luong:");
		sumSalaryDayLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(sumSalaryDayLabel);

		sumDayChoosing.setFont(new Font("Segoe UI", 0, 14));
		sumDayChoosing.setModel(new DefaultComboBoxModel<>(new String[] { "Day 01", "Day 02", "Day 03", "Day 04",
				"Day 05", "Day 06", "Day 07", "Day 08", "Day 09", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14",
				"Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
				"Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31" }));
		sumDayChoosing.setBorder(null);
		sumDayChoosing.setOpaque(false);
		sumDayChoosing.setPreferredSize(new Dimension(85, 25));
		basicSalarySetupPanel.add(sumDayChoosing);

		paySalaryDayLabel.setFont(new Font("Segoe UI", 0, 14));
		paySalaryDayLabel.setText("Ngay tra luong:");
		paySalaryDayLabel.setPreferredSize(new Dimension(100, 25));
		basicSalarySetupPanel.add(paySalaryDayLabel);

		paySalaryDayChoosing.setFont(new Font("Segoe UI", 0, 14));
		paySalaryDayChoosing.setModel(new DefaultComboBoxModel<>(new String[] { "Day 01", "Day 02", "Day 03", "Day 04",
				"Day 05", "Day 06", "Day 07", "Day 08", "Day 09", "Day 10", "Day 11", "Day 12", "Day 13", "Day 14",
				"Day 15", "Day 16", "Day 17", "Day 18", "Day 19", "Day 20", "Day 21", "Day 22", "Day 23", "Day 24",
				"Day 25", "Day 26", "Day 27", "Day 28", "Day 29", "Day 30", "Day 31" }));
		paySalaryDayChoosing.setBorder(null);
		paySalaryDayChoosing.setOpaque(false);
		paySalaryDayChoosing.setPreferredSize(new Dimension(85, 25));

		basicSalarySetupPanel.add(paySalaryDayChoosing);

		setupSalaryTittle.setFont(new Font("Segoe UI", 1, 16));
		setupSalaryTittle.setForeground(new Color(255, 0, 51));
		setupSalaryTittle.setText("Thiet lap luong:");
		setupSalaryTittle.setPreferredSize(new Dimension(350, 30));
		basicSalarySetupPanel.add(setupSalaryTittle);

		typeOfStaffLabel.setFont(new Font("Segoe UI", 0, 14));
		typeOfStaffLabel.setText("Loai nhan vien:");
		typeOfStaffLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(typeOfStaffLabel);

		typeOfStaffChoosing.setFont(new Font("Segoe UI", 0, 14));
		typeOfStaffChoosing
				.setModel(new DefaultComboBoxModel<>(new String[] { "Nhan vien hanh chinh", "nhan vien hop dong" }));
		typeOfStaffChoosing.setBorder(null);
		typeOfStaffChoosing.setOpaque(false);
		typeOfStaffChoosing.setPreferredSize(new Dimension(180, 25));
		basicSalarySetupPanel.add(typeOfStaffChoosing);

		salaryBlank5.setPreferredSize(new Dimension(100, 25));
		basicSalarySetupPanel.add(salaryBlank5);

		payPeriodLabel.setFont(new Font("Segoe UI", 0, 14));
		payPeriodLabel.setText("Ky han tra luong:");
		payPeriodLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(payPeriodLabel);

		payPeriodChoosing.setFont(new Font("Segoe UI", 0, 14));
		payPeriodChoosing.setModel(new DefaultComboBoxModel<>(
				new String[] { "Hang thang", "2 lan/thang", "Hang tuan", "1 lan/2 tuan", " " }));
		payPeriodChoosing.setBorder(null);
		payPeriodChoosing.setOpaque(false);
		payPeriodChoosing.setPreferredSize(new Dimension(120, 25));
		basicSalarySetupPanel.add(payPeriodChoosing);

		salaryBlank6.setPreferredSize(new Dimension(130, 25));
		basicSalarySetupPanel.add(salaryBlank6);

		mainSalaryLabel.setFont(new Font("Segoe UI", 0, 14));
		mainSalaryLabel.setText("Luong chinh:");
		mainSalaryLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(mainSalaryLabel);

		mainSalaryChoosing.setFont(new Font("Segoe UI", 0, 14));
		mainSalaryChoosing
				.setModel(new DefaultComboBoxModel<>(new String[] { "Theo ca", "Theo ky luong", "Theo gio" }));
		mainSalaryChoosing.setBorder(null);
		mainSalaryChoosing.setOpaque(false);
		mainSalaryChoosing.setPreferredSize(new Dimension(120, 25));
		basicSalarySetupPanel.add(mainSalaryChoosing);

		salaryBlank7.setPreferredSize(new Dimension(130, 25));
		basicSalarySetupPanel.add(salaryBlank7);

		wageLabel.setFont(new Font("Segoe UI", 1, 14));
		wageLabel.setText("Muc luong:");
		wageLabel.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(wageLabel);

		casualDayWageLabel.setFont(new Font("Segoe UI", 0, 14));
		casualDayWageLabel.setForeground(new Color(153, 153, 153));
		casualDayWageLabel.setText("Ngay thuong");
		casualDayWageLabel.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(casualDayWageLabel);

		casualDayWageField.setFont(new Font("Segoe UI", 0, 14));
		casualDayWageField.setHorizontalAlignment(JTextField.RIGHT);
		casualDayWageField.setText("0.000.000");
		casualDayWageField.setBorder(null);
		casualDayWageField.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(casualDayWageField);

		periodUnit1.setFont(new Font("Segoe UI", 0, 14));
		periodUnit1.setForeground(new Color(153, 153, 153));
		periodUnit1.setText("/ky");
		periodUnit1.setPreferredSize(new Dimension(25, 25));
		basicSalarySetupPanel.add(periodUnit1);

		salaryBlank8.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(salaryBlank8);

		dayOffWageLabel.setFont(new Font("Segoe UI", 0, 14));
		dayOffWageLabel.setForeground(new Color(153, 153, 153));
		dayOffWageLabel.setText("Ngay nghi");
		dayOffWageLabel.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(dayOffWageLabel);

		dayOffWageField.setFont(new Font("Segoe UI", 0, 14));
		dayOffWageField.setHorizontalAlignment(JTextField.RIGHT);
		dayOffWageField.setText("0.000.000");
		dayOffWageField.setBorder(null);
		dayOffWageField.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(dayOffWageField);

		vndUnitOption1.setBackground(new Color(255, 255, 255));
		buttonGroup5.add(vndUnitOption1);
		vndUnitOption1.setFont(new Font("Segoe UI", 0, 12));
		vndUnitOption1.setSelected(true);
		vndUnitOption1.setText("VND");
		vndUnitOption1.setOpaque(false);
		vndUnitOption1.setPreferredSize(new Dimension(50, 25));
		basicSalarySetupPanel.add(vndUnitOption1);

		percentUnitOption1.setBackground(new Color(255, 255, 255));
		buttonGroup5.add(percentUnitOption1);
		percentUnitOption1.setFont(new Font("Segoe UI", 0, 12));
		percentUnitOption1.setForeground(new Color(153, 153, 153));
		percentUnitOption1.setText("%");
		percentUnitOption1.setOpaque(false);
		basicSalarySetupPanel.add(percentUnitOption1);

		salaryBlank9.setPreferredSize(new Dimension(110, 25));
		basicSalarySetupPanel.add(salaryBlank9);

		holidayWageLabel.setFont(new Font("Segoe UI", 0, 14));
		holidayWageLabel.setForeground(new Color(153, 153, 153));
		holidayWageLabel.setText("Ngay le tet");
		holidayWageLabel.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(holidayWageLabel);

		holidayWageField.setFont(new Font("Segoe UI", 0, 14));
		holidayWageField.setHorizontalAlignment(JTextField.RIGHT);
		holidayWageField.setText("0.000.000");
		holidayWageField.setBorder(null);
		holidayWageField.setPreferredSize(new Dimension(90, 25));
		basicSalarySetupPanel.add(holidayWageField);

		vndUnitOption2.setBackground(new Color(255, 255, 255));
		buttonGroup6.add(vndUnitOption2);
		vndUnitOption2.setFont(new Font("Segoe UI", 0, 12));
		vndUnitOption2.setSelected(true);
		vndUnitOption2.setText("VND");
		vndUnitOption2.setOpaque(false);
		vndUnitOption2.setPreferredSize(new Dimension(50, 25));
		basicSalarySetupPanel.add(vndUnitOption2);

		percentUnitOption2.setBackground(new Color(255, 255, 255));
		buttonGroup6.add(percentUnitOption2);
		percentUnitOption2.setFont(new Font("Segoe UI", 0, 12));
		percentUnitOption2.setForeground(new Color(153, 153, 153));
		percentUnitOption2.setText("%");
		percentUnitOption2.setOpaque(false);
		basicSalarySetupPanel.add(percentUnitOption2);

		timekeepingSetupPanel1.add(basicSalarySetupPanel);

		advancedSalarySetupSP.setBorder(null);
		advancedSalarySetupSP.setPreferredSize(new Dimension(500, 500));

		advancedSalarySetupPanel.setBackground(new Color(255, 255, 255));
		advancedSalarySetupPanel.setPreferredSize(new Dimension(450, 1500));
		advancedSalarySetupPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));

		otherOptionsHeader.setFont(new Font("Segoe UI", 1, 16));
		otherOptionsHeader.setForeground(new Color(255, 0, 51));
		otherOptionsHeader.setText("Cac tuy chon khac:");
		otherOptionsHeader.setPreferredSize(new Dimension(450, 30));
		advancedSalarySetupPanel.add(otherOptionsHeader);

		extraHoursCheckbox.setBackground(new Color(255, 255, 255));
		extraHoursCheckbox.setFont(new Font("Segoe UI", 1, 14));
		extraHoursCheckbox.setSelected(true);
		extraHoursCheckbox.setText("Lam them gio (Tinh theo he so luong)");
		extraHoursCheckbox.setBorder(null);
		extraHoursCheckbox.setPreferredSize(new Dimension(450, 30));
		advancedSalarySetupPanel.add(extraHoursCheckbox);

		casualDayExtraWageLabel.setFont(new Font("Segoe UI", 0, 14));
		casualDayExtraWageLabel.setForeground(new Color(153, 153, 153));
		casualDayExtraWageLabel.setText("Ngay thuong");
		casualDayExtraWageLabel.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(casualDayExtraWageLabel);

		casualDayExtraWageField.setFont(new Font("Segoe UI", 0, 14));
		casualDayExtraWageField.setHorizontalAlignment(JTextField.RIGHT);
		casualDayExtraWageField.setText("000");
		casualDayExtraWageField.setBorder(null);
		casualDayExtraWageField.setPreferredSize(new Dimension(50, 25));
		advancedSalarySetupPanel.add(casualDayExtraWageField);

		percentUnit1.setFont(new Font("Segoe UI", 0, 14));
		percentUnit1.setForeground(new Color(153, 153, 153));
		percentUnit1.setText("%");
		percentUnit1.setPreferredSize(new Dimension(70, 25));
		advancedSalarySetupPanel.add(percentUnit1);

		otherOptionBlank1.setPreferredSize(new Dimension(150, 25));
		advancedSalarySetupPanel.add(otherOptionBlank1);

		offDayExtraWageLabel.setFont(new Font("Segoe UI", 0, 14));
		offDayExtraWageLabel.setForeground(new Color(153, 153, 153));
		offDayExtraWageLabel.setText("Ngay nghi");
		offDayExtraWageLabel.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(offDayExtraWageLabel);

		offDayExtraWageField.setFont(new Font("Segoe UI", 0, 14));
		offDayExtraWageField.setHorizontalAlignment(JTextField.RIGHT);
		offDayExtraWageField.setText("000");
		offDayExtraWageField.setBorder(null);
		offDayExtraWageField.setPreferredSize(new Dimension(50, 25));
		advancedSalarySetupPanel.add(offDayExtraWageField);

		percentUnit2.setFont(new Font("Segoe UI", 0, 14));
		percentUnit2.setForeground(new Color(153, 153, 153));
		percentUnit2.setText("%");
		percentUnit2.setPreferredSize(new Dimension(70, 25));
		advancedSalarySetupPanel.add(percentUnit2);

		otherOptionBlank2.setPreferredSize(new Dimension(150, 25));
		advancedSalarySetupPanel.add(otherOptionBlank2);

		jLabel25.setFont(new Font("Segoe UI", 0, 14));
		jLabel25.setForeground(new Color(153, 153, 153));
		jLabel25.setText("Ngay le tet");
		jLabel25.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(jLabel25);

		jTextField16.setFont(new Font("Segoe UI", 0, 14));
		jTextField16.setHorizontalAlignment(JTextField.RIGHT);
		jTextField16.setText("000");
		jTextField16.setBorder(null);
		jTextField16.setPreferredSize(new Dimension(50, 25));
		advancedSalarySetupPanel.add(jTextField16);

		percentUnit3.setFont(new Font("Segoe UI", 0, 14));
		percentUnit3.setForeground(new Color(153, 153, 153));
		percentUnit3.setText("%");
		percentUnit3.setPreferredSize(new Dimension(70, 25));
		advancedSalarySetupPanel.add(percentUnit3);

		bonusByRevenueCheckbox.setBackground(new Color(255, 255, 255));
		bonusByRevenueCheckbox.setFont(new Font("Segoe UI", 1, 14));
		bonusByRevenueCheckbox.setSelected(true);
		bonusByRevenueCheckbox.setText("Thuong doanh so (Tinh tren tong doanh thu)");
		bonusByRevenueCheckbox.setBorder(null);
		bonusByRevenueCheckbox.setPreferredSize(new Dimension(450, 30));
		advancedSalarySetupPanel.add(bonusByRevenueCheckbox);

		lowestRevenueRangeLabel.setFont(new Font("Segoe UI", 0, 14));
		lowestRevenueRangeLabel.setText("Doanh thu toi thieu:");
		lowestRevenueRangeLabel.setPreferredSize(new Dimension(130, 25));
		advancedSalarySetupPanel.add(lowestRevenueRangeLabel);

		lowestRevenueRangeField.setFont(new Font("Segoe UI", 0, 14));
		lowestRevenueRangeField.setHorizontalAlignment(JTextField.RIGHT);
		lowestRevenueRangeField.setText("0.000.000");
		lowestRevenueRangeField.setBorder(null);
		lowestRevenueRangeField.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(lowestRevenueRangeField);

		vndUnitOption3.setBackground(new Color(255, 255, 255));
		buttonGroup4.add(vndUnitOption3);
		vndUnitOption3.setFont(new Font("Segoe UI", 0, 14));
		vndUnitOption3.setSelected(true);
		vndUnitOption3.setText("VND");
		vndUnitOption3.setOpaque(false);
		vndUnitOption3.setPreferredSize(new Dimension(60, 25));
		advancedSalarySetupPanel.add(vndUnitOption3);

		percentUnitOption3.setBackground(new Color(255, 255, 255));
		buttonGroup4.add(percentUnitOption3);
		percentUnitOption3.setFont(new Font("Segoe UI", 0, 14));
		percentUnitOption3.setForeground(new Color(153, 153, 153));
		percentUnitOption3.setText("%");
		percentUnitOption3.setOpaque(false);
		percentUnitOption3.setPreferredSize(new Dimension(40, 25));
		advancedSalarySetupPanel.add(percentUnitOption3);

		overRevenueRangeLabel.setFont(new Font("Segoe UI", 0, 14));
		overRevenueRangeLabel.setText("Vuot toi thieu tu:");
		overRevenueRangeLabel.setPreferredSize(new Dimension(130, 25));
		advancedSalarySetupPanel.add(overRevenueRangeLabel);

		overRevenueRangeField.setFont(new Font("Segoe UI", 0, 14));
		overRevenueRangeField.setHorizontalAlignment(JTextField.RIGHT);
		overRevenueRangeField.setText("0.000.000");
		overRevenueRangeField.setBorder(null);
		overRevenueRangeField.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(overRevenueRangeField);

		otherOptionBlank3.setFont(new Font("Segoe UI", 0, 14));
		otherOptionBlank3.setText("VND");
		otherOptionBlank3.setPreferredSize(new Dimension(200, 25));
		advancedSalarySetupPanel.add(otherOptionBlank3);

		bonusLabel.setFont(new Font("Segoe UI", 0, 14));
		bonusLabel.setText("Thuong:");
		bonusLabel.setPreferredSize(new Dimension(130, 25));
		advancedSalarySetupPanel.add(bonusLabel);

		bonusField.setFont(new Font("Segoe UI", 0, 14));
		bonusField.setHorizontalAlignment(JTextField.TRAILING);
		bonusField.setText("00.000");
		bonusField.setBorder(null);
		bonusField.setPreferredSize(new Dimension(100, 25));
		advancedSalarySetupPanel.add(bonusField);

		vndUnitOption4.setBackground(new Color(255, 255, 255));
		buttonGroup3.add(vndUnitOption4);
		vndUnitOption4.setFont(new Font("Segoe UI", 0, 14));
		vndUnitOption4.setSelected(true);
		vndUnitOption4.setText("VND");
		vndUnitOption4.setOpaque(false);
		vndUnitOption4.setPreferredSize(new Dimension(60, 25));
		advancedSalarySetupPanel.add(vndUnitOption4);

		percentUnitOption4.setBackground(new Color(255, 255, 255));
		buttonGroup3.add(percentUnitOption4);
		percentUnitOption4.setFont(new Font("Segoe UI", 0, 14));
		percentUnitOption4.setForeground(new Color(153, 153, 153));
		percentUnitOption4.setText("%");
		percentUnitOption4.setOpaque(false);
		percentUnitOption4.setPreferredSize(new Dimension(40, 25));
		advancedSalarySetupPanel.add(percentUnitOption4);

		addExtraBonusConditionBtn.setBackground(new Color(204, 204, 255));
		addExtraBonusConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		addExtraBonusConditionBtn.setText("Them dieu kien");
		addExtraBonusConditionBtn.setBorder(null);
		addExtraBonusConditionBtn.setOpaque(true);
		addExtraBonusConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(addExtraBonusConditionBtn);

		removeExtraBonusConditionBtn.setBackground(new Color(204, 204, 255));
		removeExtraBonusConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		removeExtraBonusConditionBtn.setText("Xoa dieu kien");
		removeExtraBonusConditionBtn.setBorder(null);
		removeExtraBonusConditionBtn.setOpaque(true);
		removeExtraBonusConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(removeExtraBonusConditionBtn);

		extraBonusConditionSP.setPreferredSize(new Dimension(450, 200));

		extraBonusConditionList.setFont(new Font("Segoe UI", 0, 14));
		extraBonusConditionList.setModel(new AbstractListModel<String>() {
			String[] strings = { "Vuot tu: 0.000.000 duoc thuong 5%" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		extraBonusConditionSP.setViewportView(extraBonusConditionList);

		advancedSalarySetupPanel.add(extraBonusConditionSP);

		bonusCheckbox.setBackground(new Color(255, 255, 255));
		bonusCheckbox.setFont(new Font("Segoe UI", 1, 14));
		bonusCheckbox.setSelected(true);
		bonusCheckbox.setText("Phu cap");
		bonusCheckbox.setBorder(null);
		bonusCheckbox.setPreferredSize(new Dimension(450, 30));
		advancedSalarySetupPanel.add(bonusCheckbox);

		typeOfBonusLabel.setFont(new Font("Segoe UI", 0, 14));
		typeOfBonusLabel.setText("Loai phu cap");
		typeOfBonusLabel.setPreferredSize(new Dimension(120, 25));
		advancedSalarySetupPanel.add(typeOfBonusLabel);

		tpeOfBonusField.setFont(new Font("Segoe UI", 0, 14));
		tpeOfBonusField.setText("Phu cap an uong");
		tpeOfBonusField.setBorder(null);
		tpeOfBonusField.setPreferredSize(new Dimension(300, 25));
		advancedSalarySetupPanel.add(tpeOfBonusField);

		rangeOfBonusLabel.setFont(new Font("Segoe UI", 0, 14));
		rangeOfBonusLabel.setText("Muc ap dung");
		rangeOfBonusLabel.setPreferredSize(new Dimension(120, 25));
		advancedSalarySetupPanel.add(rangeOfBonusLabel);

		rangeOfBonusField.setFont(new Font("Segoe UI", 0, 14));
		rangeOfBonusField.setHorizontalAlignment(JTextField.RIGHT);
		rangeOfBonusField.setText("0.000.000");
		rangeOfBonusField.setBorder(null);
		rangeOfBonusField.setPreferredSize(new Dimension(70, 25));
		advancedSalarySetupPanel.add(rangeOfBonusField);

		vndUnitOption5.setBackground(new Color(255, 255, 255));
		buttonGroup2.add(vndUnitOption5);
		vndUnitOption5.setFont(new Font("Segoe UI", 0, 14));
		vndUnitOption5.setSelected(true);
		vndUnitOption5.setText("VND");
		vndUnitOption5.setOpaque(false);
		vndUnitOption5.setPreferredSize(new Dimension(55, 25));
		advancedSalarySetupPanel.add(vndUnitOption5);

		percentUnitOption5.setBackground(new Color(255, 255, 255));
		buttonGroup2.add(percentUnitOption5);
		percentUnitOption5.setFont(new Font("Segoe UI", 0, 14));
		percentUnitOption5.setForeground(new Color(153, 153, 153));
		percentUnitOption5.setText("%");
		percentUnitOption5.setOpaque(false);
		percentUnitOption5.setPreferredSize(new Dimension(50, 25));
		advancedSalarySetupPanel.add(percentUnitOption5);

		addBonusConditionBtn.setBackground(new Color(204, 204, 255));
		addBonusConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		addBonusConditionBtn.setText("Them phu cap");
		addBonusConditionBtn.setBorder(null);
		addBonusConditionBtn.setOpaque(true);
		addBonusConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(addBonusConditionBtn);

		removeBonusConditionBtn.setBackground(new Color(204, 204, 255));
		removeBonusConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		removeBonusConditionBtn.setText("Xoa phu cap");
		removeBonusConditionBtn.setBorder(null);
		removeBonusConditionBtn.setOpaque(true);
		removeBonusConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(removeBonusConditionBtn);

		bonusConditionSP.setPreferredSize(new Dimension(450, 200));

		bonusConditionList.setFont(new Font("Segoe UI", 0, 14));
		bonusConditionList.setModel(new AbstractListModel<String>() {
			String[] strings = { "Phu cap xang xe : 250.000 VND" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		bonusConditionSP.setViewportView(bonusConditionList);

		advancedSalarySetupPanel.add(bonusConditionSP);

		deductionCheckbox.setBackground(new Color(255, 255, 255));
		deductionCheckbox.setFont(new Font("Segoe UI", 1, 14));
		deductionCheckbox.setSelected(true);
		deductionCheckbox.setText("Giam tru, tien phat");
		deductionCheckbox.setBorder(null);
		deductionCheckbox.setPreferredSize(new Dimension(450, 30));
		advancedSalarySetupPanel.add(deductionCheckbox);

		typeOfDeductionLabel.setFont(new Font("Segoe UI", 0, 14));
		typeOfDeductionLabel.setText("Loai giam tru");
		typeOfDeductionLabel.setPreferredSize(new Dimension(130, 25));
		advancedSalarySetupPanel.add(typeOfDeductionLabel);

		typeOfDeductionField.setFont(new Font("Segoe UI", 0, 14));
		typeOfDeductionField.setText("Bao hiem xa hoi");
		typeOfDeductionField.setBorder(null);
		typeOfDeductionField.setPreferredSize(new Dimension(300, 25));
		advancedSalarySetupPanel.add(typeOfDeductionField);

		rangeOfDeductionLabel.setFont(new Font("Segoe UI", 0, 14));
		rangeOfDeductionLabel.setText("Muc ap dung");
		rangeOfDeductionLabel.setPreferredSize(new Dimension(130, 25));
		advancedSalarySetupPanel.add(rangeOfDeductionLabel);

		rangeOfDeductionField.setFont(new Font("Segoe UI", 0, 14));
		rangeOfDeductionField.setHorizontalAlignment(JTextField.RIGHT);
		rangeOfDeductionField.setText("0.000.000");
		rangeOfDeductionField.setBorder(null);
		rangeOfDeductionField.setPreferredSize(new Dimension(70, 25));
		advancedSalarySetupPanel.add(rangeOfDeductionField);

		vndUnitOption6.setBackground(new Color(255, 255, 255));
		buttonGroup1.add(vndUnitOption6);
		vndUnitOption6.setFont(new Font("Segoe UI", 0, 14));
		vndUnitOption6.setSelected(true);
		vndUnitOption6.setText("VND");
		vndUnitOption6.setOpaque(false);
		vndUnitOption6.setPreferredSize(new Dimension(55, 25));
		advancedSalarySetupPanel.add(vndUnitOption6);

		pecentUnitOption6.setBackground(new Color(255, 255, 255));
		buttonGroup1.add(pecentUnitOption6);
		pecentUnitOption6.setFont(new Font("Segoe UI", 0, 14));
		pecentUnitOption6.setForeground(new Color(153, 153, 153));
		pecentUnitOption6.setText("%");
		pecentUnitOption6.setOpaque(false);
		pecentUnitOption6.setPreferredSize(new Dimension(55, 25));
		advancedSalarySetupPanel.add(pecentUnitOption6);

		addDeductionConditionBtn.setBackground(new Color(204, 204, 255));
		addDeductionConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		addDeductionConditionBtn.setText("Them giam tru");
		addDeductionConditionBtn.setBorder(null);
		addDeductionConditionBtn.setOpaque(true);
		addDeductionConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(addDeductionConditionBtn);

		removeDeductionConditionBtn.setBackground(new Color(204, 204, 255));
		removeDeductionConditionBtn.setFont(new Font("Segoe UI", 1, 14));
		removeDeductionConditionBtn.setText("Xoa giam tru");
		removeDeductionConditionBtn.setBorder(null);
		removeDeductionConditionBtn.setOpaque(true);
		removeDeductionConditionBtn.setPreferredSize(new Dimension(150, 30));
		advancedSalarySetupPanel.add(removeDeductionConditionBtn);

		deductionConditionSP.setPreferredSize(new Dimension(450, 200));

		deductionConditionList.setFont(new Font("Segoe UI", 0, 14));
		deductionConditionList.setModel(new AbstractListModel<String>() {
			String[] strings = { "Giam tru BHXH : 685.951 VND" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		deductionConditionSP.setViewportView(deductionConditionList);

		advancedSalarySetupPanel.add(deductionConditionSP);

		advancedSalarySetupSP.setViewportView(advancedSalarySetupPanel);

		timekeepingSetupPanel1.add(advancedSalarySetupSP);

		saveButton.setBackground(new Color(255, 204, 204));
		saveButton.setFont(new Font("Segoe UI", 1, 16));
		saveButton.setText("Luu");
		timekeepingSetupPanel1.add(saveButton);

		salaryParentPanel.add(timekeepingSetupPanel1, "card4");

		calSalaryPanel.setBackground(new Color(255, 255, 255));
		calSalaryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

		calBlank.setPreferredSize(new Dimension(450, 45));
		calSalaryPanel.add(calBlank);

		timekeepingManualButton3.setBackground(new Color(255, 204, 204));
		timekeepingManualButton3.setText("Salary payment");
		timekeepingManualButton3.setPreferredSize(new Dimension(150, 45));
		calSalaryPanel.add(timekeepingManualButton3);

		importTimekeepingButton3.setBackground(new Color(255, 204, 204));
		importTimekeepingButton3.setText("Import excel file");
		importTimekeepingButton3.setPreferredSize(new Dimension(150, 45));
		calSalaryPanel.add(importTimekeepingButton3);

		exportTimekeepingButton3.setBackground(new Color(255, 204, 204));
		exportTimekeepingButton3.setText("Export excel file");
		exportTimekeepingButton3.setPreferredSize(new Dimension(150, 45));
		calSalaryPanel.add(exportTimekeepingButton3);

		jScrollPane1.setPreferredSize(new Dimension(950, 450));

		jTable1.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Month", "Staff ID", "Salary", "Paid" }));
		jScrollPane1.setViewportView(jTable1);

		calSalaryPanel.add(jScrollPane1);

		salaryParentPanel.add(calSalaryPanel, "card7");

		salarySetupPanel.add(salaryParentPanel);

		settingParentPane.addTab("Salary", salarySetupPanel);
		return salaryParentPanel;
	}

	private JPanel accountManagementPanel() {
		accountManagementPanel = new JPanel();
		accountManagementPanel.setBackground(new Color(255, 255, 255));
		accountManagementPanel.setMinimumSize(new Dimension(900, 54));
		accountManagementPanel.setPreferredSize(new Dimension(900, 654));
		accountManagementPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));

		JLabel header = new JLabel();
		header.setFont(new Font("Segoe UI", 3, 24));
		header.setForeground(new Color(255, 102, 102));
		header.setText("Account management");
		header.setPreferredSize(new Dimension(700, 35));
		accountManagementPanel.add(header);

		JButton edit = new JButton();
		edit.setBackground(new Color(255, 255, 204));
		edit.setFont(new Font("Segoe UI", 1, 18));
		edit.setForeground(Color.red);
		edit.setText("Edit");
		edit.setPreferredSize(new Dimension(115, 35));
		accountManagementPanel.add(edit);

		JPanel identityPanel = new JPanel();
		JLabel identity = new JLabel();
		JLabel employeeName = new JLabel();
		JTextField nameField = new JTextField();
		JLabel gender = new JLabel();
		JCheckBox male = new JCheckBox();
		JCheckBox female = new JCheckBox();
		JLabel idCardNum = new JLabel();
		JTextField idCardNumField = new JTextField();
		JLabel employeeID = new JLabel();
		JTextField employeeIDField = new JTextField();
		JLabel Password = new JLabel();
		JButton changePass = new JButton();
		JLabel lastChangedPass = new JLabel();
		JPanel photoPanel = new JPanel();
		JLabel portraitPhoto = new JLabel();
		JButton uploadPhoto = new JButton();
		JPanel connectionPanel = new JPanel();
		JLabel connection = new JLabel();
		JLabel phoneNum = new JLabel();
		JTextField phoneNumField = new JTextField();
		JLabel email = new JLabel();
		JTextField emailField = new JTextField();
		JLabel address = new JLabel();
		JTextField addressField = new JTextField();
		JPanel workPanel = new JPanel();
		JLabel work = new JLabel();
		JLabel position = new JLabel();
		JTextField positionField = new JTextField();
		JLabel salary = new JLabel();
		JTextField salaryField = new JTextField();
		JLabel enterDate = new JLabel();
		JPanel endDateField = new JDateChooser();
		JLabel endDate = new JLabel();
		JPanel enterDateField = new JDateChooser();
		identityPanel.setPreferredSize(new Dimension(700, 195));
		identityPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 10));

		identity.setFont(new Font("Segoe UI", 0, 18));
		identity.setForeground(new Color(255, 51, 51));
		identity.setText("Identity");
		identity.setPreferredSize(new Dimension(650, 25));
		identityPanel.add(identity);

		employeeName.setFont(new Font("Segoe UI", 0, 12));
		employeeName.setText("Employee name:");
		employeeName.setPreferredSize(new Dimension(90, 35));
		identityPanel.add(employeeName);

		nameField.setFont(new Font("Segoe UI", 0, 12));
		nameField.setText("NGUYEN VAN A");
		nameField.setPreferredSize(new Dimension(550, 35));
		identityPanel.add(nameField);

		gender.setFont(new Font("Segoe UI", 0, 12));
		gender.setText("Gender:");
		gender.setPreferredSize(new Dimension(90, 35));
		identityPanel.add(gender);

		male.setBackground(new Color(255, 255, 255));
		male.setFont(new Font("Segoe UI", 0, 12));
		male.setText("Male");
		male.setOpaque(false);
		male.setPreferredSize(new Dimension(70, 35));
		identityPanel.add(male);

		female.setBackground(new Color(255, 255, 255));
		female.setFont(new Font("Segoe UI", 0, 12));
		female.setText("Female");
		female.setMinimumSize(new Dimension(63, 35));
		female.setOpaque(false);
		female.setPreferredSize(new Dimension(115, 35));
		identityPanel.add(female);

		idCardNum.setFont(new Font("Segoe UI", 0, 12));
		idCardNum.setHorizontalAlignment(SwingConstants.TRAILING);
		idCardNum.setText("Identity card number:");
		idCardNum.setPreferredSize(new Dimension(120, 35));
		identityPanel.add(idCardNum);

		idCardNumField.setFont(new Font("Segoe UI", 0, 12));
		idCardNumField.setText("xxx xxx xxxx");
		idCardNumField.setPreferredSize(new Dimension(200, 35));
		identityPanel.add(idCardNumField);

		employeeID.setFont(new Font("Segoe UI", 0, 12));
		employeeID.setText("Employee ID:");
		employeeID.setPreferredSize(new Dimension(90, 35));
		identityPanel.add(employeeID);

		employeeIDField.setFont(new Font("Segoe UI", 0, 12));
		employeeIDField.setText("xxx xxx xxxx");
		employeeIDField.setPreferredSize(new Dimension(200, 35));
		identityPanel.add(employeeIDField);

		Password.setFont(new Font("Segoe UI", 0, 12));
		Password.setHorizontalAlignment(SwingConstants.RIGHT);
		Password.setText("Password:");
		Password.setPreferredSize(new Dimension(120, 35));
		identityPanel.add(Password);

		changePass.setFont(new Font("Segoe UI", 0, 12));
		changePass.setForeground(new Color(51, 51, 255));
		changePass.setText("Change");
		changePass.setBorder(null);
		changePass.setBorderPainted(false);
		changePass.setOpaque(false);
		changePass.setPreferredSize(new Dimension(45, 35));
		identityPanel.add(changePass);

		lastChangedPass.setFont(new Font("Segoe UI", 2, 12));
		lastChangedPass.setForeground(new Color(204, 204, 204));
		lastChangedPass.setText("Last changed Jul 6, 2020");
		lastChangedPass.setPreferredSize(new Dimension(130, 35));
		identityPanel.add(lastChangedPass);

		accountManagementPanel.add(identityPanel);

		photoPanel.setBackground(new Color(255, 255, 255));
		photoPanel.setPreferredSize(new Dimension(125, 200));
		photoPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));

		portraitPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		portraitPhoto.setIcon(new ImageIcon("icons8_cancel_24px.png"));
		portraitPhoto.setOpaque(true);
		portraitPhoto.setPreferredSize(new Dimension(115, 165));
		photoPanel.add(portraitPhoto);

		uploadPhoto.setFont(new Font("Segoe UI", 0, 14));
		uploadPhoto.setText("Upload (3x4)");
		uploadPhoto.setHorizontalAlignment(SwingConstants.LEFT);
		uploadPhoto.setPreferredSize(new Dimension(115, 25));
		photoPanel.add(uploadPhoto);

		accountManagementPanel.add(photoPanel);

		connectionPanel.setPreferredSize(new Dimension(700, 150));
		connectionPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 10));

		connection.setFont(new Font("Segoe UI", 0, 18));
		connection.setForeground(new Color(255, 51, 51));
		connection.setText("Connection");
		connection.setPreferredSize(new Dimension(650, 25));
		connectionPanel.add(connection);

		phoneNum.setFont(new Font("Segoe UI", 0, 12));
		phoneNum.setText("Phone number:");
		phoneNum.setPreferredSize(new Dimension(90, 35));
		connectionPanel.add(phoneNum);

		phoneNumField.setFont(new Font("Segoe UI", 0, 12));
		phoneNumField.setText("xxx xxx xxxx");
		phoneNumField.setPreferredSize(new Dimension(200, 35));
		connectionPanel.add(phoneNumField);

		email.setFont(new Font("Segoe UI", 0, 12));
		email.setHorizontalAlignment(SwingConstants.TRAILING);
		email.setText("Email:");
		email.setHorizontalTextPosition(SwingConstants.LEADING);
		email.setPreferredSize(new Dimension(120, 35));
		connectionPanel.add(email);

		emailField.setFont(new Font("Segoe UI", 0, 12));
		emailField.setText("xxx xxx xxxx");
		emailField.setPreferredSize(new Dimension(200, 35));
		connectionPanel.add(emailField);

		address.setFont(new Font("Segoe UI", 0, 12));
		address.setText("Address:");
		address.setPreferredSize(new Dimension(90, 35));
		connectionPanel.add(address);

		addressField.setFont(new Font("Segoe UI", 0, 12));
		addressField.setText("xxx xxx xxxx");
		addressField.setPreferredSize(new Dimension(550, 35));
		connectionPanel.add(addressField);

		accountManagementPanel.add(connectionPanel);

		workPanel.setPreferredSize(new Dimension(700, 150));
		workPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 10));

		work.setFont(new Font("Segoe UI", 0, 18));
		work.setForeground(new Color(255, 51, 51));
		work.setText("Work");
		work.setPreferredSize(new Dimension(650, 25));
		workPanel.add(work);

		position.setFont(new Font("Segoe UI", 0, 12));
		position.setText("Current position:");
		position.setPreferredSize(new Dimension(90, 35));
		workPanel.add(position);

		positionField.setFont(new Font("Segoe UI", 0, 12));
		positionField.setText("Menu management");
		positionField.setPreferredSize(new Dimension(200, 35));
		workPanel.add(positionField);

		salary.setFont(new Font("Segoe UI", 0, 12));
		salary.setHorizontalAlignment(SwingConstants.TRAILING);
		salary.setText("Average salary:");
		salary.setPreferredSize(new Dimension(120, 35));
		workPanel.add(salary);

		salaryField.setText("0.000.000");
		salaryField.setPreferredSize(new Dimension(200, 35));
		workPanel.add(salaryField);

		enterDate.setFont(new Font("Segoe UI", 0, 12));
		enterDate.setText("Enter date:");
		enterDate.setPreferredSize(new Dimension(90, 35));
		workPanel.add(enterDate);

		endDateField.setPreferredSize(new Dimension(200, 35));
		workPanel.add(endDateField);

		endDate.setFont(new Font("Segoe UI", 0, 12));
		endDate.setHorizontalAlignment(SwingConstants.TRAILING);
		endDate.setText("Contract's end date:");
		endDate.setPreferredSize(new Dimension(120, 35));
		workPanel.add(endDate);

		enterDateField.setPreferredSize(new Dimension(200, 35));
		workPanel.add(enterDateField);

		accountManagementPanel.add(workPanel);

		contentPanel.add(accountManagementPanel, "card11");

		return accountManagementPanel;
	}

	private JPanel breakPanel() {
		breakPanel = new JPanel();
		breakPanel.setBackground(new Color(255, 204, 204));
		breakPanel.setPreferredSize(new Dimension(1100, 730));
		// breakPanel.setLayout(new AbsoluteLayout());

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 35, 20));

		JLabel breakHeader = new JLabel();
		breakHeader.setBackground(Color.red);
		breakHeader.setFont(new Font("Segoe UI", 1, 18));
		breakHeader.setForeground(Color.red);
		breakHeader.setHorizontalAlignment(SwingConstants.CENTER);
		breakHeader.setText("Computer is in break time ...");
		breakHeader.setPreferredSize(new Dimension(430, 30));
		mainPanel.add(breakHeader);

		JLabel id = new JLabel();
		id.setFont(new Font("Segoe UI", 0, 14));
		id.setText("Employee ID");
		id.setPreferredSize(new Dimension(100, 30));
		mainPanel.add(id);

		JTextField idField = new JTextField();
		idField.setFont(new Font("Segoe UI", 1, 14));
		idField.setText("000 000 0000");
		idField.setEnabled(false);
		idField.setPreferredSize(new Dimension(250, 30));
		mainPanel.add(idField);

		JLabel pass = new JLabel();
		pass.setFont(new Font("Segoe UI", 0, 14));
		pass.setText("Password");
		pass.setPreferredSize(new Dimension(100, 30));
		mainPanel.add(pass);

		JPasswordField passField = new JPasswordField();
		passField.setPreferredSize(new Dimension(250, 30));
		mainPanel.add(passField);

		JButton signin = new JButton();
		signin.setBackground(new Color(255, 204, 204));
		signin.setFont(new Font("Segoe UI", 0, 15));
		signin.setText("Sign in");
		signin.setPreferredSize(new Dimension(80, 30));
		mainPanel.add(signin);

		// breakPanel.add(mainPanel, new AbsoluteConstraints(330, 250, 460, 240));

		JLabel background = new JLabel();
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("logo1000x563.jpg"));
		background.setPreferredSize(new Dimension(1100, 730));
		// breakPanel.add(background, new AbsoluteConstraints(0, 0, 1100, 730));
		contentPanel.add(breakPanel, "card9");
		return breakPanel;
	}

//---------------function methods----------------------------------------
	// of menu bar
	private void changeCardLayoutByClickBtn(ActionEvent evt, Component linkingComp) {
		contentPanel.removeAll();
		contentPanel.add(linkingComp);
		contentPanel.repaint();
		contentPanel.revalidate();
	}

	// doi tu mau hong sang trang
	private void changeColorOfbutton(ActionEvent evt, ArrayList<JButton> buttonList, JButton btnNeedToAddAct) {
		for (JButton button : buttonList) {
			if (button == btnNeedToAddAct) {
				button.setBackground(pinkColor);
			} else {
				button.setBackground(whiteColor);
			}

		}
	}

	// tao them 1 hop thoai de nhap ma so va thoat / hay su dung lai signout panel
	private void signOutButtonActionPerformed(ActionEvent evt) {

	}

	private JButton createNewButton(int height, int width, Color background, Color textColor, String buttonName,
			int characterSize) {
		JButton button = new JButton();
		button.setBackground(background);
		button.setFont(new Font("Segoe UI", 0, characterSize));
		button.setForeground(textColor);
		button.setText(buttonName);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setPreferredSize(new Dimension(height, width));
		button.setFocusable(false);
		return button;
	}

	private void clock(JLabel label) {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						// label.setText(timeAndDate.showCurrentDateAndTime(new Date()));
						sleep(1000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	private Dimension reSizeComponent(int extraHeight, int extraWidth, Component comp) {
		Dimension deminsion;
		int height = comp.getPreferredSize().height + extraHeight;
		int width = comp.getPreferredSize().width + extraWidth;
		deminsion = new Dimension(width, height);
		return deminsion;
	}

	// of menuSetupScrollPane
	private JPanel unitPanel(String unitName, ArrayList<String> unitList, ArrayList<String> sizeList) {
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setOpaque(false);
		mainPanel.setPreferredSize(new Dimension(500, 300));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel tittleOfunit = new JLabel();
		tittleOfunit.setFont(new Font("Segoe UI", 1, 18));
		tittleOfunit.setForeground(new Color(255, 51, 51));
		tittleOfunit.setText(unitName);
		tittleOfunit.setPreferredSize(new Dimension(430, 30));

		mainPanel.add(tittleOfunit);
		mainPanel.add(subPanel(true, unitList));
		mainPanel.add(subPanel(false, sizeList));

		return mainPanel;
	}

	// of unitPanel
	private JPanel subPanel(boolean isUnit, ArrayList<String> itemList) {
		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(235, 250));
		subPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		String type;
		if (isUnit) {
			type = "Unit";
		} else {
			type = "Size"; // neu k phai la unit thi mac dinh la size (chi co 2 loai)
		}

		JTextField field = new JTextField("Search or create one here!");
		field.setPreferredSize(new Dimension(210, 30));
		subPanel.add(field);

		JScrollPane scrollPane = new JScrollPane();
		JList<String> jList = new JList<>();
		jList.setPreferredSize(new Dimension(200, 0));
		DefaultListModel<String> defaultListModel = new DefaultListModel<>();
		for (String element : itemList) {
			defaultListModel.addElement(element);
			jList.setPreferredSize(reSizeComponent(20, 0, jList));
		}
		jList.setModel(defaultListModel);
		jList.setFont(new Font("Segoe UI", 0, 13));

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(210, 160));
		scrollPane.setViewportView(jList);

		JButton addButton = createNewButton(100, 25, null, null, "Add new" + type, 13);
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = field.getText();
				if (input.equals("") || input.equals("Search or create one here!")) {
					field.setText("Search or create one here!");
				}
				// else if (defaultListModel.contains(input)) { }
				else {
					itemList.add(input);
					defaultListModel.addElement(input);
					jList.setModel(defaultListModel);
					field.setText("");
					jList.setPreferredSize(reSizeComponent(20, 0, jList));
					scrollPane.repaint();
				}
			}
		});
		subPanel.add(addButton);

		JButton removeButton = createNewButton(100, 25, null, null, "Remove " + type + "(s)", 13);

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog((Component) e.getSource(), "No data selected!", "Oops...", 1);
				} else {
					List selectedList = jList.getSelectedValuesList();
					Object[] valueList = selectedList.toArray();
					for (int i = 0; i < selectedList.size(); i++) {
						defaultListModel.removeElement(valueList[i]);
						jList.setPreferredSize(reSizeComponent(-20, 0, jList));
						scrollPane.repaint();
					}
					jList.setModel(defaultListModel);
				}
			}
		});
		subPanel.add(removeButton);

		subPanel.add(scrollPane);

		return subPanel;
	}

	// tao bang
	private JScrollPane tableScrollPane(int width, int height, String URL, int textSize, Color backgound,
			Color textColor) {
		Object[][] data = model.dataTable(URL);
		Object[] ColNames = model.columnNames(URL);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(width, height));
		DefaultTableModel defaultTableModel = new DefaultTableModel(data, ColNames);
		JTable table = new JTable(defaultTableModel) {

			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass(); // chi lay duoc dong dau tien (0) T.T
			}
		};
		table.setFont(new Font("Segoe UI", 0, textSize));
		table.setForeground(textColor);
		table.setBackground(backgound);
		table.setFocusable(false);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		return scrollPane;
	}

	// tao label trong de can chinh bo cuc giao dien
	private JLabel blankLabel(int width, int height) {
		JLabel blankLabel = new JLabel();
		blankLabel.setPreferredSize(new Dimension(width, height));
		return blankLabel;
	}

	private JComboBox<Object> comboBox(Object[] items, int width, int height, Color background, Color textColor,
			int textSize) {
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Segoe UI", 0, textSize));
		comboBox.setBackground(background);
		comboBox.setForeground(textColor);
		comboBox.setModel(new DefaultComboBoxModel<>(items));
		comboBox.setPreferredSize(new Dimension(width, height));
		comboBox.setFocusable(false);

		return comboBox;
	}

	private JCheckBox checkBox(String name, boolean hasBold, Color background, Color textColor, int textSize, int width,
			int height) {
		JCheckBox checkBox = new JCheckBox(name);

		if (background == null) {
			checkBox.setOpaque(false);
		} else {
			checkBox.setBackground(background);
			checkBox.setOpaque(true);
		}

		if (hasBold) {
			checkBox.setFont(new Font("Segoe UI", 1, textSize));
		} else {
			checkBox.setFont(new Font("Segoe UI", 0, textSize));
		}

		checkBox.setForeground(textColor);
		checkBox.setFocusable(false);
		checkBox.setPreferredSize(new Dimension(width, height));
		return checkBox;
	}

	// of overviewPanel
	private JPanel overviewPartPanel(String URL, String name, boolean hasPercentOfTotal) {
		ArrayList<Object> labelList = new ArrayList<>();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(240, 135));
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		JLabel headerLabel = new JLabel(name);
		headerLabel.setFont(new Font("Segoe UI", 1, 20));
		headerLabel.setPreferredSize(new Dimension(215, 30));
		panel.add(headerLabel);

		JLabel numOfBill = new JLabel();
		numOfBill.setFont(new Font("Segoe UI", 0, 12));
		numOfBill.setPreferredSize(new Dimension(215, 20));

		JLabel totalGain = new JLabel();
		totalGain.setFont(new Font("Segoe UI", 1, 15));
		totalGain.setForeground(greyColor);
		totalGain.setPreferredSize(new Dimension(115, 30));
		panel.add(totalGain);

		JLabel sumaryDevPercentLabel = new JLabel();
		sumaryDevPercentLabel.setFont(new Font("Segoe UI", 0, 12));
		sumaryDevPercentLabel.setForeground(new Color(153, 153, 153));
		sumaryDevPercentLabel.setIcon(new ImageIcon("icons8_up_16px.png"));
		sumaryDevPercentLabel.setText("00.00%");
		sumaryDevPercentLabel.setPreferredSize(new Dimension(70, 30));
		panel.add(sumaryDevPercentLabel);

		JLabel sumaryyesGainLabel = new JLabel();
		sumaryyesGainLabel.setFont(new Font("Segoe UI", 0, 12));
		sumaryyesGainLabel.setForeground(new Color(153, 153, 153));
		sumaryyesGainLabel.setText("Yesterday 000.000  ");
		sumaryyesGainLabel.setPreferredSize(new Dimension(215, 20));
		panel.add(sumaryyesGainLabel);

		return panel;
	}

	// phuong thuc lam tron so va cach so bang dau "." ???
	// de no sang ben model

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// tao cac list du lieu ao
		HashMap<String, Double> data = new HashMap<>();
		data.put("totalBill", 1352.6);// chi lay cai dau
		data.put("totalBills", 125.0);
		data.put("totalBills", 111.0);
		data.put("totalBills", 1456.0);

		EmployeeHomeModel model = new EmployeeHomeModel();
		new EmployeeHomeView(new EmployeeHomeController(model), model);
	}
}
