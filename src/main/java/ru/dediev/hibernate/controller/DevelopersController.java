package ru.dediev.hibernate.controller;



import ru.dediev.hibernate.model.entity.Developer;
import ru.dediev.hibernate.service.impl.DeveloperService;

import java.util.List;

public class DevelopersController {

    private final DeveloperService developerService = new DeveloperService();

    public Developer create(Developer developer) {
        return developerService.save(developer);
    }

    public Developer getById(Long id) {
        return developerService.getById(id);
    }

    public Developer read(Long id) {
        return developerService.getById(id);
    }

    public List<Developer> readAll() {
        return developerService.getAll();
    }

    public Developer update(Developer developer, Long id) {
        developerService.update(developer, id);
        return developer;
    }

    public Developer delete(Long id) {
        return developerService.deleteById(id);
    }
}
