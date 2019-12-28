package com.vsu.by.app.education.pupilattempt;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptAddEditDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.service.PupilAttemptChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("attempt")
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
    public String getPupilAttempt(@PathVariable("pupilId") Long pupilId,
                                  @PathVariable("attemptId") Long attemptId,
                                  Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            PupilAttempt pupilAttempt = this.pupilAttemptService.getByAttemptAndByPupil(attemptId, pupil.get());
            if (Objects.nonNull(pupilAttempt)) {
                model.addAttribute("attempt",
                        this.pupilAttemptMapper.toPupilAttemptInfoDto(pupilAttempt));
                return "Pupil attempt";
            } else {
                /**TODO EXCEPTION*/
                throw new NoSuchElementException("Такой попытки не существует");
            }
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    @PostMapping("/{pupilId}/{attemptId}")
    public String updatePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                     @PathVariable("attemptId") Long attemptId,
                                     @RequestBody PupilAttemptAddEditDto pupilAttemptAddEditDto) {
        this.pupilAttemptService.updatePupilAttempt(
                this.pupilAttemptMapper.fromPupilAttemptAddEditDto(pupilAttemptAddEditDto));
        return "Pupil attempt was updated";
    }

    /**TODO POSSIBLE OR EVERYTHING OK*/
    @PostMapping("/save/{pupilId}/{attemptId}")
    public String savePupilAttempt(@PathVariable("pupilId") Long pupilId,
                                   @PathVariable("attemptId") Long attemptId,
                                   @RequestBody PupilAttemptAddEditDto pupilAttemptAddEditDto) {
        this.pupilAttemptChecker.checkPupilAttempt(
                this.pupilAttemptMapper.fromPupilAttemptAddEditDto(pupilAttemptAddEditDto));
        return "Pupil attempt was saved";
    }
}
