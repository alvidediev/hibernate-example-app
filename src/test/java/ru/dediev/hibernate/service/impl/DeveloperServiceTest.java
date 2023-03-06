package ru.dediev.hibernate.service.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.model.entity.Developer;
import ru.dediev.hibernate.model.entity.Skill;
import ru.dediev.hibernate.model.entity.Specialty;
import ru.dediev.hibernate.repository.impl.DevelopersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.model.entity.Status.ACTIVE;
import static ru.dediev.hibernate.model.entity.Status.DELETED;


@ExtendWith(MockitoExtension.class)
public class DeveloperServiceTest {

    @Mock
    private DevelopersRepository developersRepository;

    private Developer developer;

    private final List<Developer> developerList = new ArrayList<>();

    private final DeveloperService developerService = new DeveloperService();

    @BeforeEach
    public void setUp() {
        developer = new Developer();
        List<Skill> skillList = Arrays.asList(
                new Skill(
                        "Spring-Framework",
                        ACTIVE),
                new Skill(
                        "JDBC",
                        ACTIVE)
        );
        Specialty specialty = new Specialty(
                "Java-developer",
                ACTIVE);

        developer.setId(1L);
        developer.setFirstName("Dediev");
        developer.setLastName("Alvi");
        developer.setSkill(skillList);
        developer.setSpecialty(specialty);
        developer.setStatus(ACTIVE);

        developerList.add(developer);
        developerList.add(developer);
    }

    @Test
    public void saveDeveloperTest() {
        Specialty specialty = new Specialty(
                "olo",
                ACTIVE
        );
        Developer developerBeforeAddingToDatabase = new Developer(
                "Mansur",
                "Macuhaev",
                new ArrayList<>(),
                specialty,
                ACTIVE
        );

        Developer developerAfterAddingToDatabase = new Developer(
                "Mansur",
                "Macuhaev",
                new ArrayList<>(),
                specialty,
                ACTIVE
        );
        developerAfterAddingToDatabase.setId(10L);
        when(developersRepository.save(developerBeforeAddingToDatabase)).thenReturn(developerAfterAddingToDatabase);
        assertEquals(developerService.save(developerBeforeAddingToDatabase),
                developersRepository.save(developerBeforeAddingToDatabase));
    }

    @Test
    public void getByIdTest() {
        when(developersRepository.getById(1L)).thenReturn(developer);
        assertEquals(developerService.getById(1L), developersRepository.getById(1L));
    }

    @Test
    public void getAllTest() {
        when(developersRepository.getAll()).thenReturn(developerList);
        assertEquals(developerService.getAll(), developersRepository.getAll());
    }

    @Test
    public void updateTest() {
        when(developersRepository.update(developer, 1L)).thenReturn(developer);
        assertEquals(developerService.update(developer, 1L), developersRepository.update(developer, 1L));
    }

    @Test
    public void deleteTest() {
        developer = null;

        when(developersRepository.deleteById(3L)).thenReturn(developer);
        assertEquals(developerService.deleteById(3L), developersRepository.deleteById(3L));
    }
}
