package org.example.service;

import org.example.domain.dto.UserDto;
import org.example.domain.entity.User;
import org.example.domain.request.UserCreateRequest;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserCreateRequest request);

    UserDto findUserById(Long id);

    UserDto findUserByPin(String pin);

    List<UserDto> getAllUsers();

    List<UserDto> findUsersByNameOrSurname(String key);

    void deleteUserById(Long id);

    void deleteUserByPin(String pin);

    UserDto selectBook(String pin, String isbn);
}
