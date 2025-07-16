package com.talentpool.retoaws.domain.ports.in;

import com.talentpool.retoaws.domain.model.person.PersonModel;

public interface PersonServicePort {

    PersonModel savePerson(PersonModel person);

    PersonModel getPersonByIdentificationNumber(String identificationNumber);

}
