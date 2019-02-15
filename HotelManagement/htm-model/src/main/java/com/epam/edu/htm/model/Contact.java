package com.epam.edu.htm.model;

public class Contact {
    private Long id_contact;
    private String phone;
    private String email;

    public Contact() {
    }

    public Contact(Long id_contact, String phone, String email) {
        this.id_contact = id_contact;
        this.phone = phone;
        this.email = email;
    }

    public Long getId_contact() {
        return id_contact;
    }

    public void setId_contact(Long id_contact) {
        this.id_contact = id_contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id_contact=" + id_contact +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
