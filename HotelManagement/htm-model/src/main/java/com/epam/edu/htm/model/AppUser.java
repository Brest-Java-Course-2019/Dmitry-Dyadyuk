package com.epam.edu.htm.model;

public class AppUser {
    private Long id_user;
    private String password;
    private Contact contacts;
    private Address address;
    private UserType userTypes;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContacts() {
        return contacts;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserType userTypes) {
        this.userTypes = userTypes;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id_user=" + id_user +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                ", address=" + address +
                ", userTypes=" + userTypes +
                '}';
    }
}
