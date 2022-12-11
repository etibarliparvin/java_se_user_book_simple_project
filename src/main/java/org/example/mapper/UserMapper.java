package org.example.mapper;

import org.example.domain.dto.UserDto;
import org.example.domain.entity.User;
import org.example.domain.request.UserCreateRequest;
import org.example.respository.impl.UserRepositoryImpl;
import org.example.util.EncodeDecodeUtil;

public class UserMapper {
    private static final EncodeDecodeUtil encodeDecodeUtil = new EncodeDecodeUtil();

    public static User toUserEntity(UserCreateRequest request) {
        User user = new User();
//        user.setId((long) (UserRepositoryImpl.users.size() + 1));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(encodeDecodeUtil.encode(request.getPassword()));
        user.setPin(request.getPin());
        user.setAge(request.getAge());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(encodeDecodeUtil.decode(user.getPassword()));
        userDto.setPin(user.getPin());
        userDto.setAge(user.getAge());
        return userDto;
    }
}
