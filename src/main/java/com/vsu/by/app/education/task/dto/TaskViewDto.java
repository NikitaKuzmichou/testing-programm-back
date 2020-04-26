package com.vsu.by.app.education.task.dto;

import com.vsu.by.app.education.subject.dto.SubjectDto;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskViewDto {
    private Long id;
    private String name;
    private SubjectDto subject;
    private TaskTypeInfoDto type;
    private String taskText;
}
