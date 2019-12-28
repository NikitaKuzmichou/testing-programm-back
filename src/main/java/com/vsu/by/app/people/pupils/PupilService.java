package com.vsu.by.app.people.pupils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PupilService {

    @Autowired
    private PupilRepository pupilRepository;

    @Transactional(readOnly = true)
    public Optional<Pupil> getPupil(Long id) {
        return this.pupilRepository.findById(id);
    }

    @Transactional
    public Pupil savePupil(Pupil pupil) {
        return this.pupilRepository.save(pupil);
    }

    @Transactional
    public Pupil updatePupil(Pupil pupil) {
        return this.pupilRepository.save(pupil);
    }

    @Transactional
    public void deletePupil(Long id) {
        Optional<Pupil> pupil = this.getPupil(id);
        if (pupil.isPresent()) {
            this.pupilRepository.deleteById(id);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<Pupil> findAll() {
        return this.pupilRepository.findAll();
    }
}
