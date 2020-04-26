package com.vsu.by.app.education.task.dto;

import com.vsu.by.app.education.subject.dto.SubjectMapper;
import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.task.TaskInfo;
import com.vsu.by.app.education.tasktype.dto.TaskTypeMapper;
import com.vsu.by.app.people.teacher.dto.TeacherMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    default Task fromTaskDetailDto(TaskDetailDto taskDetailDto) {
        Task task = new Task();
        task.setType(TaskTypeMapper.INSTANCE.fromTaskTypeInfoDto(taskDetailDto.getType()));
        task.setTaskText(taskDetailDto.getTaskText());
        task.setName(taskDetailDto.getName());
        task.setId(taskDetailDto.getId());
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setDescription(taskDetailDto.getDescription());
        taskInfo.setSubject(SubjectMapper.INSTANCE.fromSubjectDto(taskDetailDto.getSubject()));
        taskInfo.setTeacher(TeacherMapper.INSTANCE.fromTeacherInfoDto(taskDetailDto.getUploader()));
        task.setInfo(taskInfo);
        return task;
    }

    default Task fromTaskInfoDto(TaskInfoDto taskInfoDto) {
        Task task = new Task();
        task.setId(taskInfoDto.getId());
        task.setType(TaskTypeMapper.INSTANCE.fromTaskTypeInfoDto(taskInfoDto.getType()));
        task.setName(taskInfoDto.getName());
        task.getInfo().setTeacher(TeacherMapper.INSTANCE.fromTeacherInfoDto(taskInfoDto.getUploader()));
        task.getInfo().setSubject(SubjectMapper.INSTANCE.fromSubjectDto(taskInfoDto.getSubject()));
        return task;
    }

    /**TODO????*/
    default Task fromTaskMinInfoDto(TaskMinInfoDto taskMinInfoDto) {
        Task task = new Task();
        task.setId(taskMinInfoDto.getId());
        task.setName(taskMinInfoDto.getName());
        task.setType(TaskTypeMapper.INSTANCE.fromTaskTypeInfoDto(taskMinInfoDto.getType()));
        return task;
    }

    default Task fromTaskViewDto(TaskViewDto taskViewDto) {
        Task task = new Task();
        task.setId(taskViewDto.getId());
        task.setName(taskViewDto.getName());
        task.setTaskText(taskViewDto.getTaskText());
        task.getInfo().setSubject(SubjectMapper.INSTANCE.fromSubjectDto(taskViewDto.getSubject()));
        task.setType(TaskTypeMapper.INSTANCE.fromTaskTypeInfoDto(taskViewDto.getType()));
        return task;
    }

    default TaskDetailDto toTaskDetailDto(Task task) {
        TaskDetailDto taskDetailDto = new TaskDetailDto();
        taskDetailDto.setId(task.getId());
        taskDetailDto.setDescription(task.getInfo().getDescription());
        taskDetailDto.setName(task.getName());
        taskDetailDto.setSubject(SubjectMapper.INSTANCE.toSubjectDto(task.getInfo().getSubject()));
        taskDetailDto.setTaskText(task.getTaskText());
        taskDetailDto.setType(TaskTypeMapper.INSTANCE.toTaskTypeInfoDto(task.getType()));
        taskDetailDto.setUploader(TeacherMapper.INSTANCE.toTeacherInfoDto(task.getInfo().getTeacher()));
        return taskDetailDto;
    }

    default TaskInfoDto toTaskInfoDto(Task task) {
        TaskInfoDto taskInfo = new TaskInfoDto();
        taskInfo.setId(task.getId());
        taskInfo.setName(task.getName());
        taskInfo.setSubject(SubjectMapper.INSTANCE.toSubjectDto(task.getInfo().getSubject()));
        taskInfo.setType(TaskTypeMapper.INSTANCE.toTaskTypeInfoDto(task.getType()));
        taskInfo.setUploader(TeacherMapper.INSTANCE.toTeacherInfoDto(task.getInfo().getTeacher()));
        return taskInfo;
    }

    default TaskViewDto toTaskViewDto(Task task) {
        TaskViewDto taskViewDto = new TaskViewDto();
        taskViewDto.setId(task.getId());
        taskViewDto.setName(task.getName());
        taskViewDto.setSubject(SubjectMapper.INSTANCE.toSubjectDto(task.getInfo().getSubject()));
        taskViewDto.setTaskText(task.getTaskText());
        taskViewDto.setType(TaskTypeMapper.INSTANCE.toTaskTypeInfoDto(task.getType()));
        return taskViewDto;
    }

    default List<TaskInfoDto> toTaskInfoDto(List<Task> tasks) {
        List<TaskInfoDto> taskInfo = new LinkedList<>();
        for (Task task : tasks) {
            taskInfo.add(this.toTaskInfoDto(task));
        }
        return taskInfo;
    }

    default TaskMinInfoDto toTaskMinInfoDto(Task task) {
        TaskMinInfoDto taskMinInfo = new TaskMinInfoDto();
        taskMinInfo.setId(task.getId());
        taskMinInfo.setName(task.getName());
        taskMinInfo.setDescription(task.getInfo().getDescription());
        taskMinInfo.setSubject(SubjectMapper.INSTANCE.toSubjectDto(task.getInfo().getSubject()));
        taskMinInfo.setType(TaskTypeMapper.INSTANCE.toTaskTypeInfoDto(task.getType()));
        return taskMinInfo;
    }

    default List<TaskMinInfoDto> toTaskMinInfoDto(List<Task> tasks) {
        List<TaskMinInfoDto> tasksMinInfo = new LinkedList<>();
        for (Task task : tasks) {
            tasksMinInfo.add(this.toTaskMinInfoDto(task));
        }
        return tasksMinInfo;
    }
}
