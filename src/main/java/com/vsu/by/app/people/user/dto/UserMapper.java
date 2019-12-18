package com.vsu.by.app.people.user.dto;

import com.vsu.by.app.people.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromUserDetailDto(UserDetailDto userDetailDto);

    User fromUserInfoDto(UserInfoDto userInfoDto);

    UserDetailDto toUserDetailDto(User user);

    UserInfoDto toUserInfoDto(User user);
}
