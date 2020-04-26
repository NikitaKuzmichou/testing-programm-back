package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.dto.GroupDetailDto;
import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilAddDto {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private RoleDto role;
    private GroupDetailDto group;
}
