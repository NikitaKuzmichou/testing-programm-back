package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskInfoDto;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class AttemptInfoDto {
    private Long id;
    private TaskInfoDto taskInfoDto;
    private Date start;
    private Date end;
}
