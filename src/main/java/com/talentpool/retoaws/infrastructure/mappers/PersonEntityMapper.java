package com.talentpool.retoaws.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.talentpool.retoaws.domain.model.person.PersonModel;
import com.talentpool.retoaws.infrastructure.entities.PersonEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PersonEntityMapper {

    PersonEntity toEntity(PersonModel personModel);

    PersonModel toModel(PersonEntity personEntity);

}
