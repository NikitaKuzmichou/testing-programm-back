package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskDetailDto;
import com.vsu.by.app.people.pupils.dto.PupilDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class AttemptDetailDto {
    private Long id;
    private PupilDetailDto pupil;
    private TaskDetailDto task;
    private Date start;
    private Date end;
    private String pupilAttempt; /**TODO FOR DIPLOM*/
    private byte mark;
}
