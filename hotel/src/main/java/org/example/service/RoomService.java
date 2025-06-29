package org.example.service;

import org.example.model.Room;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RoomService {

    public static Room findRoomById(List<Room> rooms , int id){
        return rooms.stream()
                .filter(r -> Objects.equals(r.getId() , id))
                .findFirst().orElse(null);
    }

}
