package com.talentpool.retoaws.domain.usecases;

import com.talentpool.retoaws.domain.model.person.PersonModel;
import com.talentpool.retoaws.domain.ports.out.PersonPersistencePort;
import com.talentpool.retoaws.domain.exceptions.PersonAlreadyExistsException;
import com.talentpool.retoaws.domain.exceptions.PersonNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonUseCaseTest {

    @Mock
    private PersonPersistencePort personPersistencePort;

    @InjectMocks
    private PersonUseCase personUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenSavePerson_thenPersistAndReturnModel() {
        // Arrange
        PersonModel person = new PersonModel(null, "1090400500", "John", "email@example.com");
        when(personPersistencePort.savePerson(person)).thenReturn(new PersonModel(1L, "1090400500", "John", "email@example.com"));

        // Act
        PersonModel result = personUseCase.savePerson(person);

        // Assert
        assertNotNull(result.getId());
        assertEquals("John", result.getName());
        verify(personPersistencePort).savePerson(person);
    }

    @Test
    void whenGetPersonByIdentificationNumber_thenReturnModel() {
        // Arrange
        PersonModel person = new PersonModel(1L, "1090400500", "John", "email@example.com");
        when(personPersistencePort.getPersonByIdentificationNumber("1090400500")).thenReturn(Optional.of(person));

        // Act
        PersonModel result = personUseCase.getPersonByIdentificationNumber("1090400500");

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(personPersistencePort).getPersonByIdentificationNumber("1090400500");
    }

    @Test
    void whenGetPersonByIdentificationNumber_thenThrowsException() {
        // Arrange
        when(personPersistencePort.getPersonByIdentificationNumber("9999999999")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PersonNotFoundException.class, () -> {
            personUseCase.getPersonByIdentificationNumber("9999999999");
        });
        verify(personPersistencePort).getPersonByIdentificationNumber("9999999999");
    }

    @Test
    void whenSavePersonWithExistingPerson_thenThrowsException() {
        // Arrange
        PersonModel person = new PersonModel(null, "1090400500", "John", "email@example.com");
        when(personPersistencePort.getPersonByIdentificationNumber("1090400500")).thenReturn(Optional.of(new PersonModel(1L, "1090400500", "John", "email@example.com")));

        // Act & Assert
        assertThrows(PersonAlreadyExistsException.class, () -> {
            personUseCase.savePerson(person);
        });
        verify(personPersistencePort).getPersonByIdentificationNumber("1090400500");
    }
}
