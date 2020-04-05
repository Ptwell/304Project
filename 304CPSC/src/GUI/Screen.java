package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen {
    private JPanel panel1;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton viewButton;

    public Screen() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "View Button"); // temporary
                // TODO: View Button

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Update Button"); // temporary
                // TODO: Update Button
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Insert Button"); // temporary
                // TODO: Insert Button
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Delete Button"); // temporary
                // TODO: Insert Button
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QueryHandler");
        frame.setContentPane(new Screen() .panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
     }
}
