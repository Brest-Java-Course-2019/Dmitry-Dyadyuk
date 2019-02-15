package com.epam.edu.htm.model;

public class Guest {
    private Long id_guest;
    private Long id_user;

    public Long getId_guest() {
        return id_guest;
    }

    public void setId_guest(Long id_guest) {
        this.id_guest = id_guest;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id_guest=" + id_guest +
                ", id_user=" + id_user +
                '}';
    }
}




