package advanced;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class JTreeDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTree Demo with Operations");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Departments");
            DefaultTreeModel treeModel = new DefaultTreeModel(root);

            JTree tree = new JTree(treeModel);
            JScrollPane scrollPane = new JScrollPane(tree);

            JPanel panel = new JPanel(new FlowLayout());
            JTextField nodeField = new JTextField(15);
            JButton addButton = new JButton("Add");
            JButton removeButton = new JButton("Remove");

            addButton.addActionListener(e -> {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null && !nodeField.getText().isEmpty()) {
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeField.getText());
                    selectedNode.add(newNode);
                    treeModel.reload(selectedNode);
                    nodeField.setText("");
                }
            });

            removeButton.addActionListener(e -> {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.getParent() != null) {
                    treeModel.removeNodeFromParent(selectedNode);
                }
            });

            panel.add(new JLabel("Node:"));
            panel.add(nodeField);
            panel.add(addButton);
            panel.add(removeButton);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(panel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
