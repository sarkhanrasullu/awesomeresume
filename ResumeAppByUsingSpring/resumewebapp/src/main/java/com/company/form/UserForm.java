package com.company.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {

//    @NotEmpty(message="name can not be empty")
    @Size(min=3, message="name can not be less than 3")
    private String name;

    @NotEmpty
    private String surname;


    private Integer nationalityId;

    public UserForm() {
    }

    public UserForm(String name, String surname, Integer nationalityId) {
        this.name = name;
        this.surname = surname;
        this.nationalityId = nationalityId;
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

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
}
