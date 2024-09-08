
package bank.management.system;


    import java.awt.*;
    import javax.swing.*;
    import java.util.*;
    import java.awt.event.*;
    import java.sql.*;

public class Login extends JFrame implements ActionListener
{
        JButton login, signup, clear;
        JTextField text_card;
        JPasswordField text_pin;

        public Login()
        {
            //Frame f = new Frame();
            setTitle("Automated Teller Machine ");

            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(70,50,100,100);
            add(label);

            JLabel label2 = new JLabel("Welcome to ATM");
            label2.setFont(new Font("Osward", Font.BOLD, 40));
            label2.setBounds(200,50,400,100);
            add(label2);

            JLabel card_no = new JLabel("Enter Card Number :- ");
            card_no.setFont(new Font("Osward", Font.BOLD, 25));
            card_no.setBounds(70,200,280,80);
            add(card_no);

            text_card = new JTextField();
            text_card.setFont(new Font ("Osward", Font.BOLD,  25));
            text_card.setBounds(340,220,300,40);
            add(text_card);

            JLabel pin = new JLabel("Enter PIN Number :- ");
            pin.setFont(new Font("Osward", Font.BOLD, 25));
            pin.setBounds(70,300,250,80);
            add(pin);

            text_pin = new JPasswordField();
            text_pin.setFont(new Font ("Osward", Font.BOLD,  25));
            text_pin.setBounds(340,325,300,40);
            add(text_pin);  

             login = new JButton("SIGN IN");
            login.setFont(new Font ("Oshward", Font.BOLD, 25));
            login.setBounds(160,430,170,50);
            login.setBackground(Color.black);
            login.setForeground(Color.white);
            login.addActionListener(this);
            add(login);

             clear = new JButton("CLEAR");
            clear.setFont(new Font ("Oshward", Font.BOLD, 25));
            clear.setBounds(400,430,160,50);
            clear.setBackground(Color.black);
            clear.setForeground(Color.white);
            clear.addActionListener(this);
            add(clear);

            signup = new JButton("SIGN UP");
            signup.setFont(new Font ("Oshward", Font.BOLD, 25));
            signup.setBounds(240,520,300,50);
            signup.setBackground(Color.black);
            signup.setForeground(Color.white);
            signup.addActionListener(this);
            add(signup);

            getContentPane().setBackground(Color.white);



            setSize(750,680);
            setVisible(true);
            setLocation(350 , 200);
        }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == clear)
            {
                text_card.setText("");
                text_pin.setText("");
            }
            else if (ae.getSource() == login)
            {
                Main m = new Main();
                String cardnumber = text_card.getText();
                String pin = text_pin.getText();
                String query  = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"' ";
                try 
                {
                   ResultSet rs =  m.s.executeQuery(query);
                   if(rs .next())
                   {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                   }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
               
            }
            else if (ae.getSource() == signup)
            {
                setVisible(false);
                new SignUpOne().setVisible(true);
            }
        }       
        public static void main(String args [])
        {
            Login l = new Login();  
        }
}
