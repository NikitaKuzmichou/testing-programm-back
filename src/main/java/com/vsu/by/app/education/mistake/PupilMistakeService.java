package com.vsu.by.app.education.mistake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PupilMistakeService {

    @Autowired
    private PupilMistakeRepository pupilMistakeRepository;

    @Transactional(readOnly = true)
    public Optional<PupilMistake> getMistake(final Long id) {
        return this.pupilMistakeRepository.findById(id);
    }

    @Transactional
    public PupilMistake saveMistake(final PupilMistake error) {
       return this.pupilMistakeRepository.save(error);
    }

    @Transactional
    public void deleteMistake(final Long id) {
        this.pupilMistakeRepository.deleteById(id);
    }

    @Transactional
    public PupilMistake updateMistake(final PupilMistake error) {
        return this.pupilMistakeRepository.save(error);
    }

    @Transactional(readOnly = true)
    public List<PupilMistake> findAll() {
        return this.pupilMistakeRepository.findAll();
    }
}
