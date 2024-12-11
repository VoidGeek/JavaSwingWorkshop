package advanced;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTable Demo with Operations");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            String[] columnNames = {"ID", "Name", "Department"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel panel = new JPanel(new FlowLayout());
            JTextField idField = new JTextField(5);
            JTextField nameField = new JTextField(10);
            JTextField deptField = new JTextField(10);

            JButton addButton = new JButton("Add");
            JButton removeButton = new JButton("Remove");
            JButton updateButton = new JButton("Update");

            addButton.addActionListener(e -> {
                if (!idField.getText().isEmpty() && !nameField.getText().isEmpty() && !deptField.getText().isEmpty()) {
                    model.addRow(new Object[]{idField.getText(), nameField.getText(), deptField.getText()});
                    idField.setText("");
                    nameField.setText("");
                    deptField.setText("");
                }
            });

            removeButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) model.removeRow(selectedRow);
            });

            updateButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.setValueAt(idField.getText(), selectedRow, 0);
                    model.setValueAt(nameField.getText(), selectedRow, 1);
                    model.setValueAt(deptField.getText(), selectedRow, 2);
                }
            });

            panel.add(new JLabel("ID:"));
            panel.add(idField);
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Dept:"));
            panel.add(deptField);
            panel.add(addButton);
            panel.add(removeButton);
            panel.add(updateButton);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(panel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
