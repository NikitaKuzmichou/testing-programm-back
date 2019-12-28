package com.vsu.by.app.education.tasktype.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskTypeAddDto {
    private Long id;
    private String name;
    /**TODO DIPLOM*/
    private String text;
    private String result;
}
