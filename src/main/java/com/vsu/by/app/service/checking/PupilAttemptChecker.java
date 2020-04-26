package com.vsu.by.app.service.checking;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.education.pupilmistake.PupilMistakeService;
import com.vsu.by.app.service.mistakes.MistakeGenerator;
import com.vsu.by.app.service.text.TextProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class PupilAttemptChecker {
    @Autowired
    private PupilMistakeService pupilMistakeService;
    @Autowired
    private TextProcessing textProcessing;
    @Autowired
    private WordAnalyser wordAnalyser;
    @Autowired
    private WordsChecker wordsChecker;
    @Autowired
    private MistakeGenerator mistakeGenerator;

    public void checkPupilAttempt(PupilAttempt pupilAttempt) {
        /**todo убрать то, что текст для каждого ученика будет разбиваться на слова*/
        List<String> text = textProcessing.getListWords(pupilAttempt.getAttempt().getTask().getTaskText());
        List<String> pupil = textProcessing.getListWords(pupilAttempt.getText());
        int pupilI = 0;
        int textI = 0;
        Set<PupilMistake> mistakes = this.getKnownMistakes(pupilAttempt);
        while (pupilI < pupil.size() && textI < text.size()) {
            Words words = this.wordAnalyser.isSimilarWords(pupil.get(pupilI), text.get(textI));
            if (Objects.equals(Words.WITH_ERRORS, words)) {
                mistakes.addAll(this.wordsChecker.checkWord(
                             text.get(textI), textI, pupil.get(pupilI), pupilI, pupilAttempt));
            } else if (Objects.equals(Words.DIFFERENT, words)) {
                int wordI = this.wordAnalyser.firstSimilarWord(text, pupil.get(pupilI), textI + 1);
                if (-1 != wordI) {
                    mistakes.add(this.mistakeGenerator.getWordMistake(pupilAttempt, textI, pupilI));
                    textI = wordI;
                    continue;
                } else {
                    wordI = this.wordAnalyser.firstSimilarWord(pupil, text.get(textI), pupilI + 1);
                    mistakes.add(this.mistakeGenerator.getWordMistake(pupilAttempt, textI, pupilI));
                    if (-1 != wordI) {
                        pupilI = wordI;
                        continue;
                    }
                }
            }
            ++pupilI;
            ++textI;
        }
        if (!mistakes.isEmpty()) {
            pupilAttempt.addMistakes(mistakes);
        }
    }

    private Set<PupilMistake> getKnownMistakes(final PupilAttempt pupilAttempt) {
        Set<PupilMistake> pupilMistakes = new HashSet<>();
        this.pupilMistakeService.findAllByPupilAttemptId(pupilAttempt.getId()).forEach(
                pupilMistake -> {
                    pupilMistakes.add(pupilMistake);
                }
        );
        return pupilMistakes;
    }
}
