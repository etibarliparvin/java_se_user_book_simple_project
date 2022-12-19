package org.example.respository.impl;

import org.example.domain.entity.User;
import org.example.respository.UserRepository;
import org.example.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void saveUser(User user) {
        List<User> users = FileUtil.readUserFromFile() != null ? FileUtil.readUserFromFile() : new ArrayList<>();
        users.add(user);
        FileUtil.writeUserToFile(users);
    }

    @Override
    public void saveUser(List<User> users) {
        FileUtil.writeUserToFile(users);
    }

    @Override
    public User findUserById(Long id) {
        List<User> list = FileUtil.readUserFromFile();
        if (id < 0 || id > list.size()) return null;
        if (list != null && !list.isEmpty()) {
            User user = list.get((int) (id - 1));
            if (user.getEnable()) return user;
        }
        return null;
    }

    @Override
    public User findUserByPin(String pin) {
        List<User> list = FileUtil.readUserFromFile();
        if (list != null && !list.isEmpty()) {
            return list.stream()
                    .filter(a -> a.getPin().equals(pin) && a.getEnable())
                    .findFirst().get();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
//        List<User> users = FileUtil.readUserFromFile();
//        List<User> result = new ArrayList<>();
//        for(User u: users) {
//            if(u.getEnable()) {
//                result.add(u);
//            }
//        }
//        return result;
        return FileUtil.readUserFromFile().stream()
                .filter(User::getEnable)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByNameOrSurname(String key) {
        List<User> list = FileUtil.readUserFromFile();
        if (list != null && !list.isEmpty()) {
            return list.stream()
                    .filter(a -> (a.getName().contains(key) || a.getSurname().contains(key)) && a.getEnable())
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        User user = findUserById(id);
        user.setEnable(Boolean.FALSE);
        List<User> users = getAllUsers();
        users.remove((int) (id - 1));
        users.add(user);
        FileUtil.writeUserToFile(users);
    }

    @Override
    public void deleteUserByPin(String pin) {
        User user = findUserByPin(pin);
        List<User> users = getAllUsers();
        users.remove(user);
        user.setEnable(Boolean.FALSE);
        users.add(user);
        FileUtil.writeUserToFile(users);
    }
}
