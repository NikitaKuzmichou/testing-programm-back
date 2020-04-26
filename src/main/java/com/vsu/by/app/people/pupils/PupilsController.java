package com.vsu.by.app.people.pupils;

import com.vsu.by.app.people.pupils.dto.PupilAddDto;
import com.vsu.by.app.people.pupils.dto.PupilDetailDto;
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

    @GetMapping
    public ResponseEntity<List<PupilDetailDto>> getPupils() {
        return new ResponseEntity<>(
                this.pupilMapper.toPupilDetailDto(this.pupilService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PupilDetailDto> getPupil(@PathVariable("id") Long id) {
        Optional<Pupil> pupil = this.pupilService.getPupil(id);
        if (pupil.isPresent()) {
            /**TODO possible additions:
             * сортировка по предметам, по которым были написаны\проведены работы*/
            return new ResponseEntity<>(
                    this.pupilMapper.toPupilDetailDto(pupil.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    @PostMapping
    public ResponseEntity<PupilInfoDto> addPupil(@RequestBody PupilAddDto pupilAddDto) {
        Pupil pupil = this.pupilMapper.fromPupilAddDto(pupilAddDto);
        pupil = this.pupilService.savePupil(pupil);
        return new ResponseEntity<>(
                this.pupilMapper.toPupilInfoDto(pupil),
                HttpStatus.ACCEPTED);
    }

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
