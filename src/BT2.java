import javax.swing.*;
public class BT2 extends JFrame {
    JTextField txtA, txtB, txtKq;
    JButton btnCong, btnTru, btnNhan, btnChia, btnExit, btnReset;
    public BT2() {
        setTitle("Minh hoa cac phep toan");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel lblTitle = new JLabel("minh hoa cac phep toan");
        lblTitle.setBounds(150, 10, 200, 30);
        add(lblTitle);
        add(new JLabel("Nhap a:")).setBounds(30, 50, 80, 25);
        txtA = new JTextField();
        txtA.setBounds(120, 50, 250, 25);
        add(txtA);
        add(new JLabel("Nhap b:")).setBounds(30, 80, 80, 25);
        txtB = new JTextField();
        txtB.setBounds(120, 80, 250, 25);
        add(txtB);
        add(new JLabel("Ket qua:")).setBounds(30, 110, 80, 25);
        txtKq = new JTextField();
        txtKq.setBounds(120, 110, 250, 25);
        txtKq.setEditable(false);
        add(txtKq);
        btnCong = new JButton("Cong"); btnCong.setBounds(50, 150, 80, 30); add(btnCong);
        btnTru = new JButton("Tru");   btnTru.setBounds(140, 150, 80, 30); add(btnTru);
        btnNhan = new JButton("Nhan"); btnNhan.setBounds(230, 150, 80, 30); add(btnNhan);
        btnChia = new JButton("Chia"); btnChia.setBounds(320, 150, 80, 30); add(btnChia);
    
        btnExit = new JButton("Exit");   btnExit.setBounds(120, 210, 80, 30); add(btnExit);
        btnReset = new JButton("Reset"); btnReset.setBounds(220, 210, 80, 30); add(btnReset);
        btnCong.addActionListener(e -> tinh("+"));
        btnTru.addActionListener(e -> tinh("-"));
        btnNhan.addActionListener(e -> tinh("*"));
        btnChia.addActionListener(e -> tinh("/"));
        btnReset.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            txtKq.setText("");
            txtA.requestFocus();
        });
        btnExit.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void tinh(String phepToan) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double kq = 0;

            if (phepToan.equals("+")) kq = a + b;
            if (phepToan.equals("-")) kq = a - b;
            if (phepToan.equals("*")) kq = a * b;
            if (phepToan.equals("/")) {
                if (b == 0) {
                    txtKq.setText("Loi chia cho 0!");
                    return;
                }
                kq = a / b;
            }
            txtKq.setText(String.valueOf(kq));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so hop le!");
        }
    }

    public static void main(String[] args) {
        new BT2();
    }
}