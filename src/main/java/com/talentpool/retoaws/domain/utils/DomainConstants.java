package com.talentpool.retoaws.domain.utils;

public final class DomainConstants {

    public static final String PERSON_NOT_FOUND = "Person not found with identification number: ";
    public static final String PERSON_ALREADY_EXISTS = "Person with identification number %s already exists.";

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

}
