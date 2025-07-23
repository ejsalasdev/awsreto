package com.talentpool.retoaws.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentpool.retoaws.application.dto.PersonRequestDTO;
import com.talentpool.retoaws.application.dto.PersonResponseDTO;
import com.talentpool.retoaws.application.handlers.PersonHandler;
import com.talentpool.retoaws.infrastructure.exceptions.SimulatedInternalServerErrorException;
import com.talentpool.retoaws.infrastructure.utils.InfrastructureConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@Tag(name = "Person API", description = "Operations related to Person")
public class PersonController {

    private final PersonHandler personHandler;

    @Operation(summary = "Save a person")
    @PostMapping
    public ResponseEntity<PersonResponseDTO> savePerson(@RequestBody PersonRequestDTO requestDTO) {
        PersonResponseDTO savedPerson = personHandler.savePerson(requestDTO);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a person by identification number")
    @GetMapping("/{identificationNumber}")
    public ResponseEntity<PersonResponseDTO> getPerson(@PathVariable String identificationNumber) {
        return new ResponseEntity<>(
                personHandler.getPerson(identificationNumber),
                HttpStatus.OK);
    }

    @GetMapping("/test-error")
    public ResponseEntity<String> testError() {
        throw new SimulatedInternalServerErrorException(InfrastructureConstants.SIMULATED_5XX_ERROR_MESSAGE);
    }
}
