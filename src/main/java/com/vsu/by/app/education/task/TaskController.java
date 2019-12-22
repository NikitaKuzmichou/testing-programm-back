package com.vsu.by.app.education.task;

import com.vsu.by.app.education.task.dto.TaskAddEditDto;
import com.vsu.by.app.education.task.dto.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
@Transactional
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper mapper;

    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks",
                this.mapper.toTaskInfoDto(this.taskService.findAll()));
        return "All tasks";
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        Optional<Task> task = this.taskService.getTask(id);
        if (task.isPresent()) {
            model.addAttribute("task",
                    this.mapper.toTaskDetailDto(task.get()));
            return "Task by id";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого задания не существует");
        }
    }

    @PostMapping("/add")/**TODO OR NOT????*/
    public String addTask(@RequestBody TaskAddEditDto taskAddEditDto,
                          Model model) {
        Task saved = this.taskService.saveTask(this.mapper.fromTaskAddEditDto(taskAddEditDto));
        model.addAttribute("task", this.mapper.toTaskAddEditDto(saved));
        return "Saved";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return "redirect:/tasks/";
    }
}
