package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.pupils.Pupil;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PupilMapper {

    PupilMapper INSTANCE = Mappers.getMapper(PupilMapper.class);

    Pupil fromPupilInfoDto(PupilInfoDto pupilInfoDto);

    Pupil fromPupilDetailDto(PupilDetailDto pupilDetailDto);

    Pupil fromPupilAddDto(PupilAddDto pupilAddDto);

    List<Pupil> fromPupilsInfoDto(List<PupilInfoDto> pupilsInfoDto);

    PupilInfoDto toPupilInfoDto(Pupil pupil);

    List<PupilInfoDto> toPupilsInfoDto(List<Pupil> pupilsInfoDto);

    PupilDetailDto toPupilDetailDto(Pupil pupil);

    PupilAddDto toPupilAddDto(Pupil pupil);
}