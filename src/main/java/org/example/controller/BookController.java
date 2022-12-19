package org.example.controller;

import org.example.domain.request.BookCreateRequest;
import org.example.service.BookService;
import org.example.service.impl.BookServiceImpl;
import org.example.util.BookUtil;
import org.example.util.InputUtil;

public class BookController {
    private static final BookService service = new BookServiceImpl();

    public static void main(String[] args) {
        while (true) {
            int menu = InputUtil.requireNumber(
                    "1.Register a new book" +
                            "\n2.Show all books" +
                            "\n3.Find book by id" +
                            "\n4.Find book by isbn" +
                            "\n5.Find books by name or author" +
                            "\n6.Delete book by id" +
                            "\n7.Delete book by isbn" +
                            "\n8.Go to main page" +
                            "\n---------------------------------------------------------------------------");

            switch (menu) {
                case 1:
                    BookCreateRequest request = BookUtil.fillBookCreateRequest();
                    service.saveBook(request);
                    break;
                case 2:
                    System.out.println(service.getAllBooks());
                    break;
                case 3:
                    Long findId = (long) InputUtil.requireNumber("Please enter id:");
                    System.out.println(service.findBookById(findId));
                    break;
                case 4:
                    String isbn = InputUtil.requireText("Please enter isbn:");
                    System.out.println(service.findBookByIsbn(isbn));
                    break;
                case 5:
                    String key = InputUtil.requireText("Please enter name or author of book:");
                    System.out.println(service.findBooksByNameOrAuthor(key));
                    break;
                case 6:
                    Long deleteId = (long) InputUtil.requireNumber("Please enter id:");
                    service.deleteBookById(deleteId);
                    break;
                case 7:
                    String deleteIsbn = InputUtil.requireText("Please enter pin:");
                    service.deleteBookByIsbn(deleteIsbn);
                    break;
                case 8:
                    UserBookApi.main(null);
                    break;
                default:
                    break;
            }
        }
    }
}
