package com.vsu.by.app.education.rule;

import com.vsu.by.app.jpa.model.attempt.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
    Optional<Rule> findByName(String name);
}
