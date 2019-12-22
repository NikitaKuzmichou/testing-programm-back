package com.vsu.by.app.education.subject;

import com.vsu.by.app.education.subject.dto.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

/**TODO*/
@RestController
@RequestMapping("subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    @GetMapping
    public String getSubjects(Model model) {
        model.addAttribute("subjects",
                this.subjectMapper.toSubjectDto(this.subjectService.findAll()));
        return "Existing subjects";
    }

    @GetMapping("/{id}")
    /**TODO. Need list attempts related with following subject
     * ex: Russian: 1)diktant pravila pravopisania | 'mark' | 'date'*/
    public String getSubject(@PathVariable Long id, Model model) {
        Optional<Subject> subject = this.subjectService.getSubject(id);
        if (subject.isPresent()) {
            model.addAttribute(this.subjectMapper.toSubjectDto(subject.get()));
            return "Subject by id";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого предмета не существует");
        }
    }
}
