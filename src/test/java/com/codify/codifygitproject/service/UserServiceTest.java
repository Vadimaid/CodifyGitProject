package com.codify.codifygitproject.service;

import com.codify.codifygitproject.entity.User;
import com.codify.codifygitproject.exception.InvalidEmailException;
import com.codify.codifygitproject.exception.IvalidCredentialsException;
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

    @Test
    public void testAddUser_UserParameterIsNull() {
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> userService.addUser(null)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Добавляемый пользователь не может быть null!")
        );
    }

    @Test
    public void testAddUser_LoginIsNull() {
        User testUser = new User();
        testUser
                .setEmail("test@gmail.com")
                .setLogin(null)
                .setPassword("test");

        Exception exception = Assertions.assertThrows(
                IvalidCredentialsException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Логин пользователя не может быть null или пустым!")
        );
    }

    @Test
    public void testAddUser_LoginIsEmpty() {
        User testUser = new User();
        testUser
                .setEmail("test@gmail.com")
                .setLogin("")
                .setPassword("test");

        Exception exception = Assertions.assertThrows(
                IvalidCredentialsException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Логин пользователя не может быть null или пустым!")
        );
    }

    @Test
    public void testAddUser_PasswordIsNull() {
        User testUser = new User();
        testUser
                .setEmail("test@gmail.com")
                .setLogin("test")
                .setPassword(null);

        Exception exception = Assertions.assertThrows(
                IvalidCredentialsException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Пароль пользователя не может быть null или пустым!")
        );
    }

    @Test
    public void testAddUser_PasswordIsEmpty() {
        User testUser = new User();
        testUser
                .setEmail("test@gmail.com")
                .setLogin("test")
                .setPassword("");

        Exception exception = Assertions.assertThrows(
                IvalidCredentialsException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Пароль пользователя не может быть null или пустым!")
        );
    }

    @Test
    public void testAddUser_EmailIsNull() {
        User testUser = new User();
        testUser
                .setEmail(null)
                .setLogin("test")
                .setPassword("test");

        Exception exception = Assertions.assertThrows(
                InvalidEmailException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Почтовый адрес пользователя не может быть null или пустым!")
        );
    }

    @Test
    public void testAddUser_EmailIsEmpty() {
        User testUser = new User();
        testUser
                .setEmail("")
                .setLogin("test")
                .setPassword("test");

        Exception exception = Assertions.assertThrows(
                InvalidEmailException.class,
                () -> userService.addUser(testUser)
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Почтовый адрес пользователя не может быть null или пустым!")
        );
    }
}