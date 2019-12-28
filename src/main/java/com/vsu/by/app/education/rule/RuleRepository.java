package com.vsu.by.app.education.rule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
    Rule findByName(String name);
}
