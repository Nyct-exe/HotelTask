package org.hotelTask.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen {
    private JPanel mainPnl;
    private JButton closeButton;
    private JLabel title;
    private JPanel menuBoxPnl;
    private JPanel bottomMenuPnl;
    private JPanel topMenuPnl;
    private JPanel centerMenuPnl;
    private JButton addGuestButton;
    private JButton viewRoomsButton;
    private JButton checkoutGuestButton;
    private JPanel menuPnl;


    public MainMenuScreen(CardLayout cardLayout, JPanel cardPanel) {
        // Main Menu Screen
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddGuestScreen");
            }
        });

        checkoutGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CheckoutScreen");
            }
        });
        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "RoomViewScreen");
            }
        });
    }


    public JPanel getMainPnl() {
        return mainPnl;
    }


}
