package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tName, tLname, tAddress, tPhone, tCurp, tEmail, tSalary, tDesignation;
    JLabel tEmpId;
    JDateChooser tDob;
    JComboBox boxEducation;
    Random ran = new Random();
    JButton add, back;
    int number = ran.nextInt(999999);
    AddEmployee() {
        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tName = new JTextField();
        tName.setBounds(200,150,150,30);
        tName.setBackground(new Color(177,252,197));
        add(tName);

        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(400,150,150,30);
        lName.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(lName);

        tLname = new JTextField();
        tLname.setBounds(600,150,150,30);
        tLname.setBackground(new Color(177,252,197));
        add(tLname);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tDob = new JDateChooser();
        tDob.setBounds(200,200,150,30);
        tDob.setBackground(new Color(177,252,197));
        add(tDob);

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600,200,150,30);
        tSalary.setBackground(new Color(177,252,197));
        add(tSalary);

        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        tAddress = new JTextField();
        tAddress.setBounds(200,250,150,30);
        tAddress.setBackground(new Color(177,252,197));
        add(tAddress);

        JLabel phone = new JLabel("Phone Number:");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tPhone = new JTextField();
        tPhone.setBounds(600,250,150,30);
        tPhone.setBackground(new Color(177,252,197));
        add(tPhone);

        JLabel email = new JLabel("Email:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(200,300,150,30);
        tEmail.setBackground(new Color(177,252,197));
        add(tEmail);

        JLabel education = new JLabel("Highest Education:");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA",
                            "MTech", "MSC", "PHD"};
        boxEducation = new JComboBox(items);
        boxEducation.setBackground(new Color(177,252,197));
        boxEducation.setBounds(600,300,150,30);
        add(boxEducation);

        JLabel curp = new JLabel("CURP:");
        curp.setBounds(400,350,150,30);
        curp.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(curp);

        tCurp = new JTextField();
        tCurp.setBounds(600,350,150,30);
        tCurp.setBackground(new Color(177,252,197));
        add(tCurp);

        JLabel empId = new JLabel("Employee ID::");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empId);

        tEmpId = new JLabel("" + number);
        tEmpId.setBounds(200,400,150,30);
        tEmpId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tEmpId.setForeground(Color.RED);
        add(tEmpId);

        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tDesignation = new JTextField();
        tDesignation.setBounds(200,350,150,30);
        tDesignation.setBackground(new Color(177,252,197));
        add(tDesignation);

        add = new JButton("Add");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.BLACK);
        add.setFocusable(false);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tName.getText();
            String lastName = tLname.getText();
            String dob = ((JTextField) tDob.getDateEditor().getUiComponent()).getText();
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String curp = tCurp.getText();
            String phone = tPhone.getText();
            String email = tEmail.getText();
            String education = (String)boxEducation.getSelectedItem();
            String designation = tDesignation.getText();
            String empID = tEmpId.getText();
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "','" + lastName + "','" + dob + "','" + salary + "', '"+ address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+curp+"', '"+empID+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
                new Main();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == back) {

        }
    }
}
