package org.hotelTask.domain;

public class Guest {
    public Guest(String guestName, String guestSurname) {
        this.guestName = guestName;
        this.guestSurname = guestSurname;
    }
    private String guestName;

    private String guestSurname;

    private Room currentRoom;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String toString() {
        return guestName + " " + guestSurname;
    }
}
