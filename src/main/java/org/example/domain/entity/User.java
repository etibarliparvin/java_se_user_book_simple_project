package org.example.domain.entity;

import org.example.exception.AgeException;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private byte[] password;
    private String pin;
    private Integer age;

    public User() {
    }

    public User(String name, String surname, String email, byte[] password, String pin, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
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
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(pin, user.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', surname='%s', email='%s', password='%s', pin='%s', age=%d}",
                id, name, surname, email, password, pin, age);
    }
}
