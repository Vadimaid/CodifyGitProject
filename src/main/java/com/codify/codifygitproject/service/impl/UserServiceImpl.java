package com.codify.codifygitproject.service.impl;

import com.codify.codifygitproject.entity.User;
import com.codify.codifygitproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
}
