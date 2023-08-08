package com.codify.codifygitproject.service;

import com.codify.codifygitproject.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
}
