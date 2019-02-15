package com.epam.edu.htm.model;

public class RoomCapacity {
    private Long id_room_capacity;
    private Integer capacity;


    public Long getId_room_capacity() {
        return id_room_capacity;
    }

    public void setId_room_capacity(Long id_room_capacity) {
        this.id_room_capacity = id_room_capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RoomCapacity{" +
                "id_room_capacity=" + id_room_capacity +
                ", capacity=" + capacity +
                '}';
    }
}
