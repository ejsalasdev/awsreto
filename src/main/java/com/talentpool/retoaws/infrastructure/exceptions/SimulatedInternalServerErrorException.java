package com.talentpool.retoaws.infrastructure.exceptions;

public class SimulatedInternalServerErrorException extends RuntimeException {
    public SimulatedInternalServerErrorException(String message) {
        super(message);
    }
}
