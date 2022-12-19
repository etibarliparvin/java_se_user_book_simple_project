package org.example.service;

import org.example.domain.dto.BookDto;
import org.example.domain.request.BookCreateRequest;

import java.util.List;

public interface BookService {

    BookDto saveBook(BookCreateRequest request);

    BookDto findBookById(Long id);

    BookDto findBookByIsbn(String isbn);

    List<BookDto> getAllBooks();

    List<BookDto> findBooksByNameOrAuthor(String key);

    void deleteBookById(Long id);

    void deleteBookByIsbn(String isbn);
}
