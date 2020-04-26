package com.vsu.by.app.education.tasktype.dto;

import com.vsu.by.app.education.tasktype.TaskType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TaskTypeMapper {

    TaskTypeMapper INSTANCE = Mappers.getMapper(TaskTypeMapper.class);

    TaskType fromTaskTypeInfoDto(TaskTypeInfoDto taskTypeInfoDto);

    TaskTypeInfoDto toTaskTypeInfoDto(TaskType taskType);

    List<TaskTypeInfoDto> toTaskTypeInfoDto(List<TaskType> taskType);
}
