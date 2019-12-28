package com.vsu.by.app.education.mistake.dto;

import com.vsu.by.app.education.mistake.Mistake;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MistakeMapper {

    MistakeMapper INSTANCE = Mappers.getMapper(MistakeMapper.class);

    Mistake fromMistakeAddEditDto(MistakeAddEditDto mistakeAddEditDto);

    Mistake fromMistakeDetailDto(MistakeDetailDto mistakeDetailDto);

    Mistake fromMistakeInfoDto(MistakeInfoDto mistakeInfoDto);

    MistakeAddEditDto toMistakeAddEditDto(Mistake pupilMistake);

    MistakeDetailDto toMistakeDetailDto(Mistake pupilMistake);

    MistakeInfoDto toMistakeInfoDto(Mistake pupilMistake);

    List<MistakeInfoDto> toMistakeInfoDto(List<Mistake> pupilsMistakes);
}
