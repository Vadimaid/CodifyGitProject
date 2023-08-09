package com.codify.codifygitproject.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Cody5ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetHello_isOk() {
        try {
            String name = "Alex";

            URI uri = new URI("http://localhost:" + port + "/codify_5/setName?name=" + name);
            ResponseEntity<String> response = this.restTemplate.getForEntity(uri.toString(), String.class);
            Assertions.assertEquals(response.getBody(), "Hello " + name);
            Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        } catch (Exception ex) {
            Assertions.fail(ex);
        }
    }

    @Test
    public void testGetHello_isFailForNull() {
        try {
            URI uri = new URI("http://localhost:" + port + "/codify_5/setName");
            ResponseEntity<String> response = this.restTemplate.getForEntity(uri.toString(), String.class);
            Assertions.assertEquals(response.getBody(), "Параметр <name> не должен быть null");
            Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            Assertions.fail(ex);
        }
    }

    @Test
    public void testGetHello_isFailForEmpty() {
        try {
            URI uri = new URI("http://localhost:" + port + "/codify_5/setName?name=");
            ResponseEntity<String> response = this.restTemplate.getForEntity(uri.toString(), String.class);
            System.out.println(response.getBody());
            Assertions.assertEquals(response.getBody(), "Параметр <name> не должен быть пустым");
            Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            Assertions.fail(ex);
        }
    }

    @Test
    public void testGetHello_isFailForOnlySpaces() {
        try {
            String uriLine = "http://localhost:" + port + "/codify_5/setName?name=    ";
            ResponseEntity<String> response = this.restTemplate.getForEntity(uriLine, String.class);
            System.out.println(response.getBody());
            Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
            Assertions.assertEquals(response.getBody(), "Параметр <name> не должен содержать только пробелы!");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Assertions.fail(ex);
        }
    }


}