package com.epam.edu.htm.model;

public class RoomType {
    private Long id_rom_type;
    private String name;

    public Long getId_rom_type() {
        return id_rom_type;
    }

    public void setId_rom_type(Long id_rom_type) {
        this.id_rom_type = id_rom_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id_rom_type=" + id_rom_type +
                ", name='" + name + '\'' +
                '}';
    }
}
