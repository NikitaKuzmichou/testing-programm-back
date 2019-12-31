package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.attempt.dto.AttemptMapper;
import com.vsu.by.app.education.task.TaskService;
import com.vsu.by.app.education.task.dto.TaskInfoDto;
import com.vsu.by.app.education.task.dto.TaskMapper;
import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("attempts")
public class AttemptController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private AttemptService attemptService;
    @Autowired
    private AttemptMapper attemptMapper;

    @GetMapping
    public ResponseEntity<List<AttemptInfoDto>> getAttempts() {
        List<Attempt> attempts = this.attemptService.findAll();
        return new ResponseEntity<>(
                this.attemptMapper.toAttemptInfoDto(attempts),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttemptDetailDto> getAttempt(@PathVariable("id") Long id, Model model) {
        Optional<Attempt> attempt = this.attemptService.getById(id);
        if (attempt.isPresent()) {
            return new ResponseEntity<>(
                    this.attemptMapper.toAttemptDetailDto(attempt.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такой попытки не существует");
        }
    }

    @GetMapping("/start")
    /**TODO*/
    public ResponseEntity<Map<List<TaskInfoDto>, List<GroupInfoDto>>> getStartAttempt() {
        Map<List<TaskInfoDto>, List<GroupInfoDto>> resp = new LinkedHashMap<>();
        List<TaskInfoDto> tasks = this.taskMapper.toTaskInfoDto(this.taskService.findAll());
        List<GroupInfoDto> groups = this.groupMapper.toGroupInfoDto(this.groupService.findAll());
        resp.put(tasks, groups);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> startAttempt(@RequestBody AttemptDetailDto attemptDetailDto) {
        this.attemptService.saveAttempt(
                this.attemptMapper.fromAttemptDetailDto(attemptDetailDto));
        return new ResponseEntity<>("Attempt added", HttpStatus.OK);
    }

    /**TODO DIPLOM
    @PostMapping("/update/{id}")
    public String updateAttempt(@PathVariable("id") Long id,
                                @) {
        Optional<Attempt> attempt = this.attemptService.getById(id);
        if (attempt.isPresent()) {
            this
        } else {
            throw new NoSuchElementException("Такого задания не существует");
        }
    }

     @GetMapping("/delete/{id}")
     public String deleteAttempt() {

     }
     */
}
