package bank.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;   
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 820);
        add(image);

        back = new JButton("Back");
        back.setBounds(330, 470, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Main m = new Main();
        int balance = 0;
        try {
            ResultSet rs = m.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            JLabel text = new JLabel("Your current account balance is Rs " + balance);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD,16 ));
            text.setBounds(140, 250, 400, 30);
            image.add(text);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setSize(850, 820);
        setLocation(300, 0);
         setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("").setVisible(true);
    }
}
