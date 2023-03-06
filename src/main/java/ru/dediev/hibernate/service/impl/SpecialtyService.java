package ru.dediev.hibernate.service.impl;


import ru.dediev.hibernate.model.entity.Specialty;
import ru.dediev.hibernate.repository.impl.SpecialtyRepository;
import ru.dediev.hibernate.service.Service;

import java.util.List;

public class SpecialtyService implements Service<Specialty, Long> {

    private final SpecialtyRepository specialtyRepository = new SpecialtyRepository();

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty getById(Long id) {
        return specialtyRepository.getById(id);
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.getAll();
    }

    @Override
    public Specialty update(Specialty specialty, Long id) {
        return specialtyRepository.update(specialty, id);
    }

    @Override
    public Specialty deleteById(Long id) {
        return specialtyRepository.deleteById(id);
    }
}
