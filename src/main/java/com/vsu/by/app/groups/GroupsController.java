package com.vsu.by.app.groups;

import com.vsu.by.app.groups.dto.GroupDetailDto;
import com.vsu.by.app.groups.dto.GroupInfoDto;
import com.vsu.by.app.groups.dto.GroupMapper;
import com.vsu.by.app.pupils.PupilService;
import com.vsu.by.app.jpa.repository.attempt.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("groups")
public class GroupsController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private PupilService pupilService;
    @Autowired
    private AttemptService attemptService;

    @GetMapping
    public ResponseEntity<GroupInfoDto> getGroups() {
        return new ResponseEntity(
                this.groupMapper.toGroupInfoDto(this.groupService.findAll()),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GroupDetailDto> getGroup(@PathVariable("id") Long id) {
        Optional<Group> group = this.groupService.getGroup(id);
        if (group.isPresent()) {
            return new ResponseEntity<>(
                    this.groupMapper.toGroupDetailDto(group.get()),
                    new HttpHeaders(),
                    HttpStatus.OK);
        } else {
            throw new NoSuchElementException("Такой группы не существует");
        }
    }

    /** TODO FOR ADMIN
    @PostMapping
    public ResponseEntity<String> addGroup(@RequestBody AddGrpoupDto group) {

    }
    */

    /** TODO FOR ADMIN
    @PutMapping
    public ResponseEntity<String> updateGroup(@RequestBody EditGroupDto group) {

    }
    */
}
