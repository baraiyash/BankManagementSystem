package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener
{
 
    JRadioButton saving,fixeddeposit, recurring, current;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    String pin;
            
    SignUpThree(String formno)
    {
        this.formno = formno;
        this.pin = pin;
        setLayout(null);    
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD, 25));
        l1.setBounds(260,30,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD, 25));
        type.setBounds(100,120,400,30);
        add(type);
        
        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBackground(Color.white);
        saving.setBounds(100,180,250,20);
        add(saving);
        
        fixeddeposit = new JRadioButton("Fixed Deposit Account");
        fixeddeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        fixeddeposit.setBackground(Color.white);
        fixeddeposit.setBounds(370,180,300,20);
        add(fixeddeposit);
        
        recurring = new JRadioButton("Recuurring Deposit Account");     
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBackground(Color.white);
        recurring.setBounds(100,220,250,20);
        add(recurring);
        
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.white);
        current.setBounds(370,220,300,20);
        add(current);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(fixeddeposit);
        accountgroup.add(recurring);
        accountgroup.add(current);
        
        JLabel card = new JLabel("Card :");
        card.setFont(new Font("Raleway",Font.BOLD, 25));
        card.setBounds(100,280,400,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD, 25));
        number.setBounds(340,280,400,30);
        add(number);
        
        JLabel carddetail = new JLabel("(Your 16 Digit Card Number)");
        carddetail.setFont(new Font("Raleway",Font.BOLD, 15));
        carddetail.setBounds(100,300,400,30);
        add(carddetail);

        JLabel pinn = new JLabel("PIN :");
        pinn.setFont(new Font("Raleway",Font.BOLD, 25));
        pinn.setBounds(100,340,400,30);
        add(pinn);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD, 25));
        pnumber.setBounds(340,340,400,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("(Your Four Digit Password)");
        pindetail.setFont(new Font("Raleway",Font.BOLD, 15));
        pindetail.setBounds(100,360,400,30);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD, 25));
        services.setBounds(100,410,400,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,460,150,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,460,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,510,150,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,510,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,560,150,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,560,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to my best of knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100,650,680,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD,18 ));
        submit.setBounds(250,700,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD,18 ));
        cancel.setBounds(420,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);   
        setLocation(350,0);
        setVisible(true); 
    }        
         
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String accounttype = null;
            if(saving.isSelected())
            {
                accounttype = "Savings Acount";
            }
            else if (fixeddeposit.isSelected())
            {
                accounttype = "Fixed Deposit Account";
            }    
            else if (recurring.isSelected())
            {
                accounttype = "Recurring Account";
            }
            else if (current.isSelected())
            {
                accounttype = "Current Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L ) + 1000L);
            
            String  facility = "";
            if(c1.isSelected())
            {
                facility = facility + "ATM Card";
            }
            else if (c2.isSelected())
            {
                facility = facility + "Internet Banking";
            }    
            else if (c3.isSelected())
            {
                facility = facility + "Mobile Banking";
            }    
            else if (c4.isSelected())
            {
                 facility = facility + "Email and SMS Alerts";
            }    
            else if (c5.isSelected())
            {
                facility = facility + "Cheque Book";
            }    
            else if (c6.isSelected())
            {
                facility = facility + "E-Statement";
            }    
            
            try{
            if(accounttype.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Account Type Requierd");
            }
            else
            {
                Main m = new Main();
                String query1 =  "insert into signupthree values ('"+formno+"','"+accounttype+"','"+cardnumber+"', '"+pinnumber+"','"+facility+"')";
                String query2 =  "insert into login values ('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";
                m.s.executeUpdate(query1);
                m.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n  Pin: " + pinnumber);
                
                setVisible(false);
                new Deposit(pin).setVisible(true);
            }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[])
    {
         new SignUpThree("");
    }       
            
}
