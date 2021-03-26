package com.innowise.springhibernate.dao.impl;

import com.innowise.springhibernate.dao.AbstractGenericDao;
import com.innowise.springhibernate.dao.UserDao;
import com.innowise.springhibernate.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractGenericDao<User> implements UserDao {
}
