package org.example.model;

public class Room {

    private int id;
    private RoomType type;
    private int price;


    public Room(int id,RoomType type,int price){
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public RoomType getType() {
        return type;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
