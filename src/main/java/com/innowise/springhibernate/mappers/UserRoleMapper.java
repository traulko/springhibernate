package com.innowise.springhibernate.mappers;

import com.innowise.springhibernate.dto.UserRoleDto;
import com.innowise.springhibernate.entities.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    UserRoleDto userRoleToUserRoleDto(UserRole userRole);

    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);
}