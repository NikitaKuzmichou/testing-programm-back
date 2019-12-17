package com.vsu.by.app.task.dto;

import com.vsu.by.app.subject.dto.SubjectDto;
import com.vsu.by.app.tasktype.dto.TaskTypeAddDto;
import com.vsu.by.app.user.dto.UserInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskAddEditDto {
    private Long id;
    private String name;
    private String description;
    private UserInfoDto uploader;
    private SubjectDto subject;
    private TaskTypeAddDto taskType;
    /**TODO ONLY FOR KYRSACH*/
    private String taskText;
}
