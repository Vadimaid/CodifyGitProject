package com.codify.codifygitproject.service;

import com.codify.codifygitproject.exception.NoSuchWordException;

import java.util.Objects;

public class TextService {
    public Integer countWordsInText(String text) {
        String textTrimmed = text.trim();
        if (text.isEmpty() || Objects.isNull(text)) {
            throw new IllegalArgumentException("Текст не должен быть пустым!");
        }
        Integer result = textTrimmed.split("\\s").length;
        return result;
    }

    public Integer findWordInText(String word, String text) throws NoSuchWordException {
        if (text.isEmpty() || Objects.isNull(text)) {
            throw new IllegalArgumentException("Текст не должен быть пустым!");
        }
        Integer result = text.indexOf(word);
        if (Objects.isNull(result)) {
            throw new NoSuchWordException(String.format("Нет слова %s в тексте!", word));
        }
        return result;
    }
}
