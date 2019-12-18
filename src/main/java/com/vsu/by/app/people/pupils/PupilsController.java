package com.vsu.by.app.people.pupils;

import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.jpa.repository.attempt.AttemptService;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("pupils")
@Transactional
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
    public String getPupils(Model model) {
        model.addAttribute(
                "pupils",
                this.pupilMapper.toPupilsInfoDto(this.pupilService.findAll()));
        return "List pupils";
    }

    @GetMapping("/{id}")
    public String getPupil(@PathVariable("id") Long id, Model model) {
        Optional<Pupil> pupil = this.pupilService.getPupil(id);
        if (pupil.isPresent()) {
            model.addAttribute(
                    "pupil",
                    this.pupilMapper.toPupilDetailDto(pupil.get()));
            return "Pupil by id";
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

    @GetMapping("/delete/{id}")
    public String deletePupil(@PathVariable("id") Long id) {
        this.pupilService.deletePupil(id);
        return "redirect:/pupils";
    }
}
