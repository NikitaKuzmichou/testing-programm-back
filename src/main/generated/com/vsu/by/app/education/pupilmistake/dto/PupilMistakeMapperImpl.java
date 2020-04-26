package com.vsu.by.app.education.pupilmistake.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDetailDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDto;
import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
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
public class PupilMistakeMapperImpl implements PupilMistakeMapper {

    @Override
    public PupilMistake fromPupilMistakeDetailDto(PupilMistakeDetailDto pupilMistakeDetailDto) {
        if ( pupilMistakeDetailDto == null ) {
            return null;
        }

        PupilMistake pupilMistake = new PupilMistake();

        pupilMistake.setId( pupilMistakeDetailDto.getId() );
        pupilMistake.setPupilAttempt( pupilAttemptDetailDtoToPupilAttempt( pupilMistakeDetailDto.getPupilAttempt() ) );
        pupilMistake.setWordNo( pupilMistakeDetailDto.getWordNo() );
        pupilMistake.setSymbolNo( pupilMistakeDetailDto.getSymbolNo() );

        return pupilMistake;
    }

    @Override
    public PupilMistake fromPupilMistakeInfoDto(PupilMistakeInfoDto pupilMistakeInfoDto) {
        if ( pupilMistakeInfoDto == null ) {
            return null;
        }

        PupilMistake pupilMistake = new PupilMistake();

        pupilMistake.setId( pupilMistakeInfoDto.getId() );
        pupilMistake.setWordNo( pupilMistakeInfoDto.getWordNo() );
        pupilMistake.setSymbolNo( pupilMistakeInfoDto.getSymbolNo() );

        return pupilMistake;
    }

    @Override
    public PupilMistakeDetailDto toPupilMistakeDetailDto(PupilMistake pupilMistake) {
        if ( pupilMistake == null ) {
            return null;
        }

        PupilMistakeDetailDto pupilMistakeDetailDto = new PupilMistakeDetailDto();

        pupilMistakeDetailDto.setId( pupilMistake.getId() );
        pupilMistakeDetailDto.setPupilAttempt( pupilAttemptToPupilAttemptDetailDto( pupilMistake.getPupilAttempt() ) );
        pupilMistakeDetailDto.setWordNo( pupilMistake.getWordNo() );
        pupilMistakeDetailDto.setSymbolNo( pupilMistake.getSymbolNo() );

        return pupilMistakeDetailDto;
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

    protected PupilAttempt pupilAttemptDtoToPupilAttempt(PupilAttemptDto pupilAttemptDto) {
        if ( pupilAttemptDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptDto.getPupil() ) );
        pupilAttempt.setMark( pupilAttemptDto.getMark() );

        return pupilAttempt;
    }

    protected List<PupilAttempt> pupilAttemptDtoListToPupilAttemptList(List<PupilAttemptDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilAttempt> list1 = new ArrayList<PupilAttempt>( list.size() );
        for ( PupilAttemptDto pupilAttemptDto : list ) {
            list1.add( pupilAttemptDtoToPupilAttempt( pupilAttemptDto ) );
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

    protected Attempt attemptDetailDtoToAttempt(AttemptDetailDto attemptDetailDto) {
        if ( attemptDetailDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptDetailDto.getId() );
        attempt.setPupilsAttempts( pupilAttemptDtoListToPupilAttemptList( attemptDetailDto.getPupilsAttempts() ) );
        attempt.setTask( taskDetailDtoToTask( attemptDetailDto.getTask() ) );
        attempt.setStart( attemptDetailDto.getStart() );
        attempt.setEnd( attemptDetailDto.getEnd() );

        return attempt;
    }

    protected PupilAttempt pupilAttemptDetailDtoToPupilAttempt(PupilAttemptDetailDto pupilAttemptDetailDto) {
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

    protected PupilAttemptDto pupilAttemptToPupilAttemptDto(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptDto pupilAttemptDto = new PupilAttemptDto();

        pupilAttemptDto.setId( pupilAttempt.getId() );
        pupilAttemptDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptDto;
    }

    protected List<PupilAttemptDto> pupilAttemptListToPupilAttemptDtoList(List<PupilAttempt> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilAttemptDto> list1 = new ArrayList<PupilAttemptDto>( list.size() );
        for ( PupilAttempt pupilAttempt : list ) {
            list1.add( pupilAttemptToPupilAttemptDto( pupilAttempt ) );
        }

        return list1;
    }

    protected AttemptDetailDto attemptToAttemptDetailDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptDetailDto attemptDetailDto = new AttemptDetailDto();

        attemptDetailDto.setId( attempt.getId() );
        attemptDetailDto.setTask( taskToTaskDetailDto( attempt.getTask() ) );
        attemptDetailDto.setPupilsAttempts( pupilAttemptListToPupilAttemptDtoList( attempt.getPupilsAttempts() ) );
        attemptDetailDto.setStart( attempt.getStart() );
        attemptDetailDto.setEnd( attempt.getEnd() );

        return attemptDetailDto;
    }

    protected PupilAttemptDetailDto pupilAttemptToPupilAttemptDetailDto(PupilAttempt pupilAttempt) {
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
}
