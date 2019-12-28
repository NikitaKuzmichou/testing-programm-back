package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
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
    public Attempt fromAttemptDetailDto(AttemptDetailDto attemptDetailDto) {
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

    @Override
    public Attempt fromAttemptInfoDto(AttemptInfoDto attemptInfoDto) {
        if ( attemptInfoDto == null ) {
            return null;
        }

        Attempt attempt = new Attempt();

        attempt.setId( attemptInfoDto.getId() );
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
    public AttemptDetailDto toAttemptDetailDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptDetailDto attemptDetailDto = new AttemptDetailDto();

        attemptDetailDto.setId( attempt.getId() );
        attemptDetailDto.setTask( taskToTaskDetailDto( attempt.getTask() ) );
        attemptDetailDto.setPupilsAttempts( pupilAttemptListToPupilAttemptInfoDtoList( attempt.getPupilsAttempts() ) );
        attemptDetailDto.setStart( attempt.getStart() );
        attemptDetailDto.setEnd( attempt.getEnd() );

        return attemptDetailDto;
    }

    @Override
    public AttemptInfoDto toAttemptInfoDto(Attempt attempt) {
        if ( attempt == null ) {
            return null;
        }

        AttemptInfoDto attemptInfoDto = new AttemptInfoDto();

        attemptInfoDto.setId( attempt.getId() );
        attemptInfoDto.setStart( attempt.getStart() );
        attemptInfoDto.setEnd( attempt.getEnd() );

        return attemptInfoDto;
    }

    @Override
    public List<AttemptInfoDto> toAttemptInfoDto(List<Attempt> attempts) {
        if ( attempts == null ) {
            return null;
        }

        List<AttemptInfoDto> list = new ArrayList<AttemptInfoDto>( attempts.size() );
        for ( Attempt attempt : attempts ) {
            list.add( toAttemptInfoDto( attempt ) );
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
}
