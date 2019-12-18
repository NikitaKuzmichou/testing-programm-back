package com.vsu.by.app.people.teacher;

import com.vsu.by.app.people.groups.GroupService;
import com.vsu.by.app.people.groups.dto.GroupMapper;
import com.vsu.by.app.people.user.User;
import com.vsu.by.app.people.user.UserService;
import com.vsu.by.app.people.user.dto.UserDetailDto;
import com.vsu.by.app.people.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("teachers")
@Transactional
public class TeacherController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupService groupService;

    @GetMapping
    public String getTeachers(Model model) {
        model.addAttribute(
                "teachers",
                this.userMapper.toUserInfoDto(this.userService.findAll()));
        return "List teachers";
    }

    @GetMapping("{id}")
    public String getTeacher(@PathVariable("id") Long id, Model model) {
        Optional<User> teacher = this.userService.getUser(id);
        if (teacher.isPresent()) {
            model.addAttribute("groups",
                    this.groupMapper.toGroupInfoDto(
                            this.groupService.findAll(
                                    Sort.by(Sort.Direction.ASC,"faculty"))));
            model.addAttribute("teacher",
                    this.userMapper.toUserInfoDto(teacher.get()));
            return "Teacher by id";
        } else {
            /**TODO EXCEPTION*/
            throw new NoSuchElementException("Такого учителя не существует");
        }
    }

    @PostMapping
    public String addTeacher(@RequestBody UserDetailDto teacher) {
        User saved = this.userService.saveUser(this.userMapper.fromUserDetailDto(teacher));
        return saved.getId().toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return "redirect:/teachers";
    }
}
