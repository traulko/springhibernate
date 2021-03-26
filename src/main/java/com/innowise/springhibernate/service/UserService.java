package com.innowise.springhibernate.service;

import com.innowise.springhibernate.dto.UserDto;
import com.innowise.springhibernate.dto.UserRoleDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends BaseService<UserDto> {
    void add(UserDto userDto);

    void addRole(UserRoleDto userRoleDto);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void addUserRoleToUser(Long userId, Long roleId);
}
