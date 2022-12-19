package org.example.respository;

import org.example.domain.entity.Book;

import java.util.List;

public interface BookRepository {

    void saveBook(Book book);

    Book findBookById(Long id);

    Book findBookByIsbn(String isbn);

    List<Book> getAllBooks();

    List<Book> findBooksByNameOrAuthor(String key);

    void deleteBookById(Long id);

    void deleteBookByIsbn(String isbn);
}
