package ru.dediev.hibernate.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.model.entity.Skill;
import ru.dediev.hibernate.model.entity.Status;
import ru.dediev.hibernate.repository.impl.SkillRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.model.entity.Status.ACTIVE;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    private SkillRepository skillRepository;

    private Skill skill;

    private List<Skill> skillList = new ArrayList<>();

    private SkillService skillService = new SkillService();

    @BeforeEach
    public void setUp(){
        skill = new Skill(
                "Spring-Framework",
                ACTIVE
        );

        skillList.add(skill);
        skillList.add(new Skill(
                "JDBC",
                ACTIVE
        ));
    }

    @Test
    public void saveTest(){
        skill = new Skill(
                "name",
                ACTIVE
        );
        when(skillRepository.save(skill)).thenReturn(skill);
        assertEquals(skillService.save(skill), skillRepository.save(skill));
    }

    @Test
    public void getSkillByIdTest(){
        when(skillRepository.getById(1L)).thenReturn(skill);
        assertEquals(skillService.getById(1L), skillRepository.getById(1L));
    }

    @Test
    public void getAllTest(){
        when(skillRepository.getAll()).thenReturn(skillList);
        assertEquals(skillService.getAll(), skillRepository.getAll());
    }

    @Test
    public void updateTest(){
        when(skillRepository.update(skill, 1L)).thenReturn(skill);
        assertEquals(skillService.update(skill, 1L), skillRepository.update(skill, 1L));
    }

    @Test
    public void deleteSkillTest(){
        skill = new Skill();
        skill.setStatus(Status.DELETED);
        when(skillRepository.deleteById(1L)).thenReturn(skill);
        assertEquals(skillService.deleteById(1L), skillRepository.deleteById(1L));
    }
}
