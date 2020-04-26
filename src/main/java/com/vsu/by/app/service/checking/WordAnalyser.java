package com.vsu.by.app.service.checking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WordAnalyser {

    private static final double MIN_SIMILARITY_LEVEL = 0.5;

    private static final int MAX_CHECKING_WORDS = 2;

    public Words isSimilarWords(final String original, final String word) {
        double similarity = similarityLevel(original, word);
        if (Objects.equals(1.0, similarity)) {
            return Words.SAME;
        } else if (similarity >= MIN_SIMILARITY_LEVEL) {
            return Words.WITH_ERRORS;
        } else {
            return Words.DIFFERENT;
        }
    }

    public int firstSimilarWord(final List<String> words, final String findMe, int start) {
        if (start < words.size()) {
            int index = start;
            while (index < words.size() && index - start < MAX_CHECKING_WORDS) {
                if (!Objects.equals(Words.DIFFERENT,
                        this.isSimilarWords(words.get(index), findMe))) {
                    return index;
                }
                ++index;
            }
        }
        return -1;
    }

    /**TODO*/
    private double similarityLevel(final String orig, final String word) {
        int wordLength = Math.min(orig.length(), word.length());
        double difference = Math.abs(orig.length() - word.length());
        for (int i = 0; i < wordLength; ++i) {
            if (!Objects.equals(orig.charAt(i), word.charAt(i))) {
                ++difference;
            }
        }
        return 1 - difference / orig.length();
    }
}
