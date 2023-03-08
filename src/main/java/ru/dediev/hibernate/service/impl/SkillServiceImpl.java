package ru.dediev.hibernate.service.impl;

import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.repository.SkillRepository;
import ru.dediev.hibernate.repository.hibernate.HibernateSkillRepositoryImpl;

import java.util.List;

public class SkillServiceImpl implements SkillRepository {

    private final HibernateSkillRepositoryImpl hibernateSkillRepositoryImpl;

    public SkillServiceImpl() {
        this.hibernateSkillRepositoryImpl = new HibernateSkillRepositoryImpl();
    }

    public SkillServiceImpl(HibernateSkillRepositoryImpl hibernateSkillRepositoryImpl) {
        this.hibernateSkillRepositoryImpl = hibernateSkillRepositoryImpl;
    }

    @Override
    public SkillEntity save(SkillEntity skillEntity) {
        return hibernateSkillRepositoryImpl.save(skillEntity);
    }

    @Override
    public SkillEntity getById(Long id) {
        return hibernateSkillRepositoryImpl.getById(id);
    }

    @Override
    public List<SkillEntity> getAll() {
        return hibernateSkillRepositoryImpl.getAll();
    }

    @Override
    public SkillEntity update(SkillEntity skillEntity, Long id) {
        return hibernateSkillRepositoryImpl.update(skillEntity, id);
    }

    @Override
    public SkillEntity deleteById(Long id) {
        return hibernateSkillRepositoryImpl.deleteById(id);
    }
}
