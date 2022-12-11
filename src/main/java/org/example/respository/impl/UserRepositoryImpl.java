package org.example.respository.impl;

import org.example.domain.entity.User;
import org.example.respository.UserRepository;
import org.example.util.FileUtil;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public static List<User> users = FileUtil.readUserFromFile();

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public User findUserByPin(String pin) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> findUsersByNameOrSurname(String key) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void deleteUserByPin(String pin) {

    }
}
