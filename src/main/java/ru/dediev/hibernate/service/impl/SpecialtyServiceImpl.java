package ru.dediev.hibernate.service.impl;


import ru.dediev.hibernate.entity.SpecialtyEntity;
import ru.dediev.hibernate.repository.SpecialtyRepository;
import ru.dediev.hibernate.repository.hibernate.HibernateSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyRepository {

    private final HibernateSpecialtyRepositoryImpl hibernateSpecialtyRepositoryImpl;

    public SpecialtyServiceImpl() {
        this.hibernateSpecialtyRepositoryImpl = new HibernateSpecialtyRepositoryImpl();
    }

    public SpecialtyServiceImpl(HibernateSpecialtyRepositoryImpl hibernateSpecialtyRepositoryImpl) {
        this.hibernateSpecialtyRepositoryImpl = hibernateSpecialtyRepositoryImpl;
    }

    @Override
    public SpecialtyEntity save(SpecialtyEntity specialtyEntity) {
        return hibernateSpecialtyRepositoryImpl.save(specialtyEntity);
    }

    @Override
    public SpecialtyEntity getById(Long id) {
        return hibernateSpecialtyRepositoryImpl.getById(id);
    }

    @Override
    public List<SpecialtyEntity> getAll() {
        return hibernateSpecialtyRepositoryImpl.getAll();
    }

    @Override
    public SpecialtyEntity update(SpecialtyEntity specialtyEntity, Long id) {
        return hibernateSpecialtyRepositoryImpl.update(specialtyEntity, id);
    }

    @Override
    public SpecialtyEntity deleteById(Long id) {
        return hibernateSpecialtyRepositoryImpl.deleteById(id);
    }
}
