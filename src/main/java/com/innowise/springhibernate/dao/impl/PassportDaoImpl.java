package com.innowise.springhibernate.dao.impl;

import com.innowise.springhibernate.dao.AbstractGenericDao;
import com.innowise.springhibernate.dao.PassportDao;
import com.innowise.springhibernate.entities.Passport;
import org.springframework.stereotype.Repository;

@Repository
public class PassportDaoImpl extends AbstractGenericDao<Passport> implements PassportDao {
}
