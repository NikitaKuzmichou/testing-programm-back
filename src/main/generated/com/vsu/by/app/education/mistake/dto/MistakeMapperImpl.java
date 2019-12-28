package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.attempt.Attempt;
import com.vsu.by.app.education.attempt.dto.AttemptDetailDto;
import com.vsu.by.app.education.attempt.dto.AttemptInfoDto;
import com.vsu.by.app.education.mistake.Mistake;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptDetailDto;
import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptInfoDto;
import com.vsu.by.app.education.rule.Rule;
import com.vsu.by.app.education.rule.dto.RuleDetailDto;
import com.vsu.by.app.education.rule.dto.RuleInfoDto;
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
public class MistakeMapperImpl implements MistakeMapper {

    @Override
    public Mistake fromMistakeAddEditDto(MistakeAddEditDto mistakeAddEditDto) {
        if ( mistakeAddEditDto == null ) {
            return null;
        }

        Mistake mistake = new Mistake();

        mistake.setId( mistakeAddEditDto.getId() );
        mistake.setPupilAttempt( pupilAttemptInfoDtoToPupilAttempt( mistakeAddEditDto.getPupilAttempt() ) );
        mistake.setRule( ruleInfoDtoToRule( mistakeAddEditDto.getRule() ) );
        mistake.setRowNo( mistakeAddEditDto.getRowNo() );
        mistake.setColNo( mistakeAddEditDto.getColNo() );

        return mistake;
    }

    @Override
    public Mistake fromMistakeDetailDto(MistakeDetailDto mistakeDetailDto) {
        if ( mistakeDetailDto == null ) {
            return null;
        }

        Mistake mistake = new Mistake();

        mistake.setId( mistakeDetailDto.getId() );
        mistake.setPupilAttempt( pupilAttemptDetailDtoToPupilAttempt( mistakeDetailDto.getPupilAttempt() ) );
        mistake.setRule( ruleDetailDtoToRule( mistakeDetailDto.getRule() ) );
        mistake.setRowNo( mistakeDetailDto.getRowNo() );
        mistake.setColNo( mistakeDetailDto.getColNo() );

        return mistake;
    }

    @Override
    public Mistake fromMistakeInfoDto(MistakeInfoDto mistakeInfoDto) {
        if ( mistakeInfoDto == null ) {
            return null;
        }

        Mistake mistake = new Mistake();

        mistake.setId( mistakeInfoDto.getId() );
        mistake.setPupilAttempt( pupilAttemptInfoDtoToPupilAttempt( mistakeInfoDto.getPupilAttempt() ) );
        mistake.setRule( ruleInfoDtoToRule( mistakeInfoDto.getRule() ) );
        mistake.setRowNo( mistakeInfoDto.getRowNo() );
        mistake.setColNo( mistakeInfoDto.getColNo() );

        return mistake;
    }

    @Override
    public MistakeAddEditDto toMistakeAddEditDto(Mistake pupilMistake) {
        if ( pupilMistake == null ) {
            return null;
        }

        MistakeAddEditDto mistakeAddEditDto = new MistakeAddEditDto();

        mistakeAddEditDto.setId( pupilMistake.getId() );
        mistakeAddEditDto.setPupilAttempt( pupilAttemptToPupilAttemptInfoDto( pupilMistake.getPupilAttempt() ) );
        mistakeAddEditDto.setRule( ruleToRuleInfoDto( pupilMistake.getRule() ) );
        mistakeAddEditDto.setRowNo( pupilMistake.getRowNo() );
        mistakeAddEditDto.setColNo( pupilMistake.getColNo() );

        return mistakeAddEditDto;
    }

    @Override
    public MistakeDetailDto toMistakeDetailDto(Mistake pupilMistake) {
        if ( pupilMistake == null ) {
            return null;
        }

        MistakeDetailDto mistakeDetailDto = new MistakeDetailDto();

        mistakeDetailDto.setId( pupilMistake.getId() );
        mistakeDetailDto.setPupilAttempt( pupilAttemptToPupilAttemptDetailDto( pupilMistake.getPupilAttempt() ) );
        mistakeDetailDto.setRule( ruleToRuleDetailDto( pupilMistake.getRule() ) );
        mistakeDetailDto.setRowNo( pupilMistake.getRowNo() );
        mistakeDetailDto.setColNo( pupilMistake.getColNo() );

        return mistakeDetailDto;
    }

    @Override
    public MistakeInfoDto toMistakeInfoDto(Mistake pupilMistake) {
        if ( pupilMistake == null ) {
            return null;
        }

        MistakeInfoDto mistakeInfoDto = new MistakeInfoDto();

        mistakeInfoDto.setId( pupilMistake.getId() );
        mistakeInfoDto.setPupilAttempt( pupilAttemptToPupilAttemptInfoDto( pupilMistake.getPupilAttempt() ) );
        mistakeInfoDto.setRule( ruleToRuleInfoDto( pupilMistake.getRule() ) );
        mistakeInfoDto.setRowNo( pupilMistake.getRowNo() );
        mistakeInfoDto.setColNo( pupilMistake.getColNo() );

        return mistakeInfoDto;
    }

    @Override
    public List<MistakeInfoDto> toMistakeInfoDto(List<Mistake> pupilsMistakes) {
        if ( pupilsMistakes == null ) {
            return null;
        }

        List<MistakeInfoDto> list = new ArrayList<MistakeInfoDto>( pupilsMistakes.size() );
        for ( Mistake mistake : pupilsMistakes ) {
            list.add( toMistakeInfoDto( mistake ) );
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

    protected PupilAttempt pupilAttemptInfoDtoToPupilAttempt(PupilAttemptInfoDto pupilAttemptInfoDto) {
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

    protected Rule ruleInfoDtoToRule(RuleInfoDto ruleInfoDto) {
        if ( ruleInfoDto == null ) {
            return null;
        }

        Rule rule = new Rule();

        rule.setId( ruleInfoDto.getId() );
        rule.setName( ruleInfoDto.getName() );

        return rule;
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

    protected Rule ruleDetailDtoToRule(RuleDetailDto ruleDetailDto) {
        if ( ruleDetailDto == null ) {
            return null;
        }

        Rule rule = new Rule();

        rule.setId( ruleDetailDto.getId() );
        rule.setName( ruleDetailDto.getName() );
        rule.setDescription( ruleDetailDto.getDescription() );
        rule.setNote( ruleDetailDto.getNote() );

        return rule;
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

    protected PupilAttemptInfoDto pupilAttemptToPupilAttemptInfoDto(PupilAttempt pupilAttempt) {
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

    protected RuleInfoDto ruleToRuleInfoDto(Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RuleInfoDto ruleInfoDto = new RuleInfoDto();

        ruleInfoDto.setId( rule.getId() );
        ruleInfoDto.setName( rule.getName() );

        return ruleInfoDto;
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

    protected AttemptDetailDto attemptToAttemptDetailDto(Attempt attempt) {
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

    protected RuleDetailDto ruleToRuleDetailDto(Rule rule) {
        if ( rule == null ) {
            return null;
        }

        RuleDetailDto ruleDetailDto = new RuleDetailDto();

        ruleDetailDto.setId( rule.getId() );
        ruleDetailDto.setName( rule.getName() );
        ruleDetailDto.setDescription( rule.getDescription() );
        ruleDetailDto.setNote( rule.getNote() );

        return ruleDetailDto;
    }
}
