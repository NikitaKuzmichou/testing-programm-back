package com.vsu.by.app.education.task;

import com.vsu.by.app.education.tasktype.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Transactional(readOnly = true)
    public Optional<Task> getTask(final Long id) {
        return this.taskRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Task getTask(final String name) {
        return this.taskRepository.findByName(name);
    }

    @Transactional
    public Task saveTask(final Task task) {
       return this.taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(final Task task) {
        return this.taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(final Long id) {
        Optional<Task> task = this.getTask(id);
        if (task.isPresent()) {
            this.taskTypeRepository.delete(task.get().getType());
            this.taskRepository.delete(task.get());
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого задания не существует");
        }
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> findAllBySubjectAndTaskType(final Long subjectId, final Long taskTypeId) {
        List<Task> tasks = new LinkedList<>();
        for(Task task : this.findAll()) {
            if (Objects.equals(task.getInfo().getSubject().getId(), subjectId) &&
                    Objects.equals(task.getType().getId(), taskTypeId)) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
