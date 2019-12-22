package com.vsu.by.app.education.attempt;

import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Transactional(readOnly = true)
    public Optional<Attempt> getByIdAndByPupil(final Long id) {
        return this.attemptRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Attempt> getByIdAndByPupil(final Long id, final Pupil pupil) {
        this.attemptRepository.findByIdAndByPupil(id, pupil);
    }

    @Transactional
    public Attempt saveAttempt(final Attempt attempt) {
        return this.attemptRepository.save(attempt);
    }

    @Transactional
    public Attempt updateAttempt(final Attempt attempt) {
        return this.attemptRepository.save(attempt);
    }

    @Transactional
    public void deleteAttempt(final Long id) {
        this.attemptRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllByPupil(final Pupil pupil) {
        this.attemptRepository.deleteAllByPupil(pupil);
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAll() {
        return this.attemptRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAll(Sort sort) {
        return this.attemptRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAllByPupil(final Pupil pupil) {
        return this.attemptRepository.findAllByPupil(pupil);
        /*List<Attempt> attempts = this.findAll();
        List<Attempt> pupilAttempts = new LinkedList<>();
        for (Attempt attempt : attempts) {
            if (Objects.equals(attempt.getPupil().getUser().getId(), pupil.getUser().getId())) {
                pupilAttempts.add(attempt);
            }
        }
        return pupilAttempts;
         */
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAllByStart(final Date start) {
        return this.attemptRepository.findAllByStart(start);
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAllByEnd(final Date end) {
        return this.attemptRepository.findAllByEnd(end);
    }

    @Transactional(readOnly = true)
    public List<Attempt> findAllByMark(final Byte mark) {
        return this.attemptRepository.findAllByMark(mark);
    }
}