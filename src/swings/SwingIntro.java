package swings;
import javax.swing.*;

public class SwingIntro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Introduction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel label = new JLabel("Welcome to Java Swing!", SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}
