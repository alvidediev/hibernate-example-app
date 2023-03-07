package ru.dediev.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.model.entity.Specialty;
import ru.dediev.hibernate.repository.GenericRepository;

import java.util.List;

public class SpecialtyRepository implements GenericRepository<Specialty, Long> {

    SessionFactory sessionFactory = HibernateConnectionConfig.getSessionFactory();

    @Override
    public Specialty getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Specialty.class, id);
        }
    }

    @Override
    public List<Specialty> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT a FROM Specialty a", Specialty.class).getResultList();
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(specialty);
            transaction.commit();
        }
        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty, Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Specialty specialtyForUpdate = session.get(Specialty.class, id);
            specialtyForUpdate.setName(specialtyForUpdate.getName());
            session.merge(specialtyForUpdate);
            transaction.commit();
        }
        return specialty;
    }

    @Override
    public Specialty deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();
            Specialty specialtyForDelete = session.get(Specialty.class, id);
            session.remove(specialtyForDelete);
            transaction.commit();
            return specialtyForDelete;
        }
    }
}
