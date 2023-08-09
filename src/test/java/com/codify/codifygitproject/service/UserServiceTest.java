package com.codify.codifygitproject.service;

import com.codify.codifygitproject.entity.User;
import com.codify.codifygitproject.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserServiceTest {
    private static UserService userService;

    @BeforeAll
    public static void beforeAll() {
        UserServiceTest.userService = new UserServiceImpl();
    }
    @Test
    public void testAddUser_OK() {
        User testUser = new User();
        testUser
                .setEmail("test@gmail.com")
                .setLogin("test")
                .setPassword("test");

        try {
            testUser = UserServiceTest.userService.addUser(testUser);

            Assertions.assertNotNull(testUser.getId());
            Assertions.assertEquals("test", testUser.getLogin());
            Assertions.assertEquals("test", testUser.getPassword());
            Assertions.assertEquals("test@gmail.com", testUser.getEmail());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}