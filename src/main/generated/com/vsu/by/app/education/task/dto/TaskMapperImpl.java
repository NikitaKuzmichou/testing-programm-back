package com.vsu.by.app.education.task.dto;

import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.tasktype.TaskType;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromTaskDetailDto(TaskDetailDto taskDetailDto) {
        if ( taskDetailDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDetailDto.getId() );
        task.setName( taskDetailDto.getName() );
        task.setType( taskTypeInfoDtoToTaskType( taskDetailDto.getType() ) );
        task.setTaskText( taskDetailDto.getTaskText() );

        return task;
    }

    @Override
    public Task fromTaskInfoDto(TaskInfoDto taskInfoDto) {
        if ( taskInfoDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskInfoDto.getId() );
        task.setName( taskInfoDto.getName() );
        task.setType( taskTypeInfoDtoToTaskType( taskInfoDto.getType() ) );

        return task;
    }

    @Override
    public Task fromTaskAddEditDto(TaskAddEditDto taskAddEditDto) {
        if ( taskAddEditDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskAddEditDto.getId() );
        task.setName( taskAddEditDto.getName() );
        task.setTaskText( taskAddEditDto.getTaskText() );

        return task;
    }

    @Override
    public TaskDetailDto toTaskDetailDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDetailDto taskDetailDto = new TaskDetailDto();

        taskDetailDto.setId( task.getId() );
        taskDetailDto.setName( task.getName() );
        taskDetailDto.setType( taskTypeToTaskTypeInfoDto( task.getType() ) );
        taskDetailDto.setTaskText( task.getTaskText() );

        return taskDetailDto;
    }

    @Override
    public TaskInfoDto toTaskInfoDto(Task taskInfoDto) {
        if ( taskInfoDto == null ) {
            return null;
        }

        TaskInfoDto taskInfoDto1 = new TaskInfoDto();

        taskInfoDto1.setId( taskInfoDto.getId() );
        taskInfoDto1.setName( taskInfoDto.getName() );
        taskInfoDto1.setType( taskTypeToTaskTypeInfoDto( taskInfoDto.getType() ) );

        return taskInfoDto1;
    }

    @Override
    public List<TaskInfoDto> toTaskInfoDto(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskInfoDto> list = new ArrayList<TaskInfoDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toTaskInfoDto( task ) );
        }

        return list;
    }

    @Override
    public TaskAddEditDto toTaskAddEditDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskAddEditDto taskAddEditDto = new TaskAddEditDto();

        taskAddEditDto.setId( task.getId() );
        taskAddEditDto.setName( task.getName() );
        taskAddEditDto.setTaskText( task.getTaskText() );

        return taskAddEditDto;
    }

    protected TaskType taskTypeInfoDtoToTaskType(TaskTypeInfoDto taskTypeInfoDto) {
        if ( taskTypeInfoDto == null ) {
            return null;
        }

        TaskType taskType = new TaskType();

        taskType.setId( taskTypeInfoDto.getId() );
        taskType.setName( taskTypeInfoDto.getName() );

        return taskType;
    }

    protected TaskTypeInfoDto taskTypeToTaskTypeInfoDto(TaskType taskType) {
        if ( taskType == null ) {
            return null;
        }

        TaskTypeInfoDto taskTypeInfoDto = new TaskTypeInfoDto();

        taskTypeInfoDto.setId( taskType.getId() );
        taskTypeInfoDto.setName( taskType.getName() );

        return taskTypeInfoDto;
    }
}
