package com.vsu.by.app.service.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class TextProcessing {

    @Autowired
    private SpacesProcessing spaces;

    public static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static final String NUMBERS = "1234567890";

    public static final String SHOULD_SKIP = "-—";

    public String processText(final String str) {
        String withoutExcessSpaces = this.spaces.deleteExcessSpaces(str, 1);
        StringBuilder sb = new StringBuilder(withoutExcessSpaces);
        for (int i = 0; i < sb.length() - 1; ++i) {
            if (Objects.equals(' ', sb.charAt(i))
                    && !this.isLetter(sb.charAt(i + 1))
                    && !this.isNumber(sb.charAt(i + 1))
                    && !this.isSkip(sb.charAt(i + 1))) {
                sb.delete(i, i + 1);
            }
        }
        return sb.toString();
    }

    public List<String> getListWords(final String str) {
        if (Objects.equals(null, str)) {
            return null;
        }
        List<String> words = new LinkedList<>();
        for (String word : str.split(" ")) {
            words.add(word);
        }
        /*for (int i = 0; i < str.length() && i != -1; ++i) {
            i = this.spaces.getFirstNonSpace(str, i);
            if (i != -1) {
                int wordEnd = this.spaces.getFirstSpace(str, i);
                String word = str.substring(i, wordEnd > -1 ? wordEnd : str.length());
                words.add(word);
                i = wordEnd - 1;
            }
        }
         */
        return words;
    }

    private boolean isLetter(char symbol) {
        char lowerSymbol = Character.toLowerCase(symbol);
        return RUSSIAN_ALPHABET.indexOf(lowerSymbol) != -1;
    }

    private boolean isNumber(char symbol) {
        return NUMBERS.indexOf(symbol) != -1;
    }

    private boolean isSkip(char symbol) {
        return SHOULD_SKIP.indexOf(symbol) != -1;
    }
}
