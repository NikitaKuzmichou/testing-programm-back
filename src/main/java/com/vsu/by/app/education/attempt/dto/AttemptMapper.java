package com.vsu.by.app.education.attempt.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vsu.by.app.education.attempt.*;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AttemptMapper {

    AttemptMapper INSTANCE = Mappers.getMapper(AttemptMapper.class);

    Attempt fromAttemptAddEditDto(AttemptAddEditDto attemptAddEditDto);

    Attempt fromAttemptDetailDto(AttemptDetailDto attemptDetailDto);

    Attempt fromAttemptInfoDto(AttemptInfoDto attemptInfoDto);

    List<Attempt> fromAttemptInfoDto(List<AttemptInfoDto> attemptInfoDto);

    AttemptAddEditDto toAttemptAddEditDto(Attempt attempt);

    AttemptDetailDto toAttemptDetailDto(Attempt attempt);

    AttemptInfoDto toAttemptInfoDto(Attempt attempt);

    List<AttemptInfoDto> toAttemptInfoDto(List<Attempt> attempts);
}
