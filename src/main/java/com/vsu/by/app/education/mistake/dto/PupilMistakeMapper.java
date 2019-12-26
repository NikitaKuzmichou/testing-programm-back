package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.mistake.PupilMistake;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PupilMistakeMapper {

    PupilMistakeMapper INSTANCE = Mappers.getMapper(PupilMistakeMapper.class);

    PupilMistake fromPupilMistakeAddEditDto(PupilMistakeAddEditDto pupilMistakeAddEditDto);

    PupilMistake fromPupilMistakeDetailDto(PupilMistakeDetailDto pupilMistakeDetailDto);

    PupilMistake fromPupilMistakeInfoDto(PupilMistakeInfoDto pupilMistakeInfoDto);

    PupilMistakeAddEditDto toPupilMistakeAddEditDto(PupilMistake pupilMistake);

    PupilMistakeDetailDto toPupilMistakeDetailDto(PupilMistake pupilMistake);

    PupilMistakeInfoDto toPupilMistakeInfoDto(PupilMistake pupilMistake);

    List<PupilMistakeInfoDto> toPupilMistakeInfoDto(List<PupilMistake> pupilMistake);
}
