package com.vsu.by.app.education.tasktype.dto;

import com.vsu.by.app.education.tasktype.TaskType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TaskTypeMapperImpl implements TaskTypeMapper {

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
    public TaskTypeInfoDto toTaskTypeInfoDto(TaskType taskType) {
        if ( taskType == null ) {
            return null;
        }

        TaskTypeInfoDto taskTypeInfoDto = new TaskTypeInfoDto();

        taskTypeInfoDto.setId( taskType.getId() );
        taskTypeInfoDto.setName( taskType.getName() );

        return taskTypeInfoDto;
    }

    @Override
    public List<TaskTypeInfoDto> toTaskTypeInfoDto(List<TaskType> taskType) {
        if ( taskType == null ) {
            return null;
        }

        List<TaskTypeInfoDto> list = new ArrayList<TaskTypeInfoDto>( taskType.size() );
        for ( TaskType taskType1 : taskType ) {
            list.add( toTaskTypeInfoDto( taskType1 ) );
        }

        return list;
    }
}
