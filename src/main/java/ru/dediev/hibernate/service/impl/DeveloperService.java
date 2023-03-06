package ru.dediev.hibernate.service.impl;

import ru.dediev.hibernate.model.entity.Developer;
import ru.dediev.hibernate.repository.impl.DevelopersRepository;
import ru.dediev.hibernate.service.Service;

import java.util.List;

public class DeveloperService implements Service<Developer, Long> {

    private final DevelopersRepository developersRepository = new DevelopersRepository();

    @Override
    public Developer save(Developer developer) {
        return developersRepository.save(developer);
    }

    @Override
    public Developer getById(Long id) {
        return developersRepository.getById(id);
    }

    @Override
    public List<Developer> getAll() {
        return developersRepository.getAll();
    }

    @Override
    public Developer update(Developer developer, Long id) {
        return developersRepository.update(developer, id);
    }

    @Override
    public Developer deleteById(Long id) {
        return developersRepository.deleteById(id);
    }
}
