package swings;
import javax.swing.*;
import java.awt.*;

public class SwingLayouts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layouts in Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        JLabel northLabel = new JLabel("North Label", SwingConstants.CENTER);
        JButton southButton = new JButton("South Button");

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.add(new JButton("Button 1"));
        centerPanel.add(new JButton("Button 2"));
        centerPanel.add(new JButton("Button 3"));
        centerPanel.add(new JButton("Button 4"));

        frame.add(northLabel, BorderLayout.NORTH);
        frame.add(southButton, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
