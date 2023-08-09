package com.codify.codifygitproject.service;

import com.codify.codifygitproject.entity.User;
import com.codify.codifygitproject.exception.InvalidEmailException;
import com.codify.codifygitproject.exception.IvalidCredentialsException;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);

    User addUser(User user) throws IvalidCredentialsException, InvalidEmailException;
}
