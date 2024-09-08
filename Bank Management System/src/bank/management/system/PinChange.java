
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField pintxt,repintxt;
    JButton change,back;
    String pin;
    
      PinChange(String pin)
      {
            this.pin = pin;   
           setLayout(null);
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0,0,850,820);
           add(image);
          
         JLabel text = new JLabel("CHANGE YOUR PIN");
         text.setForeground(Color.white);
         text.setFont(new Font("System", Font.BOLD,18 ));
         text.setBounds(220,270,500,35);
         image.add(text);
         
         JLabel pintext = new JLabel("New PIN:");
         pintext.setForeground(Color.white);
         pintext.setFont(new Font("System", Font.BOLD,16 ));
         pintext.setBounds(135,320,180,25);
         image.add(pintext);
         
         pintxt = new JPasswordField();
         pintxt.setFont(new Font("System", Font.BOLD,25));
         pintxt.setBounds(300,320,180,25);
         image.add(pintxt);
         
         JLabel repintext = new JLabel("Re-Enter New PIN:");
         repintext.setForeground(Color.white);
         repintext.setFont(new Font("System", Font.BOLD,16 ));
         repintext.setBounds(135,360,180,25);
         image.add(repintext);
         
         repintxt = new JPasswordField();
         repintxt.setFont(new Font("System", Font.BOLD,25));
         repintxt.setBounds(300,360,180,25);
         image.add(repintxt);
         
         change = new JButton("CHANGE");
         change.setBounds(330,430,150,30);
         change.addActionListener(this);
         image.add(change);
         
         back = new JButton("BACK");
         back.setBounds(330,470,150,30);
         back.addActionListener(this);
         image.add(back);
         
          
          
        setSize(850,820);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
      }
      
      public void actionPerformed (ActionEvent ae)
      {
          if(ae.getSource() == change)
       {
          try
          {
              String npin = pintxt.getText();
              String rpin = repintxt.getText();
              
              if(!npin.equals(rpin))
              {
                  JOptionPane.showMessageDialog(null, "Entered PIN does'nt match");
                  return;
              }
              
              if(npin.equals(""))
              {
                  JOptionPane.showMessageDialog(null, "Please enter new PIN");
                  return;
              }
              
              if(rpin.equals(""))   
              {
                  JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                  return;
              }
              
                Main m = new Main();
                String query = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query1 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query2 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"'";
                
                m.s.executeUpdate(query);
                 m.s.executeUpdate(query1);
                  m.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null,"PIN Changed Suceesfully");
                  
                  setVisible(false);
                  new Transactions(rpin).setVisible(true);
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
        }
          else 
          {
              setVisible(false);
              new Transactions(pin).setVisible(true);
          }
      }
      
      public static void main(String args[])
      {
          new PinChange("").setVisible(true);
      } 
}
