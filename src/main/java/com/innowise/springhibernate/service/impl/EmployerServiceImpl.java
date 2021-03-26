package com.innowise.springhibernate.service.impl;

import com.innowise.springhibernate.dao.EmployerDao;
import com.innowise.springhibernate.dto.EmployerDto;
import com.innowise.springhibernate.entities.Employer;
import com.innowise.springhibernate.entities.User;
import com.innowise.springhibernate.mappers.EmployerMapper;
import com.innowise.springhibernate.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    private static final BATCH_SIZE = 5;

    private final EmployerDao employerDao;
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployerServiceImpl(EmployerDao employerDao, SessionFactory sessionFactory) {
        this.employerDao = employerDao;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(EmployerDto employerDto) {
        employerDao.save(EmployerMapper.INSTANCE.employerDtoToEmployer(employerDto));
    }

    @Transactional
    private void batchTest() {
        Session session = sessionFactory.openSession();
        for (int i = 0; i < 10; i++) {
            Employer employer = createEmployer();
            session.persist(employer);
        }
        session.close();
    }

    @Transactional
    private void orderInsertsBatchTest() {
        Session session = sessionFactory.openSession();
        for (int i = 0; i < 10; i++) {
            if (i > 0 && i % BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }
            Employer employer = createEmployer();
            session.persist(employer);
            Employer firstEmployer = createEmployer(employer);
            Employer secondEmployer = createEmployer(employer);
            session.persist(firstEmployer);
            session.persist(secondEmployer);
        }
        session.close();
    }

    @Transactional
    public void updateBatchTest() {
        Session session = sessionFactory.openSession();
        TypedQuery<Employer> employerTypedQuery =
                session.createQuery("SELECT e from Employer e", Employer.class);
        List<Employer> employerList = employerTypedQuery.getResultList();
        for (Employer employer : employerList) {
            employer.setCompany("Updated_" + employer.getCompany());
        }
        session.close();
    }

    private jpaQueryProjectionTest() {
        Session session = sessionFactory.openSession();
        List<EmployerDto> employerDtoList = session.createQuery("""
            select new com.innowise.springhibernate.dto.EmployerDto(
                e.id,
                e.name,
                e.company
            )
            from Employer e
            """, EmployerDto.class).getResultList();
        //List<EmployerDto> employerDtoList = session.createNamedQuery("PostDtoNativeQuery").getResultList();
        )
    }



    private Employer createEmployer() {
        Employer employer = new Employer();
        employer.setCompany("company");
        return employer;
    }

    private Employer createEmployer(Employer employer) {
        return new Employer(employer);
    }
}
