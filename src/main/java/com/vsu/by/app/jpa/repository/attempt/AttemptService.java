package com.vsu.by.app.jpa.repository.attempt;

import com.vsu.by.app.jpa.model.attempt.Attempt;
import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Transactional(readOnly = true)
    public Optional<Attempt> getAttempt(final Long id) {
        return this.attemptRepository.findById(id);
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
    public List<Attempt> allByStart(final Date start) {
        return this.attemptRepository.findAllByStart(start);
    }

    @Transactional(readOnly = true)
    public List<Attempt> allByEnd(final Date end) {
        return this.attemptRepository.findAllByEnd(end);
    }

    @Transactional(readOnly = true)
    public List<Attempt> allByMark(final Byte mark) {
        return this.attemptRepository.findAllByMark(mark);
    }
}
