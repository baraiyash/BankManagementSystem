package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpTwo extends JFrame implements ActionListener {
    long random;
    JTextField nametxt, fnametxt, dobtext, emailtxt, addresstxt, citytxt, statetxt, pincodetxt,pantxt,aadhartxt;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox CReligion , Ccategory, incomecategory,education,occupational;
    String formno;
            
            

    public SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        JLabel additional_details = new JLabel("Page 2 : Additional Details");
        additional_details.setFont(new Font("Raleway", Font.BOLD, 22));
        additional_details.setBounds(300, 80, 400, 30);
        add(additional_details);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 25));
        religion.setBounds(100, 140, 400, 30);
        add(religion);

        String valReligion[] = {"Hindu","Christian","Sikh","Buddhist"};
        CReligion = new JComboBox(valReligion);
        CReligion.setBounds(350,140,400,35); 
        CReligion.setBackground(Color.WHITE);
        add(CReligion);
         
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 25));
        category.setBounds(100, 200, 400, 30);
        add(category);
        
        String ValCategory[] = {"General", "ST", "OBC" , "SC", "Other"};
        Ccategory = new JComboBox(ValCategory) ;
        Ccategory .setBounds(350,200,400,35);
        Ccategory.setBackground(Color.white);
        add(Ccategory);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 25));
        income.setBounds(100, 260, 400, 30);
        add(income);

        String IncomeCategory[] = {"Null", "< 1,50,000", "< 3,00,000" , " < 5,00,000", "Upto 10,00,000"};
        incomecategory = new JComboBox(IncomeCategory) ;
        incomecategory.setBounds(350,260,400,30);
        incomecategory.setBackground(Color.white); 
        add(incomecategory);

        JLabel educational = new JLabel("Educationional ");
        educational.setFont(new Font("Raleway", Font.BOLD, 25));
        educational.setBounds(100, 320, 400, 30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 25));
        qualification.setBounds(100, 350, 400, 30);
        add(qualification);
        
        String EducationalValues[] = {"Non Graduate", "Graduate", "Post Graduation", "Other"};
        education = new JComboBox (EducationalValues);
        education.setBounds(350,345,400,30);
        education.setBackground(Color.white); 
        add(education);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 25));
        occupation.setBounds(100, 430, 400, 30);
        add(occupation);
        
        String OccupationalValues[] = {"Salaried", "Self Employed", "Businessman", "Student", "Retired", "Other"};
        occupational = new JComboBox (OccupationalValues);
        occupational.setBounds(350,430,400,30);
        occupational.setBackground(Color.white); 
        add(occupational);

        JLabel pannumber = new JLabel("PAN Number:");
        pannumber.setFont(new Font("Raleway", Font.BOLD, 25));
        pannumber.setBounds(100, 500, 400, 30);
        add(pannumber);

        pantxt = new JTextField();
        pantxt.setFont(new Font("Raleway", Font.BOLD, 25));
        pantxt.setBounds(350, 500, 400, 30);
        add(pantxt);

        JLabel aadhar = new JLabel("Addhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 25));
        aadhar.setBounds(100, 560, 400, 30);
        add(aadhar);

        aadhartxt = new JTextField();
        aadhartxt.setFont(new Font("Raleway", Font.BOLD, 25));
        aadhartxt.setBounds(350, 560, 400, 30);
        add(aadhartxt);

        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 25));
        seniorcitizen.setBounds(100, 620, 400, 30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(350,620,150,30);
        syes.setFont(new Font("Raleway", Font.BOLD, 25));
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(500,620,250,30);
        sno.setFont(new Font("Raleway", Font.BOLD, 25));
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorbutton = new ButtonGroup();
        seniorbutton.add(syes);
        seniorbutton.add(sno);
        
        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 25));
        existingaccount.setBounds(100, 680, 400, 30);
        add(existingaccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(350,680,150,30);
        eyes.setFont(new Font("Raleway", Font.BOLD, 25));
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(500,680,250,30);
        eno.setFont(new Font("Raleway", Font.BOLD, 25));
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingbutton = new ButtonGroup();
        existingbutton.add(eyes);
        existingbutton.add(eno);

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
         //String formno = "" + random; // long
        String SReligion = (String) CReligion.getSelectedItem();
        String SCategory = (String) Ccategory.getSelectedItem();
        String SIncome = (String) incomecategory.getSelectedItem();
        String Seducation = (String) education.getSelectedItem();
        String SOccupational = (String) occupational.getSelectedItem();
        String pan = pantxt.getText();
        String aadhar = aadhartxt.getText();
        String senior = null;
        if (syes.isSelected()) {
            senior = "Yes";
        } else {
            senior = "No";
        }
        String existing = null;
        if (eno.isSelected()) {
            existing = "Yes";
        } else if (eno.isSelected()) {   
            existing = "No";
        }
        
        try {
            if (SReligion.equals("")) {
                JOptionPane.showMessageDialog(null, "Religion is Required");
            }
            else if (SCategory.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Category is Required");
            }
            else if (SIncome.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Income is Required");
            }
            else if (Seducation.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Education is Required");
            }
            else if (SOccupational.equals(""))
            { 
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }
            else if (pan.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }
            else if (aadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            }
            else {
                
                Main m = new Main();
                String query = "INSERT INTO signuptwo values('"+ formno +"','" + SReligion + "','" + SCategory + "','" + SIncome + "','" + Seducation + "','" + SOccupational + "','" + pan + "','" + aadhar + "','" + senior + "','" + existing + "')";
                m.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Form Submitted Successfully");
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
