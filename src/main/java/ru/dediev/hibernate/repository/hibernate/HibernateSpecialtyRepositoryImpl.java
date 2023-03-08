package ru.dediev.hibernate.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.entity.SpecialtyEntity;
import ru.dediev.hibernate.repository.SpecialtyRepository;

import java.util.List;

public class HibernateSpecialtyRepositoryImpl implements SpecialtyRepository {

    @Override
    public SpecialtyEntity getById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            String getByIdHqlQuery = "FROM SpecialtyEntity a WHERE a.id = :specialtyId";
            final Query<SpecialtyEntity> query = session.createQuery(getByIdHqlQuery, SpecialtyEntity.class);
            query.setParameter("specialtyId", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<SpecialtyEntity> getAll() {
        try(Session session = HibernateConnectionConfig.getSession()){
            return session.createQuery("SELECT a FROM SpecialtyEntity a", SpecialtyEntity.class).getResultList();
        }
    }

    @Override
    public SpecialtyEntity save(SpecialtyEntity specialtyEntity) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(specialtyEntity);
            transaction.commit();
        }
        return specialtyEntity;
    }

    @Override
    public SpecialtyEntity update(SpecialtyEntity specialtyEntity, Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            SpecialtyEntity specialtyEntityForUpdate = session.get(SpecialtyEntity.class, id);
            specialtyEntityForUpdate.setName(specialtyEntityForUpdate.getName());
            session.merge(specialtyEntityForUpdate);
            transaction.commit();
        }
        return specialtyEntity;
    }

    @Override
    public SpecialtyEntity deleteById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {

            Transaction transaction = session.beginTransaction();
            SpecialtyEntity specialtyEntityForDelete = session.get(SpecialtyEntity.class, id);
            session.remove(specialtyEntityForDelete);
            transaction.commit();
            return specialtyEntityForDelete;
        }
    }
}
