package com.codify.codifygitproject.service.impl;

import com.codify.codifygitproject.entity.User;
import com.codify.codifygitproject.exception.InvalidEmailException;
import com.codify.codifygitproject.exception.IvalidCredentialsException;
import com.codify.codifygitproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        if (this.users.isEmpty()) {
            return null;
        }
        return this.users.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public User addUser(User user) throws IvalidCredentialsException, InvalidEmailException {
        if(Objects.isNull(user)) {
            throw new IllegalArgumentException("Добавляемый пользователь не может быть null!");
        }
        if(Objects.isNull(user.getLogin()) || user.getLogin().isEmpty()) {
            throw new IvalidCredentialsException("Логин пользователя не может быть null или пустым!");
        }
        if(Objects.isNull(user.getPassword()) || user.getPassword().isEmpty()) {
            throw new IvalidCredentialsException("Пароль пользователя не может быть null или пустым!");
        }
        if(Objects.isNull(user.getEmail()) || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("Почтовый адрес пользователя не может быть null или пустым!");
        }

        user.setId((long) this.users.size());
        this.users.add(user);
        return user;
    }
}
