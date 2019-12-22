package com.vsu.by.app.education.attempt;

import com.vsu.by.app.education.attempt.dto.AttemptMapper;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
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
    private PupilMapper pupilMapper;
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
        Optional<Attempt> attempt = this.attemptService.getByIdAndByPupil(id);
        if (attempt.isPresent()) {
            model.addAttribute("attempt",
                    this.attemptMapper.fromAttemptDetailDto(attempt.get()));
            return "Attempt detail";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такой попытки не существует");
        }
    }

    @GetMapping("/{pupilId/{attemptId}}")
    public String getPupilAttempt(@PathVariable("pupilId") Long pupilId,
                                  @PathVariable("attemptId") Long attemptId,
                                  Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(pupilId);
        if (pupil.isPresent()) {
            Optional<Attempt> attempt = this.attemptService.getByIdAndByPupil(attemptId, pupil.get());
            if (attempt.isPresent()) {
                model.addAttribute("attempt",
                        this.attemptMapper.toAttemptDetailDto(attempt.get()));
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

    /**@PostMapping("/add")
     * public String addAttempt() {
     * 
     *     return "Attempt added";
     * }
     */

}
