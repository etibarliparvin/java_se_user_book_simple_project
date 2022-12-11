package org.example.domain.request;

import org.example.exception.AgeException;

public class UserCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String  password;
    private String pin;
    private Integer age;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name, String surname, String email, String  password, String pin, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.pin = pin;
        try {
            this.age = age;
            if (age < 16) throw new AgeException("Age must be over 16 years");
        } catch (AgeException e) {
            e.printStackTrace();
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String  getPassword() {
        return password;
    }

    public void setPassword(String  password) {
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        try {
            this.age = age;
            if (age < 16) throw new AgeException("Age must be over 16 years");
        } catch (AgeException e) {
            e.printStackTrace();
        }
    }
}
