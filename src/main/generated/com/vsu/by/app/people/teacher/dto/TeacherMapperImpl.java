package com.vsu.by.app.people.teacher.dto;

import com.vsu.by.app.people.teacher.Teacher;
import com.vsu.by.app.role.Role;
import com.vsu.by.app.role.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public Teacher fromTeacherDetailDto(TeacherDetailDto teacherDetailDto) {
        if ( teacherDetailDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDetailDto.getId() );
        teacher.setName( teacherDetailDto.getName() );
        teacher.setSurname( teacherDetailDto.getSurname() );
        teacher.setPatronymic( teacherDetailDto.getPatronymic() );
        teacher.setLogin( teacherDetailDto.getLogin() );
        teacher.setPassword( teacherDetailDto.getPassword() );
        teacher.setRole( roleDtoToRole( teacherDetailDto.getRole() ) );

        return teacher;
    }

    @Override
    public Teacher fromTeacherInfoDto(TeacherInfoDto teacherInfoDto) {
        if ( teacherInfoDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherInfoDto.getId() );
        teacher.setName( teacherInfoDto.getName() );
        teacher.setSurname( teacherInfoDto.getSurname() );
        teacher.setPatronymic( teacherInfoDto.getPatronymic() );
        teacher.setLogin( teacherInfoDto.getLogin() );
        teacher.setRole( roleDtoToRole( teacherInfoDto.getRole() ) );

        return teacher;
    }

    @Override
    public TeacherDetailDto toTeacherDetailDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDetailDto teacherDetailDto = new TeacherDetailDto();

        teacherDetailDto.setId( teacher.getId() );
        teacherDetailDto.setLogin( teacher.getLogin() );
        teacherDetailDto.setPassword( teacher.getPassword() );
        teacherDetailDto.setName( teacher.getName() );
        teacherDetailDto.setSurname( teacher.getSurname() );
        teacherDetailDto.setPatronymic( teacher.getPatronymic() );
        teacherDetailDto.setRole( roleToRoleDto( teacher.getRole() ) );

        return teacherDetailDto;
    }

    @Override
    public TeacherInfoDto toTeacherInfoDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherInfoDto teacherInfoDto = new TeacherInfoDto();

        teacherInfoDto.setId( teacher.getId() );
        teacherInfoDto.setLogin( teacher.getLogin() );
        teacherInfoDto.setName( teacher.getName() );
        teacherInfoDto.setSurname( teacher.getSurname() );
        teacherInfoDto.setPatronymic( teacher.getPatronymic() );
        teacherInfoDto.setRole( roleToRoleDto( teacher.getRole() ) );

        return teacherInfoDto;
    }

    @Override
    public List<TeacherInfoDto> toTeacherInfoDto(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherInfoDto> list = new ArrayList<TeacherInfoDto>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( toTeacherInfoDto( teacher ) );
        }

        return list;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }
}
