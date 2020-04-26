package com.vsu.by.app.people.pupils.dto;

import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.groups.dto.GroupDetailDto;
import com.vsu.by.app.people.groups.dto.GroupInfoDto;
import com.vsu.by.app.people.pupils.Pupil;
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
public class PupilMapperImpl implements PupilMapper {

    @Override
    public Pupil fromPupilInfoDto(PupilInfoDto pupilInfoDto) {
        if ( pupilInfoDto == null ) {
            return null;
        }

        Pupil pupil = new Pupil();

        pupil.setId( pupilInfoDto.getId() );
        pupil.setName( pupilInfoDto.getName() );
        pupil.setSurname( pupilInfoDto.getSurname() );
        pupil.setPatronymic( pupilInfoDto.getPatronymic() );
        pupil.setLogin( pupilInfoDto.getLogin() );
        pupil.setRole( roleDtoToRole( pupilInfoDto.getRole() ) );
        pupil.setGroup( groupInfoDtoToGroup( pupilInfoDto.getGroup() ) );

        return pupil;
    }

    @Override
    public Pupil fromPupilDetailDto(PupilDetailDto pupilDetailDto) {
        if ( pupilDetailDto == null ) {
            return null;
        }

        Pupil pupil = new Pupil();

        pupil.setId( pupilDetailDto.getId() );
        pupil.setName( pupilDetailDto.getName() );
        pupil.setSurname( pupilDetailDto.getSurname() );
        pupil.setPatronymic( pupilDetailDto.getPatronymic() );
        pupil.setLogin( pupilDetailDto.getLogin() );
        pupil.setPassword( pupilDetailDto.getPassword() );
        pupil.setRole( roleDtoToRole( pupilDetailDto.getRole() ) );
        pupil.setGroup( groupInfoDtoToGroup( pupilDetailDto.getGroup() ) );

        return pupil;
    }

    @Override
    public Pupil fromPupilAddDto(PupilAddDto pupilAddDto) {
        if ( pupilAddDto == null ) {
            return null;
        }

        Pupil pupil = new Pupil();

        pupil.setId( pupilAddDto.getId() );
        pupil.setName( pupilAddDto.getName() );
        pupil.setSurname( pupilAddDto.getSurname() );
        pupil.setPatronymic( pupilAddDto.getPatronymic() );
        pupil.setLogin( pupilAddDto.getLogin() );
        pupil.setPassword( pupilAddDto.getPassword() );
        pupil.setRole( roleDtoToRole( pupilAddDto.getRole() ) );
        pupil.setGroup( groupDetailDtoToGroup( pupilAddDto.getGroup() ) );

        return pupil;
    }

    @Override
    public List<Pupil> fromPupilsInfoDto(List<PupilInfoDto> pupilsInfoDto) {
        if ( pupilsInfoDto == null ) {
            return null;
        }

        List<Pupil> list = new ArrayList<Pupil>( pupilsInfoDto.size() );
        for ( PupilInfoDto pupilInfoDto : pupilsInfoDto ) {
            list.add( fromPupilInfoDto( pupilInfoDto ) );
        }

        return list;
    }

    @Override
    public List<PupilInfoDto> toPupilsInfoDto(List<Pupil> pupilsInfoDto) {
        if ( pupilsInfoDto == null ) {
            return null;
        }

        List<PupilInfoDto> list = new ArrayList<PupilInfoDto>( pupilsInfoDto.size() );
        for ( Pupil pupil : pupilsInfoDto ) {
            list.add( toPupilInfoDto( pupil ) );
        }

        return list;
    }

    @Override
    public PupilDetailDto toPupilDetailDto(Pupil pupil) {
        if ( pupil == null ) {
            return null;
        }

        PupilDetailDto pupilDetailDto = new PupilDetailDto();

        pupilDetailDto.setId( pupil.getId() );
        pupilDetailDto.setLogin( pupil.getLogin() );
        pupilDetailDto.setPassword( pupil.getPassword() );
        pupilDetailDto.setName( pupil.getName() );
        pupilDetailDto.setSurname( pupil.getSurname() );
        pupilDetailDto.setPatronymic( pupil.getPatronymic() );
        pupilDetailDto.setRole( roleToRoleDto( pupil.getRole() ) );
        pupilDetailDto.setGroup( groupToGroupInfoDto( pupil.getGroup() ) );

        return pupilDetailDto;
    }

    @Override
    public List<PupilDetailDto> toPupilDetailDto(List<Pupil> pupil) {
        if ( pupil == null ) {
            return null;
        }

        List<PupilDetailDto> list = new ArrayList<PupilDetailDto>( pupil.size() );
        for ( Pupil pupil1 : pupil ) {
            list.add( toPupilDetailDto( pupil1 ) );
        }

        return list;
    }

    @Override
    public PupilAddDto toPupilAddDto(Pupil pupil) {
        if ( pupil == null ) {
            return null;
        }

        PupilAddDto pupilAddDto = new PupilAddDto();

        pupilAddDto.setId( pupil.getId() );
        pupilAddDto.setLogin( pupil.getLogin() );
        pupilAddDto.setPassword( pupil.getPassword() );
        pupilAddDto.setName( pupil.getName() );
        pupilAddDto.setSurname( pupil.getSurname() );
        pupilAddDto.setPatronymic( pupil.getPatronymic() );
        pupilAddDto.setRole( roleToRoleDto( pupil.getRole() ) );
        pupilAddDto.setGroup( groupToGroupDetailDto( pupil.getGroup() ) );

        return pupilAddDto;
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

    protected Group groupInfoDtoToGroup(GroupInfoDto groupInfoDto) {
        if ( groupInfoDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupInfoDto.getId() );
        group.setGroupNo( groupInfoDto.getGroupNo() );
        group.setFaculty( groupInfoDto.getFaculty() );
        group.setCourse( groupInfoDto.getCourse() );

        return group;
    }

    protected Group groupDetailDtoToGroup(GroupDetailDto groupDetailDto) {
        if ( groupDetailDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDetailDto.getId() );
        group.setGroupNo( groupDetailDto.getGroupNo() );
        group.setFaculty( groupDetailDto.getFaculty() );
        group.setCourse( groupDetailDto.getCourse() );
        group.setPupils( fromPupilsInfoDto( groupDetailDto.getPupils() ) );

        return group;
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

    protected GroupInfoDto groupToGroupInfoDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupInfoDto groupInfoDto = new GroupInfoDto();

        groupInfoDto.setId( group.getId() );
        groupInfoDto.setFaculty( group.getFaculty() );
        groupInfoDto.setCourse( group.getCourse() );
        groupInfoDto.setGroupNo( group.getGroupNo() );

        return groupInfoDto;
    }

    protected GroupDetailDto groupToGroupDetailDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDetailDto groupDetailDto = new GroupDetailDto();

        groupDetailDto.setId( group.getId() );
        groupDetailDto.setGroupNo( group.getGroupNo() );
        groupDetailDto.setFaculty( group.getFaculty() );
        groupDetailDto.setCourse( group.getCourse() );
        groupDetailDto.setPupils( toPupilsInfoDto( group.getPupils() ) );

        return groupDetailDto;
    }
}
