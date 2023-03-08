package ru.dediev.hibernate.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.entity.SkillEntity;
import ru.dediev.hibernate.entity.Status;
import ru.dediev.hibernate.repository.hibernate.HibernateSkillRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.entity.Status.ACTIVE;

@ExtendWith(MockitoExtension.class)
public class SkillEntityServiceTest {

    private HibernateSkillRepositoryImpl hibernateSkillRepositoryImpl = Mockito.mock(HibernateSkillRepositoryImpl.class);

    private SkillServiceImpl skillServiceImpl = new SkillServiceImpl(hibernateSkillRepositoryImpl);

    private SkillEntity getSkillEntity(){
        return new SkillEntity(
                "Spring-framework",
                ACTIVE
        );
    }

    private List<SkillEntity> getSkills(){
        return List.of(
                new SkillEntity(
                        "Spring-framework",
                        ACTIVE
                ),
                new SkillEntity(
                        "JDBC",
                        ACTIVE
                )
        );
    }

    @Test
    public void saveTest(){
        SkillEntity skill = new SkillEntity(
                "name",
                ACTIVE
        );
        when(hibernateSkillRepositoryImpl.save(skill)).thenReturn(getSkillEntity());
        assertEquals(skillServiceImpl.save(skill), hibernateSkillRepositoryImpl.save(skill));
    }

    @Test
    public void getSkillByIdTest(){
        when(hibernateSkillRepositoryImpl.getById(1L)).thenReturn(getSkillEntity());
        assertEquals(skillServiceImpl.getById(1L), hibernateSkillRepositoryImpl.getById(1L));
    }

    @Test
    public void getAllTest(){
        when(hibernateSkillRepositoryImpl.getAll()).thenReturn(getSkills());
        assertEquals(skillServiceImpl.getAll(), hibernateSkillRepositoryImpl.getAll());
    }

    @Test
    public void updateTest(){
        when(hibernateSkillRepositoryImpl.update(getSkillEntity(), 1L)).thenReturn(getSkillEntity());
        assertEquals(skillServiceImpl.update(getSkillEntity(), 1L), hibernateSkillRepositoryImpl.update(getSkillEntity(), 1L));
    }

    @Test
    public void deleteSkillTest(){
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setStatus(Status.DELETED);
        when(hibernateSkillRepositoryImpl.deleteById(1L)).thenReturn(skillEntity);
        assertEquals(skillServiceImpl.deleteById(1L), hibernateSkillRepositoryImpl.deleteById(1L));
    }
}
