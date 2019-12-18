package com.vsu.by.app.people.user.dto;

import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfoDto {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private RoleDto role;
}
