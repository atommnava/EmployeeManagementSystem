package employee.management.system;

// Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
 * @brief La clase 'Login' muestra una ventana mayor en la que se ingersara las credenciales del empleador
 *        , de forma que pueda ingresar a la base de datos de una empresa y llevar a cabo la gestión de un sistema de empleados
 * @author Atom Alexander M. Nava
 * @date 26/08/24
 */
public class Login extends JFrame implements ActionListener {
    // Variables globales
    JTextField tUsername;
    JPasswordField tPassword;
    JButton login, back;
    /*
     * @brief Constructor 'Login' que integra toda la parte Swing y el diseño de la ventana, utlizando campos vacíos
     *        para la entrada de las credenciales.
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    Login()
    {
        JLabel userName = new JLabel("Username");
        userName.setBounds(40,20,100,30);
        add(userName);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tUsername = new JTextField();
        tUsername.setBounds(150,20,150,30);
        add(tUsername);

        tPassword = new JPasswordField();
        tPassword.setBounds(150,70,150,30);
        add(tPassword);

        login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.black);
        login.setFocusable(false);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.black);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image image2 = image1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(350,10,600,400);
        add(image);

        ImageIcon image11 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image image22 = image11.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon image33 = new ImageIcon(image22);
        JLabel img = new JLabel(image33);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    /*
     * @brief Método para responder a eventos, para pulsar el boton de 'login' o en caso de cerrar la ventana
     *        pulsar el botón 'back'.
     * @param e. Para responder al evento del usuario al hacer click en los botones.
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tUsername.getText();
                String password = tPassword.getText();

                Conn conn = new Conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Main().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }
    /*
     * @brief Método principal para correr la funcionalidad de la clase 'Login'.
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    public static void main(String[] args) {
        new Login();
    }
}

