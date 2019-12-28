package com.vsu.by.app.education.mistake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MistakeService {

    @Autowired
    private MistakeRepository mistakeRepository;

    @Transactional(readOnly = true)
    public Optional<Mistake> getMistake(final Long id) {
        return this.mistakeRepository.findById(id);
    }

    @Transactional
    public Mistake saveMistake(final Mistake error) {
       return this.mistakeRepository.save(error);
    }

    @Transactional
    public void deleteMistake(final Long id) {
        this.mistakeRepository.deleteById(id);
    }

    @Transactional
    public Mistake updateMistake(final Mistake error) {
        return this.mistakeRepository.save(error);
    }

    @Transactional(readOnly = true)
    public List<Mistake> findAll() {
        return this.mistakeRepository.findAll();
    }
}
