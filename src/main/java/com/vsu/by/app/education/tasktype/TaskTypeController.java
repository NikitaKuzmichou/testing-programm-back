package com.vsu.by.app.education.tasktype;


import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.task.TaskService;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import com.vsu.by.app.education.tasktype.dto.TaskTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("task-type")
@Transactional
public class TaskTypeController {
    @Autowired
    private TaskTypeService taskTypeService;
    @Autowired
    private TaskTypeMapper taskTypeMapper;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskTypeInfoDto>> getTaskTypes() {
        return new ResponseEntity<>(
                this.taskTypeMapper.toTaskTypeInfoDto(this.taskTypeService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<TaskTypeInfoDto>> getTaskTypesBySubject(@PathVariable("subjectId") Long id) {
        Set<TaskType> taskTypes = new HashSet<>();
        for (Task task : this.taskService.findAll()) {
            if (Objects.equals(id, task.getInfo().getSubject().getId())) {
                taskTypes.add(task.getType());
            }
        }
        return new ResponseEntity<>(
                this.taskTypeMapper.toTaskTypeInfoDto(new LinkedList<>(taskTypes)),
                HttpStatus.OK);
    }
}
