package org.hotelTask;

import org.hotelTask.domain.Guest;
import org.hotelTask.domain.Hotel;
import org.hotelTask.domain.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hotelTask.ui.AddGuestScreen.assignRoom;
import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTests {
    @Test
    @DisplayName("Check if the creation of the hotel works")
    void HotelCreationTest() {
        // Creating the rooms and then populating the hotel with the rooms.
        Room room1 = new Room("Room 101");
        Room room2 = new Room("Room 102");
        Room room3 = new Room("Room 103");
        Room room4 = new Room("Room 104");
        Room room5 = new Room("Room 105");

        Hotel hotel = new Hotel();
        hotel.setHotelName("OneStopInn");
        hotel.setHotelRooms(new ArrayList<>(Arrays.asList(room1,room2,room3,room4,room5)));

        Assertions.assertAll(
                () -> assertEquals(hotel.getHotelRooms().size(), 5),
                () -> assertEquals(hotel.getHotelName(), "OneStopInn")
        );
    }

    @Test
    @DisplayName("Tests The Guest creation through a Constructor")
    void GuestCreationTest() {
        Guest guest = new Guest("Lukas","Krasauskis");
        Assertions.assertAll(
                () -> assertEquals(guest.getGuestName(), "Lukas"),
                () -> assertEquals(guest.getGuestSurname(), "Krasauskis"),
                () -> assertNull(guest.getCurrentRoom())
        );
    }

    @Test
    @DisplayName("Tests if guest's checking in works properly")
    void GuestCheckInTest() {
        Room room1 = new Room("Room 101");
        Room room2 = new Room("Room 102");
        Room room3 = new Room("Room 103");
        Room room4 = new Room("Room 104");
        Room room5 = new Room("Room 105");

        Hotel hotel = new Hotel();
        hotel.setHotelName("OneStopInn");
        hotel.setHotelRooms(new ArrayList<>(Arrays.asList(room1,room2,room3,room4,room5)));

        Guest guest = new Guest("Lukas","Krasauskis");
        assignRoom(guest,hotel);
        Assertions.assertAll(
                () -> assertTrue(hotel.getHotelRooms().contains(guest.getCurrentRoom())),
                () -> assertFalse(guest.getCurrentRoom().isRoomAvailable())
        );
    }

}
