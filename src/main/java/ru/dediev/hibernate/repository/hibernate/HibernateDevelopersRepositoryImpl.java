package ru.dediev.hibernate.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.dediev.hibernate.config.HibernateConnectionConfig;
import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.repository.DevelopersRepository;

import java.util.List;


public class HibernateDevelopersRepositoryImpl implements DevelopersRepository {

    @Override
    public DeveloperEntity save(DeveloperEntity developerEntity) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(developerEntity);
            transaction.commit();
        }
        return developerEntity;
    }

    @Override
    public DeveloperEntity getById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            String getByIdHqlQuery = "" +
                    "FROM DeveloperEntity a " +
                    "LEFT JOIN FETCH a.skillEntity, a.specialtyEntity WHERE a.id = :developerId";
            final Query<DeveloperEntity> query = session.createQuery(getByIdHqlQuery, DeveloperEntity.class);
            query.setParameter("developerId", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<DeveloperEntity> getAll() {
        try (Session session = HibernateConnectionConfig.getSession()) {
            String getAllHqlQuery =
                    "SELECT a FROM DeveloperEntity a JOIN FETCH a.specialtyEntity p join FETCH a.skillEntity f";
            return session.createQuery(getAllHqlQuery, DeveloperEntity.class).getResultList();
        }
    }

    @Override
    public DeveloperEntity update(DeveloperEntity developerEntity, Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            DeveloperEntity developerEntityToUpdate = session.get(DeveloperEntity.class, id);
            developerEntityToUpdate.setLastName(developerEntity.getLastName());
            developerEntityToUpdate.setFirstName(developerEntity.getFirstName());
            session.merge(developerEntityToUpdate);
            transaction.commit();
        }
        return developerEntity;
    }

    @Override
    public DeveloperEntity deleteById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Transaction transaction = session.beginTransaction();
            DeveloperEntity developerEntityForDelete = session.get(DeveloperEntity.class, id);
            session.remove(developerEntityForDelete);
            transaction.commit();
            return developerEntityForDelete;
        }
    }
}

