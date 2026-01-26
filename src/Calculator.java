import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame {

    private double soThuNhat = 0;
    private String phepToan = "";
    private boolean batDauSoMoi = true; 
    public static void main(String[] args) {
        new Calculator();
    }
    Calculator() {
        setTitle("Hang calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        getContentPane().setLayout(new BorderLayout());
        JTextField manhinh = new JTextField("0");
        manhinh.setFont(new Font("Times New Roman", Font.BOLD, 50)); 
        manhinh.setHorizontalAlignment(JTextField.RIGHT);
        manhinh.setEditable(false);
        manhinh.setFocusable(false);
        add(manhinh, BorderLayout.NORTH);
        JPanel banphim = new JPanel();
        banphim.setLayout(new GridLayout(5, 4, 4, 4));
        String[] nut = {
            "CE", "C", "\u232B", "÷",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };
        for (String n : nut) {
            JButton button = new JButton(n);
            button.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
            button.setFocusable(false);
            button.setBorderPainted(false);
            if ("0123456789.".contains(n)) {
                button.setBackground(Color.WHITE);
            } else if (n.equals("=")) {
                button.setBackground(new Color(100, 149, 237));
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(new Color(211, 211, 211));
            }
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = button.getText();
                    if ("0123456789.".contains(text)) {
                        if (batDauSoMoi) {
                            manhinh.setText(text);
                            batDauSoMoi = false;
                        } else {
                            if (text.equals(".") && manhinh.getText().contains(".")) return; // Tránh 2 dấu chấm
                            manhinh.setText(manhinh.getText() + text);
                        }
                    } 
                    else if ("+-x÷".contains(text)) {
                        soThuNhat = Double.parseDouble(manhinh.getText());
                        phepToan = text;
                        batDauSoMoi = true;
                    } 
                    else if (text.equals("=")) {
                        double soThuHai = Double.parseDouble(manhinh.getText());
                        double ketQua = 0;
                        switch (phepToan) {
                            case "+": ketQua = soThuNhat + soThuHai; break;
                            case "-": ketQua = soThuNhat - soThuHai; break;
                            case "x": ketQua = soThuNhat * soThuHai; break;
                            case "÷": 
                                if (soThuHai != 0) ketQua = soThuNhat / soThuHai;
                                else { manhinh.setText("Lỗi!"); return; }
                                break;
                        }
                        manhinh.setText(String.valueOf(ketQua));
                        batDauSoMoi = true;
                    }
                    else if (text.equals("C") || text.equals("CE")) {
                        manhinh.setText("0");
                        batDauSoMoi = true;
                        if (text.equals("C")) { soThuNhat = 0; phepToan = ""; }
                    }             
                    else if (text.equals("\u232B")) {
                        String s = manhinh.getText();
                        if (s.length() > 0) {
                            s = s.substring(0, s.length() - 1);
                            manhinh.setText(s.isEmpty() ? "0" : s);
                        }
                    }
                }
            });

            banphim.add(button);
        }
        add(banphim, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}