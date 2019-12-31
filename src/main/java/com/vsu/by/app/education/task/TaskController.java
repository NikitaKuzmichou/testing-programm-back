package com.vsu.by.app.education.task;

import com.vsu.by.app.education.task.dto.TaskAddEditDto;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
import com.vsu.by.app.education.task.dto.TaskInfoDto;
import com.vsu.by.app.education.task.dto.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
@Transactional
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskInfoDto>> getTasks() {
        return new ResponseEntity<>(
                this.taskMapper.toTaskInfoDto(this.taskService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDetailDto> getTask(@PathVariable("id") Long id) {
        Optional<Task> task = this.taskService.getTask(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(
                    this.taskMapper.toTaskDetailDto(task.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого задания не существует");
        }
    }

    @PostMapping/**TODO OR NOT????*/
    public ResponseEntity<TaskAddEditDto> addTask(@RequestBody TaskAddEditDto taskAddEditDto) {
        Task saved = this.taskService.saveTask(this.taskMapper.fromTaskAddEditDto(taskAddEditDto));
        return new ResponseEntity<>(
                this.taskMapper.toTaskAddEditDto(saved),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return new ResponseEntity<>("redirect:/tasks/", HttpStatus.ACCEPTED);
    }
}
