package com.vsu.by.app.user.dto;

import com.vsu.by.app.role.dto.RoleDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfoDto {
    private Long id;
    private Long login;
    private String name;
    private String surname;
    private String patronymic;
    private RoleDto roleDto;
}
