package com.company.dto;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String nationalityName;


    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String nationalityName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationalityName = nationalityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }
}
