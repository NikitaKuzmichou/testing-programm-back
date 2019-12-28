package com.vsu.by.app.people.teacher.dto;

import com.vsu.by.app.people.teacher.Teacher;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher fromTeacherDetailDto(TeacherDetailDto teacherDetailDto);

    Teacher fromTeacherInfoDto(TeacherInfoDto teacherInfoDto);

    TeacherDetailDto toTeacherDetailDto(Teacher teacher);

    TeacherInfoDto toTeacherInfoDto(Teacher teacher);

    List<TeacherInfoDto> toTeacherInfoDto(List<Teacher> teachers);
}
