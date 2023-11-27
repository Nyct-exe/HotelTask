package org.hotelTask.ui;

import org.hotelTask.domain.Guest;
import org.hotelTask.domain.Hotel;
import org.hotelTask.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



public class AddGuestScreen {

    private JPanel mainGuestAddPnl;
    private JPanel registerGuestPnl;
    private JPanel registerGuestBoxPnl;
    private JPanel topRegisterGuestPnl;
    private JPanel bottomRegisterGuestPnl;
    private JButton registerGuestButton;
    private JPanel centerRegisterGuestPnl;

    private JTextField firstnameText;
    private JTextField surnameText;
    private JButton cancelButtonGuestRegister;

    private static ErrorDialogBox errorDialogBox = new ErrorDialogBox();



    public AddGuestScreen(CardLayout cardLayout, JPanel cardPanel, Hotel hotel) {

        // Add Guest Screen
        registerGuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstnameText.getText().isEmpty()){
                    errorDialogBox.showErrorDialog("Missing name");
                } else if (surnameText.getText().isEmpty()){
                    errorDialogBox.showErrorDialog("Missing surname");
                }
                else {
                    Guest guest = new Guest(firstnameText.getText(), surnameText.getText());
                    assignRoom(guest,hotel);
                }

            }
        });

        cancelButtonGuestRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenuScreen");
            }
        });
    }

    public JPanel getMainPnl() {
        return mainGuestAddPnl;
    }


    // Assigns room to the guest when the guest registers
    public static void assignRoom(Guest guest, Hotel hotel){

        //Repurposing ErrorBox for a pop up to inform the person about the room they have been assigned
        ErrorDialogBox infoDialogBox = new ErrorDialogBox();
        infoDialogBox.setTitle("Room Assignment");

        try{
            for(Room r: hotel.getHotelRooms()){
                if(r.isRoomAvailable() && guest.getCurrentRoom() == null){
                    r.setRoomGuest(guest);
                    r.setRoomAvailable(false);
                    infoDialogBox.showErrorDialog("Guest: " + guest.getGuestName() + " " + guest.getGuestSurname() + " has been assigned a " + r.getRoomName());
                    break;
                } else if (Objects.equals(r.getCurrentGuest().getGuestName(), guest.getGuestName()) && Objects.equals(r.getCurrentGuest().getGuestSurname(), guest.getGuestSurname())){
                    errorDialogBox.showErrorDialog("Guest already has a room!");
                    guest.setCurrentRoom(r);
                    break;
                }
            }
            if(guest.getCurrentRoom() == null) {
                errorDialogBox.showErrorDialog("There are currently no rooms available");
            }

        }catch (Exception e){
            errorDialogBox.showErrorDialog("Hotel does not exist! Or Something Went Wrong");
        }

    }
}
