package org.example.model;

import java.util.Date;

public class Booking {

    private Room room;
    private Users users;
    private Date checkIn;
    private Date checkOut;

    public Booking(Users users , Room room,Date checkIn,Date checkOut){
        this.room = room;
        this.users = users;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public Users getUsers() {
        return users;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
