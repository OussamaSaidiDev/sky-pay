package org.example.service;

import org.example.model.Booking;
import org.example.model.Room;

import java.util.Date;
import java.util.List;

public class BookingService {

    public static boolean isRoomAlreadyReserved(List<Booking> bookings, Room selectedRoom, Date checkIn, Date checkOut) {
        if (bookings == null || bookings.isEmpty()) {
            return false;
        }

        return bookings.stream()
                .filter(b -> b.getRoom().getId() == selectedRoom.getId())
                .anyMatch(b -> checkIn.before(b.getCheckOut()) && checkOut.after(b.getCheckIn()));
    }
}
