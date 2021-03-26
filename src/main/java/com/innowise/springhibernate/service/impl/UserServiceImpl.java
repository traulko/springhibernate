package com.innowise.springhibernate.service.impl;

import com.innowise.springhibernate.dao.UserDao;
import com.innowise.springhibernate.dao.UserRoleDao;
import com.innowise.springhibernate.dto.UserDto;
import com.innowise.springhibernate.dto.UserRoleDto;
import com.innowise.springhibernate.entities.User;
import com.innowise.springhibernate.entities.UserRole;
import com.innowise.springhibernate.exception.ApiException;
import com.innowise.springhibernate.mappers.UserMapper;
import com.innowise.springhibernate.mappers.UserRoleMapper;
import com.innowise.springhibernate.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;
    private final SessionFactory sessionFactory;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao, SessionFactory sessionFactory) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UserDto userDto) {
        userDao.save(UserMapper.INSTANCE.userDtoToUser(userDto));
    }

    @Override
    public void addRole(UserRoleDto userRoleDto) {
        userRoleDao.save(UserRoleMapper.INSTANCE.userRoleDtoToUserRole(userRoleDto));
    }

    @Transactional
    @Override
    public void addUserRoleToUser(Long userId, Long roleId) {
        User user = Optional.ofNullable(userDao.findById(userId))
                .orElseThrow(() -> new ApiException("User not found"));
        UserRole userRole = Optional.ofNullable(userRoleDao.findById(roleId))
                .orElseThrow(() -> new ApiException("Role not found"));
        userRole.getUserList().add(user);
        user.getUserRoles().add(userRole);
        userDao.saveOrUpdate(user);
    }

    private void secondLevelCacheTest() {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();

        session = sessionFactory.openSession();
        User user1 = session.get(User.class, userId);
        session.close();
    }

    private void thirdLevelCacheTest() { // does not work :(
        String queryText = "FROM User where id = 3L";

        Session session1 = sessionFactory.openSession();
        Query query1 = session1.createQuery(queryText);
        query1.setCacheable(true);
        query1.setCacheRegion("org.hibernate.cache.jcache.JCacheRegionFactory");
        List results = query1.list();
        System.out.println(results);

        Query query2 = session1.createQuery(queryText);
        query2.setCacheable(true);
        query2.setCacheRegion("org.hibernate.cache.jcache.JCacheRegionFactory");
        results = query2.list();
        System.out.println(results);
        session.close();
    }
}
