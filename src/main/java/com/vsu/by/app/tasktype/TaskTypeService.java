package com.vsu.by.app.tasktype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTypeService {

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Transactional(readOnly = true)
    public Optional<TaskType> getTaskType(Long id) {
        return this.taskTypeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<TaskType> getTaskType(String name) {
        return this.taskTypeRepository.findByName(name);
    }

    @Transactional
    public TaskType saveTaskType(TaskType taskType) {
        return this.taskTypeRepository.save(taskType);
    }

    @Transactional
    public TaskType updateTaskType(TaskType taskType) {
        return this.taskTypeRepository.save(taskType);
    }

    @Transactional
    public void deleteTaskType(TaskType taskType) {
        this.taskTypeRepository.delete(taskType);
    }

    @Transactional(readOnly = true)
    public List<TaskType> findAll() {
        return this.taskTypeRepository.findAll();
    }
}
