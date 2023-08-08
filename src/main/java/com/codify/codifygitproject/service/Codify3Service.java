package com.codify.codifygitproject.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Codify3Service {

    public Boolean search(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("found");
                return true;
            }
        }
        System.out.println("not found");
        return false;
    }

    public String[] sort(String[] array) {
        Arrays.sort(array);
        System.out.println("array sorted");
        return array;
    }
}
