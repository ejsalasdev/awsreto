package com.talentpool.retoaws.infrastructure.adapters;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.talentpool.retoaws.domain.model.person.PersonModel;
import com.talentpool.retoaws.domain.ports.out.PersonPersistencePort;
import com.talentpool.retoaws.infrastructure.entities.PersonEntity;
import com.talentpool.retoaws.infrastructure.mappers.PersonEntityMapper;
import com.talentpool.retoaws.infrastructure.repositories.mysql.PersonRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonPersistenceAdapter implements PersonPersistencePort {

    private final PersonRepository personRepository;
    private final PersonEntityMapper personEntityMapper;

    @Override
    public PersonModel savePerson(PersonModel person) {
        PersonEntity personEntity = personEntityMapper.toEntity(person);
        PersonEntity savedEntity = personRepository.save(personEntity);
        return personEntityMapper.toModel(savedEntity);
    }

    @Override
    public Optional<PersonModel> getPersonByIdentificationNumber(String identificationNumber) {
        return personRepository.findByIdentificationNumber(identificationNumber)
                .map(personEntityMapper::toModel);
    }
}
