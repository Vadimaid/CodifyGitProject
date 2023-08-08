package com.codify.codifygitproject.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Cody5ControllerTest {
    @Autowired
    public  Cody5Controller controller;
    @Test
    void testGetHello_OK() {
        String name = "Alex";
        String line = controller.getHello(name);

        Assertions.assertEquals(line, "Hello " + name);
    }

    @Test
    void testGetHello_isNull(){
        String name = null;
        String line = controller.getHello(name);

        Assertions.assertEquals(line, "Должен быть заполнен параметр");
    }

    @Test
    void testGetHello_isEmpty(){
        String name = "";
        String line = controller.getHello(name);

        Assertions.assertEquals(line, "Должен быть заполнен параметр");
    }
}