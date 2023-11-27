package org.hotelTask.domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private List<Room> hotelRooms = new ArrayList<>();

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Room> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(List<Room> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
}
