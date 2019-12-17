package com.vsu.by.app.groups.dto;

import com.vsu.by.app.groups.Group;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group fromGroupDetail(GroupDetailDto groupDetailDto);

    Group fromGroupDetailDto(GroupInfoDto groupInfoDto);

    List<Group> fromGroupDetailDto(List<GroupDetailDto> groupDetailDto);

    GroupDetailDto toGroupDetailDto(Group group);

    GroupInfoDto toGroupInfoDto(Group group);

    List<GroupInfoDto> toGroupInfoDto(List<Group> group);

    List<GroupDetailDto> toGroupDetailDto(List<Group> groups);
}
