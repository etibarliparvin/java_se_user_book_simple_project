package org.example.service.impl;

import org.example.domain.dto.UserDto;
import org.example.domain.entity.Book;
import org.example.domain.entity.User;
import org.example.domain.request.UserCreateRequest;
import org.example.mapper.UserMapper;
import org.example.respository.BookRepository;
import org.example.respository.UserRepository;
import org.example.respository.impl.BookRepositoryImpl;
import org.example.respository.impl.UserRepositoryImpl;
import org.example.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository repository = new UserRepositoryImpl();
    private final BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public UserDto saveUser(UserCreateRequest request) {
        User user = UserMapper.toUserEntity(request);
        repository.saveUser(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto findUserById(Long id) {
        return UserMapper.toUserDto(repository.findUserById(id));
    }

    @Override
    public UserDto findUserByPin(String pin) {
        return UserMapper.toUserDto(repository.findUserByPin(pin));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.toUserDto(repository.getAllUsers());
    }

    @Override
    public List<UserDto> findUsersByNameOrSurname(String key) {
        return UserMapper.toUserDto(repository.findUsersByNameOrSurname(key));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteUserById(id);
    }

    @Override
    public void deleteUserByPin(String pin) {
        repository.deleteUserByPin(pin);
    }

    @Override
    public UserDto selectBook(String pin, String isbn) {
        User user = repository.findUserByPin(pin);
        List<User> users = repository.getAllUsers();
        users.remove(user);
        repository.saveUser(users);
        Book book = bookRepository.findBookByIsbn(isbn);
        if (book.getCountInStock() > 0 && !user.getBooks().contains(book)) {
            book.subtractCount();
            user.addBook(book);
        }
        users.add(user);
        repository.saveUser(users);
        return UserMapper.toUserDto(user);
    }
}
