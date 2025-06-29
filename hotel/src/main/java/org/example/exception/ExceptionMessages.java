    package org.example.exception;

    public class ExceptionMessages {
        public static final String NO_ROOM_IS_CREATED = "The room list is empty.";
        public static final String ROOM_NOT_FOUND = "The specified room was not found.";
        public static final String USER_ALREADY_IN_ROOM = "User is already part of the room.";

        // Reservation-related messages
        public static final String RESERVATION_NOT_FOUND = "The specified reservation was not found.";
        public static final String RESERVATION_ALREADY_EXISTS = "A reservation for this user and room already exists.";
        public static final String RESERVATION_DATES_INVALID = "The reservation dates are invalid (check-out must be after check-in).";
        public static final String RESERVATION_OVERLAPS_EXISTING = "This reservation overlaps with an existing reservation.";
        public static final String RESERVATION_CAPACITY_EXCEEDED = "Reservation exceeds the room's capacity.";
        public static final String RESERVATION_DATE_IN_PAST = "Cannot make a reservation in the past.";
        public static final String RESERVATION_CONFLICT = "This reservation conflicts with another one.";
        public static final String RESERVATION_CANCELLATION_FORBIDDEN = "You are not allowed to cancel this reservation.";

        public static final String INSUFFICIENT_BALANCE = "Insufficient balance for this booking.";

        public static final String USER_NOT_FOUND = "User not found.";

    }
