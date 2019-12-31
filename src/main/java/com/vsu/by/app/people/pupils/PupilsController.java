package com.vsu.by.app.people.pupils;

import com.vsu.by.app.education.pupilattempt.PupilAttemptService;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("pupils")
@Transactional
public class PupilsController {
    @Autowired
    private PupilMapper pupilMapper;
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilAttemptService pupilAttemptService;
    @Autowired
    private PupilAttemptMapper pupilAttemptMapper;

    @GetMapping
    public ResponseEntity<List<PupilInfoDto>> getPupils() {
        return new ResponseEntity<>(
                this.pupilMapper.toPupilsInfoDto(this.pupilService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PupilAttemptInfoDto>> getPupil(@PathVariable("id") Long id) {
        Optional<Pupil> pupil = this.pupilService.getPupil(id);
        if (pupil.isPresent()) {
            /**TODO possible additions:
             * сортировка по предметам, по которым были написаны\проведены работы*/
            return new ResponseEntity<>(
                    this.pupilAttemptMapper.toPupilAttemptInfoDto(
                            this.pupilAttemptService.findAllByPupil(pupil.get())),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    /**TODO FOR ADMIN
    @PostMapping
    public ResponseEntity<String> addPupil(@RequestBody ) {
    }
    */

    /** TODO FOR ADMIN AND PUPIL
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePupil(@PathVariable("id") Long id,
                                              @RequestBody EditPupilDto editedPupil) {
    }
     */

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePupil(@PathVariable("id") Long id) {
        this.pupilService.deletePupil(id);
        return new ResponseEntity<>("redirect:/pupils", HttpStatus.ACCEPTED);
    }
}
