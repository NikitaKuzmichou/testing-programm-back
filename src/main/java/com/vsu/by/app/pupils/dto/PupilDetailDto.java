package com.vsu.by.app.pupils.dto;

import com.vsu.by.app.groups.dto.GroupDetailDto;
import com.vsu.by.app.user.dto.UserDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilDetailDto {
    private UserDetailDto user;
    private GroupDetailDto role;
}
