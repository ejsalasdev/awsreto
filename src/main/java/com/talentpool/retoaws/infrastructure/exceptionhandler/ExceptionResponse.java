package com.talentpool.retoaws.infrastructure.exceptionhandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timestamp) {

}
