
package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
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
    public static void main(String[] args) {
        new Splash();
    }
}



