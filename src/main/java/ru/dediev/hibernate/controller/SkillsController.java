package ru.dediev.hibernate.controller;

import ru.dediev.hibernate.model.entity.Skill;
import ru.dediev.hibernate.service.impl.SkillService;

import java.util.List;

public class SkillsController {

    private final SkillService skillService = new SkillService();

    public Skill create(Skill skill){
        return skillService.save(skill);
    }

    public Skill read(Long id){
        return skillService.getById(id);
    }


    public Skill getById(Long id){
        return skillService.getById(id);
    }

    public List<Skill> readAll(){
        return skillService.getAll();
    }

    public Skill update(Skill skill, Long id){
        skillService.update(skill, id);
        return skill;
    }

    public Skill delete(Long id){
        return skillService.deleteById(id);
    }
}
