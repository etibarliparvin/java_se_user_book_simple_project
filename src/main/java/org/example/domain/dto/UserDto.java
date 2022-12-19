package org.example.domain.dto;

import org.example.domain.entity.Book;

import java.util.Set;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password; // TODO bunu gelecekde gosterme
    private String pin; // TODO gosterme
    private Integer age;
    private Boolean enable;
    private Set<Book> books;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return String.format("UserDto{id=%d, name='%s', surname='%s', email='%s', password='%s', pin='%s', age=%d, " +
                "enable=%s, books=%s}", id, name, surname, email, password, pin, age, enable, books);
    }
}
