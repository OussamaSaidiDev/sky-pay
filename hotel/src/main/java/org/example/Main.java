package org.example;

import org.example.exception.ServiceException;
import org.example.model.RoomType;
import org.example.specs.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("=== SKYPAY TECHNICAL TEST 2 - HOTEL RESERVATION SYSTEM ===\n");

        try {
            System.out.println("1. Creating 3 rooms...");
            service.setRoom(1, RoomType.STANDARD, 1000);
            service.setRoom(2, RoomType.JUNIOR, 2000);
            service.setRoom(3, RoomType.SUITE, 3000);
            System.out.println();
            System.out.println("2. Creating 2 users...");
            service.setUser(1, 5000);   // User 1: ID=1, Balance=5000
            service.setUser(2, 10000);  // User 2: ID=2, Balance=10000
            System.out.println();

            System.out.println("3. User 1 booking Room 2 from 30/06/2026 to 07/07/2026 (7 nights)...");
            Date checkIn1 = dateFormat.parse("30/06/2026");
            Date checkOut1 = dateFormat.parse("07/07/2026");
            try {
                service.bookRoom(1, 2, checkIn1, checkOut1);
            }catch (ServiceException e){
                System.out.println(e.getMessage());
            }
            System.out.println();

            System.out.println("4. User 1 booking Room 2 from 07/07/2026 to 30/06/2026 (invalid dates)...");
            try {
                Date checkIn2 = dateFormat.parse("07/07/2026");
                Date checkOut2 = dateFormat.parse("30/06/2026");
                service.bookRoom(1, 2, checkIn2, checkOut2);
            } catch (ServiceException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            System.out.println();

            System.out.println("5. User 1 booking Room 1 from 07/07/2026 to 08/07/2026 (1 night)...");
            try {
                Date checkIn3 = dateFormat.parse("07/07/2026");
                Date checkOut3 = dateFormat.parse("08/07/2026");
                service.bookRoom(1, 1, checkIn3, checkOut3);
            } catch (ServiceException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            System.out.println();

            System.out.println("6. User 2 booking Room 1 from 07/07/2026 to 09/07/2026 (2 nights)...");
            try {
                Date checkIn4 = dateFormat.parse("07/07/2026");
                Date checkOut4 = dateFormat.parse("09/07/2026");
                service.bookRoom(2, 1, checkIn4, checkOut4);
            } catch (ServiceException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            System.out.println();

            System.out.println("7. User 2 booking Room 3 from 07/07/2026 to 08/07/2026 (1 night)...");
            Date checkIn5 = dateFormat.parse("07/07/2026");
            Date checkOut5 = dateFormat.parse("08/07/2026");
            service.bookRoom(2, 3, checkIn5, checkOut5);
            System.out.println();

            System.out.println("8. Updating Room 1 to suite type with price 10000...");
            service.setRoom(1, RoomType.SUITE, 10000);
            System.out.println();

            System.out.println("=== FINAL RESULTS ===");
            System.out.println("--- printAll() ---");
            service.printAll();

            System.out.println("--- printAllUsers() ---");
            service.printAllUsers();

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}