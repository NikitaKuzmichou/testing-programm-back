package com.vsu.by.app.people.teacher.dto;

import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TeacherInfoDto {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private RoleDto role;
}
