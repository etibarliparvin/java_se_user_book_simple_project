package org.example.respository;

import org.example.domain.entity.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    void saveUser(List<User> users);

    User findUserById(Long id);

    User findUserByPin(String pin);

    List<User> getAllUsers();

    List<User> findUsersByNameOrSurname(String key);

    void deleteUserById(Long id);

    void deleteUserByPin(String pin);
}
