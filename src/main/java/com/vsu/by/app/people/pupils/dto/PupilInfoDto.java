package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilInfoDto {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private GroupInfoDto group;
    private RoleDto role;
}
