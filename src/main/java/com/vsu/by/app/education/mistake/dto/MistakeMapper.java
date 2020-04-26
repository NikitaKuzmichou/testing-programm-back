package com.vsu.by.app.education.mistake.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MistakeMapper {

    MistakeMapper INSTANCE = Mappers.getMapper(MistakeMapper.class);
}
