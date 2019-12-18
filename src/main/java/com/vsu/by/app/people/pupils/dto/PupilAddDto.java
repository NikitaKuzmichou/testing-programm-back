package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.dto.GroupDetailDto;
import com.vsu.by.app.people.user.dto.UserDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilAddDto {
    private UserDetailDto user;
    private GroupDetailDto group;
}
