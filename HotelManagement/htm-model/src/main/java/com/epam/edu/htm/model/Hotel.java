package com.epam.edu.htm.model;

import java.util.List;

public class Hotel {
    private Long id_hotel;
    private Contact contacts;
    private String hotel_type;
    private Address addresses;

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Contact getContacts() {
        return contacts;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public String getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(String hotel_type) {
        this.hotel_type = hotel_type;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id_hotel=" + id_hotel +
                ", contacts=" + contacts +
                ", hotel_type='" + hotel_type + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
