package org.example.domain.request;

public class BookCreateRequest {
    private String isbn;
    private String name;
    private String author;
    private Integer totalPages;
    private Integer countInStock;

    public BookCreateRequest() {
    }

    public BookCreateRequest(String isbn, String name, String author, Integer totalPages, Integer countInStock) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.totalPages = totalPages;
        this.countInStock = countInStock;
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
}
