package org.example.controller;

import org.example.domain.request.UserCreateRequest;
import org.example.service.BookService;
import org.example.service.UserService;
import org.example.service.impl.BookServiceImpl;
import org.example.service.impl.UserServiceImpl;
import org.example.util.InputUtil;
import org.example.util.UserUtil;

public class UserController {

    private static final UserService service = new UserServiceImpl();
    private static final BookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        while (true) {
            int menu = InputUtil.requireNumber(
                    "1.Register a new user" +
                            "\n2.Show all users" +
                            "\n3.Find user by id" +
                            "\n4.Find user by pin" +
                            "\n5.Find users by name or surname" +
                            "\n6.Delete user by id" +
                            "\n7.Delete user by pin" +
                            "\n8.Choose book:" +
                            "\n9.Return book:" +
                            "\n10.Go to main page" +
                            "\n---------------------------------------------------------------------------");

            switch (menu) {
                case 1:
                    UserCreateRequest request = UserUtil.fillUserCreateRequest();
                    service.saveUser(request);
                    break;
                case 2:
                    System.out.println(service.getAllUsers());
                    break;
                case 3:
                    Long findId = (long) InputUtil.requireNumber("Please enter id:");
                    System.out.println(service.findUserById(findId));
                    break;
                case 4:
                    String pin = InputUtil.requireText("Please enter pin:");
                    System.out.println(service.findUserByPin(pin));
                    break;
                case 5:
                    String key = InputUtil.requireText("Please enter name or surname of user:");
                    System.out.println(service.findUsersByNameOrSurname(key));
                    break;
                case 6:
                    Long deleteId = (long) InputUtil.requireNumber("Please enter id:");
                    service.deleteUserById(deleteId);
                    break;
                case 7:
                    String deletePin = InputUtil.requireText("Please enter pin:");
                    service.deleteUserByPin(deletePin);
                    break;
                case 8:
                    System.out.println(service.getAllUsers());
                    String userPin = InputUtil.requireText("Please enter pin of a user:");
                    System.out.println(bookService.getAllBooks());
                    String isbn = InputUtil.requireText("Please enter isbn of a book:");
                    service.selectBook(userPin, isbn);
                    break;
                case 10:
                    UserBookApi.main(null);
                    break;
                default:
                    break;
            }
        }
    }
}
