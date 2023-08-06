package com.codify.codifygitproject.service;

import com.codify.codifygitproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public User getUserById(Long id) {
        if (this.users.isEmpty()) {
            return null;
        }
        return this.users.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }
}
