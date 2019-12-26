package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.mistake.dto.PupilMistakeMapper;
import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{pupilId}")
    public String getPupilMistakes(@PathVariable("pupilId") Long pupilId, Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            model.addAttribute("mistakes",
                    this.pupilMistakeMapper.toPupilMistakeInfoDto(this.pupilMistakeService.findAll()));
            return "Pupil mistakes info";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }
/*
    @GetMapping("/{pupilId}/{mistakeId}")
    public String getPupilDetailMistake(@PathVariable("pupilId") Long pupilId,
                                        @PathVariable("mistakeId") Long mistakeId,
                                        Model model) {
        /**TODO. LEFT JUST SECURITY, THAT AND CONFIGS. AFTER SITE AND KYRSACH*/
    //}
}
