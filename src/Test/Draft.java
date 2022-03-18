package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Draft extends JFrame implements KeyListener, ActionListener, ListSelectionListener {
	private JTextField timeAndDateLabel;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JButton addButton;
	private JButton removeButton;
	private DefaultListModel<String> itemList;
	private JLabel label;
	private int x, y;

	public Draft() {

		ArrayList<String> items = new ArrayList<>();
		items.add("fgds");

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200, 300));
		scrollPane.setBackground(Color.pink);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		list = new JList<>();
		itemList = new DefaultListModel<>();
		for (String item : items) {
			itemList.addElement(item);
		}
		list.setModel(itemList);
		scrollPane.setViewportView(list);

		timeAndDateLabel = new JTextField();
		timeAndDateLabel.setForeground(new Color(153, 153, 153));
		timeAndDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeAndDateLabel.setFont(new Font("Segoe UI", 0, 15));
		timeAndDateLabel.setPreferredSize(new Dimension(100, 50));
		timeAndDateLabel.setText("Clock");
		timeAndDateLabel.addKeyListener(this);

		addButton = new JButton("Add an item");
		addButton.setPreferredSize(new Dimension(150, 35));
		addButton.addActionListener(this);

		removeButton = new JButton("Remove an item");
		removeButton.setPreferredSize(new Dimension(200, 35));
		removeButton.addActionListener(this);

		label = new JLabel(new ImageIcon("icons8_back_26px.png"));
		label.setBounds(x, y, 100, 100);

		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(scrollPane);
		getContentPane().add(timeAndDateLabel);
		getContentPane().add(addButton);
		getContentPane().add(removeButton);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Draft();

	}

	public String printStringList(Object[] listNeedPrint) {
		String result = "";
		for (Object e : listNeedPrint) {
			result += e + ", ";

		}
		return result;
	}

	public String printIntList(int[] listNeedPrint) {
		String result = "";
		for (int e : listNeedPrint) {
			result += e + ", ";

		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			if (timeAndDateLabel.getText().equals("Clock") || timeAndDateLabel.getText().equals("")) {
				timeAndDateLabel.setText("");
			} else {
				itemList.addElement(timeAndDateLabel.getText());
				list.setModel(itemList);
				timeAndDateLabel.setText("");
			}
		}
		// vi sao k nhan cac phan tu o vi tri chan de xoa???
		if (e.getSource() == removeButton) {
			if (list.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(this, "No data selected!", "Oops...", 1);
			} else {
				List selectedList = list.getSelectedValuesList();
				ListModel<String> l1 = itemList;
				Object[] l = selectedList.toArray();
				for (int i = 0; i < selectedList.size(); i++) {
					itemList.removeElement(l[i]);

				}
				list.setModel(itemList);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			if (timeAndDateLabel.getText().equals("Clock") || timeAndDateLabel.getText().equals("")) {
				timeAndDateLabel.setText("Clock");
			} else {
				itemList.addElement(timeAndDateLabel.getText());
				list.setModel(itemList);
				timeAndDateLabel.setText("");
			}
		}
		if (key == KeyEvent.VK_BACK_SPACE) {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}
}