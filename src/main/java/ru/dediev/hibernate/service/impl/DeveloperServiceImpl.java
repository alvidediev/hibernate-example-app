package ru.dediev.hibernate.service.impl;

import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.repository.hibernate.HibernateDevelopersRepositoryImpl;
import ru.dediev.hibernate.service.DeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {

    private final HibernateDevelopersRepositoryImpl hibernateDevelopersRepositoryImpl;

    public DeveloperServiceImpl() {
        this.hibernateDevelopersRepositoryImpl = new HibernateDevelopersRepositoryImpl();
    }

    public DeveloperServiceImpl(HibernateDevelopersRepositoryImpl hibernateDevelopersRepositoryImpl) {
        this.hibernateDevelopersRepositoryImpl = hibernateDevelopersRepositoryImpl;
    }

    @Override
    public DeveloperEntity save(DeveloperEntity developerEntity) {
        return hibernateDevelopersRepositoryImpl.save(developerEntity);
    }

    @Override
    public DeveloperEntity getById(Long id) {
        return hibernateDevelopersRepositoryImpl.getById(id);
    }

    @Override
    public List<DeveloperEntity> getAll() {
        return hibernateDevelopersRepositoryImpl.getAll();
    }

    @Override
    public DeveloperEntity update(DeveloperEntity developerEntity, Long id) {
        return hibernateDevelopersRepositoryImpl.update(developerEntity, id);
    }

    @Override
    public DeveloperEntity deleteById(Long id) {
        return hibernateDevelopersRepositoryImpl.deleteById(id);
    }
}
