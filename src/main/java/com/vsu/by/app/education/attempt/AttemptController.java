package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptMapper;
import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.task.TaskService;
import com.vsu.by.app.education.task.dto.TaskMapper;
import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import com.vsu.by.app.people.pupils.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("attempts")
public class AttemptController {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;
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
    public String getAttempts(Model model) {
        List<Attempt> sortedAttempts = this.attemptService.findAll(Sort.by("pupil"));
        model.addAttribute("attempts",
                this.attemptMapper.toAttemptInfoDto(sortedAttempts));
        return "Attempts list";
    }

    @GetMapping("/{id}")
    public String getAttempt(@PathVariable("id") Long id, Model model) {
        Optional<Attempt> attempt = this.attemptService.getById(id);
        if (attempt.isPresent()) {
            model.addAttribute("attempt",
                    this.attemptMapper.toAttemptDetailDto(attempt.get()));
            return "Attempt detail";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такой попытки не существует");
        }
    }

    @GetMapping("/start")
    public String getStartAttempt(Model model) {
        model.addAttribute("tasks",
                this.taskMapper.toTaskInfoDto(this.taskService.findAll()));
        model.addAttribute("groups",
                this.groupMapper.toGroupInfoDto(this.groupService.findAll()));
        return "Attempt init information";
    }

    @PostMapping("/start")
    public String startAttempt(@RequestBody AttemptDetailDto attemptDetailDto) {
        this.attemptService.saveAttempt(
                this.attemptMapper.fromAttemptDetailDto(attemptDetailDto));
        return "Attempt added";
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
