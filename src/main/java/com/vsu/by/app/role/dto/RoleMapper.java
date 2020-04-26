package com.vsu.by.app.role.dto;

import com.vsu.by.app.role.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role fromRoleDto(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<RoleDto> toRoleDto(List<Role> role);
}
