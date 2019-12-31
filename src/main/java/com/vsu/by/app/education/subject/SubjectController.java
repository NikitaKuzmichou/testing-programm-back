package com.vsu.by.app.education.subject;

import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.subject.dto.SubjectDto;
import com.vsu.by.app.education.subject.dto.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<SubjectDto>> getSubjects() {
        return new ResponseEntity<>(
                this.subjectMapper.toSubjectDto(this.subjectService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PupilAttemptInfoDto>> getSubject(@PathVariable Long id) {
        Optional<Subject> subject = this.subjectService.getSubject(id);
        if (subject.isPresent()) {
            return new ResponseEntity<>(
                    this.pupilAttemptMapper.toPupilAttemptInfoDto(this.pupilAttemptService.findAll()),
                    HttpStatus.OK);
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
