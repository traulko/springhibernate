package com.innowise.springhibernate.dao.impl;

import com.innowise.springhibernate.dao.AbstractGenericDao;
import com.innowise.springhibernate.dao.EmployerDao;
import com.innowise.springhibernate.entities.Employer;
import org.springframework.stereotype.Repository;

@Repository
public class EmployerDaoImpl extends AbstractGenericDao<Employer> implements EmployerDao {
}
