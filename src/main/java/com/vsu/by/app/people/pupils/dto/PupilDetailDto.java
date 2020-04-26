package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilDetailDto {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private RoleDto role;
    private GroupInfoDto group;
}
