package com.vsu.by.app.education.task;

import com.vsu.by.app.education.task.dto.*;
import com.vsu.by.app.people.teacher.Teacher;
import com.vsu.by.app.people.teacher.TeacherService;
import com.vsu.by.app.service.text.TextProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TextProcessing textProcessing;

    @GetMapping
    public ResponseEntity<List<TaskMinInfoDto>> getTasks() {
        return new ResponseEntity<>(
                this.taskMapper.toTaskMinInfoDto(this.taskService.findAll()),
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

    @GetMapping("/{subjectId}/{taskTypeId}")
    public ResponseEntity<List<TaskInfoDto>> getTaskBySubjectAndType(@PathVariable("subjectId") Long subjectId,
                                                                     @PathVariable("taskTypeId") Long taskTypeId) {
        List<Task> tasks = this.taskService.findAllBySubjectAndTaskType(subjectId, taskTypeId);
        return new ResponseEntity<>(this.taskMapper.toTaskInfoDto(tasks), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDetailDto> addTask(@RequestBody TaskDetailDto taskDetailDto) {
        Task task = this.taskMapper.fromTaskDetailDto(taskDetailDto);
        task.setTaskText(this.textProcessing.processText(task.getTaskText()));
        task = this.taskService.saveTask(this.taskMapper.fromTaskDetailDto(taskDetailDto));
        return new ResponseEntity<>(
                this.taskMapper.toTaskDetailDto(task),
                HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<TaskDetailDto> updateTask(@RequestBody TaskDetailDto taskDetailDto) {
        Task fromClient = this.taskMapper.fromTaskDetailDto(taskDetailDto);
        Teacher teacher = this.teacherService.getTeacher(fromClient.getInfo().getTeacher().getId()).get();
        fromClient.getInfo().setTeacher(teacher);
        return new ResponseEntity<>(
                this.taskMapper.toTaskDetailDto(this.taskService.updateTask(fromClient)),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return new ResponseEntity<>("redirect:/tasks/", HttpStatus.ACCEPTED);
    }
}
