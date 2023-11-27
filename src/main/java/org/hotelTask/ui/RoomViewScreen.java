package org.hotelTask.ui;

import org.hotelTask.ButtonClickListener;
import org.hotelTask.domain.Hotel;
import org.hotelTask.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RoomViewScreen {
    private JPanel mainPnl;
    private JPanel topPnl;
    private JPanel bottomPnl;
    private JButton cancelButton;
    private JPanel centerPnl;

    public RoomViewScreen(CardLayout cardLayout, JPanel cardPanel, Hotel hotel, RoomInformationScreen roomInformationScreen) {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenuScreen");
            }
        });
        mainPnl.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                // Clear existing buttons, I know this is not great but for the current system it will have to do
                centerPnl.removeAll();
                // Dynamically adds buttons to the RoomView screen once it is in view.
                for(Room r: hotel.getHotelRooms()){
                    JButton button;
                    if(r.isRoomAvailable()){
                         button = new JButton("<html><center>"+ r.getRoomName() +"<br>" + "Available" + "</center></html>");
                    } else {
                         button = new JButton("<html><center>"+ r.getRoomName() +"<br>" + r.getCurrentGuest().getGuestName() + " " + r.getCurrentGuest().getGuestSurname() + "</center></html>");
                    }

                    //Passing the room to the listener, so I could interact with dynamic buttons
                    ButtonClickListener buttonClickListener = new ButtonClickListener(r, cardLayout, cardPanel,roomInformationScreen);
                    button.addActionListener(buttonClickListener);

                    button.setVisible(true);
                    centerPnl.add(button);
                }
                centerPnl.revalidate();
                centerPnl.repaint();
            }
        });


    }

    public JPanel getMainPnl() {
        return mainPnl;
    }


}
