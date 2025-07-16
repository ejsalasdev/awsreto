package com.talentpool.retoaws.application.handlers.impl;

import org.springframework.stereotype.Service;

import com.talentpool.retoaws.application.dto.PersonRequestDTO;
import com.talentpool.retoaws.application.dto.PersonResponseDTO;
import com.talentpool.retoaws.application.handlers.PersonHandler;
import com.talentpool.retoaws.application.mappers.PersonMapper;
import com.talentpool.retoaws.domain.model.person.PersonModel;
import com.talentpool.retoaws.domain.ports.in.PersonServicePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonHandlerImpl implements PersonHandler {

    private final PersonServicePort personServicePort;
    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO savePerson(PersonRequestDTO personRequestDTO) {
        PersonModel personModel = personMapper.toDomain(personRequestDTO);
        PersonModel savedPerson = personServicePort.savePerson(personModel);
        return personMapper.toResponseDTO(savedPerson);
    }

    @Override
    public PersonResponseDTO getPerson(String identificationNumber) {
        PersonModel personModel = personServicePort.getPersonByIdentificationNumber(identificationNumber);
        return personMapper.toResponseDTO(personModel);
    }

}
