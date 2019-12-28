package com.vsu.by.app.education.task.dto;

import com.vsu.by.app.education.subject.dto.SubjectDto;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import com.vsu.by.app.people.teacher.dto.TeacherInfoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskDetailDto {
    private Long id;
    private String name;
    private String description;
    private TeacherInfoDto uploader;
    private SubjectDto subject;
    private TaskTypeInfoDto type;
    /**TODO FOR DIPLOM*/
    private String taskText;
}
