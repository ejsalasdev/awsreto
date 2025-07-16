package com.talentpool.retoaws.infrastructure.repositories.mysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentpool.retoaws.infrastructure.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByIdentificationNumber(String identificationNumber);

}
