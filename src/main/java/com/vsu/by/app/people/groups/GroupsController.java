package com.vsu.by.app.people.groups;

import com.vsu.by.app.jpa.repository.attempt.AttemptService;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import com.vsu.by.app.people.pupils.PupilService;
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
    public String getGroups(Model model) {
        model.addAttribute(
                "groups",
                this.groupMapper.toGroupInfoDto(this.groupService.findAll()));
        return "Groups list";
    }

    @GetMapping("{id}")
    public String getGroup(@PathVariable("id") Long id, Model model) {
        Optional<Group> group = this.groupService.getGroup(id);
        if (group.isPresent()) {
            model.addAttribute(
                    "group",
                    this.groupMapper.toGroupDetailDto(group.get()));
            return "Group by id";
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
