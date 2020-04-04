package test;

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
                JOptionPane.showMessageDialog(null, "View Button");
                // TODO: View Button
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Update Button");
                // TODO: Update Button
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Insert Button");
                // TODO: Insert Button
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Delete Button");
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
