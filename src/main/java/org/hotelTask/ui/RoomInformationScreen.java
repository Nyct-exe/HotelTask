package org.hotelTask.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomInformationScreen {
    private JPanel mainPnl;
    private JPanel topPnl;
    private JButton backButton;
    private JPanel bottomPnl;
    private JPanel centerPnl;
    private JPanel leftCenterPnl;
    private JPanel rightCenterPnl;
    private JPanel leftCenterTopPnl;
    private JPanel RightCenterTopPnl;
    private JLabel guestInfoText;
    private JLabel roomHistoryText;

    public RoomInformationScreen(CardLayout cardLayout, JPanel cardPanel) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "RoomViewScreen");

            }
        });
    }

    public JPanel getMainPnl() {
        return mainPnl;
    }

    public void setGuestInfoText(String guestInfoText) {
        this.guestInfoText.setText(guestInfoText);
    }

    public void setRoomHistoryText(String roomHistoryText) {
        this.roomHistoryText.setText(roomHistoryText);
    }
}
