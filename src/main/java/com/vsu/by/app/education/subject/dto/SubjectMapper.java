package com.vsu.by.app.education.subject.dto;

import com.vsu.by.app.education.subject.Subject;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    Subject fromSubjectDto(SubjectDto subjectDto);

    SubjectDto toSubjectDto(Subject subject);

    List<SubjectDto> toSubjectDto(List<Subject> subjects);
}
