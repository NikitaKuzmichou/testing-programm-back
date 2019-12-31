package com.vsu.by.app.people.teacher;

import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.PupilService;
import com.vsu.by.app.people.pupils.dto.PupilDetailDto;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import com.vsu.by.app.people.user.User;
import com.vsu.by.app.people.user.UserService;
import com.vsu.by.app.people.user.dto.UserDetailDto;
import com.vsu.by.app.people.user.dto.UserInfoDto;
import com.vsu.by.app.people.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("teachers")
@Transactional
/**TODO swithc userService... to TeacherService*/
public class TeacherController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PupilService pupilService;
    @Autowired
    private PupilMapper pupilMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<List<UserInfoDto>> getTeachers() {
        return new ResponseEntity<>(
                this.userMapper.toUserInfoDto(this.userService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    /**MULTIPLE REQUESTS. ALSE RETURN INFO ABOUT TEACHER*/
    public ResponseEntity<List<GroupInfoDto>> getTeacher(@PathVariable("id") Long id) {
        Optional<User> teacher = this.userService.getUser(id);
        if (teacher.isPresent()) {
            return new ResponseEntity<>(
                    this.groupMapper.toGroupInfoDto(
                            this.groupService.findAll(
                                    Sort.by(Sort.Direction.ASC,"faculty"))),
                    HttpStatus.OK
            );
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого учителя не существует");
        }
    }

    @GetMapping("/pupils/{id}")
    public ResponseEntity<PupilDetailDto> getPupil(@PathVariable("id") Long id) {
        Optional<Pupil> pupil = this.pupilService.getPupil(id);
        if (pupil.isPresent()) {
            return new ResponseEntity<>(
                    this.pupilMapper.toPupilDetailDto(pupil.get()),
                    HttpStatus.OK);
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого ученика не существует");
        }
    }

    @PostMapping
    public ResponseEntity<Long> addTeacher(@RequestBody UserDetailDto teacher) {
        User saved = this.userService.saveUser(this.userMapper.fromUserDetailDto(teacher));
        return new ResponseEntity<>(saved.getId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>("redirect:/teachers", HttpStatus.ACCEPTED);
    }
}
