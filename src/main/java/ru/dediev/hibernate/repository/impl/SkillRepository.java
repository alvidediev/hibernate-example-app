package ru.dediev.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.model.entity.Skill;
import ru.dediev.hibernate.repository.GenericRepository;

import java.util.List;

public class SkillRepository implements GenericRepository<Skill, Long> {

    private final SessionFactory sessionFactory = HibernateConnectionConfig.getSessionFactory();

    @Override
    public Skill save(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(skill);
            transaction.commit();
        }
        return skill;
    }

    @Override
    public Skill getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return  session.get(Skill.class, id);
        }
    }

    @Override
    public List<Skill> getAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT a FROM Skill a", Skill.class).getResultList();
        }
    }

    @Override
    public Skill update(Skill skill, Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Skill skillForUpdate = session.get(Skill.class, id);
            skillForUpdate.setName(skill.getName());
            session.update(skillForUpdate);
            transaction.commit();
        }
        return skill;
    }

    @Override
    public Skill deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Skill skillForDelete = session.get(Skill.class, id);
            session.delete(skillForDelete);
            transaction.commit();
            return skillForDelete;
        }
    }
}
