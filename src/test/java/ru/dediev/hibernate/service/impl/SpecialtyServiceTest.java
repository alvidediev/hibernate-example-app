package ru.dediev.hibernate.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.model.entity.Specialty;
import ru.dediev.hibernate.repository.impl.SpecialtyRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.model.entity.Status.ACTIVE;
import static ru.dediev.hibernate.model.entity.Status.DELETED;

@ExtendWith(MockitoExtension.class)
public class SpecialtyServiceTest {

    @Mock
    public SpecialtyRepository specialtyRepository;

    private Specialty specialty;

    private List<Specialty> specialties;

    private final SpecialtyService specialtyService = new SpecialtyService();

    @BeforeEach
    public void setUp(){
        specialty = new Specialty(
                "C++ - developer",
                ACTIVE
        );
    }

    @Test
    public void saveSpecialtyTest(){
        Specialty specialtyAfterReturnFromBase = new Specialty(
                "C++ - developer",
                ACTIVE
        );
        when(specialtyRepository.save(specialty)).thenReturn(specialtyAfterReturnFromBase);
        assertEquals(specialtyService.save(specialty), specialtyRepository.save(specialty));
    }

    @Test
    public void getById(){
        when(specialtyRepository.getById(1L)).thenReturn(specialty);
        assertEquals(specialtyService.getById(1L), specialtyRepository.getById(1L));
    }

    @Test
    public void getAll(){
        specialties = new ArrayList<>();

        specialties.add(specialty);

        when(specialtyRepository.getAll()).thenReturn(specialties);
        assertEquals(specialtyService.getAll(), specialtyRepository.getAll());
    }

    @Test
    public void deleteSkillTest(){
        specialty = new Specialty(
                null,
                DELETED
        );
        when(specialtyRepository.deleteById(1L)).thenReturn(specialty);
        assertEquals(specialtyService.deleteById(1L), specialtyRepository.deleteById(1L));
    }

}
