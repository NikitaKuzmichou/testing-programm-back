package com.vsu.by.app.people.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(String login) {
        return this.userRepository.findByLogin(login);
    }

    @Transactional
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
