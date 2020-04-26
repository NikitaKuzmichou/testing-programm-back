package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttemptInfoDto {
    private Long id;
    private TaskInfoDto task;
    private Long start;
    private Long end;
}
