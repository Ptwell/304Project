package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnViewClick extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton projectionButton;
    private JButton selectionButton;
    private Container returnPane;

    public OnViewClick() {

        buttonOK.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

//        // call onCancel() when cross is clicked
        setDefaultCloseOperation(HIDE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onCancel();
//            }
//        });

        // call onCancel() on ESCAPE
//        contentPane.registerKeyboardAction(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
        setVisible(false);
        setContentPane(returnPane);
        revalidate();


//        Screen frame = new Screen();
//        frame.showFrame();
    }

    private void onCancel() {
        // add your code here if necessary
        setVisible(false);
    }

    public void showFrame() {
        OnViewClick dialog = new OnViewClick();
        returnPane = getContentPane();
        dialog.setContentPane(contentPane);
        // dialog.setModal(true);
        // dialog.getRootPane().setDefaultButton(buttonOK);
        dialog.pack();
        dialog.setVisible(true);
        // System.exit(0);
    }
}
