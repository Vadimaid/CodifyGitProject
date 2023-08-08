package com.codify.codifygitproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Codify3ServiceTest {
    //private static Codify3Service codify3Service;
    @Test
    public void searchFound() {
        Codify3Service codify3Service = new Codify3Service();

        String[] array = new String[2];
        array[0] = "first";
        array[1] = "second";
        String element = "first";
        assert codify3Service.search(array, element);
    }

    @Test
    public void searchNotFound() {
        Codify3Service codify3Service = new Codify3Service();

        String[] array = new String[2];
        array[0] = "first";
        array[1] = "second";
        String element = "first2";
        assert codify3Service.search(array, element);
    }

    @Test
    public void sort() {
        Codify3Service codify3Service = new Codify3Service();

        String[] array = new String[2];
        array[0] = "first";
        array[1] = "second";
        Assertions.assertArrayEquals(array, codify3Service.sort(array));
    }
}