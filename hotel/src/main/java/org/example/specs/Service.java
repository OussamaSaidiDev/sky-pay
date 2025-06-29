package org.example.specs;

import org.example.exception.ExceptionMessages;
import org.example.exception.ServiceException;
import org.example.model.Booking;
import org.example.model.Room;
import org.example.model.RoomType;
import org.example.model.Users;
import org.example.service.BookingService;
import org.example.service.RoomService;
import org.example.service.UsersService;
import org.example.utils.DateUtils;
import org.example.utils.DisplayUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.exception.ExceptionMessages.*;

public class Service {
    ArrayList<Room> rooms;
    ArrayList<Users> users;
    ArrayList<Booking> bookings;

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        if(rooms ==  null){
            rooms = new ArrayList<>();
        }
        Room room = RoomService.findRoomById(rooms,roomNumber);

        if(room == null){
            room = new Room(roomNumber,roomType,roomPricePerNight);
            rooms.add(room);
            System.out.println("Room created: ");
            DisplayUtils.displayRoomDetail(room);
        }else{
            room.setPrice(roomPricePerNight);
            room.setType(roomType);
            System.out.println("Room Updated: ");
            DisplayUtils.displayRoomDetail(room);
        }

    }
    public void setUser(int userId, int balance) {
        if (users == null) {
            users = new ArrayList<>();
        }

        Users user = UsersService.findUserById(users,userId);

        if (user == null) {
            user = new Users(userId, balance);
            users.add(user);
            System.out.println("User created:");
            DisplayUtils.displayUsersDetail(user);
        } else {
            user.setBalance(balance);
            System.out.println("User updated: ");
            DisplayUtils.displayUsersDetail(user);
        }
    }


    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }

        if (checkIn == null || checkOut == null || !checkOut.after(checkIn)) {
            throw new ServiceException(RESERVATION_DATES_INVALID);
        }

        Users user = UsersService.findUserById(users,userId);

        if(user == null){
            throw new ServiceException(USER_NOT_FOUND);
        }

        Room room = RoomService.findRoomById(rooms,roomNumber);

        if(room == null){
            throw new ServiceException(ROOM_NOT_FOUND);
        }

        if (BookingService.isRoomAlreadyReserved(bookings,room,checkIn,checkOut)) {
            throw new ServiceException(ExceptionMessages.RESERVATION_CONFLICT);
        }

        int nights = DateUtils.calculateDays(checkIn,checkOut);

        int totalPrice = nights * room.getPrice();

        if (user.getBalance() < totalPrice) {
            throw new ServiceException(INSUFFICIENT_BALANCE);
        }

        user.setBalance(user.getBalance() - totalPrice);


        Room roomClone = new Room(room.getId(),room.getType(),room.getPrice());
        // We provide a copy of the Room so that setRoom doesn't affect existing bookings.
        Booking newBooking = new Booking(user, roomClone, checkIn, checkOut);
        bookings.add(newBooking);

        System.out.println("Booking successful:");
        DisplayUtils.displayBookingDetail(newBooking);
    }

    public void printAll() {
        if (rooms == null || rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.println("=== Room List (latest to oldest) ===");

        for (int i = rooms.size() - 1; i >= 0; i--) {
            Room room = rooms.get(i);
            DisplayUtils.displayRoomDetail(room);

            if (bookings != null) {
                List<Booking> bookingsForRoom = bookings.stream()
                        .filter(b -> b.getRoom().getId() == room.getId())
                        .toList();
                DisplayUtils.displayBookings(bookingsForRoom);
            }
        }
    }


    public void printAllUsers() {
        users.forEach(DisplayUtils::displayUsersDetail);
    }
}
