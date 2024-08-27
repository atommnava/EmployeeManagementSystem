package employee.management.system;

// Bibliotecas
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/*
 * @brief Clase 'ViewEmployee' despliega en un frame la información más actualizada de nuestra listo de empleados con
 *        los datos de los mismos. Implementa la interfaz 'ActionListener' para funciones adicionales que sirven para ver
 *        a un empleado especifico, imprimir la lista de los empleados insertados en la base de datos, y actualizar los
 *        datos de un empleado con información desactualizada o equivocada.
 * @author Atom Alexander M. Nava
 * @date 27/08/24
 */
public class ViewEmployee extends JFrame implements ActionListener {
    // Variables
    Choice employeeChoice;
    JTable table;
    JButton searchbtn, print, update, back;
    /*
     * @brief Clase Constructor 'ViewEmployee' para el diseño del frame en donde se visualizara los campos de
     *        cada empleado, respectivamente.
     * @author Atom Alexander M. Nava
     * @date 27/08/24
     */
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
    /*
     * @brief Método para a las accciones que realize el empleador.
     * @author Atom Alexander M. Nava
     * @date 27/08/24
     */
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
    /*
     * @brief Método principal para ejecutar la funcionalidad principal de la clase 'ViewEmployee'
     * @author Atom Alexander M. Nava
     * @date 27/08/24
     */
    public static void main(String[] args) {
        new ViewEmployee();
    }
}
