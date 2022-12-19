package org.example.util;

import org.example.domain.request.UserCreateRequest;

public class UserUtil {

    public static UserCreateRequest fillUserCreateRequest() {
        UserCreateRequest request = new UserCreateRequest();
        request.setName(InputUtil.requireText("Please insert name:"));
        request.setSurname(InputUtil.requireText("Please insert surname:"));
        request.setEmail(InputUtil.requireText("Please insert email:"));
        request.setPassword(InputUtil.requireText("Please insert password:"));
        request.setPin(InputUtil.requireText("Please insert pin:"));
        request.setAge(InputUtil.requireNumber("Please insert age:"));
        return request;
    }
}
