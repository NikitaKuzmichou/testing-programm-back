package com.vsu.by.app.education.subject;

import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.subject.dto.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;

    @GetMapping
    public String getSubjects(Model model) {
        model.addAttribute("subjects",
                this.subjectMapper.toSubjectDto(this.subjectService.findAll()));
        return "Existing subjects";
    }

    @GetMapping("/{id}")
    public String getSubject(@PathVariable Long id, Model model) {
        Optional<Subject> subject = this.subjectService.getSubject(id);
        if (subject.isPresent()) {
            model.addAttribute("pupilsAttempts",
                    this.pupilAttemptMapper.toPupilAttemptInfoDto(this.pupilAttemptService.findAll()));
            return "Subject by id";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого предмета не существует");
        }
    }

    /**TODO FOR DIPLOM
    @GetMapping
    public String addSubjectInfo() {

    }

    @PostMapping("/add")
    public String addSubject(){

    }
     */
}
