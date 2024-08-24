package employee.management.system;

// Bibliotecas
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    Choice employeeChoice;
    JTable table;
    JButton searchbtn, print, update, back;
    ViewEmployee() {
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20,20,150,20);
        add(search);

        employeeChoice = new Choice();
        employeeChoice.setBounds(180,20,150,20);
        add(employeeChoice);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
            while (rs.next()) {
                employeeChoice.add(rs.getString("empID"));
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        table = new JTable();
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from employee where empID = '" + employeeChoice.getSelectedItem() + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(employeeChoice.getSelectedItem());
        } else {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
