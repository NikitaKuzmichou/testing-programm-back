package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.attempt.dto.AttemptMinInfoDto;
import com.vsu.by.app.education.attempt.dto.AttemptViewDto;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
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
public class PupilAttemptMapperImpl implements PupilAttemptMapper {

    @Override
    public PupilAttempt fromPupilAttemptDto(PupilAttemptDto pupilAttemptDto) {
        if ( pupilAttemptDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptDto.getPupil() ) );
        pupilAttempt.setMark( pupilAttemptDto.getMark() );

        return pupilAttempt;
    }

    @Override
    public PupilAttempt fromPupilAttemptViewDto(PupilAttemptViewDto pupilAttemptViewDto) {
        if ( pupilAttemptViewDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptViewDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptViewDto.getPupil() ) );
        pupilAttempt.setAttempt( attemptViewDtoToAttempt( pupilAttemptViewDto.getAttempt() ) );
        pupilAttempt.setText( pupilAttemptViewDto.getText() );
        pupilAttempt.setMark( pupilAttemptViewDto.getMark() );

        return pupilAttempt;
    }

    @Override
    public List<PupilAttempt> fromPupilAttemptDto(List<PupilAttemptDto> pupilAttemptDto) {
        if ( pupilAttemptDto == null ) {
            return null;
        }

        List<PupilAttempt> list = new ArrayList<PupilAttempt>( pupilAttemptDto.size() );
        for ( PupilAttemptDto pupilAttemptDto1 : pupilAttemptDto ) {
            list.add( fromPupilAttemptDto( pupilAttemptDto1 ) );
        }

        return list;
    }

    @Override
    public PupilAttempt fromPupilAttemptDetailDto(PupilAttemptDetailDto pupilAttemptDetailDto) {
        if ( pupilAttemptDetailDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptDetailDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptDetailDto.getPupil() ) );
        pupilAttempt.setAttempt( attemptDetailDtoToAttempt( pupilAttemptDetailDto.getAttempt() ) );
        pupilAttempt.setText( pupilAttemptDetailDto.getText() );
        pupilAttempt.setMark( pupilAttemptDetailDto.getMark() );

        return pupilAttempt;
    }

    @Override
    public PupilAttempt fromPupilAttemptInfoDto(PupilAttemptInfoDto pupilAttemptInfoDto) {
        if ( pupilAttemptInfoDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptInfoDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptInfoDto.getPupil() ) );
        pupilAttempt.setAttempt( attemptInfoDtoToAttempt( pupilAttemptInfoDto.getAttempt() ) );
        pupilAttempt.setText( pupilAttemptInfoDto.getText() );
        pupilAttempt.setMark( pupilAttemptInfoDto.getMark() );

        return pupilAttempt;
    }

    @Override
    public List<PupilAttempt> fromPupilAttemptInfoDto(List<PupilAttemptInfoDto> pupilAttemptInfoDto) {
        if ( pupilAttemptInfoDto == null ) {
            return null;
        }

        List<PupilAttempt> list = new ArrayList<PupilAttempt>( pupilAttemptInfoDto.size() );
        for ( PupilAttemptInfoDto pupilAttemptInfoDto1 : pupilAttemptInfoDto ) {
            list.add( fromPupilAttemptInfoDto( pupilAttemptInfoDto1 ) );
        }

        return list;
    }

    @Override
    public PupilAttempt fromPupilAttemptMinInfoDto(PupilAttemptMinInfoDto pupilAttemptMinInfoDto) {
        if ( pupilAttemptMinInfoDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptMinInfoDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptMinInfoDto.getPupil() ) );
        pupilAttempt.setAttempt( attemptMinInfoDtoToAttempt( pupilAttemptMinInfoDto.getAttempt() ) );
        pupilAttempt.setMark( pupilAttemptMinInfoDto.getMark() );

        return pupilAttempt;
    }

    @Override
    public PupilAttemptDto toPupilAttemptDto(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptDto pupilAttemptDto = new PupilAttemptDto();

        pupilAttemptDto.setId( pupilAttempt.getId() );
        pupilAttemptDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptDto;
    }

    @Override
    public List<PupilAttemptDto> toPupilAttemptDto(List<PupilAttempt> pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        List<PupilAttemptDto> list = new ArrayList<PupilAttemptDto>( pupilAttempt.size() );
        for ( PupilAttempt pupilAttempt1 : pupilAttempt ) {
            list.add( toPupilAttemptDto( pupilAttempt1 ) );
        }

        return list;
    }

    @Override
    public PupilAttemptDetailDto toPupilAttemptDetailDto(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptDetailDto pupilAttemptDetailDto = new PupilAttemptDetailDto();

        pupilAttemptDetailDto.setId( pupilAttempt.getId() );
        pupilAttemptDetailDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptDetailDto.setAttempt( attemptToAttemptDetailDto( pupilAttempt.getAttempt() ) );
        pupilAttemptDetailDto.setText( pupilAttempt.getText() );
        pupilAttemptDetailDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptDetailDto;
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

    protected TaskType taskTypeInfoDtoToTaskType(TaskTypeInfoDto taskTypeInfoDto) {
        if ( taskTypeInfoDto == null ) {
            return null;
        }

        TaskType taskType = new TaskType();

        taskType.setId( taskTypeInfoDto.getId() );
        taskType.setName( taskTypeInfoDto.getName() );

        return taskType;
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

    protected Attempt attemptViewDtoToAttempt(AttemptViewDto attemptViewDto) {
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

    protected Attempt attemptDetailDtoToAttempt(AttemptDetailDto attemptDetailDto) {
        if ( attemptDetailDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptDetailDto.getId() );
        attempt.setPupilsAttempts( fromPupilAttemptDto( attemptDetailDto.getPupilsAttempts() ) );
        attempt.setTask( taskDetailDtoToTask( attemptDetailDto.getTask() ) );
        attempt.setStart( attemptDetailDto.getStart() );
        attempt.setEnd( attemptDetailDto.getEnd() );

        return attempt;
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

    protected Attempt attemptInfoDtoToAttempt(AttemptInfoDto attemptInfoDto) {
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

    protected Attempt attemptMinInfoDtoToAttempt(AttemptMinInfoDto attemptMinInfoDto) {
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

    protected AttemptDetailDto attemptToAttemptDetailDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptDetailDto attemptDetailDto = new AttemptDetailDto();

        attemptDetailDto.setId( attempt.getId() );
        attemptDetailDto.setTask( taskToTaskDetailDto( attempt.getTask() ) );
        attemptDetailDto.setPupilsAttempts( toPupilAttemptDto( attempt.getPupilsAttempts() ) );
        attemptDetailDto.setStart( attempt.getStart() );
        attemptDetailDto.setEnd( attempt.getEnd() );

        return attemptDetailDto;
    }
}
