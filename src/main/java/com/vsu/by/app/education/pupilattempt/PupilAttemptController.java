package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptAddEditDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.service.PupilAttemptChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("pupil-attempts")
public class PupilAttemptController {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;
    @Autowired
    private PupilAttemptChecker pupilAttemptChecker;

    @GetMapping("/{pupilId}/{attemptId}")
    public ResponseEntity<PupilAttemptInfoDto> getPupilAttempt(@PathVariable("pupilId") Long pupilId,
                                                               @PathVariable("attemptId") Long attemptId,
                                                               Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            PupilAttempt pupilAttempt = this.pupilAttemptService.getByAttemptAndByPupil(attemptId, pupil.get());
            if (Objects.nonNull(pupilAttempt)) {
                return new ResponseEntity<>(
                        this.pupilAttemptMapper.toPupilAttemptInfoDto(pupilAttempt),
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
    public ResponseEntity<String> updatePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                     @PathVariable("attemptId") Long attemptId,
                                     @RequestBody PupilAttemptAddEditDto pupilAttemptAddEditDto) {
        this.pupilAttemptService.updatePupilAttempt(
                this.pupilAttemptMapper.fromPupilAttemptAddEditDto(pupilAttemptAddEditDto));
        return new ResponseEntity<>("Pupil attempt was updated", HttpStatus.OK);
    }

    /**TODO POSSIBLE OR EVERYTHING OK*/
    @PostMapping("/{pupilId}/{attemptId}")
    public ResponseEntity<String> savePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                   @PathVariable("attemptId") Long attemptId,
                                   @RequestBody PupilAttemptAddEditDto pupilAttemptAddEditDto) {
        PupilAttempt pupilAttempt =
                this.pupilAttemptMapper.fromPupilAttemptAddEditDto(pupilAttemptAddEditDto);
        this.pupilAttemptChecker.checkPupilAttempt(pupilAttempt);
        this.pupilAttemptService.savePupilAttempt(pupilAttempt);
        return new ResponseEntity<>("Pupil attempt was saved", HttpStatus.OK);
    }
}
