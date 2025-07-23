package com.talentpool.retoaws.infrastructure.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.talentpool.retoaws.domain.exceptions.PersonAlreadyExistsException;
import com.talentpool.retoaws.domain.exceptions.PersonNotFoundException;

import com.talentpool.retoaws.infrastructure.exceptions.SimulatedInternalServerErrorException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlePersonNotFoundException(
            PersonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handlePersonAlreadyExistsException(
            PersonAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(SimulatedInternalServerErrorException.class)
    public ResponseEntity<ExceptionResponse> handleSimulatedInternalServerErrorException(
            SimulatedInternalServerErrorException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

}
