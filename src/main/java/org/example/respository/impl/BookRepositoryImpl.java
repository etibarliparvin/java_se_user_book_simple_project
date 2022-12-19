package org.example.respository.impl;

import org.example.domain.entity.Book;
import org.example.respository.BookRepository;
import org.example.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public void saveBook(Book book) {
        List<Book> books = FileUtil.readBookFromFile() != null ? FileUtil.readBookFromFile() : new ArrayList<>();
        books.add(book);
        FileUtil.writeBookToFile(books);
    }

    @Override
    public Book findBookById(Long id) {
        List<Book> list = FileUtil.readBookFromFile();
        if (id < 0 || id > list.size()) return null;
        if (list != null && !list.isEmpty()) {
            Book book = list.get((int) (id - 1));
            if (book.getEnable()) return book;
        }
        return null;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        List<Book> list = FileUtil.readBookFromFile();
        if (list != null && !list.isEmpty()) {
            return list.stream()
                    .filter(a -> a.getIsbn().equals(isbn) && a.getEnable())
                    .findFirst().get();
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return FileUtil.readBookFromFile()
                .stream()
                .filter(Book::getEnable)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findBooksByNameOrAuthor(String key) {
        List<Book> list = FileUtil.readBookFromFile();
        if (list != null && !list.isEmpty()) {
            return list.stream()
                    .filter(a -> (a.getName().contains(key) || a.getAuthor().contains(key)) && a.getEnable())
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = findBookById(id);
        List<Book> books = getAllBooks();
        books.remove(book);
        book.setEnable(Boolean.FALSE);
        books.add(book);
        FileUtil.writeBookToFile(books);
    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        Book book = findBookByIsbn(isbn);
        List<Book> books = getAllBooks();
        books.remove(book);
        book.setEnable(Boolean.FALSE);
        books.add(book);
        FileUtil.writeBookToFile(books);
    }
}
