package com.vsu.by.app.people.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional(readOnly = true)
    public Optional<Teacher> getTeacher(Long id) {
        return this.teacherRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Teacher getTeacher(String login) {
        return this.teacherRepository.findByLogin(login);
    }

    @Transactional
    public Teacher saveTeacher(Teacher user) {
        return this.teacherRepository.save(user);
    }

    @Transactional
    public Teacher updateTeacher(Teacher user) {
        return this.teacherRepository.save(user);
    }

    @Transactional
    public void deleteTeacher(Long id) {
        this.teacherRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }
}
