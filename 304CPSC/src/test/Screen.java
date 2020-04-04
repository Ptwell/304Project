package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen {
    private JPanel panel1;
    private JComboBox list1;
    private JTextArea enterQueryHereTextArea;
    private JComboBox list2;
    private JButton exampleButtonButton;

    public Screen() {
        exampleButtonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Testing Testing");
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
