package ru.dediev.hibernate.controller;

import ru.dediev.hibernate.entity.SpecialtyEntity;
import ru.dediev.hibernate.service.impl.SpecialtyServiceImpl;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyServiceImpl specialtyServiceImpl = new SpecialtyServiceImpl();

    public SpecialtyEntity create(SpecialtyEntity specialtyEntity) {
        return specialtyServiceImpl.save(specialtyEntity);
    }

    public SpecialtyEntity read(Long id) {
        return specialtyServiceImpl.getById(id);
    }


    public SpecialtyEntity getById(Long id) {
        return specialtyServiceImpl.getById(id);
    }

    public List<SpecialtyEntity> readAll() {
        return specialtyServiceImpl.getAll();
    }

    public SpecialtyEntity update(SpecialtyEntity specialtyEntity, Long id) {
        specialtyServiceImpl.update(specialtyEntity, id);
        return specialtyEntity;
    }

    public SpecialtyEntity delete(Long id) {
        return specialtyServiceImpl.deleteById(id);
    }
}
