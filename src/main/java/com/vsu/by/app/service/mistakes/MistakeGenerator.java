package com.vsu.by.app.service.mistakes;

import com.vsu.by.app.education.mistake.MistakeService;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilmistake.PupilMistake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MistakeGenerator {

    @Autowired
    private MistakeService mistakeService;

    /**TODO*/
    public PupilMistake getMistake(final PupilAttempt pupilAttempt, int origWordNo,
                                   int origSymbNo, int wordNo, int symbNo) {
        PupilMistake pupilMistake = new PupilMistake();
        mistakeService.findAllByTask(pupilAttempt.getAttempt().getTask()).forEach(mistake -> {
            if (Objects.equals(mistake.getWordNo(), origWordNo)
                    && Objects.equals(mistake.getSymbolNo(), origSymbNo)) {
                pupilMistake.setMistake(mistake);
                return;
            }
        });
        return this.setMistakeInfo(pupilMistake, pupilAttempt, wordNo, symbNo);
    }

    public PupilMistake getWordMistake(final PupilAttempt pupilAttempt, int origWordNo, int wordNo) {
        PupilMistake pupilMistake = new PupilMistake();
        mistakeService.findAllByTask(pupilAttempt.getAttempt().getTask()).forEach(mistake -> {
            if (Objects.equals(mistake.getWordNo(), origWordNo)
                    && Objects.equals(mistake.getSymbolNo(), -1)) {
                pupilMistake.setMistake(mistake);
                return;
            }
        });
        return this.setMistakeInfo(pupilMistake, pupilAttempt, wordNo, -1);
    }

    private PupilMistake setMistakeInfo(PupilMistake pupilMistake, PupilAttempt pupilAttempt,
                                int wordNo, int symbNo) {
        pupilMistake.setPupilAttempt(pupilAttempt);
        pupilMistake.setSymbolNo(symbNo);
        pupilMistake.setWordNo(wordNo);
        return pupilMistake;
    }
}
