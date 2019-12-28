package com.vsu.by.app.service;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class PupilAttemptChecker {

    public void checkPupilAttempt(PupilAttempt attempt) {
        String attemptTask = (String)(attempt.getAttempt().getTask().getTaskText());
        String pupilAttempt = (String)(attempt.getText());
        //for (int i = 0; i < )
        /**TODO*/
    }
}
