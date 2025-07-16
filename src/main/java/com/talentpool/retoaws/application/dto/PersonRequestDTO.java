package com.talentpool.retoaws.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request DTO for creating a person")
public record PersonRequestDTO(
        @Schema(example = "1234567890") String identificationNumber,
        @Schema(example = "John Doe") String name,
        @Schema(example = "john.doe@email.com") String email) {
}
