package com.mdw.api;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ValidationException;

/**
 * JPA Exception handler to extend API responses.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidationExceptionHandler {
    /**
     * Occurs when a constraint is violated at time of validating a process.
     * Returns a PRECONDITION_FAILED code indicating that there is a precondition that isn't
     * satisfied for the process to occur
     *
     * @param ex      The Validation exception
     * @param request The API request.
     * @return Instance of {@link ResponseEntity} containing the error
     */
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationException(ValidationException ex,
                                                               WebRequest request) {
        ObjectError objectError = new ObjectError(request.getContextPath(), ex.getMessage());
        return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }
}
