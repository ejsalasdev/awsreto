package com.talentpool.retoaws.domain.usecases;

import java.util.Optional;

import com.talentpool.retoaws.domain.exceptions.PersonAlreadyExistsException;
import com.talentpool.retoaws.domain.exceptions.PersonNotFoundException;
import com.talentpool.retoaws.domain.model.person.PersonModel;
import com.talentpool.retoaws.domain.ports.in.PersonServicePort;
import com.talentpool.retoaws.domain.ports.out.PersonPersistencePort;
import com.talentpool.retoaws.domain.utils.DomainConstants;

public class PersonUseCase implements PersonServicePort {

    private final PersonPersistencePort personPersistencePort;

    public PersonUseCase(PersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public PersonModel savePerson(PersonModel person) {
        Optional<PersonModel> existingPerson = personPersistencePort
                .getPersonByIdentificationNumber(person.getIdentificationNumber());
        if (existingPerson.isPresent()) {
            throw new PersonAlreadyExistsException(
                    String.format(DomainConstants.PERSON_ALREADY_EXISTS, person.getIdentificationNumber()));
        }
        return personPersistencePort.savePerson(person);
    }

    @Override
    public PersonModel getPersonByIdentificationNumber(String identificationNumber) {
        Optional<PersonModel> personModel = personPersistencePort.getPersonByIdentificationNumber(identificationNumber);
        if (personModel.isEmpty()) {
            throw new PersonNotFoundException(
                    String.format(DomainConstants.PERSON_NOT_FOUND, identificationNumber));
        }
        return personModel.get();
    }
}
