package com.vsu.by.app.role.dto;

import com.vsu.by.app.role.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role fromRoleDto(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    @Override
    public RoleDto toRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );

        return roleDto;
    }

    @Override
    public List<RoleDto> toRoleDto(List<Role> role) {
        if ( role == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( role.size() );
        for ( Role role1 : role ) {
            list.add( toRoleDto( role1 ) );
        }

        return list;
    }
}
