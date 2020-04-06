package GUI;

import TableClasses.Table;
import TableClasses.TableSetUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableSelection extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox selection1;
    private String s1 = "None";
    private JComboBox selection2;
    private  String s2 = "None";
    private JComboBox options;
    private JTable table1;
    private JTable table2;
    private JButton updateTableButton;
    private String optionName;
    private Container returnPane;

    public TableSelection() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                optionName = extractMethod(actionEvent);
            }
        });
        selection1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                s1 = extractMethod(actionEvent);
                updateTable();
            }
        });
        selection2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                s2 = extractMethod(actionEvent);
                updateTable();
            }
        });
        updateTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateTable();
                performOption();
            }
        });
    }

    private String extractMethod(ActionEvent actionEvent) {
        JComboBox cb = (JComboBox) actionEvent.getSource();
        String name = (String)cb.getSelectedItem();
        return name;
    }

    private  void updateTable(){
        if (s1  == "None" && s2 == "None"){
            JOptionPane.showMessageDialog(null, "Please choose a table or exit.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        if (s1 == "None" && s2 != "None") {
            JOptionPane.showMessageDialog(null, "You may not choose a second table before choosing the first table.", "TABLE ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if ((s1 == s2) ||( s1 != "None" && s2 == "None")) {
            table1 = TableSetUp.makeTable(s1);
            return;
        }
        if (s1 != "None" && s2 != "None" && s1 != s2) {
            table1 = TableSetUp.makeTable(s1);
            table2 = TableSetUp.makeTable(s2);
            return;
        }




    }

    private void performOption() {
        // TODO: update table with division/join
        if (s1 == s2 || s1 == "None" || s2 == "None") {
            JOptionPane.showMessageDialog(null, "Improper entries", "TABLE ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (optionName == "Division") {
            // todo
        } else {
            if (optionName == "Full Outer Join") {
                Table.join(table1, table2);
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
        setVisible(false);
        setContentPane(returnPane);
        revalidate();
        repaint();
    }

    public void showFrame(TableSelection view, Container returnPane) {
        this.returnPane = returnPane;
        view.setContentPane(contentPane);
        view.setModal(true);
        view.setTitle("Please choose one of the options below");
        view.getRootPane().setDefaultButton(buttonCancel);
        view.pack();
        view.setVisible(true);
        // System.exit(0);
    }
}
