package com.vsu.by.app.education.tasktype.dto;

import com.vsu.by.app.education.tasktype.TaskType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TaskTypeMapping {

    TaskTypeMapping INSTANCE = Mappers.getMapper(TaskTypeMapping.class);

    TaskType fromTaskTypeAddDto(TaskTypeAddDto taskTypeAddDto);

    TaskType fromTaskTypeInfoDto(TaskTypeInfoDto taskTypeInfoDto);

    TaskTypeAddDto toTaskTypeAddDto(TaskType taskType);

    TaskTypeInfoDto toTaskTypeInfoDto(TaskType taskType);
}
