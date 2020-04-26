package com.vsu.by.app.education.pupilattempt.dto;

import com.vsu.by.app.education.attempt.dto.AttemptMapper;
import com.vsu.by.app.education.pupilattempt.PupilAttempt;
import com.vsu.by.app.education.pupilmistake.dto.PupilMistakeMapper;
import com.vsu.by.app.people.pupils.dto.PupilMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PupilAttemptMapper {

    PupilAttemptMapper INSTANCE = Mappers.getMapper(PupilAttemptMapper.class);

    PupilAttempt fromPupilAttemptDto(PupilAttemptDto pupilAttemptDto);

    PupilAttempt fromPupilAttemptViewDto(PupilAttemptViewDto pupilAttemptViewDto);

    List<PupilAttempt> fromPupilAttemptDto(List<PupilAttemptDto> pupilAttemptDto);

    PupilAttempt fromPupilAttemptDetailDto(PupilAttemptDetailDto pupilAttemptDetailDto);

    PupilAttempt fromPupilAttemptInfoDto(PupilAttemptInfoDto pupilAttemptInfoDto);

    List<PupilAttempt> fromPupilAttemptInfoDto(List<PupilAttemptInfoDto> pupilAttemptInfoDto);

    PupilAttempt fromPupilAttemptMinInfoDto(PupilAttemptMinInfoDto pupilAttemptMinInfoDto);

    PupilAttemptDto toPupilAttemptDto(PupilAttempt pupilAttempt);

    List<PupilAttemptDto> toPupilAttemptDto(List<PupilAttempt> pupilAttempt);

    PupilAttemptDetailDto toPupilAttemptDetailDto(PupilAttempt pupilAttempt);

    default PupilAttemptViewDto toPupilAttemptViewDto(PupilAttempt pupilAttempt) {
        PupilAttemptViewDto pupilAttemptViewDto = new PupilAttemptViewDto();
        pupilAttemptViewDto.setId(pupilAttempt.getId());
        pupilAttemptViewDto.setAttempt(
                AttemptMapper.INSTANCE.toAttemptViewDto(pupilAttempt.getAttempt()));
        pupilAttemptViewDto.setMark(pupilAttempt.getMark());
        pupilAttemptViewDto.setMistakes(
                PupilMistakeMapper.INSTANCE.toPupilMistakeInfoDto(pupilAttempt.getPupilMistakes()));
        pupilAttemptViewDto.setPupil(
                PupilMapper.INSTANCE.toPupilInfoDto(pupilAttempt.getPupil()));
        pupilAttemptViewDto.setText(pupilAttempt.getText());
        return pupilAttemptViewDto;
    }

    default PupilAttemptInfoDto toPupilAttemptInfoDto(PupilAttempt pupilAttempt) {
        PupilAttemptInfoDto pupilAttemptInfoDto = new PupilAttemptInfoDto();
        pupilAttemptInfoDto.setId(pupilAttempt.getId());
        pupilAttemptInfoDto.setAttempt(
                AttemptMapper.INSTANCE.toAttemptInfoDto(pupilAttempt.getAttempt()));
        pupilAttemptInfoDto.setMark(pupilAttempt.getMark());
        pupilAttemptInfoDto.setPupil(
                PupilMapper.INSTANCE.toPupilInfoDto(pupilAttempt.getPupil()));
        pupilAttemptInfoDto.setText(pupilAttempt.getText());
        return pupilAttemptInfoDto;
    }

    default List<PupilAttemptInfoDto> toPupilAttemptInfoDto(List<PupilAttempt> pupilsAttempts) {
        List<PupilAttemptInfoDto> pupilAttempts = new LinkedList<>();
        pupilsAttempts.forEach(pupilAttempt -> {
            pupilAttempts.add(this.toPupilAttemptInfoDto(pupilAttempt));
        });
        return pupilAttempts;
    }

    default PupilAttemptMinInfoDto toPupilAttemptMinInfoDto(PupilAttempt pupilAttempt) {
        PupilAttemptMinInfoDto pupilAttemptsMinInfo = new PupilAttemptMinInfoDto();
        pupilAttemptsMinInfo.setId(pupilAttempt.getId());
        pupilAttemptsMinInfo.setMark(pupilAttempt.getMark());
        pupilAttemptsMinInfo.setPupil(
                PupilMapper.INSTANCE.toPupilInfoDto(pupilAttempt.getPupil()));
        pupilAttemptsMinInfo.setAttempt(
                AttemptMapper.INSTANCE.toAttemptMinInfoDto(pupilAttempt.getAttempt()));
        return pupilAttemptsMinInfo;
    }

    default List<PupilAttemptMinInfoDto> toPupilAttemptMinInfoDto(List<PupilAttempt> pupilsAttempts) {
        List<PupilAttemptMinInfoDto> pupilAttempts = new LinkedList<>();
        pupilsAttempts.forEach(pupilAttempt -> {
            pupilAttempts.add(this.toPupilAttemptMinInfoDto(pupilAttempt));
        });
        return pupilAttempts;
    }
}
