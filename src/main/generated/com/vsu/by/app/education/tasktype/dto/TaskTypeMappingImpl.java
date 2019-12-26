package com.vsu.by.app.education.tasktype.dto;

import com.vsu.by.app.education.tasktype.TaskType;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TaskTypeMappingImpl implements TaskTypeMapping {

    @Override
    public TaskType fromTaskTypeAddDto(TaskTypeAddDto taskTypeAddDto) {
        if ( taskTypeAddDto == null ) {
            return null;
        }

        TaskType taskType = new TaskType();

        taskType.setId( taskTypeAddDto.getId() );
        taskType.setName( taskTypeAddDto.getName() );
        taskType.setText( taskTypeAddDto.getText() );
        taskType.setResult( taskTypeAddDto.getResult() );

        return taskType;
    }

    @Override
    public TaskType fromTaskTypeInfoDto(TaskTypeInfoDto taskTypeInfoDto) {
        if ( taskTypeInfoDto == null ) {
            return null;
        }

        TaskType taskType = new TaskType();

        taskType.setId( taskTypeInfoDto.getId() );
        taskType.setName( taskTypeInfoDto.getName() );

        return taskType;
    }

    @Override
    public TaskTypeAddDto toTaskTypeAddDto(TaskType taskType) {
        if ( taskType == null ) {
            return null;
        }

        TaskTypeAddDto taskTypeAddDto = new TaskTypeAddDto();

        taskTypeAddDto.setId( taskType.getId() );
        taskTypeAddDto.setName( taskType.getName() );
        taskTypeAddDto.setText( taskType.getText() );
        taskTypeAddDto.setResult( taskType.getResult() );

        return taskTypeAddDto;
    }

    @Override
    public TaskTypeInfoDto toTaskTypeInfoDto(TaskType taskType) {
        if ( taskType == null ) {
            return null;
        }

        TaskTypeInfoDto taskTypeInfoDto = new TaskTypeInfoDto();

        taskTypeInfoDto.setId( taskType.getId() );
        taskTypeInfoDto.setName( taskType.getName() );

        return taskTypeInfoDto;
    }
}
