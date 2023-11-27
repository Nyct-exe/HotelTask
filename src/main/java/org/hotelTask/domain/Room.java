package org.hotelTask.domain;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public Room(String roomName) {
        this.roomName = roomName;
    }

    private String roomName;
    private Guest currentGuest;
    private List<Guest> guestHistory = new ArrayList<>();

    // Room is available by default on creation for convenience.
    private boolean roomAvailable = true;

    public boolean isRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Guest getCurrentGuest() {
        return currentGuest;
    }


    public List<Guest> getGuestHistory() {
        return guestHistory;
    }

    public void setRoomGuest(Guest guest) {
        currentGuest = guest;
        if(guest == null){
            roomAvailable = true;
        } else {
            roomAvailable = false;
            currentGuest.setCurrentRoom(this);
            guestHistory.add(guest);
        }
    }

    public void checkoutGuest(Guest guest){
        this.currentGuest = null;
    }
}
