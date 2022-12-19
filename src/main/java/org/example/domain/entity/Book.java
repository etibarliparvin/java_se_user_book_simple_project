package org.example.domain.entity;

import org.example.util.FileUtil;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private static Long count = (long) (FileUtil.readBookFromFile() != null ? FileUtil.readBookFromFile().size() : 0);

    private Long id;
    private String isbn;
    private String name;
    private String author;
    private Integer totalPages;
    private Integer countInStock;
    private Boolean enable = Boolean.TRUE;

    public Book() {
        this.id = ++count;
    }

    public Book(String isbn, String name, String author, Integer totalPages, Integer countInStock) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.totalPages = totalPages;
        this.countInStock = countInStock;
        this.id = ++count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Integer countInStock) {
        this.countInStock = countInStock;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void subtractCount() {
        --countInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return String.format("Book{id=%d, isbn='%s', name='%s', author='%s', totalPages=%d, countInStock=%d}",
                id, isbn, name, author, totalPages, countInStock);
    }
}
