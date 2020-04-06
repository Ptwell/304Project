package GUI;

import TableClasses.TableSetUp;

import javax.swing.*;
import java.awt.event.*;

public class TableSelection extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox selection1;
    private String s1 = "None";
    private JComboBox selection2;
    private  String s2 = "None";
    private JComboBox options;
    private JTable table1;
    private String optionName;

    public TableSelection() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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
                performOption();
                updateTable();
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
    }

    private String extractMethod(ActionEvent actionEvent) {
        JComboBox cb = (JComboBox) actionEvent.getSource();
        String name = (String)cb.getSelectedItem();
        return name;
    }

    private  void updateTable(){
        if (s1 == "None" && s2 != "None") {
            JOptionPane.showMessageDialog(null, "You may not choose a second table before choosing the first table.", "TABLE ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if (s1 == s2) {
            TableSetUp.makeTable(s1);
        }
    }

    private void performOption() {
        // TODO: update table with division/join
        if (optionName == "Division") {
            // todo
        } else {
            if (optionName == "Full Outer Join") {
                // todo
            }
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TableSelection dialog = new TableSelection();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
