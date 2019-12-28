package com.vsu.by.app.education.tasktype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
    TaskType findByName(String name);
}
