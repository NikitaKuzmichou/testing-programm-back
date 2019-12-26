package com.vsu.by.app.people.user.dto;

import com.vsu.by.app.people.user.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromUserDetailDto(UserDetailDto userDetailDto) {
        if ( userDetailDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDetailDto.getId() );
        user.setName( userDetailDto.getName() );
        user.setSurname( userDetailDto.getSurname() );
        user.setPatronymic( userDetailDto.getPatronymic() );
        user.setLogin( userDetailDto.getLogin() );
        user.setPassword( userDetailDto.getPassword() );
        user.setRole( roleDtoToRole( userDetailDto.getRole() ) );

        return user;
    }

    @Override
    public User fromUserInfoDto(UserInfoDto userInfoDto) {
        if ( userInfoDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userInfoDto.getId() );
        user.setName( userInfoDto.getName() );
        user.setSurname( userInfoDto.getSurname() );
        user.setPatronymic( userInfoDto.getPatronymic() );
        user.setLogin( userInfoDto.getLogin() );
        user.setRole( roleDtoToRole( userInfoDto.getRole() ) );

        return user;
    }

    @Override
    public UserDetailDto toUserDetailDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailDto userDetailDto = new UserDetailDto();

        userDetailDto.setId( user.getId() );
        userDetailDto.setLogin( user.getLogin() );
        userDetailDto.setPassword( user.getPassword() );
        userDetailDto.setName( user.getName() );
        userDetailDto.setSurname( user.getSurname() );
        userDetailDto.setPatronymic( user.getPatronymic() );
        userDetailDto.setRole( roleToRoleDto( user.getRole() ) );

        return userDetailDto;
    }

    @Override
    public UserInfoDto toUserInfoDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserInfoDto userInfoDto = new UserInfoDto();

        userInfoDto.setId( user.getId() );
        userInfoDto.setLogin( user.getLogin() );
        userInfoDto.setName( user.getName() );
        userInfoDto.setSurname( user.getSurname() );
        userInfoDto.setPatronymic( user.getPatronymic() );
        userInfoDto.setRole( roleToRoleDto( user.getRole() ) );

        return userInfoDto;
    }

    @Override
    public List<UserInfoDto> toUserInfoDto(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserInfoDto> list = new ArrayList<UserInfoDto>( user.size() );
        for ( User user1 : user ) {
            list.add( toUserInfoDto( user1 ) );
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
