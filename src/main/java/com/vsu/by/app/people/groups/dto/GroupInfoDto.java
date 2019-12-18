package com.vsu.by.app.people.groups.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupInfoDto {
    private Long id;
    private int groupNo;
    private String faculty;
}
