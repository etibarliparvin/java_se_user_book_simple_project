package org.example.domain.entity;

import org.example.util.FileUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
    private static Long count = (long) (FileUtil.readUserFromFile() != null ? FileUtil.readUserFromFile().size() : 0);

    private Long id;
    private String name;
    private String surname;
    private String email;
    private byte[] password;
    private String pin;
    private Integer age;

    private Boolean enable = Boolean.TRUE;
    private Set<Book> books = new HashSet<>();

    public User() {
        this.id = ++count;
    }

    public User(String name, String surname, String email, byte[] password, String pin, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.age = age;
        this.id = ++count;
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

    public void addBook(Book book) {
        this.books.add(book);
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
        return String.format("User{id=%d, name='%s', surname='%s', email='%s', password=%s, pin='%s', age=%d, " +
                "enable=%s, books=%s}", id, name, surname, email, Arrays.toString(password), pin, age, enable, books);
    }
}
