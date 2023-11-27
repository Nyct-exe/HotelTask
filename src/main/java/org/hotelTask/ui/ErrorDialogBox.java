package org.hotelTask.ui;

import javax.swing.*;
import java.awt.event.*;

public class ErrorDialogBox extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel errorText;
    private JPanel bottomErrorPnl;
    private JPanel topErrorPnl;

    public ErrorDialogBox() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Error");
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });



        // call onOK() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onOK();            }
        });

        // call onOK() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        dispose();
    }

    public void setErrorText(String text) {
        errorText.setText(text);
    }

    public void showErrorDialog(String errorMessage) {
        this.setErrorText(errorMessage);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
