package com.talentpool.retoaws.application.handlers;

import com.talentpool.retoaws.application.dto.PersonRequestDTO;
import com.talentpool.retoaws.application.dto.PersonResponseDTO;

public interface PersonHandler {

    PersonResponseDTO savePerson(PersonRequestDTO personRequestDTO);

    PersonResponseDTO getPerson(String identificationNumber);
}
