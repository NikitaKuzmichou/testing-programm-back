package com.vsu.by.app.groups.dto;

import com.vsu.by.app.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class GroupDetailDto {
    private Long id;
    private int groupNo;
    private String faculty;
    private int course;
    private List<PupilInfoDto> pupils;
}
