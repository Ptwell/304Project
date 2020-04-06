package GUI;

import javax.swing.*;
import java.awt.event.*;

public class TableSelection extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox selection1;
    private String s1;
    private JComboBox selection2;
    private  String s2;
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
            }
        });
        selection1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                s1 = extractMethod(actionEvent);
            }
        });
        selection2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                s2 = extractMethod(actionEvent);
            }
        });
    }

    private String extractMethod(ActionEvent actionEvent) {
        JComboBox cb = (JComboBox) actionEvent.getSource();
        String name = (String)cb.getSelectedItem();
        return name;
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
