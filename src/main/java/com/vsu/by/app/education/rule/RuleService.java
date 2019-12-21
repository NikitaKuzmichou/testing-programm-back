package com.vsu.by.app.education.rule;

import com.vsu.by.app.jpa.model.attempt.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @Transactional(readOnly = true)
    public Optional<Rule> getRule(final String name) {
        return this.ruleRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Optional<Rule> getRule(final Long id) {
        return this.ruleRepository.findById(id);
    }

    @Transactional
    public Rule updateRule(final Rule rule) {
        return this.ruleRepository.save(rule);
    }

    @Transactional
    public Rule saveRule(final Rule rule) {
        return this.ruleRepository.save(rule);
    }

    @Transactional
    public void deleteRule(final Long id) {
        this.ruleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Rule> findAll() {
        return this.ruleRepository.findAll();
    }
}
