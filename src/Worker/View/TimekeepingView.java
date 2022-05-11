package Worker.View;

import Store.Controller.MainHomeController;
import Worker.Controller.TimekeepingController;
import Worker.Model.TimekeepingModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimekeepingView extends JFrame implements ActionListener {
    private TimekeepingController controller;
    private TimekeepingModel model;

    private JButton btCancel;
    private JButton btEnter;
    private JLabel jLabel1;
    private JPanel jPBack;
    private JScrollPane jScrollPane1;
    private JLabel lbHeader;
    private JLabel lbID;
    private JTable tbTimeKeeping;
    private JTextField tfID;

    public TimekeepingView(TimekeepingController controller, TimekeepingModel model) {
        this.controller = controller;
        this.model = model;

        // set frame
        ImageIcon appLogo = new ImageIcon("src/logoCircle100.png");
        setTitle("Worker timekeeping");
        setBounds(100, 100, 1000, 563);
        setUndecorated(true);
        setResizable(false);
        setIconImage(appLogo.getImage());

        // set background
        jLabel1 = new JLabel();
        ImageIcon back = new ImageIcon("src/logo1000x563.jpg");
        jLabel1 = new JLabel(back);
        jLabel1.setBounds(0, 0, 1000, 563);

        // header
        lbHeader = new JLabel();
        lbHeader.setFont(new Font("Segoe UI", 1, 30));
        lbHeader.setForeground(new Color(255, 102, 102));
        lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lbHeader.setText("Timekeeping for Worker");
        lbHeader.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lbHeader.setHorizontalTextPosition(SwingConstants.CENTER);
        lbHeader.setPreferredSize(new Dimension(168, 32));

        // enter button
        btEnter = new JButton();
        btEnter.setBackground(new Color(255, 204, 204));
        btEnter.setFont(new Font("Segoe UI", 1, 30));
        btEnter.setText("Enter");
        btEnter.setHorizontalTextPosition(SwingConstants.CENTER);
        btEnter.setFocusable(false);
        btEnter.addActionListener(this);

        //cancel button
        btCancel = new JButton();
        btCancel.setFont(new Font("Segoe UI", 1, 30));
        btCancel.setText("Cancel");
        btCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        btCancel.setFocusable(false);
        btCancel.addActionListener(this);

        // input id
        lbID = new JLabel();
        lbID.setFont(new Font("Segoe UI", 1, 20));
        lbID.setForeground(new Color(255, 255, 255));
        lbID.setHorizontalAlignment(SwingConstants.LEFT);
        lbID.setText("Worker ID code");

        tfID = new JTextField();
        tfID.setFont(new java.awt.Font("Tahoma", 0, 24));

        // group input
        jPBack = new JPanel();
        jPBack.setOpaque(false);
        jPBack.setLayout(createJBackLayout());
        jPBack.setBounds(0, 0, 1000, 200);

        // timekeeping table (show last 24 hours)

        tbTimeKeeping = new JTable();

        tbTimeKeeping.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        tbTimeKeeping.setFont(new Font("Segoe UI", 0, 18));
        tbTimeKeeping.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Time", "ID", "Full name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tbTimeKeeping.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbTimeKeeping.setGridColor(new Color(255, 51, 102));
        tbTimeKeeping.setPreferredSize(new Dimension(940, 243));
        tbTimeKeeping.setRowHeight(25);

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(tbTimeKeeping);
        jScrollPane1.setBackground(new Color(255, 255, 255));
        jScrollPane1.setBounds(50, 220, 900, 320);

        // add group panel
        getContentPane().add(jPBack);
        getContentPane().add(jScrollPane1);
        getContentPane().add(jLabel1);
    }

    private GroupLayout createJBackLayout() {
        GroupLayout jPBackLayout = new GroupLayout(jPBack);

        jPBackLayout.setHorizontalGroup(
                jPBackLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPBackLayout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(lbHeader, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 295, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPBackLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPBackLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPBackLayout.createSequentialGroup()
                                                .addComponent(btEnter, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btCancel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPBackLayout.createSequentialGroup()
                                                .addComponent(lbID)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfID, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)))
                                .addGap(181, 181, 181))
        );
        jPBackLayout.setVerticalGroup(
                jPBackLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPBackLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbHeader, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPBackLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfID, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbID))
                                .addGap(18, 18, 18)
                                .addGroup(jPBackLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btEnter, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btCancel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE))
        );
        return jPBackLayout;
    }

    public void createView() {
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

    private void updateTimekeepingDataTable () {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEnter) {
            String idInput = tfID.getText();
            if (this.model.checkWorkerID(idInput)) {
                updateTimekeepingDataTable();
            } else {

            }
        }
        if (e.getSource() == btCancel) {
            MainHomeController controller = new MainHomeController();
            dispose();
        }
    }
}
