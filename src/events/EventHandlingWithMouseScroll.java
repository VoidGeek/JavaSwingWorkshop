package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Timer;
import java.util.TimerTask;

public class EventHandlingWithMouseScroll {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrolling Website Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        // Create a main panel for the scrollable content
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Vertical layout
        mainPanel.setBackground(new Color(245, 245, 245)); // Light background color

        // Add a styled header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(51, 153, 255));
        headerPanel.setPreferredSize(new Dimension(900, 150));

        JLabel title = new JLabel("Lorem Ipsum", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 36));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("\"There is no one who loves pain itself...\"", SwingConstants.CENTER);
        subtitle.setFont(new Font("Georgia", Font.ITALIC, 18));
        subtitle.setForeground(Color.WHITE);

        headerPanel.add(title, BorderLayout.CENTER);
        headerPanel.add(subtitle, BorderLayout.SOUTH);

        mainPanel.add(headerPanel);

        // Add styled sections with vertical gradient background
        for (int i = 1; i <= 4; i++) {
            JPanel section = new VerticalGradientPanel(i);
            section.setPreferredSize(new Dimension(850, 300));
            section.setMaximumSize(new Dimension(850, 300));
            section.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding for content

            section.setLayout(new GridLayout(2, 2, 15, 15)); // Two-column grid

            // Section content
            String[] titles = {"What is Lorem Ipsum?", "Why do we use it?", "Where does it come from?", "Where can I get some?"};
            String[] contents = {
                    "<html><p><strong>Lorem Ipsum</strong> is simply dummy text of the printing and typesetting industry...</p></html>",
                    "<html><p>It is a long established fact that a reader will be distracted by the readable content...</p></html>",
                    "<html><p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in classical Latin literature...</p></html>",
                    "<html><p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration...</p></html>"
            };

            for (int j = 0; j < titles.length; j++) {
                JPanel contentBox = new JPanel();
                contentBox.setLayout(new BorderLayout());
                contentBox.setOpaque(false); // Transparent to inherit gradient background
                contentBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JLabel header = new JLabel(titles[j], SwingConstants.LEFT);
                header.setFont(new Font("Georgia", Font.BOLD, 16));
                header.setForeground(new Color(51, 102, 153));

                JLabel body = new JLabel(contents[j]);
                body.setFont(new Font("Arial", Font.PLAIN, 14));
                body.setForeground(Color.DARK_GRAY);

                contentBox.add(header, BorderLayout.NORTH);
                contentBox.add(body, BorderLayout.CENTER);

                section.add(contentBox);
            }

            mainPanel.add(Box.createVerticalStrut(20)); // Add spacing between sections
            mainPanel.add(section);
        }

        // Status label for scrolling messages
        JLabel statusLabel = new JLabel("Scroll to explore the website!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(240, 240, 240));

        // Wrap the main panel inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Timer for debouncing scroll events
        Timer timer = new Timer();
        final int debounceDelay = 200; // 200ms delay to prevent rapid updates

        // Add a mouse wheel listener to the scroll pane
        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                String message = e.getWheelRotation() < 0 ? "Scrolled Up" : "Scrolled Down";
                timer.cancel();
                Timer newTimer = new Timer();
                newTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        statusLabel.setText(message); // Display scrolling message in the status label
                    }
                }, debounceDelay);
            }
        });

        // Set up the frame layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Custom JPanel with vertical gradient background
    static class VerticalGradientPanel extends JPanel {
        private final int index;

        public VerticalGradientPanel(int index) {
            this.index = index;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Color startColor = getColor(index);
            Color endColor = startColor.darker();
            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        private Color getColor(int index) {
            switch (index % 5) {
                case 1:
                    return new Color(102, 178, 255); // Light Blue
                case 2:
                    return new Color(102, 255, 178); // Light Green
                case 3:
                    return new Color(255, 153, 102); // Peach
                case 4:
                    return new Color(255, 102, 178); // Pink
                default:
                    return new Color(204, 153, 255); // Lavender
            }
        }
    }
}
