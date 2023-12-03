import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Splash extends JWindow {

    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    public Splash() {

        JLabel lbImage = new JLabel(new ImageIcon("Splash.jpg"));
        Color cl = new Color(0, 0, 0);
        lbImage.setBorder(new LineBorder(cl, 1));

        getContentPane().add(lbImage, BorderLayout.CENTER);
        pack();

        setSize(getSize().width, getSize().height);
        setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

        // Use a separate thread for time-consuming tasks
        new Thread(() -> {
            try {
                // Simulate some time-consuming task
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SwingUtilities.invokeLater(() -> {
                new BankSystem();
                toFront();
                dispose();
                setVisible(false);
            });
        }).start();

        // Use setVisible instead of deprecated show
        setVisible(true);
    }

    public static void main(String args[]) {
        new Splash();
    }
}
