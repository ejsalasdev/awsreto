package com.talentpool.retoaws.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.talentpool.retoaws.application.dto.PersonRequestDTO;
import com.talentpool.retoaws.application.dto.PersonResponseDTO;
import com.talentpool.retoaws.domain.model.person.PersonModel;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    PersonModel toDomain(PersonRequestDTO personRequestDTO);

    PersonResponseDTO toResponseDTO(PersonModel personModel);
}
