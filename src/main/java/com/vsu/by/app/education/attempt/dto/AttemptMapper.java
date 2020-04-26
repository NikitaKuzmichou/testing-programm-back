package com.vsu.by.app.education.attempt.dto;

import com.vsu.by.app.education.pupilattempt.dto.PupilAttemptMapper;
import com.vsu.by.app.education.task.dto.TaskMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vsu.by.app.education.attempt.*;

import java.util.LinkedList;
import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AttemptMapper {

    AttemptMapper INSTANCE = Mappers.getMapper(AttemptMapper.class);

    Attempt fromAttemptAddEditDto(AttemptAddEditDto attemptAddEditDto);

    Attempt fromAttemptViewDto(AttemptViewDto attemptViewDto);

    default Attempt fromAttemptDetailDto(AttemptDetailDto attemptDetailDto) {
        Attempt attempt = new Attempt();
        attempt.setId(attemptDetailDto.getId());
        attempt.setPupilsAttempts(
                PupilAttemptMapper.INSTANCE.fromPupilAttemptDto(attemptDetailDto.getPupilsAttempts()));
        attempt.setStart(attemptDetailDto.getStart());
        attempt.setEnd(attemptDetailDto.getEnd());
        attempt.setTask(TaskMapper.INSTANCE.fromTaskDetailDto(attemptDetailDto.getTask()));
        return attempt;
    }

    Attempt fromAttemptInfoDto(AttemptInfoDto attemptInfoDto);

    List<Attempt> fromAttemptInfoDto(List<AttemptInfoDto> attemptInfoDto);

    Attempt fromAttemptMinInfoDto(AttemptMinInfoDto attemptMinInfoDto);

    List<Attempt> fromAttemptMinInfoDto(List<AttemptMinInfoDto> attemptMinInfoDto);

    AttemptAddEditDto toAttemptAddEditDto(Attempt attempt);

    AttemptViewDto toAttemptViewDto(Attempt attempt);

    default AttemptDetailDto toAttemptDetailDto(Attempt attempt) {
        AttemptDetailDto attemptDetailDto = new AttemptDetailDto();
        attemptDetailDto.setId(attempt.getId());
        attemptDetailDto.setStart(attempt.getStart());
        attemptDetailDto.setEnd(attempt.getEnd());
        attemptDetailDto.setPupilsAttempts(
                PupilAttemptMapper.INSTANCE.toPupilAttemptDto(attempt.getPupilsAttempts()));
        attemptDetailDto.setTask(TaskMapper.INSTANCE.toTaskDetailDto(attempt.getTask()));
        return  attemptDetailDto;
    }

    default AttemptInfoDto toAttemptInfoDto(Attempt attempt) {
        AttemptInfoDto attemptInfoDto = new AttemptInfoDto();
        attemptInfoDto.setId(attempt.getId());
        attemptInfoDto.setStart(attempt.getStart());
        attemptInfoDto.setEnd(attempt.getEnd());
        attemptInfoDto.setTask(TaskMapper.INSTANCE.toTaskInfoDto(attempt.getTask()));
        return attemptInfoDto;
    }

    default List<AttemptInfoDto> toAttemptInfoDto(List<Attempt> attempts) {
        List<AttemptInfoDto> attemptInfoDto = new LinkedList<>();
        attempts.forEach(attempt -> {
            attemptInfoDto.add(this.toAttemptInfoDto(attempt));
        });
        return attemptInfoDto;
    }

    default AttemptMinInfoDto toAttemptMinInfoDto(Attempt attempt) {
        AttemptMinInfoDto attemptMinInfo = new AttemptMinInfoDto();
        attemptMinInfo.setId(attempt.getId());
        attemptMinInfo.setStart(attempt.getStart());
        attemptMinInfo.setEnd(attempt.getEnd());
        attemptMinInfo.setTask(TaskMapper.INSTANCE.toTaskMinInfoDto(attempt.getTask()));
        return attemptMinInfo;
    }

    default List<AttemptMinInfoDto> toAttemptMinInfoDto(List<Attempt> attempts) {
        List<AttemptMinInfoDto> attemptsMinInfo = new LinkedList<>();
        attempts.forEach(attempt -> {
            attemptsMinInfo.add(this.toAttemptMinInfoDto(attempt));
        });
        return attemptsMinInfo;
    }
}
