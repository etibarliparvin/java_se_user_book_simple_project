package org.example.util;

import org.example.domain.request.BookCreateRequest;

public class BookUtil {

    public static BookCreateRequest fillBookCreateRequest() {
        BookCreateRequest request = new BookCreateRequest();
        request.setName(InputUtil.requireText("Please enter name:"));
        request.setAuthor(InputUtil.requireText("Please enter author:"));
        request.setIsbn(InputUtil.requireText("Please enter isbn:"));
        request.setTotalPages(InputUtil.requireNumber("Please enter page size:"));
        request.setCountInStock(InputUtil.requireNumber("Please enter count:"));
        return request;
    }
}
