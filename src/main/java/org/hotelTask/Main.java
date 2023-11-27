package org.hotelTask;

import org.hotelTask.ui.*;
import org.hotelTask.domain.Guest;
import org.hotelTask.domain.Hotel;
import org.hotelTask.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hotelTask.ui.AddGuestScreen.assignRoom;

public class Main {


    public static void main(String[] args) {

        // Creating the rooms and then populating the hotel with the rooms.
        Room room1 = new Room("Room 101");
        Room room2 = new Room("Room 102");
        Room room3 = new Room("Room 103");
        Room room4 = new Room("Room 104");
        Room room5 = new Room("Room 105");

        Hotel hotel = new Hotel();
        hotel.setHotelName("OneStopInn");
        hotel.setHotelRooms(new ArrayList<>(Arrays.asList(room1,room2,room3,room4,room5)));

        // One dummy guest to at least have one room occupied for testing.
//        Guest guest = new Guest("Lukas","Krasauskis");
//        assignRoom(guest,hotel);

        JFrame frame = new JFrame("Hotel Booking System");


        JPanel cardPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Creating instances of UI panels
        MainMenuScreen mainMenuScreen = new MainMenuScreen(cardLayout, cardPanel);
        AddGuestScreen addGuestScreen = new AddGuestScreen(cardLayout, cardPanel, hotel);
        CheckoutScreen checkoutScreen = new CheckoutScreen(cardLayout, cardPanel, hotel);
        RoomInformationScreen roomInformationScreen = new RoomInformationScreen(cardLayout, cardPanel);
        RoomViewScreen roomViewScreen = new RoomViewScreen(cardLayout, cardPanel, hotel, roomInformationScreen);


        cardPanel.add(mainMenuScreen.getMainPnl(), "MainMenuScreen");
        cardPanel.add(addGuestScreen.getMainPnl(), "AddGuestScreen");
        cardPanel.add(checkoutScreen.getMainPnl(), "CheckoutScreen");
        cardPanel.add(roomViewScreen.getMainPnl(), "RoomViewScreen");
        cardPanel.add(roomInformationScreen.getMainPnl(), "RoomInformationScreen");



        frame.setContentPane(cardPanel);
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "MainMenu");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




}
