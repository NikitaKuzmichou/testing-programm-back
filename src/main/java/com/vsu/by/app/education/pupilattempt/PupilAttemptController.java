package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMinInfoDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptViewDto;
import com.vsu.by.app.education.task.TaskService;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.service.checking.PupilAttemptChecker;
import com.vsu.by.app.service.text.TextProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("pupils-attempts")
public class PupilAttemptController {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;
    @Autowired
    private PupilAttemptChecker pupilAttemptChecker;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TextProcessing textProcessing;

    @GetMapping
    public ResponseEntity<List<PupilAttemptMinInfoDto>> getPupilsAttempts() {
        List<PupilAttempt> pupilAttempts = this.pupilAttemptService.findAll();
        return new ResponseEntity<>(
                this.pupilAttemptMapper.toPupilAttemptMinInfoDto(pupilAttempts),
                HttpStatus.OK);
    }

    @GetMapping("/{pupilId}")
    public ResponseEntity<List<PupilAttemptInfoDto>> getPupilAttemptsById(@PathVariable("pupilId") Long pupilId) {
        List<PupilAttempt> pupilAttempts = this.pupilAttemptService.findAllByPupilId(pupilId);
        return new ResponseEntity<>(
                this.pupilAttemptMapper.toPupilAttemptInfoDto(pupilAttempts),
                HttpStatus.OK);
    }

    @GetMapping("/{pupilId}/{attemptId}")
    public ResponseEntity<PupilAttemptViewDto> getPupilAttempt(@PathVariable("pupilId") Long pupilId,
                                                               @PathVariable("attemptId") Long attemptId) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            PupilAttempt pupilAttempt = this.pupilAttemptService.getByAttemptAndByPupil(attemptId, pupil.get());
            if (Objects.nonNull(pupilAttempt)) {
                return new ResponseEntity<>(
                        this.pupilAttemptMapper.toPupilAttemptViewDto(pupilAttempt),
                        HttpStatus.OK);
            } else {
                /**TODO EXCEPTION*/
                throw new NoSuchElementException("Такой попытки не существует");
            }
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    /**TODO PutMapping?*/
    @PutMapping("/{pupilId}/{attemptId}")
    public ResponseEntity<PupilAttemptInfoDto> updatePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                     @PathVariable("attemptId") Long attemptId,
                                     @RequestBody PupilAttemptInfoDto pupilAttemptDto) {
        PupilAttempt pupilAttempt =
                this.pupilAttemptMapper.fromPupilAttemptInfoDto(pupilAttemptDto);
        pupilAttempt.setText(this.textProcessing.processText(pupilAttempt.getText()));
        this.initializeNullFields(pupilAttempt);
        pupilAttempt = this.pupilAttemptService.updatePupilAttempt(pupilAttempt);
        return new ResponseEntity<>(
                this.pupilAttemptMapper.toPupilAttemptInfoDto(pupilAttempt),
                HttpStatus.ACCEPTED);
    }

    /**TODO POSSIBLE OR EVERYTHING OK*/
    @PostMapping("/{pupilId}/{attemptId}")
    public ResponseEntity<PupilAttemptInfoDto> savePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                   @PathVariable("attemptId") Long attemptId,
                                   @RequestBody PupilAttemptInfoDto pupilAttemptDto) {
        PupilAttempt pupilAttempt =
                this.pupilAttemptMapper.fromPupilAttemptInfoDto(pupilAttemptDto);
        pupilAttempt.setText(this.textProcessing.processText(pupilAttempt.getText()));
        this.initializeNullFields(pupilAttempt);
        this.checkPupilAttempt(pupilAttempt);
        pupilAttempt = this.pupilAttemptService.savePupilAttempt(pupilAttempt);
        return new ResponseEntity<>(
                this.pupilAttemptMapper.toPupilAttemptInfoDto(pupilAttempt),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/recheck/{pupilId}/{attemptId}")
    public ResponseEntity<PupilAttemptViewDto> recheckPupilAttempt(@PathVariable("pupilId") Long pupilId,
                                                                   @PathVariable("attemptId") Long attemptId) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            PupilAttempt pupilAttempt =
                    this.pupilAttemptService.getByAttemptAndByPupil(attemptId, pupil.get());
            if (Objects.nonNull(pupilAttempt)) {
                this.checkPupilAttempt(pupilAttempt);
                pupilAttempt = this.pupilAttemptService.savePupilAttempt(pupilAttempt);
                return new ResponseEntity<>(
                        this.pupilAttemptMapper.toPupilAttemptViewDto(pupilAttempt),
                        HttpStatus.OK);
            } else {
                /**TODO EXCEPTION*/
                throw new NoSuchElementException("Такой попытки не существует");
            }
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    /**TODO А нахуя?*/
    private void initializeNullFields(PupilAttempt pupilAttempt) {
        pupilAttempt.setPupil(this.pupilService.getPupil(pupilAttempt.getPupil().getId()).get());
        pupilAttempt.getAttempt().setTask(
                this.taskService.getTask(pupilAttempt.getAttempt().getTask().getId()).get());
    }

    private void checkPupilAttempt(PupilAttempt pupilAttempt) {
        this.pupilAttemptChecker.checkPupilAttempt(pupilAttempt);
    }
}
