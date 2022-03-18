package Test;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Home extends JFrame implements ActionListener {
	public Home(int width, int height, Object[][] data, Object[] tittles) {
		setBounds(100, 100, 1000, 750);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(tableScrollPane(width, height, data, tittles));
		setVisible(true);

	}
	
	public Home() {
		
	}

// phuong thuc tao bang
	private JTable table(Object[][] data, Object[] tittles) {

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, tittles);
		JTable table = new JTable(defaultTableModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass(); // chi lay duoc dong dau tien (0) T.T
			}
		};
		table.setFont(new Font("Segoe UI", 0, 14));
		return table;
	}

// bat buoc phai co ( k la k co titte :)))
	private JScrollPane tableScrollPane(int width, int height, Object[][] data, Object[] tittles) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(width, height));

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, tittles);
		JTable table = new JTable(defaultTableModel) {

			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass(); // chi lay duoc dong dau tien (0) T.T
			}
		};
		table.setFont(new Font("Segoe UI", 0, 14));
		scrollPane.setViewportView(table);
		return scrollPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		String[] tittles = { "Type", "Company", "Sharegdddrts", "Price", "Boolean" };
		Object[][] data = { { "Buy", "IfewtreeeeterBM", new Integer(1000), new Double(80.50), false },
				{ "Sell", "MicroSoft", new Integer(2000), new Double(6.25), true },
				{ "Sell", "Apple", new Integer(3000), new Double(7.35), true },
				{ "Buy", "Nortel", new Integer(4000), new Double(20.00), false } };

		JCheckBox billDelivCheckBox = new JCheckBox();
		billDelivCheckBox.setBackground(new Color(255, 255, 255));
		billDelivCheckBox.setFont(new Font("Segoe UI", 0, 13));
		billDelivCheckBox.setText("Delivery cost");
		billDelivCheckBox.setOpaque(false);
		billDelivCheckBox.setFocusable(false);
		billDelivCheckBox.setPreferredSize(new Dimension(100, 30));
		
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Segoe UI", 0, 13));
		comboBox.setForeground(null);
		comboBox.setModel(new DefaultComboBoxModel<>(tittles));
		comboBox.setPreferredSize(new Dimension(150, 30));
		comboBox.setFocusable(false);
		
		JButton billSearchButton = new  JButton("Search", new ImageIcon("icons8_search_24px_1.png"));
		billSearchButton.setBackground(new Color(204, 204, 204));
		billSearchButton.setFont(new Font("Segoe UI", 0, 14));
		billSearchButton.setBorderPainted(false); // set up cai vien
		billSearchButton.setFocusable(false);
		billSearchButton.setPreferredSize(new Dimension(100, 30));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(500, 500));
		DefaultTableModel defaultTableModel = new DefaultTableModel(data, tittles);
		JTable table = new JTable(defaultTableModel) {

			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass(); // chi lay duoc dong dau tien (0) T.T
			}
		};
		table.setFont(new Font("Segoe UI", 0, 13));
		table.setForeground(null);
		table.setBackground(Color.white);
		table.setFocusable(false);
		table.setColumnSelectionAllowed(true); // moi lan chi chon duoc 1 o 
		scrollPane.setViewportView(table);
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.add(billDelivCheckBox);
		frame.add(comboBox);
		frame.add(billSearchButton);
		frame.add(scrollPane);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);

	}

}