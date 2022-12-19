package org.example.service.impl;

import org.example.domain.dto.BookDto;
import org.example.domain.entity.Book;
import org.example.domain.request.BookCreateRequest;
import org.example.mapper.BookMapper;
import org.example.respository.BookRepository;
import org.example.respository.impl.BookRepositoryImpl;
import org.example.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository repository = new BookRepositoryImpl();

    @Override
    public BookDto saveBook(BookCreateRequest request) {
        Book book = BookMapper.toBookEntity(request);
        repository.saveBook(book);
        return BookMapper.toBookDto(book);
    }

    @Override
    public BookDto findBookById(Long id) {
        return BookMapper.toBookDto(repository.findBookById(id));
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        return BookMapper.toBookDto(repository.findBookByIsbn(isbn));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return BookMapper.toBookDto(repository.getAllBooks());
    }

    @Override
    public List<BookDto> findBooksByNameOrAuthor(String key) {
        return BookMapper.toBookDto(repository.findBooksByNameOrAuthor(key));
    }

    @Override
    public void deleteBookById(Long id) {
        repository.deleteBookById(id);
    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        repository.deleteBookByIsbn(isbn);
    }
}
