package com.codify.codifygitproject.service;

import com.codify.codifygitproject.exception.NoSuchWordException;

import java.util.Objects;

public class TextService {
    public Integer countWordsInText(String text) throws IllegalArgumentException {
        this.checkForEmpty(text);
        Integer result = text.split("\\s").length;
        if (result == 0) {
            throw new IllegalArgumentException("Текст не должен быть пустым!");
        }
        return result;

    }

    public Integer findWordInText(String word, String text) throws NoSuchWordException {
        this.checkForEmpty(text);
        Integer result = text.indexOf(word);
        if (result == -1) {
            throw new NoSuchWordException(String.format("Нет слова %s в тексте!", word));
        }
        return result;
    }

    public void checkForEmpty(String text) {
        if (text.isEmpty() || Objects.isNull(text)) {
            throw new IllegalArgumentException("Текст не должен быть пустым!");
        }
    }
}
