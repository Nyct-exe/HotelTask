package org.hotelTask.ui;

import org.hotelTask.domain.Hotel;
import org.hotelTask.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CheckoutScreen {
    private JPanel mainCheckoutPnl;
    private JPanel topCheckoutPnl;
    private JPanel bottomCheckoutPnl;
    private JPanel centerCheckoutPnl;
    private JButton cancelButton;
    private JButton checkoutButton;
    private JComboBox comboBox1;

    private static ErrorDialogBox errorDialogBox = new ErrorDialogBox();

    private Map<Room,String> currentGuests;


    public CheckoutScreen(CardLayout cardLayout, JPanel cardPanel, Hotel hotel) {



        mainCheckoutPnl.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                updateCurrentGuests(hotel, cardPanel);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MainMenuScreen");
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuestOut(hotel);
                updateCurrentGuests(hotel, cardPanel);
            }
        });

    }

    /*
     * Gets the hotel rooms and removes the selected room on the checkout screen based on hashmap key which is a room object
     */
    private void checkGuestOut(Hotel hotel){
        //Repurposing ErrorBox for a pop up to inform the person about the room they have been assigned
        ErrorDialogBox infoDialogBox = new ErrorDialogBox();
        infoDialogBox.setTitle("Checked out!");
        try {
            if(comboBox1.getSelectedItem() == null){
                errorDialogBox.showErrorDialog("No room has been selected!");
            } else {
                for(Room r: hotel.getHotelRooms()){
                    if(r == getKeyByValue(currentGuests, Objects.requireNonNull(comboBox1.getSelectedItem()).toString())){
                        infoDialogBox.showErrorDialog(r.getCurrentGuest().getGuestName() + " " + r.getCurrentGuest().getGuestSurname() + " Has been checkout from " + r.getRoomName());
                        r.setRoomGuest(null);
                    }
                }
            }
        } catch (Exception exception){
            errorDialogBox.showErrorDialog(exception.toString());
        }
    }

    private void updateCurrentGuests(Hotel hotel, JPanel cardPanel){
        // Filling up the combobox  on the checkout screen to list all hotel rooms
        currentGuests = getCurrentGuestList(hotel);
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel(currentGuests.values().toArray(new String[0]));
        comboBox1.setModel(defaultComboBoxModel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    public JPanel getMainPnl() {
        return mainCheckoutPnl;
    }

    private static Map<Room, String> getCurrentGuestList(Hotel hotel){
        Map<Room, String> currentGuests = new HashMap<>();
        for(Room r: hotel.getHotelRooms()){
            if(r.getCurrentGuest() != null){
                currentGuests.put(r,r.getRoomName() + " | " + r.getCurrentGuest().getGuestName() + " " + r.getCurrentGuest().getGuestSurname());
            }
        }
        return currentGuests;
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}

