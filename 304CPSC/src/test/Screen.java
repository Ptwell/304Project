package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen {
    private JPanel panel1;
    private JComboBox list1;
    private JTextArea enterQueryHereTextArea;
    private JComboBox list2;
    private JButton exampleButtonButton;

    public Screen()
    {
        exampleButtonButton = new JButton("example button");
        enterQueryHereTextArea = new JTextArea("enter query here！！");
        String[] operation = {"insert" , "delete", "update"};
        list1 = new JComboBox(operation);
        list1.setSelectedIndex(4);
        //list1.addActionListener(this);
    }
    //@Override
  //  public void actionPerformed(ActionEvent e) {
   // };
}
