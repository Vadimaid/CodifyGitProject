package com.codify.codifygitproject.service;

import com.codify.codifygitproject.exception.NoSuchWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceTest {
    TextService textService = new TextService();
    String text = "Java — строго типизированный объектно-ориентированный язык";

    @Test
    void countWordsInText() {
        try {
            Integer countTest = textService.countWordsInText(text);
            assert countTest == 6;
        } catch (IllegalArgumentException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    @Test
    public void CountWordsInTextException_Test() throws IllegalArgumentException {
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> textService.countWordsInText(""));
        Assertions.assertTrue(exception.getMessage().contains("Текст не должен быть пустым!"));
    }

    @Test
    void findWordInText() {
        try {
            Integer indexOfWord = textService.findWordInText("строго", text);
            assert indexOfWord == 7;
        } catch (NoSuchWordException | IllegalArgumentException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    @Test
    public void FindWordInTextException_Test() throws IllegalArgumentException {
        Exception exception = Assertions.assertThrows(
                NoSuchWordException.class, () -> textService.findWordInText("Hello", text));
        Assertions.assertTrue(exception.getMessage().contains(String.format("Нет слова %s в тексте!", "Hello")));
    }
}