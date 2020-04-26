package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AttemptAddEditDto {
    private Long id;
    private TaskDetailDto task;
    private List<PupilAttemptInfoDto> pupilsAttempts;
    private Long start;
    private Long end;
}
