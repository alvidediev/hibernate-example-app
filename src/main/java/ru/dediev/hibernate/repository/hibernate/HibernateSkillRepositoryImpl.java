package ru.dediev.hibernate.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.repository.SkillRepository;

import java.util.List;

public class HibernateSkillRepositoryImpl implements SkillRepository {

    @Override
    public SkillEntity save(SkillEntity skillEntity) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(skillEntity);
            transaction.commit();
        }
        return skillEntity;
    }

    @Override
    public SkillEntity getById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            String getByIdHqlQuery = "FROM SkillEntity a WHERE a.id = :skillId";
            final Query<SkillEntity> query = session.createQuery(getByIdHqlQuery, SkillEntity.class);
            query.setParameter("skillId", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<SkillEntity> getAll() {
        try(Session session = HibernateConnectionConfig.getSession()){
            return session.createQuery("SELECT a FROM SkillEntity a", SkillEntity.class).getResultList();
        }
    }

    @Override
    public SkillEntity update(SkillEntity skillEntity, Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            SkillEntity skillEntityForUpdate = session.get(SkillEntity.class, id);
            skillEntityForUpdate.setName(skillEntity.getName());
            session.merge(skillEntityForUpdate);
            transaction.commit();
        }
        return skillEntity;
    }

    @Override
    public SkillEntity deleteById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            SkillEntity skillEntityForDelete = session.get(SkillEntity.class, id);
            session.remove(skillEntityForDelete);
            transaction.commit();
            return skillEntityForDelete;
        }
    }
}
