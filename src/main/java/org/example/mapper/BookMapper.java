package org.example.mapper;

import org.example.domain.dto.BookDto;
import org.example.domain.entity.Book;
import org.example.domain.request.BookCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Book toBookEntity(BookCreateRequest request) {
        Book book = new Book();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setCountInStock(request.getCountInStock());
        book.setTotalPages(request.getTotalPages());
        return book;
    }

    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTotalPages(book.getTotalPages());
        bookDto.setCountInStock(book.getCountInStock());
        bookDto.setEnable(book.getEnable());
        return bookDto;
    }

    public static List<BookDto> toBookDto(List<Book> books) {
        return books.stream()
                .map(BookMapper::toBookDto)
                .collect(Collectors.toList());
    }
}
