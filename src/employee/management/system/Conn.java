package employee.management.system;

// Bibliotecas
import java.sql.*;

/*
 * @brief La clase 'Conn' conecta nuestra base de datos de MySQL llamada 'employeemanagementsystem', esta contiene las mesas
 *        'login' y 'employee' con sus respectivos campos, y actualiza nuestra base de datos.
 * @author Atom Alexander M. Nava
 * @date 26/08/24
 */
public class Conn {
    // Variables
    Connection c;
    Statement s;
    /*
     * @brief Contructor 'Conn' para realizar las conexiones requeridas con nuestra base de datos en MySQL
     * @author Atom Alexander M. Nava
     * @date 26/08/24
     */
    public Conn() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "12345678");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
