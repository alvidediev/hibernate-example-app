package ru.dediev.hibernate.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.entity.SpecialtyEntity;
import ru.dediev.hibernate.repository.hibernate.HibernateSpecialtyRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.entity.Status.ACTIVE;

@ExtendWith(MockitoExtension.class)
public class SpecialtyEntityServiceTest {

    public HibernateSpecialtyRepositoryImpl hibernateSpecialtyRepositoryImpl =
            Mockito.mock(HibernateSpecialtyRepositoryImpl.class);

    private final SpecialtyServiceImpl specialtyServiceImpl = new SpecialtyServiceImpl(hibernateSpecialtyRepositoryImpl);

    private SpecialtyEntity getSpecialty(){
        return new SpecialtyEntity(
                "Java-developer",
                ACTIVE
        );
    }

    private List<SpecialtyEntity> getSpecialties(){
        return List.of(
                new SpecialtyEntity(
                        "Php-developers",
                        ACTIVE
                ),
                new SpecialtyEntity(
                        "Java-developer",
                        ACTIVE
                )
        );
    }

    @Test
    public void saveSpecialtyTest(){
        SpecialtyEntity specialtyEntity = new SpecialtyEntity(
                "C++ - developer",
                ACTIVE
        );
        when(hibernateSpecialtyRepositoryImpl.save(specialtyEntity)).thenReturn(getSpecialty());
        assertEquals(specialtyServiceImpl.save(specialtyEntity), hibernateSpecialtyRepositoryImpl.save(specialtyEntity));
    }

    @Test
    public void getById(){
        when(hibernateSpecialtyRepositoryImpl.getById(1L)).thenReturn(getSpecialty());
        assertEquals(specialtyServiceImpl.getById(1L), hibernateSpecialtyRepositoryImpl.getById(1L));
    }

    @Test
    public void getAll(){
        when(hibernateSpecialtyRepositoryImpl.getAll()).thenReturn(getSpecialties());
        assertEquals(specialtyServiceImpl.getAll(), hibernateSpecialtyRepositoryImpl.getAll());
    }

    @Test
    public void deleteSkillTest(){
        SpecialtyEntity specialtyEntity = null;
        when(hibernateSpecialtyRepositoryImpl.deleteById(1L)).thenReturn(specialtyEntity);
        assertEquals(specialtyServiceImpl.deleteById(1L), hibernateSpecialtyRepositoryImpl.deleteById(1L));
    }

}
