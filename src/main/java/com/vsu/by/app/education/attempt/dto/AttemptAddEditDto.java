package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class AttemptAddEditDto {
    private Long id;
    private TaskDetailDto task;
    private Date start;
    private Date end;
    private String pupilAttempt; /**TODO FOR DIPLOM*/
    private byte mark;
}
