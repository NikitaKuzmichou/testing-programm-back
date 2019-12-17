package com.vsu.by.app.task;

import com.vsu.by.app.task.dto.TaskAddEditDto;
import com.vsu.by.app.task.dto.TaskDetailDto;
import com.vsu.by.app.task.dto.TaskInfoDto;
import com.vsu.by.app.task.dto.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper mapper;

    @GetMapping
    public ResponseEntity<List<TaskInfoDto>> getTasks() {
        return new ResponseEntity<>(
                this.mapper.toTaskInfoDto(this.taskService.findAll()),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDetailDto> getTask(@PathVariable("id") Long id) {
        Optional<Task> task = this.taskService.getTask(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(
                    this.mapper.toTaskDetailDto(task.get()),
                    new HttpHeaders(),
                    HttpStatus.OK);
        } else {
            /**TODO*/
            throw new NoSuchElementException("Такого задания не существует");
        }
    }

    @PostMapping/**TODO*/
    public ResponseEntity<String> addTask(@RequestBody TaskAddEditDto taskAddEditDto) {
        Task saved = this.taskService.saveTask(this.mapper.fromTaskAddEditDto(taskAddEditDto));
        return new ResponseEntity<>(
                saved.getId().toString(),
                new HttpHeaders(),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return new ResponseEntity<>("Deleted", new HttpHeaders(), HttpStatus.ACCEPTED);
    }
}
