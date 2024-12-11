package exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel label1 = new JLabel("Number 1:");
        JTextField num1Field = new JTextField();
        JLabel label2 = new JLabel("Number 2:");
        JTextField num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result:");

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = 0;

                    if (e.getSource() == addButton) result = num1 + num2;
                    else if (e.getSource() == subtractButton) result = num1 - num2;
                    else if (e.getSource() == multiplyButton) result = num1 * num2;
                    else if (e.getSource() == divideButton) {
                        if (num2 != 0) result = num1 / num2;
                        else throw new ArithmeticException("Cannot divide by zero");
                    }

                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        };

        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);

        panel.add(label1);
        panel.add(num1Field);
        panel.add(label2);
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
