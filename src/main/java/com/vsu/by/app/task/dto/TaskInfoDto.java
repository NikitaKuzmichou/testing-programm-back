package com.vsu.by.app.task.dto;

import com.vsu.by.app.user.dto.UserInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
/**TODO*/
public class TaskInfoDto {
    private Long id;
    private UserInfoDto userInfoDto;

}
