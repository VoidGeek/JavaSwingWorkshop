package events;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandling {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Handling Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField textField = new JTextField(15);
        JButton button = new JButton("Click Me");
        JLabel resultLabel = new JLabel("Type something and click!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("Button Clicked! Text: " + textField.getText());
            }
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                resultLabel.setText("You pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        panel.add(new JLabel("Enter text:"));
        panel.add(textField);
        panel.add(button);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
