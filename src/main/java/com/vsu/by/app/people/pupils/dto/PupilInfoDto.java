package com.vsu.by.app.people.pupils.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PupilInfoDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String faculty;
    private int groupNo;
}
