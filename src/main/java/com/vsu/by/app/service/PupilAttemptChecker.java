package com.vsu.by.app.service;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PupilAttemptChecker {
    @Autowired
    private TextProcessing textProcessing;
    @Autowired
    private MistakeGenerator mistakeGenerator;

    /**TODO FOR DIPLOM*/
    public void checkPupilAttempt(PupilAttempt pupilAttempt) {
        String attemptTask = pupilAttempt.getAttempt().getTask().getTaskText();
        int aLength = attemptTask.length();
        this.processPupilAttemptText(pupilAttempt);
        String pupilSolution = pupilAttempt.getText();
        int pLength = pupilSolution.length();
        int maxLength = aLength - pLength > 0 ? aLength : pLength;
        for (int i = 0; i < maxLength; ++i) {
            if (!Objects.equals(attemptTask.charAt(i), pupilSolution.charAt(i))) {
                pupilAttempt.addMistake(
                        this.mistakeGenerator.getMistake(pupilAttempt, i, 0));
            }
        }
        if (!Objects.equals(aLength, pLength)) {
            pupilAttempt.addMistake(
                    this.mistakeGenerator.getDifferentLengthMistake(pupilAttempt));
        }
    }

    private void processPupilAttemptText(PupilAttempt pupilAttempt) {
        String processedText =
                this.textProcessing.deleteExcessSpaces(pupilAttempt.getText(), 1);
        pupilAttempt.setText(processedText);
    }
}
