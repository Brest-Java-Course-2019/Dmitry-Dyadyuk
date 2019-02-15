package com.epam.edu.htm.model;

public class UserType {
    private Long id_user;
    private String user_name;

    public UserType() {
    }

    public UserType(Long id_user, String user_name) {
        this.id_user = id_user;
        this.user_name = user_name;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id_user=" + id_user +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
