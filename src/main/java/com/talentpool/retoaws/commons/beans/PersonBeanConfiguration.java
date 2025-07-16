package com.talentpool.retoaws.commons.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.talentpool.retoaws.domain.ports.in.PersonServicePort;
import com.talentpool.retoaws.domain.ports.out.PersonPersistencePort;
import com.talentpool.retoaws.domain.usecases.PersonUseCase;
import com.talentpool.retoaws.infrastructure.adapters.PersonPersistenceAdapter;
import com.talentpool.retoaws.infrastructure.mappers.PersonEntityMapper;
import com.talentpool.retoaws.infrastructure.repositories.mysql.PersonRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PersonBeanConfiguration {

    @Bean
    public PersonPersistencePort personPersistencePort(PersonRepository personRepository,
            PersonEntityMapper personEntityMapper) {
        return new PersonPersistenceAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public PersonServicePort personServicePort(
        PersonPersistencePort personPersistencePort
    ) {
        return new PersonUseCase(personPersistencePort);
    }

}
