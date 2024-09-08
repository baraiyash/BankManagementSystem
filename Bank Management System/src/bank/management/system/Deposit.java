
package bank.management.system;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener
{
    JLabel text;
    JTextField amount;
    JButton deposit , back;
    String pin;
    Deposit(String pin)
    {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,850, 820);
        add(image);
        
        text = new JLabel("Enter the amount you want to Deposit:- ");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(160,280,700,30);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font ("System", Font.BOLD, 22));
        amount.setBounds(160,320,300,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 22));
        deposit.setBounds(330,450,120,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 22));
        back.setBounds(330,480,120,25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(850,820);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }     
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the Amount you want to Deposit");
            }
            else 
            {
            try
                {
                Main m = new Main();
                String query = "insert into bank values ('"+pin+"','"+date+"','Deposit','"+number+"')";
                m.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +number+ "Deposited Succesfully" );
                setVisible(false);
                new Transactions(pin).setVisible(true);
                } 
            catch (Exception e)
            {
                System.out.println(e);
            }
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }    
    }
    
    
    public static void main(String args[])
    {
        new Deposit("");
    }
}
