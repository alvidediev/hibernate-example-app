package ru.dediev.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.model.entity.Developer;
import ru.dediev.hibernate.repository.GenericRepository;

import java.util.List;


public class DevelopersRepository implements GenericRepository<Developer, Long> {

    SessionFactory sessionFactory = HibernateConnectionConfig.getSessionFactory();

    @Override
    public Developer save(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(developer);
            transaction.commit();
        }
        return developer;
    }

    @Override
    public Developer getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, id);
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            final List<Developer> allDevelopers = session.createQuery(
                    "SELECT a FROM Developer a ",
                    Developer.class).getResultList();
            transaction.commit();
            return allDevelopers;
        }
    }

    @Override
    public Developer update(Developer developer, Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Developer developerToUpdate = session.get(Developer.class, id);
            developerToUpdate.setLastName(developer.getLastName());
            developerToUpdate.setFirstName(developer.getFirstName());
            session.merge(developerToUpdate);
            transaction.commit();
        }
        return developer;
    }

    @Override
    public Developer deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();
            Developer developerForDelete = session.get(Developer.class, id);
            session.remove(developerForDelete);
            transaction.commit();
            return developerForDelete;
        }
    }
}

