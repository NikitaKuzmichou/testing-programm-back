package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class PupilAttemptService {

    @Autowired
    private PupilAttemptRepository pupilAttemptRepository;

    @Transactional(readOnly = true)
    public Optional<PupilAttempt> getPupilAttempt(final Long id) {
        return this.pupilAttemptRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public PupilAttempt getByAttemptAndByPupil(final Long attemptId, final Pupil pupil) {
        List<PupilAttempt> pupilAttempts = this.findAllByPupil(pupil);
        for (PupilAttempt pupilAttempt : pupilAttempts) {
            if (Objects.equals(attemptId, pupilAttempt.getAttempt().getId())) {
                return pupilAttempt;
            }
        }
        return null;
    }

    @Transactional
    public PupilAttempt savePupilAttempt(final PupilAttempt pupilAttempt) {
        return this.pupilAttemptRepository.save(pupilAttempt);
    }

    @Transactional
    public PupilAttempt updatePupilAttempt(final PupilAttempt pupilAttempt) {
        return this.savePupilAttempt(pupilAttempt);
    }

    public void delete(final Long id) {
        this.pupilAttemptRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PupilAttempt> findAll() {
        return this.pupilAttemptRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PupilAttempt> findAllByPupil(final Pupil pupil) {
        return this.pupilAttemptRepository.findAllByPupil(pupil);
    }
}

