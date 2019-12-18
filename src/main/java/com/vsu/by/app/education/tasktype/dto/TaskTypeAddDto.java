package com.vsu.by.app.education.tasktype.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskTypeAddDto {
    private Long id;
    private String name;
    private Object text;
    private Object result;
}
