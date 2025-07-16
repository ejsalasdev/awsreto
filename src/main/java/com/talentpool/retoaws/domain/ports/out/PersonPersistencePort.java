package com.talentpool.retoaws.domain.ports.out;

import com.talentpool.retoaws.domain.model.person.PersonModel;
import java.util.Optional;

public interface PersonPersistencePort {
    PersonModel savePerson(PersonModel person);
    Optional<PersonModel> getPersonByIdentificationNumber(String identificationNumber);
}
