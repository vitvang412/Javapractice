import java.awt.*;
import javax.swing.*;
public class Calculator extends JFrame  {
    public static void main(String[] args) {
      new Calculator();
    }

 Calculator() {
    setTitle("Hang calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,500);
    getContentPane().setLayout(new BorderLayout());
    JTextField manhinh = new JTextField("0");
    manhinh.setFont(new Font("Times New Roman", Font.BOLD,70));
    manhinh.setHorizontalAlignment(JTextField.RIGHT);
    manhinh.setEditable(false);
    manhinh.setFocusable(false);
    add(manhinh, BorderLayout.NORTH);
    JPanel banphim=new JPanel();
    banphim.setLayout(new GridLayout(5,4,4,4));
    String[] nut= {
      "CE", "C", "\u232B", "÷",
      "7", "8", "9", "x",
      "4", "5", "6", "-",
      "1", "2", "3", "+",
      "+/-", "0", ".", "="
    };
    for (String n:nut) {
      JButton button=new JButton(n);
        button.setFont(new Font("Segoe UI Symbol", Font.PLAIN,20));
        banphim.add(button);
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
    } 
    add(banphim, BorderLayout.CENTER);
    setVisible(true);
}
}