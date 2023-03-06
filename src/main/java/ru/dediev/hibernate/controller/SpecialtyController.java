package ru.dediev.hibernate.controller;

import ru.dediev.hibernate.model.entity.Specialty;
import ru.dediev.hibernate.service.impl.SpecialtyService;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyService specialtyService = new SpecialtyService();

    public Specialty create(Specialty specialty) {
        return specialtyService.save(specialty);
    }

    public Specialty read(Long id) {
        return specialtyService.getById(id);
    }


    public Specialty getById(Long id) {
        return specialtyService.getById(id);
    }

    public List<Specialty> readAll() {
        return specialtyService.getAll();
    }

    public Specialty update(Specialty specialty, Long id) {
        specialtyService.update(specialty, id);
        return specialty;
    }

    public Specialty delete(Long id) {
        return specialtyService.deleteById(id);
    }
}
