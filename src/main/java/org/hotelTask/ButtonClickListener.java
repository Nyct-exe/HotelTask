package org.hotelTask;

import org.hotelTask.ui.RoomInformationScreen;
import org.hotelTask.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class is meant for responding to dynamically created buttons within RoomViewScreen and displaying
// Correct info on the Room Information Screen
public class ButtonClickListener  implements ActionListener {
    private Room room;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private RoomInformationScreen roomInformationScreen;

    public ButtonClickListener(Room room, CardLayout cardLayout, JPanel cardPanel, RoomInformationScreen roomInformationScreen){
        this.room = room;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.roomInformationScreen = roomInformationScreen;
    }

    // Action that happens once one of the room buttons is pressed
    // In this case it sets up the screen to match the selected room data.
    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.show(cardPanel, "RoomInformationScreen");
        //Logic for dynamic roomInfo screen
        if(!room.getGuestHistory().isEmpty()){
            roomInformationScreen.setRoomHistoryText(String.valueOf(room.getGuestHistory()));
        } else {
            roomInformationScreen.setRoomHistoryText("There Have been no guests yet");
        }
        if(room.getCurrentGuest() != null){
            roomInformationScreen.setGuestInfoText(room.getCurrentGuest().toString());
        } else {
            roomInformationScreen.setGuestInfoText("Room Is Available");
        }



    }
}
