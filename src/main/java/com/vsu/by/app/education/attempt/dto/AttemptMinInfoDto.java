package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.task.dto.TaskMinInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttemptMinInfoDto {
    private Long id;
    private TaskMinInfoDto task;
    private Long start;
    private Long end;
}
