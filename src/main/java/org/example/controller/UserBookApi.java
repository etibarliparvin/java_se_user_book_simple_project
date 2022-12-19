package org.example.controller;

import org.example.util.InputUtil;

public class UserBookApi {
    public static void main(String[] args) {
        while (true) {
            int menu = InputUtil.requireNumber(
                    "1.Go to user controller" +
                            "\n2.Go to book controller" +
                            "\n3.Exit from system" +
                            "\n---------------------------------------------------------------------------");
            switch (menu) {
                case 1:
                    UserController.main(null);
                    break;
                case 2:
                    BookController.main(null);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
