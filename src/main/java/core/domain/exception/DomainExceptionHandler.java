package core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class DomainExceptionHandler {
    @ExceptionHandler(DomainRuleValidationException.class)
    public ResponseEntity<String> handleDomainRuleValidation(DomainRuleValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid input: " + e.getMessage());
    }
}
