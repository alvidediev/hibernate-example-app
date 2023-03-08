package ru.dediev.hibernate.controller;



import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.service.impl.DeveloperServiceImpl;

import java.util.List;

public class DevelopersController {

    private final DeveloperServiceImpl developerServiceImpl = new DeveloperServiceImpl();

    public DeveloperEntity create(DeveloperEntity developerEntity) {
        return developerServiceImpl.save(developerEntity);
    }

    public DeveloperEntity getById(Long id) {
        return developerServiceImpl.getById(id);
    }

    public DeveloperEntity read(Long id) {
        return developerServiceImpl.getById(id);
    }

    public List<DeveloperEntity> readAll() {
        return developerServiceImpl.getAll();
    }

    public DeveloperEntity update(DeveloperEntity developerEntity, Long id) {
        developerServiceImpl.update(developerEntity, id);
        return developerEntity;
    }

    public DeveloperEntity delete(Long id) {
        return developerServiceImpl.deleteById(id);
    }
}
