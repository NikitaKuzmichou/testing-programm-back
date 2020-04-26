package com.vsu.by.app.education.pupilmistake.dto;

import com.vsu.by.app.education.pupilmistake.PupilMistake;
import com.vsu.by.app.education.rule.dto.RuleMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PupilMistakeMapper {

    PupilMistakeMapper INSTANCE = Mappers.getMapper(PupilMistakeMapper.class);

    PupilMistake fromPupilMistakeDetailDto(PupilMistakeDetailDto pupilMistakeDetailDto);

    PupilMistake fromPupilMistakeInfoDto(PupilMistakeInfoDto pupilMistakeInfoDto);

    PupilMistakeDetailDto toPupilMistakeDetailDto(PupilMistake pupilMistake);

    default PupilMistakeInfoDto toPupilMistakeInfoDto(PupilMistake pupilMistake) {
        PupilMistakeInfoDto pupilMistakeInfoDto = new PupilMistakeInfoDto();
        pupilMistakeInfoDto.setId(pupilMistake.getId());
        if (Objects.nonNull(pupilMistake.getMistake())) {
            pupilMistakeInfoDto.setRule(RuleMapper.INSTANCE.toRuleInfoDto(pupilMistake.getMistake().getRule()));
        }
        pupilMistakeInfoDto.setSymbolNo(pupilMistake.getSymbolNo());
        pupilMistakeInfoDto.setWordNo(pupilMistake.getWordNo());
        return pupilMistakeInfoDto;
    }

    default List<PupilMistakeInfoDto> toPupilMistakeInfoDto(List<PupilMistake> pupilsMistakes) {
        List<PupilMistakeInfoDto> pupilMistakeInfoDto = new LinkedList<>();
        pupilsMistakes.forEach(pupilMistake -> {
            pupilMistakeInfoDto.add(this.toPupilMistakeInfoDto(pupilMistake));
        });
        return pupilMistakeInfoDto;
    }
}
