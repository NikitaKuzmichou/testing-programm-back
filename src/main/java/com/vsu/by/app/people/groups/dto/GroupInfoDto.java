package com.vsu.by.app.people.groups.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupInfoDto {
    private Long id;
    private String faculty;
    private int course;
    private int groupNo;
}
