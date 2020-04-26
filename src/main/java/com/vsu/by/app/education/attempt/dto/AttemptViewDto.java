package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskViewDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttemptViewDto {
    private Long id;
    private TaskViewDto task;
    private Long start;
    private Long end;
}
