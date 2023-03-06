package ru.dediev.hibernate.service.impl;

import ru.dediev.hibernate.model.entity.Skill;
import ru.dediev.hibernate.repository.impl.SkillRepository;
import ru.dediev.hibernate.service.Service;

import java.util.List;

public class SkillService implements Service<Skill, Long> {

    private final SkillRepository skillRepository = new SkillRepository();

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    @Override
    public Skill update(Skill skill, Long id) {
        return skillRepository.update(skill, id);
    }

    @Override
    public Skill deleteById(Long id) {
        return skillRepository.deleteById(id);
    }
}
