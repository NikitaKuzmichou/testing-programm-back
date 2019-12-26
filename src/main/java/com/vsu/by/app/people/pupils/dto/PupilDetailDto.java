package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.user.dto.UserDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilDetailDto extends UserDetailDto {
    private GroupInfoDto group;
}
