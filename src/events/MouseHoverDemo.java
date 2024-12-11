package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHoverDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Hover Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 20, 20)); // 2x2 grid with spacing
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel statusLabel = new JLabel("Hover over a box to see details", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Updated colors for each box
        Color[] colors = {
                new Color(255, 200, 200), // Light Red for Box 1
                new Color(200, 255, 255), // Light Cyan for Box 2
                new Color(200, 200, 255), // Light Blue for Box 3
                new Color(255, 230, 150)  // Light Orange for Box 4
        };

        String[] boxLabels = {"Box 1", "Box 2", "Box 3", "Box 4"};

        for (int i = 0; i < 4; i++) {
            final int index = i; // Create a final variable for the current index
            JLabel box = new JLabel(boxLabels[index], SwingConstants.CENTER);
            box.setOpaque(true);
            box.setBackground(colors[index]);
            box.setFont(new Font("Arial", Font.BOLD, 16));
            box.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

            // Add hover effects and event handling
            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    box.setBackground(colors[index].darker());
                    statusLabel.setText(box.getText() + " - Hovering");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    box.setBackground(colors[index]); // Reset to original color
                    statusLabel.setText("Hover over a box to see details");
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(frame, box.getText() + " clicked!", "Box Clicked", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            panel.add(box);
        }

        // Set up the frame layout
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
