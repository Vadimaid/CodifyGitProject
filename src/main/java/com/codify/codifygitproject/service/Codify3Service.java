package com.codify.codifygitproject.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Codify3Service {
    private String[] array = new String[2];

    public Codify3Service() {
        array[0] = "first";
        array[1] = "second";
    }


    public void search(String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("found");
                return;
            }
        }
        System.out.println("not found");
    }

    public void sort() {
        Arrays.sort(array);
        System.out.println("array sorted");
    }
}
