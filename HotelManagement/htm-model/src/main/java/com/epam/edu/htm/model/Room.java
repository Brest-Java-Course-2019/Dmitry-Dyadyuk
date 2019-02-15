package com.epam.edu.htm.model;

public class Room {
    private Long id_room;
    private String status;
    private Double prise_per_hour;
    private Long hotel;
    private Long room_capacity;
    private String room_type;

    public Long getId_room() {
        return id_room;
    }

    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrise_per_hour() {
        return prise_per_hour;
    }

    public void setPrise_per_hour(Double prise_per_hour) {
        this.prise_per_hour = prise_per_hour;
    }

    public Long getHotel() {
        return hotel;
    }

    public void setHotel(Long hotel) {
        this.hotel = hotel;
    }

    public Long getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(Long room_capacity) {
        this.room_capacity = room_capacity;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id_room=" + id_room +
                ", status='" + status + '\'' +
                ", prise_per_hour=" + prise_per_hour +
                ", hotel=" + hotel +
                ", room_capacity=" + room_capacity +
                ", room_type='" + room_type + '\'' +
                '}';
    }
}
