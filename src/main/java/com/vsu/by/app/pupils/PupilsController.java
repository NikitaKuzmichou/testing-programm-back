package com.vsu.by.app.pupils;

import com.vsu.by.app.groups.GroupService;
import com.vsu.by.app.pupils.dto.PupilDetailDto;
import com.vsu.by.app.pupils.dto.PupilInfoDto;
import com.vsu.by.app.pupils.dto.PupilMapper;
import com.vsu.by.app.jpa.repository.attempt.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("pupils")
public class PupilsController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private PupilMapper pupilMapper;
    @Autowired
    private PupilService pupilService;
    @Autowired
    private AttemptService attemptService;

    @GetMapping
    public ResponseEntity<PupilInfoDto> getPupils() {
        return new ResponseEntity(
                this.pupilMapper.toPupilsInfoDto(this.pupilService.findAll()),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PupilDetailDto> getPupil(@PathVariable("id") Long id) {
        Optional<Pupil> pupil = this.pupilService.getPupil(id);
        if (pupil.isPresent()) {
            return new ResponseEntity<PupilDetailDto>(
                    this.pupilMapper.toPupilDetailDto(pupil.get()),
                    new HttpHeaders(),
                    HttpStatus.OK);
        } else {
            /**TODO*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    /**TODO FOR ADMIN
    @PostMapping
    public ResponseEntity<String> addPupil(@RequestBody ) {

    }
    */

    /** TODO FOR ADMIN
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePupil(@PathVariable("id") Long id,
                                              @RequestBody EditPupilDto editedPupil) {

    }
     */

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePupil(@PathVariable("id") Long id) {
        this.pupilService.deletePupil(id);
        return new ResponseEntity<>("deleted", new HttpHeaders(),HttpStatus.ACCEPTED);
    }
}
