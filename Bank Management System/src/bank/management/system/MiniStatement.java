//
//package bank.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//
//public class MiniStatement extends JFrame
//{
//    
//    MiniStatement(String pin)
//    {
//        
//        
//        setTitle("Mini Statement");
//        
//        setLayout(null);
//        
//        JLabel mini = new JLabel();
//        add(mini);
//        
//        JLabel bank = new JLabel("State Bank of India");
//        bank.setBounds(150,20,200,20);
//        add(bank); 
//        
//        JLabel card = new JLabel();
//        card.setBounds( 20,80,200,30);
//        add(card);
//        
//        JLabel balance = new JLabel();
//        balance.setBounds(20,400,320,20);
//         add(balance);
//        
//        try{
//            Main m = new Main();
//            int bal = 0;
//            ResultSet rs = m.s.executeQuery("select * from login where pin = '"+pin+"'");  
//            while(rs.next())
//            {
//                card.setText("Card Number :" + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
//                
//                   if(rs.getString("type").equals("Deposit"))
//                   {
//                       bal += Integer.parseInt(rs.getString("amount"));
//                   }
//                   else 
//                   {
//                        bal -= Integer.parseInt(rs.getString("amount"));
//                   }
//            }
//           
//            balance.setText("Your Current Account Balance is Rs " + bal);
//           
//        }
//        
//        catch (Exception e)
//        {
//            System.out.println("e");
//        }
//        
//        try{
//            Main m = new Main();
//            ResultSet rs = m.s.executeQuery("select * from bank where pin = '1535'");
//            while(rs.next())
//            {
//                mini.setText(mini.getText()+ "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")  + "<br><br><html>");
//            }
//        }
//        catch (Exception ex)
//        {
//            System.out.println("e");
//        }
//        
//        
//        
//        mini.setBounds(20,140,400,200);
//        
//        setSize(400,600);
//        setLocation(20,20);
//        getContentPane().setBackground(Color.WHITE  );
//        setVisible(true);
//    }
//    
//    public static void main(String args[])
//    {
//        new MiniStatement("");
//    }
//}



package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pin) {
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 200, 30);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 320, 20);
        add(balance);

        try {
            Main m = new Main();
            int bal = 0;
            ResultSet rs = m.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                card.setText("Card Number :" + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }

            rs = m.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your Current Account Balance is Rs " + bal);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            Main m = new Main();
            ResultSet rs = m.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        mini.setBounds(20, 140, 400, 200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
