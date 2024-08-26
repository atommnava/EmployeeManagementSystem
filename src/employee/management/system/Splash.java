package employee.management.system;

// Bibliotecas
import javax.swing.*;
import java.awt.*;

/* @brief Parte swing integrada para la trnasición de una imagen .gif hacia la clase 'Login', se reedirigira
          al empleador a una siguientr ventana.
 * @author Atom Alexander M. Nava
 * @dater 26/08/24
 */
public class Splash extends JFrame {
    /* @brief Constructor 'Splash' para el diseño de la ventana con la imagen en la que cinco segundos
              despues se cerrara esta ventana para abrir la que sera para la entrada de datos.
     * @author Atom Alexander M. Nava
     * @dater 26/08/24
     */
    Splash()
    {
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image image2 = image1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0,0,1170,650);
        add(image);

        setSize(1170,650);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* @brief Método principal para ejcutar la parte swing de la clase 'Splash'
     * @author Atom Alexander M. Nava
     * @dater 26/08/24
     */
    public static void main(String[] args) {
        new Splash();
    }
}



