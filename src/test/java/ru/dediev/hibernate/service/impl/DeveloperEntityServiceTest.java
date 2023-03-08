package ru.dediev.hibernate.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dediev.hibernate.entity.DeveloperEntity;
import ru.dediev.hibernate.repository.hibernate.HibernateDevelopersRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.dediev.hibernate.entity.Status.ACTIVE;


@ExtendWith(MockitoExtension.class)
public class DeveloperEntityServiceTest {

    private final HibernateDevelopersRepositoryImpl hibernateDevelopersRepositoryImpl =
            Mockito.mock(HibernateDevelopersRepositoryImpl.class);

    private final DeveloperServiceImpl developerServiceImpl = new DeveloperServiceImpl(hibernateDevelopersRepositoryImpl);

    private DeveloperEntity getDeveloperEntity(){
        return new DeveloperEntity(
                "Alvi",
                "Dediev",
                new ArrayList<>(),
                null,
                ACTIVE
        );
    }

    private List<DeveloperEntity> getDevelopers(){
        return List.of(
                new DeveloperEntity(
                        "Eugene",
                        "Suleimanov",
                        new ArrayList<>(),
                        null,
                        ACTIVE
                )
        );
    }

    @Test
    public void saveDeveloperTest() {
        DeveloperEntity developerForSave = new DeveloperEntity(
                null,
                "Mansur",
                "Macuhaev",
                new ArrayList<>(),
                null,
                ACTIVE
        );
        when(hibernateDevelopersRepositoryImpl.save(developerForSave)).thenReturn(getDeveloperEntity());
        assertEquals(developerServiceImpl.save(developerForSave),
                hibernateDevelopersRepositoryImpl.save(developerForSave));
    }

    @Test
    public void getByIdTest() {
        when(hibernateDevelopersRepositoryImpl.getById(1L)).thenReturn(getDeveloperEntity());
        assertEquals(developerServiceImpl.getById(1L), hibernateDevelopersRepositoryImpl.getById(1L));
    }

    @Test
    public void getAllTest() {
        when(hibernateDevelopersRepositoryImpl.getAll()).thenReturn(getDevelopers());
        assertEquals(developerServiceImpl.getAll(), hibernateDevelopersRepositoryImpl.getAll());
    }

    @Test
    public void updateTest() {
        when(hibernateDevelopersRepositoryImpl.update(getDeveloperEntity(), 1L)).thenReturn(getDeveloperEntity());
        assertEquals(developerServiceImpl.update(getDeveloperEntity(), 1L),
                hibernateDevelopersRepositoryImpl.update(getDeveloperEntity(), 1L));
    }

    @Test
    public void deleteTest() {
        DeveloperEntity deletedDeveloper = null;

        when(hibernateDevelopersRepositoryImpl.deleteById(3L)).thenReturn(deletedDeveloper);
        assertEquals(developerServiceImpl.deleteById(3L), hibernateDevelopersRepositoryImpl.deleteById(3L));
    }
}
