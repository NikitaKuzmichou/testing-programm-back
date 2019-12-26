package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PupilAttemptMapper {

    PupilAttemptMapper INSTANCE = Mappers.getMapper(PupilAttemptMapper.class);

    PupilAttempt fromPupilAttemptAddEditDto(PupilAttemptAddEditDto pupilAttemptAddEditDto);

    PupilAttempt fromPupilAttemptDetailDto(PupilAttemptDetailDto pupilAttemptDetailDto);

    PupilAttempt fromPupilAttemptInfoDto(PupilAttemptInfoDto pupilAttemptInfoDto);

    PupilAttemptAddEditDto toPupilAttemptAddEdit(PupilAttempt pupilAttempt);

    PupilAttemptDetailDto toPupilAttemptDetailDto(PupilAttempt pupilAttempt);

    PupilAttemptInfoDto toPupilAttemptInfoDto(PupilAttempt pupilAttempt);

    List<PupilAttemptInfoDto> toPupilAttemptInfoDto(List<PupilAttempt> pupilsAttempts);
}
