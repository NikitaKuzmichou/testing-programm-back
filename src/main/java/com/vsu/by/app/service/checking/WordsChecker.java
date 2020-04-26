package com.vsu.by.app.service.checking;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.service.mistakes.MistakeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class WordsChecker {

    @Autowired
    private MistakeGenerator mistakeGenerator;

    List<PupilMistake> checkWord(final String orig, int origWordNo,
                                 final String word, int wordNo, final PupilAttempt pupilAttempt) {
        /**TODO different length*/
        /**TODO different mistakes*/
        List<PupilMistake> pupilMistakes = new LinkedList<>();
        int origI = 0;
        int wordI = 0;
        while (origI < orig.length() || wordI < word.length()) {
            if (origI == orig.length()) {
                --origI;
            }
            if (wordI == word.length()) {
                --wordI;
            }
            if (!Objects.equals(orig.charAt(origI), word.charAt(wordI))) {
                if (this.isUnnecessarySymbol(orig, word, origI, wordI)) {
                    pupilMistakes.add(this.mistakeGenerator.getMistake(
                            pupilAttempt, origWordNo, origI, wordNo, wordI));
                    ++wordI;
                } else if (this.isSkippedSymbol(orig, word, origI, wordI)) {
                    pupilMistakes.add(this.mistakeGenerator.getMistake(
                            pupilAttempt, origWordNo, origI, wordNo, wordI));
                    ++origI;
                } else {
                    pupilMistakes.add(this.mistakeGenerator.getMistake(
                            pupilAttempt, origWordNo, origI, wordNo, wordI));
                }
            }
            ++origI;
            ++wordI;
        }
        return pupilMistakes;
    }

    private boolean isUnnecessarySymbol(String orig, String word, int origI, int wordI) {
        if (Objects.equals(word.length(), wordI + 1)) {
            return false;
        } else {
            return Objects.equals(orig.charAt(origI), word.charAt(wordI + 1));
        }
    }

    private boolean isSkippedSymbol(String orig, String word, int origI, int wordI) {
        if (Objects.equals(orig.length(), origI + 1)) {
            return false;
        } else {
            return Objects.equals(orig.charAt(origI + 1), word.charAt(wordI));
        }
    }
}
