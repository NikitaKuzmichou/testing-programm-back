package com.vsu.by.app.education.pupilmistake;

import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.pupilmistake.dto.PupilMistakeDetailDto;
import com.vsu.by.app.education.pupilmistake.dto.PupilMistakeInfoDto;
import com.vsu.by.app.education.pupilmistake.dto.PupilMistakeMapper;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("mistakes")
public class PupilMistakesController {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilMapper pupilMapper;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;
    @Autowired
    private PupilMistakeService pupilMistakeService;
    @Autowired
    private PupilMistakeMapper pupilMistakeMapper;

    @GetMapping("/{pupilAttemptId}")
    public ResponseEntity<List<PupilMistakeInfoDto>> getPupilMistakes(
                               @PathVariable("pupilAttemptId") Long pupilAttemptId) {
        return new ResponseEntity<>(
                    this.pupilMistakeMapper.toPupilMistakeInfoDto(
                            this.pupilMistakeService.findAllByPupilAttemptId(pupilAttemptId)),
                    HttpStatus.OK);
    }

    @GetMapping("/{mistakeId}/{pupilId}")
    public ResponseEntity<PupilMistakeDetailDto> getPupilDetailMistake(@PathVariable("pupilId") Long pupilId,
                                                                       @PathVariable("mistakeId") Long mistakeId) {
        Optional<PupilMistake> mistake = this.pupilMistakeService.getMistake(mistakeId);
        if (mistake.isPresent()) {
            return new ResponseEntity<>(
                    this.pupilMistakeMapper.toPupilMistakeDetailDto(mistake.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ошибки не существует");
        }
    }

    /**TODO POST DELETE PUT REQ*/
}
