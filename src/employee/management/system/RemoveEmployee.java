package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice employeeChoice;
    JButton remove, back;
    RemoveEmployee()
    {
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        employeeChoice = new Choice();
        employeeChoice.setBounds(200,50,150,15);
        add(employeeChoice);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
            while (rs.next()) {
                employeeChoice.add(rs.getString("empID"));
            }
        } catch(Exception e1) {
            e1.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,200,30);
        add(textEmail);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee where empID = '"+employeeChoice.getSelectedItem()+"'");
            while (rs.next()) {
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));

            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        employeeChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from employee where empID = '"+employeeChoice.getSelectedItem()+"'");
                    while (rs.next()) {
                        textName.setText(rs.getString("name"));
                        textPhone.setText(rs.getString("phone"));
                        textEmail.setText(rs.getString("email"));
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        remove = new JButton("Delete");
        remove.setBounds(80,300,100,30);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.BLACK);
        remove.setFocusPainted(false);
        remove.addActionListener(this);
        add(remove);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700,80,200,200);
        add(image);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i12.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i32 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i32);
        image2.setBounds(0,0,1120,630);
        add(image2);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            try {
                Conn conn = new Conn();
                String query = "delete from employee where empID = '"+employeeChoice.getSelectedItem()+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, " 🗑 Employee has been deleted successfully.️");
                setVisible(false);
                new Main();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
