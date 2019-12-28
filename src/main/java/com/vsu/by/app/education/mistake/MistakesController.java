package com.vsu.by.app.education.mistake;

import com.vsu.by.app.education.mistake.dto.MistakeMapper;
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
public class MistakesController {
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilMapper pupilMapper;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;
    @Autowired
    private MistakeService mistakeService;
    @Autowired
    private MistakeMapper mistakeMapper;

    @GetMapping("/{pupilId}")
    public String getPupilMistakes(@PathVariable("pupilId") Long pupilId, Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            model.addAttribute("mistakes",
                    this.mistakeMapper.toMistakeInfoDto(this.mistakeService.findAll()));
            return "Pupil mistakes info";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    @GetMapping("/{mistakeId}/{pupilId}")
    public String getPupilDetailMistake(@PathVariable("pupilId") Long pupilId,
                                        @PathVariable("mistakeId") Long mistakeId,
                                        Model model) {
        Optional<Mistake> mistake = this.mistakeService.getMistake(mistakeId);
        if (mistake.isPresent()) {
            model.addAttribute("pupilAttempt",
                    this.mistakeMapper.toMistakeDetailDto(mistake.get()));
            return "Pupil mistake detail";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ошибки не существует");
        }
    }
}
