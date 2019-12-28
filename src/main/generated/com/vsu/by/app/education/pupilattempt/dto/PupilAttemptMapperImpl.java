package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.task.Task;
import com.vsu.by.app.education.task.dto.TaskDetailDto;
import com.vsu.by.app.education.tasktype.TaskType;
import com.vsu.by.app.education.tasktype.dto.TaskTypeInfoDto;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
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
    public PupilAttempt fromPupilAttemptAddEditDto(PupilAttemptAddEditDto pupilAttemptAddEditDto) {
        if ( pupilAttemptAddEditDto == null ) {
            return null;
        }

        PupilAttempt pupilAttempt = new PupilAttempt();

        pupilAttempt.setId( pupilAttemptAddEditDto.getId() );
        pupilAttempt.setPupil( pupilInfoDtoToPupil( pupilAttemptAddEditDto.getPupil() ) );
        pupilAttempt.setAttempt( attemptInfoDtoToAttempt( pupilAttemptAddEditDto.getAttempt() ) );
        pupilAttempt.setText( pupilAttemptAddEditDto.getText() );
        pupilAttempt.setMark( pupilAttemptAddEditDto.getMark() );

        return pupilAttempt;
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
    public PupilAttemptAddEditDto toPupilAttemptAddEdit(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptAddEditDto pupilAttemptAddEditDto = new PupilAttemptAddEditDto();

        pupilAttemptAddEditDto.setId( pupilAttempt.getId() );
        pupilAttemptAddEditDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptAddEditDto.setAttempt( attemptToAttemptInfoDto( pupilAttempt.getAttempt() ) );
        pupilAttemptAddEditDto.setText( pupilAttempt.getText() );
        pupilAttemptAddEditDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptAddEditDto;
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

    @Override
    public PupilAttemptInfoDto toPupilAttemptInfoDto(PupilAttempt pupilAttempt) {
        if ( pupilAttempt == null ) {
            return null;
        }

        PupilAttemptInfoDto pupilAttemptInfoDto = new PupilAttemptInfoDto();

        pupilAttemptInfoDto.setId( pupilAttempt.getId() );
        pupilAttemptInfoDto.setPupil( pupilToPupilInfoDto( pupilAttempt.getPupil() ) );
        pupilAttemptInfoDto.setAttempt( attemptToAttemptInfoDto( pupilAttempt.getAttempt() ) );
        pupilAttemptInfoDto.setText( pupilAttempt.getText() );
        pupilAttemptInfoDto.setMark( pupilAttempt.getMark() );

        return pupilAttemptInfoDto;
    }

    @Override
    public List<PupilAttemptInfoDto> toPupilAttemptInfoDto(List<PupilAttempt> pupilsAttempts) {
        if ( pupilsAttempts == null ) {
            return null;
        }

        List<PupilAttemptInfoDto> list = new ArrayList<PupilAttemptInfoDto>( pupilsAttempts.size() );
        for ( PupilAttempt pupilAttempt : pupilsAttempts ) {
            list.add( toPupilAttemptInfoDto( pupilAttempt ) );
        }

        return list;
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

        return pupil;
    }

    protected Attempt attemptInfoDtoToAttempt(AttemptInfoDto attemptInfoDto) {
        if ( attemptInfoDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptInfoDto.getId() );
        attempt.setStart( attemptInfoDto.getStart() );
        attempt.setEnd( attemptInfoDto.getEnd() );

        return attempt;
    }

    protected List<PupilAttempt> pupilAttemptInfoDtoListToPupilAttemptList(List<PupilAttemptInfoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilAttempt> list1 = new ArrayList<PupilAttempt>( list.size() );
        for ( PupilAttemptInfoDto pupilAttemptInfoDto : list ) {
            list1.add( fromPupilAttemptInfoDto( pupilAttemptInfoDto ) );
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
        attempt.setPupilsAttempts( pupilAttemptInfoDtoListToPupilAttemptList( attemptDetailDto.getPupilsAttempts() ) );
        attempt.setTask( taskDetailDtoToTask( attemptDetailDto.getTask() ) );
        attempt.setStart( attemptDetailDto.getStart() );
        attempt.setEnd( attemptDetailDto.getEnd() );

        return attempt;
    }

    protected PupilInfoDto pupilToPupilInfoDto(Pupil pupil) {
        if ( pupil == null ) {
            return null;
        }

        PupilInfoDto pupilInfoDto = new PupilInfoDto();

        pupilInfoDto.setId( pupil.getId() );
        pupilInfoDto.setName( pupil.getName() );
        pupilInfoDto.setSurname( pupil.getSurname() );
        pupilInfoDto.setPatronymic( pupil.getPatronymic() );

        return pupilInfoDto;
    }

    protected AttemptInfoDto attemptToAttemptInfoDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptInfoDto attemptInfoDto = new AttemptInfoDto();

        attemptInfoDto.setId( attempt.getId() );
        attemptInfoDto.setStart( attempt.getStart() );
        attemptInfoDto.setEnd( attempt.getEnd() );

        return attemptInfoDto;
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
        attemptDetailDto.setPupilsAttempts( toPupilAttemptInfoDto( attempt.getPupilsAttempts() ) );
        attemptDetailDto.setStart( attempt.getStart() );
        attemptDetailDto.setEnd( attempt.getEnd() );

        return attemptDetailDto;
    }
}
