package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
import com.vsu.by.app.education.task.dto.TaskInfoDto;
import com.vsu.by.app.education.task.dto.TaskMinInfoDto;
import com.vsu.by.app.education.task.dto.TaskViewDto;
import com.vsu.by.app.education.tasktype.TaskType;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
import com.vsu.by.app.role.Role;
import com.vsu.by.app.role.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AttemptMapperImpl implements AttemptMapper {

    @Override
    public Attempt fromAttemptAddEditDto(AttemptAddEditDto attemptAddEditDto) {
        if ( attemptAddEditDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptAddEditDto.getId() );
        attempt.setPupilsAttempts( pupilAttemptInfoDtoListToPupilAttemptList( attemptAddEditDto.getPupilsAttempts() ) );
        attempt.setTask( taskDetailDtoToTask( attemptAddEditDto.getTask() ) );
        attempt.setStart( attemptAddEditDto.getStart() );
        attempt.setEnd( attemptAddEditDto.getEnd() );

        return attempt;
    }

    @Override
    public Attempt fromAttemptViewDto(AttemptViewDto attemptViewDto) {
        if ( attemptViewDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptViewDto.getId() );
        attempt.setTask( taskViewDtoToTask( attemptViewDto.getTask() ) );
        attempt.setStart( attemptViewDto.getStart() );
        attempt.setEnd( attemptViewDto.getEnd() );

        return attempt;
    }

    @Override
    public Attempt fromAttemptInfoDto(AttemptInfoDto attemptInfoDto) {
        if ( attemptInfoDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptInfoDto.getId() );
        attempt.setTask( taskInfoDtoToTask( attemptInfoDto.getTask() ) );
        attempt.setStart( attemptInfoDto.getStart() );
        attempt.setEnd( attemptInfoDto.getEnd() );

        return attempt;
    }

    @Override
    public List<Attempt> fromAttemptInfoDto(List<AttemptInfoDto> attemptInfoDto) {
        if ( attemptInfoDto == null ) {
            return null;
        }

        List<Attempt> list = new ArrayList<Attempt>( attemptInfoDto.size() );
        for ( AttemptInfoDto attemptInfoDto1 : attemptInfoDto ) {
            list.add( fromAttemptInfoDto( attemptInfoDto1 ) );
        }

        return list;
    }

    @Override
    public Attempt fromAttemptMinInfoDto(AttemptMinInfoDto attemptMinInfoDto) {
        if ( attemptMinInfoDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptMinInfoDto.getId() );
        attempt.setTask( taskMinInfoDtoToTask( attemptMinInfoDto.getTask() ) );
        attempt.setStart( attemptMinInfoDto.getStart() );
        attempt.setEnd( attemptMinInfoDto.getEnd() );

        return attempt;
    }

    @Override
    public List<Attempt> fromAttemptMinInfoDto(List<AttemptMinInfoDto> attemptMinInfoDto) {
        if ( attemptMinInfoDto == null ) {
            return null;
        }

        List<Attempt> list = new ArrayList<Attempt>( attemptMinInfoDto.size() );
        for ( AttemptMinInfoDto attemptMinInfoDto1 : attemptMinInfoDto ) {
            list.add( fromAttemptMinInfoDto( attemptMinInfoDto1 ) );
        }

        return list;
    }

    @Override
    public AttemptAddEditDto toAttemptAddEditDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptAddEditDto attemptAddEditDto = new AttemptAddEditDto();

        attemptAddEditDto.setId( attempt.getId() );
        attemptAddEditDto.setTask( taskToTaskDetailDto( attempt.getTask() ) );
        attemptAddEditDto.setPupilsAttempts( pupilAttemptListToPupilAttemptInfoDtoList( attempt.getPupilsAttempts() ) );
        attemptAddEditDto.setStart( attempt.getStart() );
        attemptAddEditDto.setEnd( attempt.getEnd() );

        return attemptAddEditDto;
    }

    @Override
    public AttemptViewDto toAttemptViewDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptViewDto attemptViewDto = new AttemptViewDto();

        attemptViewDto.setId( attempt.getId() );
        attemptViewDto.setTask( taskToTaskViewDto( attempt.getTask() ) );
        attemptViewDto.setStart( attempt.getStart() );
        attemptViewDto.setEnd( attempt.getEnd() );

        return attemptViewDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    protected Group groupInfoDtoToGroup(GroupInfoDto groupInfoDto) {
        if ( groupInfoDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupInfoDto.getId() );
        group.setGroupNo( groupInfoDto.getGroupNo() );
        group.setFaculty( groupInfoDto.getFaculty() );
        group.setCourse( groupInfoDto.getCourse() );

        return group;
    }

    protected Pupil pupilInfoDtoToPupil(PupilInfoDto pupilInfoDto) {
        if ( pupilInfoDto == null ) {
            return null;
        }

        Pupil pupil = new Pupil();

        pupil.setId( pupilInfoDto.getId() );
        pupil.setName( pupilInfoDto.getName() );
        pupil.setSurname( pupilInfoDto.getSurname() );
        pupil.setPatronymic( pupilInfoDto.getPatronymic() );
        pupil.setLogin( pupilInfoDto.getLogin() );
        pupil.setRole( roleDtoToRole( pupilInfoDto.getRole() ) );
        pupil.setGroup( groupInfoDtoToGroup( pupilInfoDto.getGroup() ) );

        return pupil;
    }

    protected PupilAttempt pupilAttemptInfoDtoToPupilAttempt(PupilAttemptInfoDto pupilAttemptInfoDto) {
        if ( pupilAttemptInfoDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptInfoDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptInfoDto.getPupil() ) );
        pupilAttempt.setAttempt( fromAttemptInfoDto( pupilAttemptInfoDto.getAttempt() ) );
        pupilAttempt.setText( pupilAttemptInfoDto.getText() );
        pupilAttempt.setMark( pupilAttemptInfoDto.getMark() );

        return pupilAttempt;
    }

    protected List<PupilAttempt> pupilAttemptInfoDtoListToPupilAttemptList(List<PupilAttemptInfoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilAttempt> list1 = new ArrayList<PupilAttempt>( list.size() );
        for ( PupilAttemptInfoDto pupilAttemptInfoDto : list ) {
            list1.add( pupilAttemptInfoDtoToPupilAttempt( pupilAttemptInfoDto ) );
        }

        return list1;
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

    protected Task taskDetailDtoToTask(TaskDetailDto taskDetailDto) {
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

    protected Task taskViewDtoToTask(TaskViewDto taskViewDto) {
        if ( taskViewDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskViewDto.getId() );
        task.setName( taskViewDto.getName() );
        task.setType( taskTypeInfoDtoToTaskType( taskViewDto.getType() ) );
        task.setTaskText( taskViewDto.getTaskText() );

        return task;
    }

    protected Task taskInfoDtoToTask(TaskInfoDto taskInfoDto) {
        if ( taskInfoDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskInfoDto.getId() );
        task.setName( taskInfoDto.getName() );
        task.setType( taskTypeInfoDtoToTaskType( taskInfoDto.getType() ) );

        return task;
    }

    protected Task taskMinInfoDtoToTask(TaskMinInfoDto taskMinInfoDto) {
        if ( taskMinInfoDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskMinInfoDto.getId() );
        task.setName( taskMinInfoDto.getName() );
        task.setType( taskTypeInfoDtoToTaskType( taskMinInfoDto.getType() ) );

        return task;
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

    protected TaskDetailDto taskToTaskDetailDto(Task task) {
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

    protected GroupInfoDto groupToGroupInfoDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupInfoDto groupInfoDto = new GroupInfoDto();

        groupInfoDto.setId( group.getId() );
        groupInfoDto.setFaculty( group.getFaculty() );
        groupInfoDto.setCourse( group.getCourse() );
        groupInfoDto.setGroupNo( group.getGroupNo() );

        return groupInfoDto;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }

    protected PupilInfoDto pupilToPupilInfoDto(Pupil pupil) {
        if ( pupil == null ) {
            return null;
        }

        PupilInfoDto pupilInfoDto = new PupilInfoDto();

        pupilInfoDto.setId( pupil.getId() );
        pupilInfoDto.setLogin( pupil.getLogin() );
        pupilInfoDto.setName( pupil.getName() );
        pupilInfoDto.setSurname( pupil.getSurname() );
        pupilInfoDto.setPatronymic( pupil.getPatronymic() );
        pupilInfoDto.setGroup( groupToGroupInfoDto( pupil.getGroup() ) );
        pupilInfoDto.setRole( roleToRoleDto( pupil.getRole() ) );

        return pupilInfoDto;
    }

    protected PupilAttemptInfoDto pupilAttemptToPupilAttemptInfoDto(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptInfoDto pupilAttemptInfoDto = new PupilAttemptInfoDto();

        pupilAttemptInfoDto.setId( pupilAttempt.getId() );
        pupilAttemptInfoDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptInfoDto.setAttempt( toAttemptInfoDto( pupilAttempt.getAttempt() ) );
        pupilAttemptInfoDto.setText( pupilAttempt.getText() );
        pupilAttemptInfoDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptInfoDto;
    }

    protected List<PupilAttemptInfoDto> pupilAttemptListToPupilAttemptInfoDtoList(List<PupilAttempt> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilAttemptInfoDto> list1 = new ArrayList<PupilAttemptInfoDto>( list.size() );
        for ( PupilAttempt pupilAttempt : list ) {
            list1.add( pupilAttemptToPupilAttemptInfoDto( pupilAttempt ) );
        }

        return list1;
    }

    protected TaskViewDto taskToTaskViewDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskViewDto taskViewDto = new TaskViewDto();

        taskViewDto.setId( task.getId() );
        taskViewDto.setName( task.getName() );
        taskViewDto.setType( taskTypeToTaskTypeInfoDto( task.getType() ) );
        taskViewDto.setTaskText( task.getTaskText() );

        return taskViewDto;
    }
}
