package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.rule.Rule;
import com.vsu.by.app.education.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MistakeRepository extends JpaRepository<Mistake, Long> {

    Mistake findByRule(final Rule rule);

    List<Mistake> findAllByTask(final Task task);
}
