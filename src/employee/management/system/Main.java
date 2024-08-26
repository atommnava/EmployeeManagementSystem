package employee.management.system;

// Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @brief La clase Main representa el escritorio para un empleador a quien se le asignará la tarea de llevar la
 *        gestión de empleados de una organización especifica. Para ingresar al sistema de empleados, el empleador
 *        debera ingersar sus credenciales (para mayor seguridad).
 *        Un sistema de gestión de empleados cuenta con multiples
 *        funcionalidades, como son:
 *        1. Agregar empleado
 *        2. Remover empleado
 *        3. Ver empleados
 *        Nota: La parte Swing ya esta integrada.
 * @author Atom Alexander M. Nava
 * @date 26/08/24
 */
public class Main extends JFrame {

    /*
     * @brief Constructor 'Main' para integrar el diseño de la ventana con la librería swing
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    Main()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        setResizable(false);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        JButton add = new JButton("New Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.BLACK);
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.BLACK);
        view.setBackground(Color.BLACK);
        view.setFocusable(false);
        view.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton remove = new JButton("Remove Employee");
        remove.setBounds(440,370,150,40);
        remove.setForeground(Color.BLACK);
        remove.setBackground(Color.BLACK);
        remove.setFocusable(false);
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        img.add(remove);

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    /* @brief Método principal para ejecutar el programa principal
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    public static void main(String[] args) {
        new Main();
    }
}
