package Store.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import Customer.Controller.OrderController;
import Customer.Model.OrderModel;
import Employee.Controller.EmployeeSigninController;
import Employee.Model.EmployeeSigninModel;
import Store.Controller.MainHomeController;
import Worker.Controller.TimekeepingController;
import Worker.Model.TimekeepingModel;

// lop lam giao dien (edit code)

public class MainHomeView extends JFrame implements ActionListener {

    private MainHomeController control;

    private JButton bnCustomer;
    private JButton bnEmployee;
    private JButton bnExit;
    private JLabel header;
    private JButton bnWorker;
    private JLabel background;
    private JLabel note;
    private JPanel panel;

    public MainHomeView(MainHomeController control) {
        this.control = control;
    }

    // tao layout chua cac component cho panel
    public void createView() {
        // set up for frame
        ImageIcon appLogo = new ImageIcon("src/logoCircle100.png");
        setTitle("Bubble Tea App");
        setBounds(100, 100, 1000, 563);
        setUndecorated(true);
        setResizable(false);
        setIconImage(appLogo.getImage());

        // set background
        ImageIcon back = new ImageIcon("src/logo1000x563.jpg");
        background = new JLabel(back);
        background.setBounds(0, 0, 1000, 563);

        // set header (Welcome to Bubble tea!)
        header = new JLabel();
        header.setFont(new Font("Bookman Old Style", 1, 36));
        header.setForeground(new Color(255, 102, 102));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setText("Welcome to Bubble tea!");

        // set note (Please choose your position ...)
        note = new JLabel();
        note.setFont(new Font("Segoe UI", 2, 18));
        note.setHorizontalAlignment(SwingConstants.CENTER);
        note.setText("Please choose your position ...");

        // set button for customer
        bnCustomer = new JButton("Customer");
        bnCustomer.setBackground(new Color(255, 255, 255));
        bnCustomer.setFont(new Font("Segoe UI", 1, 24));
        bnCustomer.setText("Customer");
        bnCustomer.setHorizontalTextPosition(SwingConstants.CENTER);
        bnCustomer.addActionListener(this);
        bnCustomer.setFocusable(false);

        // set button for employee (Employee signin)
        bnEmployee = new JButton();
        bnEmployee.setBackground(new Color(255, 255, 255));
        bnEmployee.setFont(new Font("Segoe UI", 1, 24));
        bnEmployee.setText("Employee");
        bnEmployee.setHorizontalTextPosition(SwingConstants.CENTER);
        bnEmployee.addActionListener(this);
        bnEmployee.setFocusable(false);

        // set button for worker (worker's timekeeping)
        bnWorker = new JButton();
        bnWorker.setBackground(new Color(255, 255, 255));
        bnWorker.setFont(new Font("Segoe UI", 1, 24));
        bnWorker.setText("Worker");
        bnWorker.setHorizontalTextPosition(SwingConstants.CENTER);
        bnWorker.addActionListener(this);
        bnWorker.setFocusable(false);

        // set button exit
        bnExit = new JButton();
        bnExit.setBackground(new Color(204, 204, 255));
        bnExit.setFont(new Font("Segoe UI", 1, 18));
        bnExit.setForeground(Color.red);
        bnExit.setText("Exit");
        bnExit.addActionListener(this);
        bnExit.setFocusable(false);

        // set panel (group of buttons)
        panel = new JPanel();
        panel.setBackground(new Color(255, 204, 204));
        panel.setBounds(200, 131, 600, 300);
        panel.setLayout(createpanelLayout());

        // add in frame (toi sau add truoc ???)
        getContentPane().add(panel);
        getContentPane().add(background);

        setVisible(true);
    }

    private GroupLayout createpanelLayout() {
        GroupLayout panelLayout = new GroupLayout(panel);

        // set chieu ngang
        panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup().addGap(0, 179, Short.MAX_VALUE)
                        .addComponent(note, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                .addGroup(panelLayout.createSequentialGroup().addGroup(panelLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelLayout.createSequentialGroup().addGap(65, 65, 65).addComponent(header,
                                        GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelLayout.createSequentialGroup().addGap(15, 15, 15)
                                        .addComponent(bnCustomer, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(bnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(bnEmployee, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                        .addGap(15, 15, 15)
                                        .addComponent(bnWorker, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // set chieu doc
        panelLayout.setVerticalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLayout
                .createSequentialGroup().addGap(50, 50, 50)
                .addComponent(header, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addGap(15, 15, 15)
                .addComponent(note, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(bnEmployee, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bnCustomer, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addComponent(bnWorker, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18).addComponent(bnExit, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap()));
        return panelLayout;
    }

    public void gotoOrderView() throws IOException {
        dispose();
        OrderModel model = new OrderModel();
        OrderController controller = new OrderController(model);
    }

    public void gotoEmployeeSigninView() {
        try {
            EmployeeSigninModel signinModel;
            signinModel = new EmployeeSigninModel("D:\\code\\subject\\Project_OOP\\FileExcel\\Cus+Staff.xlsx", 1, 1, 12,
                    7);
            EmployeeSigninController controller = new EmployeeSigninController(signinModel);
            dispose();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void gotoTimekeepingView() {
        TimekeepingModel model = new TimekeepingModel();
        new TimekeepingController(model);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bnCustomer) {
            try {
                gotoOrderView();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == bnEmployee) {
            gotoEmployeeSigninView();
        }
        if (e.getSource() == bnWorker) {
            gotoTimekeepingView();
        }
        if (e.getSource() == bnExit) {
            dispose();
        }
    }
}
