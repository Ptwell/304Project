package Main;

import GUI.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class MainClass {
     // Screen screen = null;

   // private JFrame frame = new JFrame("Query Engine");
    private JPanel backgroundPanel = new JPanel();
    private JPanel mainPanel;
    private  JPanel viewPanel;
    private  JPanel deletePanel;
    private  JPanel updatePanel;
    private  JPanel insertPanel;

    private  JButton viewButton;
    private  JButton updateButton;
    private  JButton deleteButton;
    private  JButton insertButton;
    private  JButton selectionButton;
    private  JButton projectionButton;

    private  CardLayout cards = new CardLayout();

     public MainClass() {
          // backgroundPanel.setLayout(cards);
         //start();
         viewButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //  cards.show(viewPanel, "1");
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
         mainPanel.addContainerListener(new ContainerAdapter() {
             @Override
             public void componentAdded(ContainerEvent e) {
                 super.componentAdded(e);
             }
         });
     }

    public void start() {

        //cards.layoutContainer(backgroundPanel);
        cards.addLayoutComponent(mainPanel, "0");
        //backgroundPanel.add(mainPanel,"0");
        cards.addLayoutComponent(viewPanel, "1");

        // backgroundPanel = new JPanel(cards);
        cards.show(backgroundPanel, "0");




    }

    private void addComponent(Container contentPane) {


        //contentPane.add(cards);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QueryHandler");
        MainClass m = new MainClass();
        frame.setContentPane( m.backgroundPanel);
        m.start();
        frame.add(m.backgroundPanel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        MainClass mc = new MainClass();
//        mc.start();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                MainClass m = new MainClass();
//
//            }
//        });

    }
}
