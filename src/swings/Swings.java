package swings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swings {
	public static void main(String[] args) {
		System.out.println("Hello, Welcome to first session of ISDC!");

//		 // Level-1
//		JFrame frame = new JFrame("Hello Swing");
//        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
//
//        frame.add(label);
//        frame.setSize(400, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

//        // Level-2
//        JFrame frame = new JFrame("Swing Structure");
//        JPanel panel = new JPanel(new FlowLayout());
//        JButton button = new JButton("Click Me");
//        JLabel label = new JLabel("Welcome!");
//
//        panel.add(label);
//        panel.add(button);
//        frame.add(panel);
//
//        frame.setSize(400, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

//		// Level-3
//		 JFrame frame = new JFrame("Grid Layout");
//        frame.setLayout(new GridLayout(2, 2));
//
//        frame.add(new JButton("Button 1"));
//        frame.add(new JButton("Button 2"));
//        frame.add(new JButton("Button 3"));
//        frame.add(new JButton("Button 4"));
//
//        frame.setSize(400, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

//		// Level 4 (Event Handling)
//		JFrame frame = new JFrame("Event Handling");
//		JTextField textField = new JTextField(20);
//		JButton button = new JButton("Submit");
//		JLabel label = new JLabel("Your Input:");
//
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String input = textField.getText();
//				label.setText("Your Input: " + input);
//			}
//		});
//
//		JPanel panel = new JPanel();
//		panel.add(textField);
//		panel.add(button);
//		panel.add(label);
//
//		frame.add(panel);
//		frame.setSize(400, 200);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);

		// Calculator-app
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
					if (e.getSource() == addButton)
						result = num1 + num2;
					else if (e.getSource() == subtractButton)
						result = num1 - num2;
					else if (e.getSource() == multiplyButton)
						result = num1 * num2;
					else if (e.getSource() == divideButton) {
						if (num2 != 0)
							result = num1 / num2;
						else
							throw new ArithmeticException("Cannot divide by zero");
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
