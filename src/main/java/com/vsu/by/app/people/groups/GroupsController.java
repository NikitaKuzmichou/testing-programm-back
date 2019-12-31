package com.vsu.by.app.people.groups;

import com.vsu.by.app.education.attempt.AttemptService;
import com.vsu.by.app.people.groups.dto.GroupDetailDto;
import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import com.vsu.by.app.people.pupils.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("groups")
@Transactional
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
    public ResponseEntity<List<GroupInfoDto>> getGroups() {
        return new ResponseEntity<>(
                this.groupMapper.toGroupInfoDto(this.groupService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDetailDto> getGroup(@PathVariable("id") Long id) {
        Optional<Group> group = this.groupService.getGroup(id);
        if (group.isPresent()) {
            return new ResponseEntity<>(
                    this.groupMapper.toGroupDetailDto(group.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
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
