package ru.dediev.hibernate.controller;

import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.service.impl.SkillServiceImpl;

import java.util.List;

public class SkillsController {

    private final SkillServiceImpl skillServiceImpl = new SkillServiceImpl();

    public SkillEntity create(SkillEntity skillEntity){
        return skillServiceImpl.save(skillEntity);
    }

    public SkillEntity read(Long id){
        return skillServiceImpl.getById(id);
    }


    public SkillEntity getById(Long id){
        return skillServiceImpl.getById(id);
    }

    public List<SkillEntity> readAll(){
        return skillServiceImpl.getAll();
    }

    public SkillEntity update(SkillEntity skillEntity, Long id){
        skillServiceImpl.update(skillEntity, id);
        return skillEntity;
    }

    public SkillEntity delete(Long id){
        return skillServiceImpl.deleteById(id);
    }
}
