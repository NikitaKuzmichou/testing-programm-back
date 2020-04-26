package com.vsu.by.app.people.groups.dto;

import com.vsu.by.app.people.groups.Group;
import com.vsu.by.app.people.pupils.Pupil;
import com.vsu.by.app.people.pupils.dto.PupilInfoDto;
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
public class GroupMapperImpl implements GroupMapper {

    @Override
    public Group fromGroupDetail(GroupDetailDto groupDetailDto) {
        if ( groupDetailDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDetailDto.getId() );
        group.setGroupNo( groupDetailDto.getGroupNo() );
        group.setFaculty( groupDetailDto.getFaculty() );
        group.setCourse( groupDetailDto.getCourse() );
        group.setPupils( pupilInfoDtoListToPupilList( groupDetailDto.getPupils() ) );

        return group;
    }

    @Override
    public Group fromGroupDetailDto(GroupInfoDto groupInfoDto) {
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

    @Override
    public List<Group> fromGroupDetailDto(List<GroupDetailDto> groupDetailDto) {
        if ( groupDetailDto == null ) {
            return null;
        }

        List<Group> list = new ArrayList<Group>( groupDetailDto.size() );
        for ( GroupDetailDto groupDetailDto1 : groupDetailDto ) {
            list.add( fromGroupDetail( groupDetailDto1 ) );
        }

        return list;
    }

    @Override
    public GroupDetailDto toGroupDetailDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDetailDto groupDetailDto = new GroupDetailDto();

        groupDetailDto.setId( group.getId() );
        groupDetailDto.setGroupNo( group.getGroupNo() );
        groupDetailDto.setFaculty( group.getFaculty() );
        groupDetailDto.setCourse( group.getCourse() );
        groupDetailDto.setPupils( pupilListToPupilInfoDtoList( group.getPupils() ) );

        return groupDetailDto;
    }

    @Override
    public GroupInfoDto toGroupInfoDto(Group group) {
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

    @Override
    public List<GroupInfoDto> toGroupInfoDto(List<Group> group) {
        if ( group == null ) {
            return null;
        }

        List<GroupInfoDto> list = new ArrayList<GroupInfoDto>( group.size() );
        for ( Group group1 : group ) {
            list.add( toGroupInfoDto( group1 ) );
        }

        return list;
    }

    @Override
    public List<GroupDetailDto> toGroupDetailDto(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDetailDto> list = new ArrayList<GroupDetailDto>( groups.size() );
        for ( Group group : groups ) {
            list.add( toGroupDetailDto( group ) );
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

    protected Pupil pupilInfoDtoToPupil(PupilInfoDto pupilInfoDto) {
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
        pupil.setGroup( fromGroupDetailDto( pupilInfoDto.getGroup() ) );

        return pupil;
    }

    protected List<Pupil> pupilInfoDtoListToPupilList(List<PupilInfoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Pupil> list1 = new ArrayList<Pupil>( list.size() );
        for ( PupilInfoDto pupilInfoDto : list ) {
            list1.add( pupilInfoDtoToPupil( pupilInfoDto ) );
        }

        return list1;
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

    protected PupilInfoDto pupilToPupilInfoDto(Pupil pupil) {
        if ( pupil == null ) {
            return null;
        }

        PupilInfoDto pupilInfoDto = new PupilInfoDto();

        pupilInfoDto.setId( pupil.getId() );
        pupilInfoDto.setLogin( pupil.getLogin() );
        pupilInfoDto.setName( pupil.getName() );
        pupilInfoDto.setSurname( pupil.getSurname() );
        pupilInfoDto.setPatronymic( pupil.getPatronymic() );
        pupilInfoDto.setGroup( toGroupInfoDto( pupil.getGroup() ) );
        pupilInfoDto.setRole( roleToRoleDto( pupil.getRole() ) );

        return pupilInfoDto;
    }

    protected List<PupilInfoDto> pupilListToPupilInfoDtoList(List<Pupil> list) {
        if ( list == null ) {
            return null;
        }

        List<PupilInfoDto> list1 = new ArrayList<PupilInfoDto>( list.size() );
        for ( Pupil pupil : list ) {
            list1.add( pupilToPupilInfoDto( pupil ) );
        }

        return list1;
    }
}
