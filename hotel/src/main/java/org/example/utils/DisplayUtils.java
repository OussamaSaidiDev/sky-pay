package org.example.utils;

import org.example.model.Booking;
import org.example.model.Room;
import org.example.model.Users;

import java.text.SimpleDateFormat;
import java.util.List;

public class DisplayUtils {

    // Add this date formatter
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void displayBookingDetail(Booking booking){
        System.out.println("User ID: " + booking.getUsers().getId() + ", Room ID: " + booking.getRoom().getId());
        System.out.println("Check-in: " + DATE_FORMAT.format(booking.getCheckIn()) + ", Check-out: " + DATE_FORMAT.format(booking.getCheckOut()));
        int nights = DateUtils.calculateDays(booking.getCheckIn(),booking.getCheckOut());
        System.out.println("Nights : " + nights);
        System.out.println("Total price: " + nights * booking.getRoom().getPrice());
    }

    public static void displayUsersDetail(Users user){
        System.out.println("User : ID=" + user.getId() + ", Balance=" + user.getBalance());
    }

    public  static void displayRoomDetail(Room room){
        System.out.println("Room : ID=" + room.getId()+ ", Type=" + room.getType() + ", Price=" + room.getPrice());
    }

    public  static void displayBookings(List<Booking> bookings){
        if (bookings.isEmpty()) {
            System.out.println("No bookings for this room.");
        } else {
            System.out.println("Bookings:");
            for (int j = bookings.size() - 1; j >= 0; j--) {
                Booking b = bookings.get(j);
                displayBookingDetail(b);
            }
        }
    }
}