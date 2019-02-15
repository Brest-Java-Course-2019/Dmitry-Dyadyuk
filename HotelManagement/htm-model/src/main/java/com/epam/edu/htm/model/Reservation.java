package com.epam.edu.htm.model;

import java.sql.Date;

public class Reservation {
    private Long id_reservation;
    private String country;
    private String room_type;
    private Date start_booking;
    private Date end_booking;
    private Room room_id;
    private Long guest_id;
    private Long hotel_id;

    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Date getStart_booking() {
        return start_booking;
    }

    public void setStart_booking(Date start_booking) {
        this.start_booking = start_booking;
    }

    public Date getEnd_booking() {
        return end_booking;
    }

    public void setEnd_booking(Date end_booking) {
        this.end_booking = end_booking;
    }

    public Room getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }

    public Long getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Long guest_id) {
        this.guest_id = guest_id;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", country='" + country + '\'' +
                ", room_type='" + room_type + '\'' +
                ", start_booking=" + start_booking +
                ", end_booking=" + end_booking +
                ", room_id=" + room_id +
                ", guest_id=" + guest_id +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
