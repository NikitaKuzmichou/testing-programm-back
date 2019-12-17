package com.vsu.by.app.subject;

import com.vsu.by.app.subject.Subject;
import com.vsu.by.app.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional(readOnly = true)
    public Optional<Subject> getSubject(final Long id) {
        return this.subjectRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Subject> getSubject(final String name) {
        return this.subjectRepository.findByName(name);
    }

    @Transactional
    public Subject saveSubject(final Subject subject) {
       return this.subjectRepository.save(subject);
    }

    @Transactional
    public Subject updateSubject(final Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Transactional
    public void deleteSubject(final Long id) {
        this.subjectRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return this.subjectRepository.findAll();
    }
}
