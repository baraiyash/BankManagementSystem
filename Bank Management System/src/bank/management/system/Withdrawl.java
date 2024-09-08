package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    JLabel text;
    JTextField amount;
    JButton withdraw, back;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 820);
        add(image);

        text = new JLabel("Enter the amount you want to Withdraw:");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(160, 280, 700, 30);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBounds(160, 320, 300, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("System", Font.BOLD, 22));
        withdraw.setBounds(330, 450, 120, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 22));
        back.setBounds(330, 480, 120, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 820);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            java.util.Date date = new java.util.Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Withdraw");
            } else {
                try {
                    int amountToWithdraw = Integer.parseInt(number);
                    Main m = new Main();

                    // Calculate balance
                    String query = "select * from bank where pin = '"+pin+"'";
                    ResultSet rs = m.s.executeQuery(query);

                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += rs.getInt("amount");
                        } else if (rs.getString("type").equals("Withdraw")) {
                            balance -= rs.getInt("amount");
                        }
                    }

                    if (balance < amountToWithdraw) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    query = "insert into bank(pin, date, type, amount) values ('"+pin+"', '"+new java.sql.Timestamp(date.getTime())+"', 'Withdraw', '"+amountToWithdraw+"')";
                    m.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawl("");
    }
}
