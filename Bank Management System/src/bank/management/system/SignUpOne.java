package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nametxt, fnametxt, dobtext, emailtxt, addresstxt, citytxt, statetxt, pincodetxt;
    JRadioButton married, unmarried, male, female;
    JButton next;

    public SignUpOne() {
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel form_no = new JLabel("APPLICATION FORM NO. " + random);
        form_no.setFont(new Font("Raleway", Font.BOLD, 38));
        form_no.setBounds(120, 20, 600, 40);
        add(form_no);

        JLabel personal_details = new JLabel("Page 1 : Personal Details");
        personal_details.setFont(new Font("Raleway", Font.BOLD, 22));
        personal_details.setBounds(300, 80, 400, 30);
        add(personal_details);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 25));
        name.setBounds(100, 140, 400, 30);
        add(name);

        nametxt = new JTextField();
        nametxt.setFont(new Font("Raleway", Font.BOLD, 25));
        nametxt.setBounds(350, 140, 400, 30);
        add(nametxt);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 25));
        fname.setBounds(100, 200, 400, 30);
        add(fname);

        fnametxt = new JTextField();
        fnametxt.setFont(new Font("Raleway", Font.BOLD, 25));
        fnametxt.setBounds(350, 200, 400, 30);
        add(fnametxt);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 25));
        dob.setBounds(100, 260, 400, 30);
        add(dob);

        dobtext = new JTextField();
        dobtext.setFont(new Font("Raleway", Font.BOLD, 25));
        dobtext.setBounds(350, 260, 400, 30);
        add(dobtext);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 25));
        gender.setBounds(100, 320, 400, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350, 320, 150, 30);
        male.setFont(new Font("Raleway", Font.BOLD, 25));
        male.setBackground(Color.WHITE); 
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(500, 320, 250, 30);
        female.setFont(new Font("Raleway", Font.BOLD, 25));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 25));
        email.setBounds(100, 380, 400, 30);
        add(email);

        emailtxt = new JTextField();
        emailtxt.setFont(new Font("Raleway", Font.BOLD, 25));
        emailtxt.setBounds(350, 380, 400, 30);
        add(emailtxt);

        JLabel maritial_status = new JLabel("Marital Status:");
        maritial_status.setFont(new Font("Raleway", Font.BOLD, 25));
        maritial_status.setBounds(100, 440, 400, 30);
        add(maritial_status);

        married = new JRadioButton("Married");
        married.setBounds(350, 440, 150, 30);
        married.setFont(new Font("Raleway", Font.BOLD, 25));
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 440, 250, 30);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 25));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 25));
        address.setBounds(100, 500, 400, 30);
        add(address);

        addresstxt = new JTextField();
        addresstxt.setFont(new Font("Raleway", Font.BOLD, 25));
        addresstxt.setBounds(350, 500, 400, 30);
        add(addresstxt);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 25));
        city.setBounds(100, 560, 400, 30);
        add(city);

        citytxt = new JTextField();
        citytxt.setFont(new Font("Raleway", Font.BOLD, 25));
        citytxt.setBounds(350, 560, 400, 30);
        add(citytxt);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 25));
        state.setBounds(100, 620, 400, 30);
        add(state);

        statetxt = new JTextField();
        statetxt.setFont(new Font("Raleway", Font.BOLD, 25));
        statetxt.setBounds(350, 620, 400, 30);
        add(statetxt);

        JLabel pincode = new JLabel("PIN Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 25));
        pincode.setBounds(100, 680, 400, 30);
        add(pincode);

        pincodetxt = new JTextField();
        pincodetxt.setFont(new Font("Raleway", Font.BOLD, 25));
        pincodetxt.setBounds(350, 680, 400, 30);
        add(pincodetxt);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(420, 730, 130, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);    

        setSize(850, 880);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long
        String name = nametxt.getText(); // Get the text value
        String fname = fnametxt.getText();
        String dob = dobtext.getText();
        String email = emailtxt.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {   
            marital = "Unmarried";
        }
        String address = addresstxt.getText();
        String city = citytxt.getText();
        String pincode = pincodetxt.getText();
        String state = statetxt.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if (fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fathers Name is Required");
            }
            else if (dob.equals(""))
            {
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }
            else if (gender.equals(""))
            {
                JOptionPane.showMessageDialog(null, " Gender is Required");
            }
            else if (email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            else if (male.equals(""))
            {
                JOptionPane.showMessageDialog(null, "maritial status is Required");
            }
            else if (female.equals(""))
            {
                JOptionPane.showMessageDialog(null, "maritial status is Required");
            }
            else if (address.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            else if (city.equals(""))
            {
                JOptionPane.showMessageDialog(null," City is Required");
            }
            else if (state.equals(""))
            {
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            else if (pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null, "   Pincode is Required");
            }
            
            else {
                
                Main m = new Main();
                String query = "INSERT INTO signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                m.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Form Submitted Successfully");
                setVisible(false);
                new SignUpTwo(formno).setVisible(true); 
                // Next page can be opened here
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
