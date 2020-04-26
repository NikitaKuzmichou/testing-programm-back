package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.education.rule.Rule;
import com.vsu.by.app.education.task.Task;
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

    @Transactional(readOnly = true)
    public Mistake getMistakeByRule(final Rule rule) {
        return this.mistakeRepository.findByRule(rule);
    }

    @Transactional
    public Mistake saveMistake(final Mistake mistake) {
        return this.mistakeRepository.save(mistake);
    }

    @Transactional
    public void deleteMistake(final Long id) {
        this.mistakeRepository.deleteById(id);
    }

    @Transactional
    public Mistake updateMistake(final Mistake mistake) {
        return this.mistakeRepository.save(mistake);
    }

    @Transactional(readOnly = true)
    public List<Mistake> findAllByTask(final Task task) {
        return this.mistakeRepository.findAllByTask(task);
    }

    @Transactional(readOnly = true)
    public List<Mistake> findAll() {
        return this.mistakeRepository.findAll();
    }
}
