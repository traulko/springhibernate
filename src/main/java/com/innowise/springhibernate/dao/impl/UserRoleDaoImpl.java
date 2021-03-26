package com.innowise.springhibernate.dao.impl;

import com.innowise.springhibernate.dao.AbstractGenericDao;
import com.innowise.springhibernate.dao.UserRoleDao;
import com.innowise.springhibernate.entities.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl extends AbstractGenericDao<UserRole> implements UserRoleDao {
}
