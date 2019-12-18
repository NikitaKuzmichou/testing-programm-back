package com.vsu.by.app.education.task.dto;

import com.vsu.by.app.education.task.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task fromTaskDetailDto(TaskDetailDto taskDetailDto);

    Task fromTaskInfoDto(TaskInfoDto taskInfoDto);

    Task fromTaskAddEditDto(TaskAddEditDto taskAddEditDto);

    TaskDetailDto toTaskDetailDto(Task task);

    TaskInfoDto toTaskInfoDto(Task taskInfoDto);

    List<TaskInfoDto> toTaskInfoDto(List<Task> tasks);

    TaskAddEditDto toTaskAddEditDto(Task task);
}
