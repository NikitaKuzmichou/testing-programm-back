package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDto;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AttemptDetailDto {
    private Long id;
    private TaskDetailDto task;
    private List<PupilAttemptDto> pupilsAttempts;
    private Long start;
    private Long end;
}
