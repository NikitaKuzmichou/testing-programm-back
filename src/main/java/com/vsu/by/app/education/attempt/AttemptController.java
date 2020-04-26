package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.attempt.dto.AttemptMapper;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.people.pupils.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("attempts")
public class AttemptController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private PupilAttemptService pupilAttemptService;
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
    public ResponseEntity<AttemptDetailDto> getAttempt(@PathVariable("id") Long id) {
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

    @PostMapping("{groupId}")
    public ResponseEntity<String> startAttempt(@RequestBody AttemptDetailDto attemptDetailDto,
                                               @PathVariable("groupId") Long groupId) {
        Attempt attempt = this.attemptMapper.fromAttemptDetailDto(attemptDetailDto);
        this.startPupilsAttempt(groupId, this.attemptService.saveAttempt(attempt));
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /**TODO*/
    private void startPupilsAttempt(Long groupId, Attempt attempt) {
        Optional<Group> group = this.groupService.getGroup(groupId);
        if (group.isPresent()) {
            for (Pupil pupil : group.get().getPupils()) {
                PupilAttempt pupilAttempt = new PupilAttempt();
                pupilAttempt.setAttempt(attempt);
                pupilAttempt.setPupil(pupil);
                this.pupilAttemptService.savePupilAttempt(pupilAttempt);
            }
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такой группы не существует");
        }
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
    */
}
